package br.com.qi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.qi.dao.ActionDao;
import br.com.qi.dao.LojaDao;
import br.com.qi.form.Form;
import br.com.qi.form.LoginForm;
import br.com.qi.form.LojaForm;

public class LojaAction extends Action	{

	@Override
	public String main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return "404.jsp";
	}

	@Override
	public String loadList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
				
		String retorno = "lista/lista1.jsp"; //"lista/lojas.jsp";
		
		String acao = (String) request.getAttribute("acao"); 
		String tipo = (String) request.getAttribute("tipoLista");
		LoginForm loginForm = (LoginForm) request.getSession().getAttribute("form");		
		
		LojaDao dao ;
		
		 if(acao == null ) 
			   acao = request.getParameter("acao");		 
		 
	     if(tipo == null ) 
			   tipo = request.getParameter("tipoLista");
		 
	     if(loginForm != null )
	    	 request.getSession().setAttribute("form", loginForm);
	    	 
		   if("lista1".equalsIgnoreCase(tipo) ) {			   
			   
				dao = (LojaDao) ActionDao.loadClasse("LojaDao");
				request.setAttribute("lista", dao.lista());
				request.setAttribute("acao", acao);
				
			   retorno = "lista/lista1.jsp";
		   }else {
			   
				dao = (LojaDao) ActionDao.loadClasse("LojaDao");
				request.setAttribute("lista", dao.lista());			   
				request.setAttribute("acao", acao);
				
				retorno = "lista/lista2.jsp";
		   }
		   		
		return retorno;
	}

	@Override
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionDao dao = (ActionDao) ActionDao.loadClasse((String)request.getAttribute("dao"));
		dao.adicionar((Form)request.getAttribute("form"));
		return "principal.jsp";
	}

	@Override
	public String remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return "404.jsp";
	}

	@Override
	public String edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return "404.jsp";
	}

	@Override
	public String loadForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String retorno = "cadastros/cadastroPrincipal.jsp";
		
		LoginForm loginForm = (LoginForm) request.getSession().getAttribute("form");	
		
		if(loginForm != null) {
			request.getSession().setAttribute("form", loginForm);		
			retorno = "cadastros/LojaForm.jsp";
		}else {
			request.setAttribute("mensagem", "É necessário um usuário logado para castrar uma loja.");
		}
				
		return retorno;
	}

	@Override
	public String form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String  retorno = "";
		
		LojaForm lojaForm = (LojaForm) request.getAttribute("form");
		
		if(lojaForm != null) {
			request.setAttribute("form", lojaForm);
			request.setAttribute("dao", "LojaDao");
			request.setAttribute("acao", "Loja");
			request.setAttribute("metodo", "add");
			retorno = "/controler";
		}else {
			retorno = "cadastros/LojaForm.jsp";
		}
		
		
		System.out.println("cadastro loja");
		
		return retorno;	
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return "404.jsp";
	}

	@Override
	public String detalhes(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return "404.jsp";
	}

	@Override
	public String detalhe(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return "404.jsp";
	}

}
