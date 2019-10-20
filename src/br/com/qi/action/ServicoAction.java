package br.com.qi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.qi.dao.ActionDao;
import br.com.qi.dao.LojaDao;
import br.com.qi.dao.ServicoDao;
import br.com.qi.form.Form;
import br.com.qi.form.LoginForm;
import br.com.qi.form.ServicoForm;

public class ServicoAction extends Action{

	@Override
	public String main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String loadList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
/*		ServicoDao dao = (ServicoDao) ActionDao.loadClasse("ServicoDao");
		request.setAttribute("lista", dao.lista());		
		return "lista/servicos.jsp";*/
		String acao = (String) request.getAttribute("acao"); 
		String tipo = (String) request.getAttribute("tipoLista");
		
		   if(acao == null ) 
			   acao = request.getParameter("acao");
		   
		   if(tipo == null ) 
			   tipo = request.getParameter("tipoLista");
		   
		   if("lista1".equalsIgnoreCase(tipo) ) {
			   
			   
				LojaDao dao = (LojaDao) ActionDao.loadClasse("LojaDao");
				request.setAttribute("lista", dao.lista());
				request.setAttribute("acao", acao);
				
			   return "lista/lista1.jsp";
		   }else {
			   
				LojaDao dao = (LojaDao) ActionDao.loadClasse("LojaDao");
				request.setAttribute("lista", dao.lista());			   
				request.setAttribute("acao", acao);
				
			   return "lista/lista2.jsp";
		   }		
	}

	@Override
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionDao dao = (ActionDao) ActionDao.loadClasse((String)request.getAttribute("dao"));
		dao.adicionar((Form)request.getAttribute("form"));		
		return "index.jsp";
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
			retorno = "cadastros/ServicoForm.jsp";
		}else {
			request.setAttribute("mensagem", "É necessário um usuário logado para castrar um serviço.");
		}
				
		return retorno;	
	}

	@Override
	public String form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String  retorno = "";
		
		ServicoForm servicoForm = (ServicoForm) request.getAttribute("form");
		
		if(servicoForm != null) {
			request.setAttribute("form", servicoForm);
			request.setAttribute("dao", "ServicoDao");
			request.setAttribute("acao", "Servico");
			request.setAttribute("metodo", "add");
			retorno = "/controler";
		}else {
			retorno = "cadastros/ServicoForm.jsp";
		}
		
		
		System.out.println("cadastro Servico");
		
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
