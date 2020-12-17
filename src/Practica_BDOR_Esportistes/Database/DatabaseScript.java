package Practica_BDOR_Esportistes.Database;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class DatabaseScript {

   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	
	/**
	 * Mètode utilitzat per a conectar-se a la base de dades
	 * @return Connection
	 */
	public static Connection ConnectToDatabase() {
		
		try
		{
		    Class.forName("org.postgresql.Driver"); //Carregar la classe i el driver
		} 
		catch (ClassNotFoundException cnfe)
		{
		      System.out.println("Could not find the JDBC driver!");
		      System.exit(1);
		}
		
		//Connecta amb la BBDD
		Connection conn = null;
		try 
		{
			conn = DriverManager.getConnection ("jdbc:postgresql:Esportistes", "postgres", "Henry200*"); //Connectar-nos a la base de dades "Esportistes" amb un usuari i contrasenya
			System.out.println("Connection Successful!");
			

		} 
		catch (SQLException sqle) 
		{
		       System.out.println("Could not connect"); //Si no hi ha conexió ens posara aquest error
		       System.exit(1);
		}
		
		return conn;
		
	}

	/**
	 * Afegir un club a la base de dades
	 * @param nomClub String
	 * @param poblacioClub String
	 * @param codiPostalClub int
	 * @param anyFundacioClub int
	 * @param codiClub int
	 * @return boolean (Si ha funcionat o no)
	 */
	public static boolean InsertClub(String nomClub, String poblacioClub, int codiPostalClub, int anyFundacioClub, int codiClub) {
		
		Statement stmt;
		Connection conn = ConnectToDatabase(); //Connectar-se a la base de dades
		try 
		{
			stmt = conn.createStatement();
			
		    String getSql = "SELECT * FROM club"; //Agafar la taula club, fer una consulta per a comprovar si ja existeix el codi club
		    ResultSet rs = stmt.executeQuery(getSql); //Guardar la consulta
		    
		    while (rs.next()) 
		    {
		    	while (Integer.parseInt(rs.getString(1)) == codiClub) { //Comprovar que el codi club no estigiu repetit
		    		System.out.println("El codi de club ja està repetit a la base de dades");
		    		return false;
		    	}
		    }
		    
		    String insertClub = "INSERT INTO club VALUES("+codiClub+",'"+nomClub+"',"+anyFundacioClub+","+codiPostalClub+",'"+poblacioClub+"');"; //Afegir l'esportista a la base de dades
		    stmt.execute(insertClub); //Executar la comanda
			
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return true;
	}
	
	/**
	 * Afegir un esportista a la base de dades
	 * @param nom
	 * @param cognom1
	 * @param cognom2
	 * @param sexe
	 * @param dataNaixement
	 * @param dni
	 * @param codiClub
	 * @param codiFederat
	 * @return boolean (Si ha funcionat o no)
	 */
	public static boolean InsertEsportista(String nom, String cognom1, String cognom2, char sexe, LocalDate dataNaixement, String dni, int codiClub, String codiFederat) {
		
		Statement stmt;
		Connection conn = ConnectToDatabase();
		try 
		{
			stmt = conn.createStatement();
							 
		    String getSql = "SELECT * FROM esportista"; //Agafar la taula esportista
		    ResultSet rs = stmt.executeQuery(getSql); //Guardar la consulta

		    while (rs.next()) 
		    {
		    	if (rs.getString("dni").equals(dni)) { //Comprovar si el dni està repetit
		    		System.out.println("El dni ja està repetit a la base de dades");
		    		return false;
		    	}
		    	
		    }
		    
		    try {
		    	String insertEsportista = "";
		    	if (codiFederat == null) { //Afegir a la taula esportista com a no federat
		    		insertEsportista = "INSERT INTO esportista VALUES('"+dni+"','"+nom+"','"+cognom1+"','"+cognom2+"','"+sexe+"','"+dataNaixement+"');";
		    	}
		    	else { //Afegir-lo com a federat
		    		insertEsportista = "INSERT INTO esportista VALUES('"+dni+"','"+nom+"','"+cognom1+"','"+cognom2+"','"+sexe+"','"+dataNaixement+"','"+	codiFederat+"',"+codiClub+");";
		    	}
		    	stmt.execute(insertEsportista); //Executar la comanda
		    }
		    catch (Exception e) {
		    	System.out.println("Codi federat està repetit");
		    	return false;
		    }
		    
			
		}
		
		catch (SQLException e) 
		{
			System.out.println("Error al fer l'inserció");
			return false;
		}
		
		return true;
	}
	
	/**
	 * Afegir una prova a la taula proves
	 * @param codiProva
	 * @param nom
	 * @param horaSortida
	 * @param data
	 * @param ubicacio
	 * @param codiClubAnfitrio
	 * @param type
	 * @return boolean (Si ha funcionat o no)
	 */
	public static boolean InsertProves(int codiProva, String nom, LocalTime horaSortida, LocalDate data, String ubicacio, int codiClubAnfitrio, int type) {
		
		Statement stmt;
		Connection conn = ConnectToDatabase();
		try 
		{
			stmt = conn.createStatement();
							
		    String getSql = "SELECT * FROM proves"; //Agafar la taula proves
		    ResultSet rs = stmt.executeQuery(getSql); //Guardar la consulta

		    
		    while (rs.next()) 
		    {
		    	if (Integer.parseInt(rs.getString("codiprova")) == codiProva) { //Comprovar que el codi no estigui repetit
		    		System.out.println("El codi de la prova està repetit");
		    		return false;
		    	}
		    	
		    }
		    
		    switch (type) {
		    
			    case 1: //Marato
			    	String insertMarato = "INSERT INTO marato VALUES("+codiProva+",'"+nom+"','"+horaSortida+"','"+data+"');"; //Afegir la taula com a marato (fill de proves)
				    stmt.execute(insertMarato); //Executar comanda
			    	return true;
			    	
			    case 2: //Prova 10000 (clubAnfitrio, ubicacio)
			    	String getSqlClub = "SELECT * FROM club";
			    	ResultSet rsClub = stmt.executeQuery(getSqlClub);
			    	
			    	try {
			    		String prova10000 = "INSERT INTO prova10000 VALUES("+codiProva+",'"+nom+"','"+horaSortida+"','"+data+"',"+codiClubAnfitrio+",'"+ubicacio+"');"; //Afegir la taula com a prova10000 (fill de proves)
					    stmt.execute(prova10000); //Executar comanda
					    System.out.println("Relació establerta amb el codi club anfitrió");
					    return true;
			    	} 
		    		catch (Exception e) { //Si el club no està en la taula club, retornara false (no s'executa)
		    			System.out.println("No existeix el club introduit");
		    			return false;
		    		}
			    case 3: //Marxa Popular (ubicacio)
			    	String marxapopular = "INSERT INTO marxapopular VALUES("+codiProva+",'"+nom+"','"+horaSortida+"','"+data+"','"+ubicacio+"');"; //Afegir la taula com a marxa popular (fill de proves)
				    stmt.execute(marxapopular); //Executar comanda
			    	return true;
			    case 4: //Proves
			    	String proves = "INSERT INTO proves VALUES("+codiProva+",'"+nom+"','"+horaSortida+"','"+data+"');"; //Afegir la taula com a prova
				    stmt.execute(proves); //Executar comanda
			    	return true;
			    	
			    default:
			    	return false;
		    }
			
		}
		
		catch (SQLException e) 
		{
			System.out.println("Error d'inserció");
			return false;
		}
	}
	
	/**
	 * Mostrar valors de la base de dades (consultes)
	 * @param table - Taula a la qual es vol fer la consulta (club, proves, esportista, proves_participants)
	 */
	public static void ShowDataBaseValues(String table) {
		
		String getSql = "SELECT * FROM "+table;
		
		try {
			
			Statement stmt;
			Connection conn = ConnectToDatabase();
			
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(getSql);
			
			//Insertem a la BBDD la query
			
			ResultSet resultShow = stmt.executeQuery(getSql);
			
			switch (table) {
			
			case "club": //Consultar tots els clubs
				while (resultShow.next())
			    {
			      System.out.println("---------------------------");
			      System.out.println("Codi Club: " + resultShow.getString(1));
			      System.out.println("Nom: " + resultShow.getString(2));
			      System.out.println("Any Fundacio: " + resultShow.getString(3));
			      System.out.println("Codi Poblacio: " + resultShow.getString(4));
			      System.out.println("Poblacio: " + resultShow.getString(5));
			     
			    }
				break;
				
			case "esportista": //Consultar tots els esportistes
				while (resultShow.next())
			    {
			      System.out.println("---------------------------");
			      System.out.println("Dni: " + resultShow.getString(1));
			      System.out.println("Nom: " + resultShow.getString(2));
			      System.out.println("Cognom 1: " + resultShow.getString(3));
			      System.out.println("Cognom 2: " + resultShow.getString(4));
			      System.out.println("Sexe: " + resultShow.getString(5));
			      System.out.println("Data Naixement: " + resultShow.getString(6));
			      System.out.println("Codi Federat: " + resultShow.getString(7));
			      System.out.println("Codi Club: " + resultShow.getString(8));
			     
			    }
				break;
				
			case "proves": //Consultar totes les proves
				while (resultShow.next())
			    {
			      System.out.println("---------------------------");
			      System.out.println("Codi Prova: " + resultShow.getString(1));
			      System.out.println("Nom: " + resultShow.getString(2));
			      System.out.println("Hora Sortida: " + resultShow.getString(3));
			      System.out.println("Data: " + resultShow.getString(4));
			     
			    }
				break;
				
			case "proves_participants": //Consultar tots els participants de totes les proves
				while (resultShow.next())
			    {
			      System.out.println("---------------------------");
			      System.out.println("Dni: " + resultShow.getString(1));
			      System.out.println("Codi Prova: " + resultShow.getString(2));
			    }
				break;
			
			}
		    
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Modificar un esportista, només faran falta alguns dels paràmeters depenent del que es vulgui modificar
	 * @param dni - dni per el qual es vol canviar
	 * @param nom
	 * @param cognom1
	 * @param cognom2
	 * @param sexe
	 * @param dataNaixement
	 * @param dniLike  - dni que es vol modificar
	 * @param codiClub
	 * @param codiFederat
	 * @param type
	 * @return boolean (Si ha funcionat o no)
	 */
	public static boolean UpdateEsportistes (String dni, String nom, String cognom1, String cognom2, char sexe, LocalDate dataNaixement, String dniLike, int codiClub, String codiFederat, int type) {
		
		String getSql = "SELECT * FROM esportista"; //Crear una consulta
		
		Statement stmt;
		Connection conn = ConnectToDatabase();
		
		try {
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(getSql);
			
			//Insertem a la BBDD la query
			
			ResultSet resultShow = stmt.executeQuery(getSql);
			
			switch (type) { //Tipus de modificació
			
				case 1: //UPDATE nom, cognom1, cognom2
					String updateNom = "UPDATE esportista SET nom = '"+nom+"' WHERE dni like '"+dniLike+"';";
					String updateCognom1 = "UPDATE esportista SET cognom1 = '"+cognom1+"' WHERE dni like '"+dniLike+"';";
					String updateCognom2 = "UPDATE esportista SET cognom2 = '"+cognom2+"' WHERE dni like '"+dniLike+"';";
				    stmt.execute(updateNom);
				    stmt.execute(updateCognom1);
				    stmt.execute(updateCognom2);
					return true;
				
				case 2: //UPDATE sexe, dataNaixement
					String updateSexe = "UPDATE esportista SET sexe = '"+sexe+"' WHERE dni like '"+dniLike+"';";
					String updateDataNaixement = "UPDATE esportista SET datanaixement = '"+dataNaixement+"' WHERE dni like '"+dniLike+"';";
					stmt.execute(updateSexe);
					stmt.execute(updateDataNaixement);
					break;
				
				case 3: //UPDATE codi federat, codi club del esportista
					String updateCodiFederat = "UPDATE esportista SET codifederat = '"+codiFederat+"' WHERE dni like '"+dniLike+"';";
					String updateCodiClub = "UPDATE esportista SET codiclub = "+codiClub+" WHERE dni like '"+dniLike+"';";
					
					try {
						stmt.execute(updateCodiFederat);
					}
					catch (Exception e) {
						System.out.println("Codi federat repetit");
						return false;
					}
					
					try {
						stmt.execute(updateCodiClub);
					}
					catch (Exception e) {
						System.out.println("Codi club no existeix");
						return false;
					}
					
					break;
					
				case 4: //UPDATE dni
					String updatDni = "UPDATE esportista SET dni = '"+dni+"' WHERE dni like '"+dniLike+"';";
					
					try {
						stmt.execute(updatDni);
					}
 					catch (Exception e) {
 						System.out.println("Dni repetit");
 						return false;
 					}
					
					break;
				
				default: //Si no s'introdueix de quin tipus es retorna un error
					System.out.println("Error d'inserció");
					return false;
			}
			
		}
		
		catch (Exception e) {
			
			System.out.println("Error de UPDATE");
			
		}
		
		return true;
		
	}
	
	/**
	 * Modificar un club, només faran falta alguns dels paràmeters depenent del que es vulgui modificar
	 * @param codiClub  - codi club per el qual es vol canviar
	 * @param nomClub
	 * @param anyFundacio
	 * @param codiPoblacio
	 * @param poblacio
	 * @param codiClubLike - codi club que es vol modificar
	 * @param type
	 * @return boolean (Si ha funcionat o no)
	 */
	public static boolean UpdateClub (int codiClub, String nomClub, int anyFundacio, int codiPoblacio, String poblacio, int codiClubLike, int type) {
		
		String getSql = "SELECT * FROM club";
		
		Statement stmt;
		Connection conn = ConnectToDatabase();
		
		try {
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(getSql);
			
			//Insertem a la BBDD la query
			
			ResultSet resultShow = stmt.executeQuery(getSql);
			
			switch (type) {
			
				case 1: //UPDATE nomclub
					String updateNomClub = "UPDATE club SET nomclub = '"+nomClub+"' WHERE codiclub = "+codiClubLike+";";
				    stmt.execute(updateNomClub);
					return true;
				
				case 2: //UPDATE poblacio
					String updatePoblacio = "UPDATE club SET poblacio = '"+poblacio+"' WHERE codiclub = "+codiClubLike+";";
				    stmt.execute(updatePoblacio);
					break;
				
				case 3: //UPDATE codi poblacio
					String updateCodiPoblacio= "UPDATE club SET codipoblacio = "+codiPoblacio+" WHERE codiclub = "+codiClubLike+";";
				    stmt.execute(updateCodiPoblacio);		
					break;
					
				case 4: //UPDATE any fundacio
					String updateAnyFundacio = "UPDATE club SET anyfundacio = "+anyFundacio+" WHERE codiclub = "+codiClubLike+";";
					stmt.execute(updateAnyFundacio);	
					break;
				
				default:
					System.out.println("Error d'inserció");
					return false;
			}
			
		}
		
		catch (Exception e) {
			
			System.out.println("Error de UPDATE");
			return false;
		}
		
		return true;
		
	}
	
	/**
	 * Modificar una prova, només faran falta alguns dels paràmeters depenent del que es vulgui modificar
	 * @param codiProva - codiprova per el qual es vol canviar
	 * @param nomProva
	 * @param horaSortida
	 * @param data
	 * @param codiProvaLike - codiprova que es vol modificar
	 * @param type
	 * @return boolean (si ha funcionat o no)
	 */
	public static boolean UpdateProves(int codiProva, String nomProva, LocalTime horaSortida, LocalDate data, int codiProvaLike, int type) {
		
		String getSql = "SELECT * FROM proves";
		
		Statement stmt;
		Connection conn = ConnectToDatabase();
		
		try {
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(getSql);
			
			//Insertem a la BBDD la query
			
			ResultSet resultShow = stmt.executeQuery(getSql);
			
			switch (type) {
			
				case 1: //UPDATE nomProva
					String updateNomProva = "UPDATE proves SET nom = '"+nomProva+"' WHERE codiprova = "+codiProvaLike+";";
				    stmt.execute(updateNomProva);
					return true;
				
				case 2: //UPDATE horaSortida
					String updateHoraSortida = "UPDATE proves SET horasortida = '"+horaSortida+"' WHERE codiprova = "+codiProvaLike+";";
				    stmt.execute(updateHoraSortida);
					break;
				
				case 3: //UPDATE data
					String updateData= "UPDATE proves SET data = '"+data+"' WHERE codiprova = "+codiProvaLike+";";
				    stmt.execute(updateData);		
					break;
					
				default:
					System.out.println("Error d'inserció");
					return false;
			}
			
		}
		
		catch (Exception e) {
			
			System.out.println("Error de UPDATE");
			return false;
		}
		
		return true;
	}
	
	/**
	 * Comprovacions de l'existencia de claus primaries en les taules, només farà falta una sèrie de paràmetres segons la taula
	 * @param table - Taula a la qual es vol comprovar l'existencia de la clau pasada
	 * @param dni
	 * @param codiClub
	 * @param codiProva
	 * @return Retorna True si existeix, false si no
	 */
	public static boolean ComprovarClausPrimariesExistents(String table, String dni, int codiClub, int codiProva) {
		
		Statement stmt;
		Connection conn = ConnectToDatabase();
		try {
			stmt = conn.createStatement();
							
		    String getSql = "SELECT * FROM "+table; //Agafar la taula proves
		    ResultSet rs = stmt.executeQuery(getSql); //Guardar la consulta
	
		    switch (table) {
			    
			    case "esportista": //Consultar el dni del esportista
			    	while (rs.next()) 
				    {
				    	if (rs.getString("dni").equals(dni)) {
				    		System.out.println("Dni trobat");
				    		return true;
				    	}
				    }
			    	break;
			    
			    case "club": //Consultar el codi club de la taula club
			    	while (rs.next()) 
				    {
				    	if (Integer.parseInt(rs.getString("codiclub")) == codiClub) {
				    		System.out.println("Codi club trobat");
				    		return true;
				    	}
				    }
			    	break;
			    
			    case "proves": //Consultar el codi prova de la taula proves
			    	while (rs.next()) 
				    {
				    	if (Integer.parseInt(rs.getString("codiprova")) == codiProva) {
				    		System.out.println("Codi prova trobat");
				    		return true;
				    	}
				    }
			    	break;
			    case "proves_participants": //Consultar l'existencia del participant en una prova especifica
				    while (rs.next()) 
				    {
				    	if (rs.getInt("codiprova") == codiProva && rs.getString("dni").equals(dni)) {
				    		System.out.println("Participant trobat");
				    		return true;
				    	}
				    }
			    	break;
			    	
			    default:
			    	System.out.println("Taula no existent");
			    	break;
		    
		    }
		    
		}
		
		catch (Exception e) {
			System.out.println("Error al comprovar esportista");
		}
		
		return false;
	}
	
	/**
	 * Inscriure un esportista a una prova
	 * @param dni
	 * @param codiProva
	 * @param categoria - la categoria es crea automaticament
	 * @param dorsal - el dorsal es crea automaticament
	 * @return boolean (si ha funcionat, o no)
	 */
	public static boolean InscripcioProva(String dni, int codiProva, String categoria, int dorsal) {
		
		Statement stmt;
		Connection conn = ConnectToDatabase();
		
		try {
			
			stmt = conn.createStatement();
		    String getSql = "SELECT * FROM esportista"; //Agafar la taula proves
			ResultSet rs = stmt.executeQuery(getSql); //Guardar la consulta
			String insertParticipant = "INSERT INTO proves_participants VALUES ('"+dni+"',"+codiProva+",'"+categoria+"',"+dorsal+");"; //Afegir el participant a la prova
			try {
				stmt.execute(insertParticipant);
			}
			catch (Exception e) { //Si esta inscrit no ens l'inscriurà
				System.out.println("L'esportista ja esta inscrit a la base de dades");
				return false;
			}
			
			
		}
		
		catch (Exception e) {
			System.out.println("Error d'inscripció");
			return false;
		}
		
		return true;
		
	}
	
	/**
	 * Anular l'inscripcio de un participant en una prova
	 * @param dni
	 * @param codiProva
	 * @return boolean (si s'ha eliminat el participant o no)
	 */
	public static boolean AnularInscripcioProva(String dni, int codiProva) {
		
		Statement stmt;
		Connection conn = ConnectToDatabase();
		
		try {
			
			stmt = conn.createStatement();
			try {
				String anularInscripcio = "DELETE FROM proves_participants WHERE dni like '"+dni+"' AND codiprova = "+codiProva; //Esborrar el participant a través del dni i codi prova
				stmt.execute(anularInscripcio);
			}
			
			catch (Exception e) { //Si l'esportista i el codi prova no estan relacionats, no esborrarà res
				System.out.println("L'esportista no coincideix amb el codi prova, comprova que estiguin relacionats");
				return false;
			}
		}
		
		catch (Exception e) {
			System.out.println("Error d'inscripció");
			return false;
		}
		
		return true;
		
	}
	
	/**
	 * Llistar les inscripcions de una prova
	 * @param codiProva
	 */
	public static void LlistarInscripcionsProva(int codiProva) {
		
		try {
			
			Statement stmt;
			Connection conn = ConnectToDatabase();
			
			stmt = conn.createStatement();
			String consultaParticipantsProva = "SELECT pp.dni, e.nom, pp.categoria, pp.dorsal FROM proves_participants pp INNER JOIN esportista e ON e.dni = pp.dni WHERE pp.codiprova = "+codiProva; //Llistar
			
			ResultSet resultShowParticipantsProva = stmt.executeQuery(consultaParticipantsProva);
			
			System.out.println("");
			System.out.println("Prova ID: "+codiProva);
			
			while (resultShowParticipantsProva.next()) //Llistar tots els participants de la consulta feta
		    {
		      System.out.println("---------------------------");
		      System.out.println("Dni: " + resultShowParticipantsProva.getString(1));
		      System.out.println("Nom: " + resultShowParticipantsProva.getString(2));
		      System.out.println("Categoria: " + resultShowParticipantsProva.getString(3));
		      System.out.println("Dorsal: " + resultShowParticipantsProva.getString(4));		     
		    }
			
		}
		
		catch (Exception e) {
			System.out.println("Error de consulta");
		}
		
	}
	
	/**
	 * Canviar el temps que ha tardat un participant de una prova a assolir la prova
	 * @param dni
	 * @param codiProva
	 * @param tempsProva
	 * @return boolean (Si s'ha pogut actualitzar el temps o no)
	 */
	public static boolean UpdateProvesParticipantsTemps(String dni, int codiProva, LocalTime tempsProva) {
		
		try {
			Statement stmt;
			Connection conn = ConnectToDatabase();
			
			stmt = conn.createStatement();
			String updateProvesParticipantsTemps = "UPDATE proves_participants SET tempsprova = '"+tempsProva+"' WHERE codiprova = "+codiProva+" AND dni like '"+dni+"';"; //Canviar el temps de la prova del participant
			stmt.execute(updateProvesParticipantsTemps); //Executar comanda
			
			
		}
		
		catch (Exception e) {
			System.out.println("Update ha fallat");
		}
		
		return true;
	}
	
	/**
	 * Mostrar la classificació total, permet classificar per temps, sexe i categoria segons el String que es possi com a parametre en "tipus"
	 * @param codiProva
	 * @param tipus String (temps, sexe, categoria)
	 */
	public static void MostrarClassificacioTotal(int codiProva, String tipus) {
		
		try {
			
			Statement stmt;
			Connection conn = ConnectToDatabase();
			
			stmt = conn.createStatement();
			String consulta = "";
			ResultSet resultShowParticipantsProva = null;
			
			
			
			switch (tipus) {
			
				case "temps": //Classificar per temps (menor a major temps)
					consulta = "SELECT pp.dni, e.sexe, e.nom, pp.categoria, pp.dorsal, pp.tempsprova FROM proves_participants pp INNER JOIN esportista e ON e.dni = pp.dni WHERE pp.codiprova = "+codiProva+" ORDER BY pp.tempsprova";
					resultShowParticipantsProva = stmt.executeQuery(consulta);
					break;
					
				case "sexe": //Classificar per sexe (ordre alfabetic, A -> Z)
					consulta = "SELECT pp.dni, e.sexe, e.nom, pp.categoria, pp.dorsal, pp.tempsprova FROM proves_participants pp INNER JOIN esportista e ON e.dni = pp.dni WHERE pp.codiprova = "+codiProva+" ORDER BY e.sexe";
					resultShowParticipantsProva = stmt.executeQuery(consulta);
					break;
					
				case "categoria": //Classificar per categoria (ordre alfabetic, A -> Z)
					consulta = "SELECT pp.dni, e.sexe, e.nom, pp.categoria, pp.dorsal, pp.tempsprova FROM proves_participants pp INNER JOIN esportista e ON e.dni = pp.dni WHERE pp.codiprova = "+codiProva+" ORDER BY pp.categoria";
					resultShowParticipantsProva = stmt.executeQuery(consulta);
					break;
			}
			
			System.out.println("");
			String consultaProva = "SELECT * FROM proves WHERE codiprova = "+codiProva;
			ResultSet provaDades = stmt.executeQuery(consultaProva);
			while (provaDades.next()) { //Mostrar les dades de la prova en especific
				System.out.println("Codi Prova: "+provaDades.getString(1));
				System.out.println("Nom: "+provaDades.getString(2));
				System.out.println("Hora Sortida: "+provaDades.getString(3));
				System.out.println("Data: "+provaDades.getString(4));
			}
			System.out.println("-----------------CLASSIFICACIÓ TOTAL PER "+tipus.toUpperCase()+"------------------");
			System.out.println("Dni		Sexe	Nom	Categoria	Dorsal	Temps");
			while (resultShowParticipantsProva.next()) //Mostrar les dades dels participants
		    { 
		      System.out.print("" + resultShowParticipantsProva.getString(1)); //Mostrar dni
		      System.out.print("	" + resultShowParticipantsProva.getString(2)); //Mostrar sexe
		      System.out.print("	" + resultShowParticipantsProva.getString(3)); //Mostrar nom
		      System.out.print("	" + resultShowParticipantsProva.getString(4)); //Mostrarcategoria
		      System.out.print("	" + resultShowParticipantsProva.getString(5));	//Mostrar dorsal
		      System.out.print("	" + resultShowParticipantsProva.getString(6));	//Mostrar temps
		    }
			System.out.println();
		}
		
		catch (Exception e) {
			System.out.println("Error de consulta");
		}
		
	}
	
	public static Date RetornarDataNaixementEsportista(String dni) {
		
		Statement stmt;
		Connection conn = ConnectToDatabase();
		
		try {
			
			stmt = conn.createStatement();
		    String getSql = "SELECT * FROM esportista"; //Consultar esportistes
			ResultSet rs = stmt.executeQuery(getSql); //Guardar la consulta
			
			while (rs.next()) 
		    {
		    	if (rs.getString("dni").equals(dni)) { //Comprovar que el dni existeixi
		    		System.out.println("Retornant data naixement");
		    		return rs.getDate("datanaixement"); //Retornar la data de naixament del esportista seleccionat
		    	}
		    }
		}
		
		catch (Exception e) { //Si el dni no existeix
			System.out.println("Error d'inscripció");
		}
		
		return Date.valueOf(LocalDate.of(0, 0, 0));
		
	}
	
	/**
	 * Assignar el dorsal a través de mirar tots els numeros de dorsal ocupats en el codi prova
	 * @param codiProva
	 * @return int dorsal
	 */
	public static int AssignarDorsal(int codiProva) {
		
		Statement stmt;
		Connection conn = ConnectToDatabase();
		
		try {
			stmt = conn.createStatement();
			
			String sqlConsulta = "SELECT * FROM proves_participants WHERE codiprova = "+codiProva+" ORDER BY dorsal;"; //Consultar els dorsal del codi prova ordenats
			
			ResultSet query = stmt.executeQuery(sqlConsulta);
			
			System.out.println("Consulta done");
			int dorsal = 1;
			
			while (query.next()) { //Mirar tots els dorsals
				
				if (query.getInt(4) == dorsal) { //Si el dorsal es igual al actual, sumarà
					System.out.println(query.getInt(4));
					dorsal++;
				}

			}
			
			return dorsal; //Quant ja ha comprovat tots els dorsals el numero sempre sera un diferent als consultats
			
		}
		
		catch (SQLException e) { //Si falla la consulta
			e.printStackTrace();
			return -1;
		}
		
	}
	
}