package br.com.qi.servlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.qi.action.Action;
import br.com.qi.util.LogErroUtil;

public class ServletUsuarioController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
	private String nmClasse,acao,retorno;
	private String metodo;
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(request, response);
		
		try {  	
			
			   acao = (String) request.getAttribute("acao"); 
			   
			   if(acao == null ) 
				   acao = request.getParameter("acao"); 		   
				
			   
			   //nmClasse = request.getServletContext().getInitParameter(acao+"Action");
			   nmClasse = "br.com.qi.action."+acao+"Action";
			  Class classe = Class.forName(nmClasse);
			  
			  Action action = (Action) classe.newInstance(); 		  
			  
	  		abrePagina(request, response ,action.execute(request, response));
			
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("\n\nErro: ");
			System.out.println("ServletController: " + e.getMessage());		
			
			LogErroUtil.logErro(acao, metodo, e.getMessage());
		}
	}
	
	
	 void abrePagina(HttpServletRequest req, HttpServletResponse resp , String strJsp) 
	 {
		try {
			System.out.println("funfou!!!   "+strJsp);
		
			String teste = req.getParameter("acao");
		
			System.out.println("Teste: "+teste);
		
			String barra =   strJsp.substring(0,1);
			
			int p  = strJsp.indexOf('.');
			p++;
			
			System.out.println("strJSP "+strJsp.substring(p, strJsp.length()));
				    	  
	     		RequestDispatcher requestDispatcher = req.getRequestDispatcher(strJsp);                  
	    		requestDispatcher.forward(req, resp);
	    				      
	    } catch (IOException i) {
	        System.out.println("ServletController: abrePagina: IOException: " + i.getMessage());
	        LogErroUtil.logErro(acao, metodo, i.getMessage());
	    } catch (ServletException s) {
	        System.out.println("ServletController: abrePagina: ServletException: " + s.getMessage());
	        LogErroUtil.logErro(acao, metodo, s.getMessage());
	    }			
	}	

}
