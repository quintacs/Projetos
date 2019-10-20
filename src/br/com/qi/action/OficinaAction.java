package br.com.qi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.qi.dao.ActionDao;
import br.com.qi.dao.LojaDao;
import br.com.qi.dao.OficinaDao;
import br.com.qi.form.OficinaForm;
import br.com.qi.form.Form;
import br.com.qi.form.LoginForm;

public class OficinaAction extends Action {

	@Override
	public String main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String loadList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
				
/*		OficinaDao oDao = (OficinaDao) ActionDao.loadClasse("OficinaDao");
		request.setAttribute("lista", oDao.lista());
				
		return "lista/oficinas.jsp";*/
		
		String retorno = "lista/lista1.jsp";
		
		String acao = (String) request.getAttribute("acao"); 
		String tipo = (String) request.getAttribute("tipoLista");
		LoginForm loginForm = (LoginForm) request.getSession().getAttribute("form");	
		
		   if(acao == null ) 
			   acao = request.getParameter("acao");
		   
		   if(tipo == null ) 
			   tipo = request.getParameter("tipoLista");

		   if(loginForm != null )
		    	 request.getSession().setAttribute("form", loginForm);
		   
		   if("lista1".equalsIgnoreCase(tipo) ) {
			   
			   
				LojaDao dao = (LojaDao) ActionDao.loadClasse("LojaDao");
				request.setAttribute("lista", dao.lista());
				request.setAttribute("acao", acao);
				
				retorno = "lista/lista1.jsp";
		   }else {
			   
				LojaDao dao = (LojaDao) ActionDao.loadClasse("LojaDao");
				request.setAttribute("lista", dao.lista());			   
				request.setAttribute("acao", acao);
				
				retorno = "lista/lista2.jsp";
		   }
		   return retorno;
	}

	@Override
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//System.out.println("     dao:"+request.getAttribute("dao"));
		//System.out.println("     form:"+request.getAttribute("form"));		
		//String n =(String) request.getAttribute("dao");
		
		ActionDao dao = (ActionDao) ActionDao.loadClasse((String)request.getAttribute("dao"));
		dao.adicionar((Form)request.getAttribute("form"));
		return "principal.jsp";
	}

	@Override
	public String remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String loadForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String retorno = "cadastros/cadastroPrincipal.jsp";
		
		LoginForm loginForm = (LoginForm) request.getSession().getAttribute("form");	
		
		if(loginForm != null) {
			request.getSession().setAttribute("form", loginForm);	
			retorno = "cadastros/OficinaForm.jsp";
		}else {
			request.setAttribute("mensagem", "É necessário um usuário logado para castrar uma oficina.");
		}
				
		return retorno;
		
	}

	@Override
	public String form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String  retorno = "";
		
		OficinaForm oficinaForm = (OficinaForm) request.getAttribute("form");
		
		if(oficinaForm != null) {
			request.setAttribute("form", oficinaForm);
			request.setAttribute("dao", "OficinaDao");
			request.setAttribute("acao", "Oficina");
			request.setAttribute("metodo", "add");
			retorno = "/controler";
		}else {
			retorno = "cadastros/OficinaForm.jsp";
		}
		
		
		System.out.println("cadastro oficina");
		
		return retorno;		
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String detalhes(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String detalhe(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
