package MES.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class MySQLModel {
	
	public static String getdatadb()
	{
		
		 Connection conn = null;

	     try
	     {
	             String userName = "root";
	             String password = "lpro";

	             String url = "jdbc:mysql://54.72.202.110/LPRO";
	             Class.forName("com.mysql.jdbc.Driver").newInstance();
	             conn = DriverManager.getConnection(url,userName,password);
	             System.out.println("Database connection established");
	             
	             // Se crea un Statement, para realizar la consulta
		            java.sql.Statement s = conn.createStatement();
		            
		            // Se realiza la consulta. Los resultados se guardan en el 
		            // ResultSet rs
		            ResultSet rs = s.executeQuery ("select * from DATA order by DATE DESC LIMIT 1 ");
		            
		            // Se recorre el ResultSet, mostrando por pantalla los resultados.
		            while (rs.next())
		            {
		            	System.out.println (rs.getInt ("VALUE") + " " + rs.getDate (1));
		                return rs.getString("VALUE");
		                
		            }
		            
		            conn.close();
		            return "";

	     }
	     catch (Exception e)
	     {
	             System.err.println("Cannot connect to database server");
	             System.err.println(e.getMessage());
	             e.printStackTrace();
	     }
	     return "";
		
	}
}
