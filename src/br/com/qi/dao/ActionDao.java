package br.com.qi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import br.com.qi.connection.Conection;
import br.com.qi.form.Form;

public abstract class ActionDao {

	private static Class classe ;
	private static Object obj;
	private static String  nome;
	
	 PreparedStatement pstm;
	 ResultSet rs;
	
	Connection con;
	
	Connection getConnection(){
	    return Conection.getConection();
	}
	
	public static Object loadClasse(String nm)throws Exception{
		
	  	nome = "br.com.qi.dao."+nm;
        classe = Class.forName(nome);						
		obj = (Object)classe.newInstance();			
	
	return obj;
}	
	
	public  abstract void adicionar(Form frm)throws Exception;
	public  abstract void alterar(Form frm)throws Exception;
	public  abstract Form consulta(int id)throws Exception;
	public  abstract List<Form> lista(int id)throws Exception;
	public  abstract List<Form> lista()throws Exception;
	public  abstract void excluir(Long id)throws Exception;
	
	
}
