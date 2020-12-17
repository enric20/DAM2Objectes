package M3_UF4_Practica.Database;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class DatabaseScript {

   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	
	public static void main(String[] args) 
	{
		
		ShowDataBaseValues("club");
		ShowDataBaseValues("esportista");
		ShowDataBaseValues("proves_participants");
		ShowDataBaseValues("proves");
		//String nom, String cognom1, String cognom2, char sexe, LocalDate dataNaixement, String dni, int codiClub, String codiFederat
		boolean inserted = InsertEsportista("Nom", "Cognom1", "Cognom2", 'H', LocalDate.of(2000, 12, 9), "41701130X", 1, "W124");
		inserted = InsertProves(3, "AlphaBeta", LocalTime.of(8, 30, 00), LocalDate.of(2020, 9, 10));

	}
	
	public static Connection ConnectToDatabase() {
		
		try
		{
		    Class.forName("org.postgresql.Driver");
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
			conn = DriverManager.getConnection ("jdbc:postgresql:esportistes", "postgres", "Henry200*");
			System.out.println("Connection Successful!");
			

		} 
		catch (SQLException sqle) 
		{
		       System.out.println("Could not connect");
		       System.exit(1);
		}
		
		return conn;
		
	}
	
	public static boolean InsertClub(String nomClub, String poblacioClub, int codiPostalClub, LocalDate anyFundacioClub, int codiClub) {
		
		Statement stmt;
		Connection conn = ConnectToDatabase();
		try 
		{
			stmt = conn.createStatement();
							 
		    /*codiClub = 4;
		    nomClub = "Pro Club";
		    anyFundacioClub = 2019;
		    codiPoblacioClub = 17500;
		    poblacioClub = "Palamos";
		    */
			
		    String getSql = "SELECT * FROM club"; //Agafar la taula club
		    ResultSet rs = stmt.executeQuery(getSql); //Guardar la consulta
		    
		    while (rs.next()) 
		    {
		    	while (Integer.parseInt(rs.getString(1)) == codiClub) {
		    		System.out.println("El codi de club ja està repetit a la base de dades");
		    		return false;
		    	}
		    }
		    
		    String insertClub = "INSERT INTO club VALUES("+codiClub+",'"+nomClub+"',"+anyFundacioClub+","+codiPostalClub+",'"+poblacioClub+"');";
		    stmt.execute(insertClub);
			
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return true;
	}
	
	public static boolean InsertEsportista(String nom, String cognom1, String cognom2, char sexe, LocalDate dataNaixement, String dni, int codiClub, String codiFederat) {
		
		Statement stmt;
		Connection conn = ConnectToDatabase();
		try 
		{
			stmt = conn.createStatement();
							 			
		    String getSql = "SELECT * FROM esportista"; //Agafar la taula club
		    ResultSet rs = stmt.executeQuery(getSql); //Guardar la consulta

		    
		    while (rs.next()) 
		    {
		    	if (rs.getString(1).equals(dni)) {
		    		System.out.println("El dni ja està repetit a la base de dades");
		    		return false;
		    	}
		    	
		    }
		    	    
		    String insertEsportista = "INSERT INTO esportista VALUES('"+dni+"','"+nom+"','"+cognom1+"','"+cognom2+"','"+sexe+"','"+dataNaixement+"','"+	codiFederat+"',"+codiClub+");";
		    stmt.execute(insertEsportista);
			
		}
		
		catch (SQLException e) 
		{
			System.out.println("Codi federat està repetit");
			return false;
		}
		
		return true;
	}
	
	public static boolean InsertProves(int codiProva, String nom, LocalTime horaSortida, LocalDate data) {
		
		Statement stmt;
		Connection conn = ConnectToDatabase();
		try 
		{
			stmt = conn.createStatement();
							
		    String getSql = "SELECT * FROM proves"; //Agafar la taula proves
		    ResultSet rs = stmt.executeQuery(getSql); //Guardar la consulta

		    
		    while (rs.next()) 
		    {
		    	if (Integer.parseInt(rs.getString("codiprova")) == codiProva) {
		    		System.out.println("El codi de la prova està repetit");
		    		return false;
		    	}
		    	
		    }
		    
		    String insertEsportista = "INSERT INTO proves VALUES("+codiProva+",'"+nom+"','"+horaSortida+"','"+data+"');";
		    stmt.execute(insertEsportista);
			
		}
		
		catch (SQLException e) 
		{
			System.out.println("Codi federat està repetit");
			return false;
		}
		
		return true;
	}
	
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
			
			case "club":
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
				
			case "esportista":
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
				
			case "proves":
				while (resultShow.next())
			    {
			      System.out.println("---------------------------");
			      System.out.println("Codi Prova: " + resultShow.getString(1));
			      System.out.println("Nom: " + resultShow.getString(2));
			      System.out.println("Hora Sortida: " + resultShow.getString(3));
			      System.out.println("Data: " + resultShow.getString(4));
			     
			    }
				break;
				
			case "proves_participants":
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
	 * INSERT DATA INHERITED
	 * 
	 * 	WITH provesid AS (
	  	INSERT INTO proves VALUES (1, 'Prova10000 Palafrugell', '12:00:00', '2020-12-10') RETURNING codiprova
		)
		UPDATE prova10000 pr10 SET codiclub = 15
	  	FROM provesid
	 	WHERE pr10.codiprova = provesid.codiprova;
	 * 
	 */
}