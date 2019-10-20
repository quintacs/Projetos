package br.com.qi.action;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.qi.servlet.controller.ServletController;
import br.com.qi.util.LogErroUtil;


public abstract class Action  {

	String nmClasse,acao,retorno;
	String metodo;
	
	 public String execute(HttpServletRequest servletRequest, HttpServletResponse servletResponse)
			 							throws ServletException, IOException {
		 try {
			 
			 acao = (String) servletRequest.getAttribute("acao");
			 
			 if(acao == null ) 
				 	 acao = servletRequest.getParameter("acao");
			   
			 metodo = (String) servletRequest.getAttribute("metodo");			 							   				   
			 
			 if(metodo == null ) 
			    metodo = servletRequest.getParameter("metodo");
			 
			 //nmClasse = "br.com.qi.action."+acao+"Action";
			 
			   // int p  = acao.indexOf('.');			 		  
			   //p++;
			   //nmClasse = "br.com.qi.action."+acao.substring(p, acao.length())+"Action";
			  //p--;			    
			   //metodo = acao.substring(0, p)+"";
			 
			  			 
					 
			  //Class classe = Class.forName(nmClasse);			  
			  // Action action = (Action) classe.newInstance();  
			  
		   if (metodo.equals("main")) {
	           retorno = main(servletRequest, servletResponse);
	        } else if (metodo.equals("loadList")) {
	        	retorno = loadList(servletRequest, servletResponse);
	        } else if (metodo.equals("add")) {
	        	retorno = add(servletRequest, servletResponse);
	        } else if (metodo.equals("remove")) {
	        	retorno = remove(servletRequest, servletResponse);
	        } else if (metodo.equals("edit")) {
	        	retorno = edit(servletRequest, servletResponse);
	        } else if (metodo.equals("loadForm")) {
	        	retorno = loadForm(servletRequest, servletResponse);
	        } else if (metodo.equals("form")) {
	        	retorno = form(servletRequest, servletResponse);
	        } else if (metodo.equals("process")) {
	        	retorno = process(servletRequest, servletResponse);
	        } else if (metodo.equals("detalhes")) {
	        	retorno = detalhes(servletRequest, servletResponse);
	        } else if (metodo.equals("detalhe")) {
	        	retorno = detalhe(servletRequest, servletResponse);	        	        
	        }else if(metodo == null){
	        	retorno = "404.jsp";
	        }else if(metodo.equals("index")){
	        	HttpSession session = servletRequest.getSession();
	        	if(session != null) {
	        		session.removeAttribute("form");
	        		session.invalidate();
	        	}
	        	retorno = "index.jsp";
	        }else if(metodo.equals("principal")){	        	
	        	retorno = "principal.jsp";	        	
	        }else if(metodo.equals("fale")){
	        	retorno = "faleconosco.jsp";
	        }else if(metodo.equals("novo")) {
	        	retorno = "cadastros/cadastroPrincipal.jsp";
	        }
	        		  
		 }catch (Exception e) {
			// TODO: handle exception
			 
			 System.out.println(e.getMessage());
			 
			 LogErroUtil.logErro(acao, metodo, e.getMessage());
			 
			 retorno = "404.jsp";
		} 
		 
		 return retorno;
	 }
	 

	 	public abstract String main(HttpServletRequest request, HttpServletResponse response) throws Exception;
	 	public abstract String loadList(HttpServletRequest request, HttpServletResponse response) throws Exception;
	 	public abstract String add(HttpServletRequest request, HttpServletResponse response) throws Exception;
		public abstract String remove(HttpServletRequest request, HttpServletResponse response) throws Exception;
		public abstract String edit(HttpServletRequest request, HttpServletResponse response) throws Exception;
		public abstract String loadForm(HttpServletRequest request, HttpServletResponse response) throws Exception;
		public abstract String form(HttpServletRequest request, HttpServletResponse response) throws Exception;
		public abstract String process(HttpServletRequest request, HttpServletResponse response) throws Exception;
		public abstract String detalhes(HttpServletRequest request, HttpServletResponse response) throws Exception;
		public abstract String detalhe(HttpServletRequest request, HttpServletResponse response) throws Exception;
	 
}
