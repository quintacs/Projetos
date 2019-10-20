package br.com.qi.connection;

import java.sql.Connection;

public interface  Conectar {

	String classe    = "oracle.jdbc.driver.OracleDriver";
    String host      = "127.0.0.1";
	String porta     = "1521";
	String drive     = "jdbc:oracle:thin:@";
	String instancia = "XE";
	String usuario   = "cesar";
	String senha     = "cesar";

	 Connection getConnection();

}
