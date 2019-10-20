package br.com.qi.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import br.com.qi.connection.Conection;

public class LogErroUtil {

	private LogErroUtil() {
		
	}
	
	private static String sqlErro ="insert into LogErroAplicacao(classe,metodo,erro,data) values (?,?,?,?)";	
	private static PreparedStatement pstm;
	private ResultSet rs;
	
	public static void logErro(String classe,String metodo,String erro) {
		
		try {
			pstm =  Conection.getConection().prepareStatement(sqlErro);		
			pstm.setString(1, classe);
			pstm.setString(2, metodo);
			pstm.setString(3, erro);
			pstm.setString(4, DateUtil.formatDMYHHMMSS(new Date()));//"select TO_CHAR(SYSDATE, 'DD-MM-YYYY HH24:MI:SS') from dual");		
			pstm.execute();
			pstm.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/*public static void main(String[] args) {
		
		Date data = new Date();
		System.out.println("date: "+ data);				
		
		try {
			
			System.out.println("DateUtil.formatDMYHHMMSS: "+ DateUtil.formatDMYHHMMSS(new Date()));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
