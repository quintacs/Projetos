package br.com.qi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.qi.dao.ActionDao;
import br.com.qi.dao.LojaDao;
import br.com.qi.dao.PecaDao;
import br.com.qi.form.Form;
import br.com.qi.form.LoginForm;
import br.com.qi.form.PecaForm;

public class PecaAction extends Action {

	@Override
	public String main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String loadList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
/*		PecaDao dao = (PecaDao) ActionDao.loadClasse("PecaDao");
		request.setAttribute("lista", dao.lista());		
		return "lista/pecas.jsp";*/
		
		String retorno = "";
		String acao = (String) request.getAttribute("acao"); 
		String tipo = (String) request.getAttribute("tipoLista");
		LoginForm loginForm = (LoginForm) request.getSession().getAttribute("form");	
		
		   if(acao == null ) 
			   acao = request.getParameter("acao");
		   
		   if(tipo == null ) 
			   tipo = request.getParameter("tipoLista");
		   
		   if(loginForm == null) { 
			   	request.setAttribute("mensagem", "É necessário um usuário logado para listar as peças.");			   	
				request.setAttribute("acao", "Peca");
				request.setAttribute("metodo", "index");
				retorno = "/controler";			   
			}else {
				
			   if("lista1".equalsIgnoreCase(tipo) ) {
				   
				   
					LojaDao dao = (LojaDao) ActionDao.loadClasse("LojaDao");
					request.setAttribute("lista", dao.lista());
					request.setAttribute("acao", acao);
					
					retorno =  "lista/lista1.jsp";
			   }else {
				   
					LojaDao dao = (LojaDao) ActionDao.loadClasse("LojaDao");
					request.setAttribute("lista", dao.lista());			   
					request.setAttribute("acao", acao);
					
					retorno =  "lista/lista2.jsp";
			   }
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
		
		System.out.println("cadastro peca");
		String retorno = "cadastros/cadastroPrincipal.jsp";
		
		LoginForm loginForm = (LoginForm) request.getSession().getAttribute("form");	
		
		if(loginForm != null) {
			request.getSession().setAttribute("form", loginForm);		
			retorno = "cadastros/PecaForm.jsp";
		}else {
			request.setAttribute("mensagem", "É necessário um usuário logado para castrar uma peça.");
		}
				
		return retorno;		
	}

	@Override
	public String form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub  "index.jsp"
		String retorno="";
		
		PecaForm pecaForm =(PecaForm) request.getAttribute("form");
		
		if(pecaForm != null) {
			request.setAttribute("form", pecaForm);
			request.setAttribute("dao", "PecaDao");
			request.setAttribute("acao", "Peca");
			request.setAttribute("metodo", "add");			
			//request.setAttribute("acao", "add.CadastroPeca");			
			retorno = "/controler";
		}else {
			retorno = "cadastros/PecaForm.jsp";
		}		
		
		System.out.println("cadastro peca");
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
