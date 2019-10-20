package br.com.qi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.qi.dao.ActionDao;
import br.com.qi.dao.UsuarioDao;
import br.com.qi.form.Form;
import br.com.qi.form.LoginForm;
import br.com.qi.form.UsuarioForm;

public class UsuarioAction extends Action {

	private HttpSession session;
	
	@Override
	public String main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String  retorno = "";
		
		UsuarioForm usuarioForm = (UsuarioForm) request.getAttribute("usuario");
		
		if(usuarioForm != null) {									
			UsuarioDao dao = (UsuarioDao) ActionDao.loadClasse("UsuarioDao"); 
			 session = request.getSession();
			session.setAttribute("usuario", usuarioForm);
			session.setAttribute("lista", dao.lista(usuarioForm));
			
			retorno = "principal.jsp";
		}else {
			retorno = "cadastros/UsuarioForm.jsp";
		}
		
		return retorno;
	}

	@Override
	public String loadList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionDao dao = (ActionDao) ActionDao.loadClasse((String)request.getAttribute("dao"));
		dao.adicionar((Form)request.getAttribute("form"));
		
		UsuarioForm usuarioForm = (UsuarioForm)request.getAttribute("form");
		
		request.setAttribute("dao", "LoginDao");
		request.setAttribute("acao", "Login");			
		request.setAttribute("metodo", "add");
		request.setAttribute("form", usuarioForm);
		
		return "/controler";//"index.jsp";
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
		request.setAttribute("mensagem", "");

		return "cadastros/UsuarioForm.jsp";
	}

	@Override
	public String form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String  retorno = "", mensagem = "";
		
		mensagem = (String)request.getAttribute("mensagem");
				
		UsuarioForm usuarioForm = (UsuarioForm) request.getAttribute("form");
		
		if(usuarioForm != null) {
			
			UsuarioDao usuarioDao = (UsuarioDao) ActionDao.loadClasse("UsuarioDao");	
			usuarioForm = (UsuarioForm) usuarioDao.consulta(usuarioForm);
			
			if(usuarioForm == null ) {
				
				request.setAttribute("form", usuarioForm);
				request.setAttribute("dao", "UsuarioDao");
				request.setAttribute("acao", "Usuario");
				request.setAttribute("metodo", "add");			
				
				retorno = "/controler";
			}else {
				request.setAttribute("mensagem", "Usuário já cadastrado.");
				retorno = "cadastros/UsuarioForm.jsp";
			}
			
		}else {
			
			//usuarioForm = (UsuarioForm)request.getAttribute("formlario");
			//request.setAttribute("form", (Form)request.getAttribute("formlario"));
			request.setAttribute("mensagem", mensagem);
			//System.out.println(session.getAttribute("formulario"));
			
			retorno = "cadastros/UsuarioForm.jsp";
		}
		
		
		System.out.println("cadastro Login");
		
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
