package br.com.qi.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conection implements Conectar {

	private Conection() {}
	  
	 public static Connection getConection() {							
					
	   try {
	        Class.forName(classe);
	 	    return DriverManager.getConnection(drive+host+":"+porta+":"+instancia, usuario, senha);
		 } catch(Exception e) {
		       throw new RuntimeException(e);
	    }
	}

		@Override
		public Connection getConnection() {
			// TODO Auto-generated method stub
			return getConection();
		}
									
	 
	/*
	 * public static void main(String[] args) {
	 * 
	 * try {
	 * 
	 * System.out.println("conectado : "+getConection());
	 * 
	 * 
	 * // Properties prop = new Properties(); // FileInputStream file = new
	 * FileInputStream("src\\conection.properties"); // prop.load(file); // //
	 * String cl = prop.getProperty("oracle.classe"); // String hs =
	 * prop.getProperty("oracle.host"); // String pr =
	 * prop.getProperty("oracle.porta"); // String dr =
	 * prop.getProperty("oracle.drive"); // String is =
	 * prop.getProperty("oracle.instancia"); // String us =
	 * prop.getProperty("oracle.usuario"); // String se =
	 * prop.getProperty("oracle.senha"); // // System.out.println(" classe "+cl); //
	 * System.out.println(" host "+hs); // System.out.println(" porta "+pr); //
	 * System.out.println(" drive "+dr); // System.out.println(" instancia "+is); //
	 * System.out.println(" usuario "+us); // System.out.println(" senha "+se); //
	 * // Class.forName(cl); // DriverManager.getConnection(dr+hs +":"+pr+":"+is,
	 * us, se);
	 * 
	 * }catch (Exception e) { // TODO: handle exception e.printStackTrace(); }
	 * //System.out.println("conectado: "+con.toString() ); }
	 */
		
		public static Connection getConnection1() {
			// System.out.println("Conectando ao banco");
		 try { Class.forName("oracle.jdbc.driver.OracleDriver");
			 return DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "cesar", "cesar");
		} catch(Exception e) {
				 throw new RuntimeException(e);
		  }
		}
	
}
