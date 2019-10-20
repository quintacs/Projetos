package br.com.qi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.qi.dao.ActionDao;
import br.com.qi.dao.LoginDao;
import br.com.qi.form.Form;
import br.com.qi.form.LoginForm;
import br.com.qi.form.UsuarioForm;

public class LoginAction extends Action {

	@Override
	public String main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String  retorno = "";
		
		LoginForm loginForm = (LoginForm) request.getAttribute("form");
		
		if(loginForm != null) {									
			LoginDao dao = (LoginDao) ActionDao.loadClasse("LoginDao"); 
			HttpSession session = request.getSession();
			session.setAttribute("usuario", dao.consulta(loginForm));
			session.setAttribute("lista", dao.lista(loginForm));
			
			retorno = "principal.jsp";
		}else {
			retorno = "cadastros/LoginForm.jsp";
		}
		
		return retorno;
	}

	@Override
	public String loadList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		/* A LISTA DE LOGIN DEVE CONTER OS USUÁRIOS DA EMPRESA 
		 * PARA QUE A MESMA SEJA EXIBIDA O USUÁRIO DEVE ESTAR LOGADO 
		 * POIS A LISTA É EXIBIDA DE ACORDO COM O PERFIL DO USUARIO 
		 * QUE ESTA NA SESSÃO DO SERVLET*/
		
		//LoginDao dao = (LoginDao) ActionDao.loadClasse("LoginDao");
		//request.setAttribute("lista", dao.lista());
		
		return null; // "lista/lista1.jsp";
	}

	@Override
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionDao dao = (ActionDao) ActionDao.loadClasse((String)request.getAttribute("dao"));
		dao.adicionar(((UsuarioForm)request.getAttribute("form")).getLoginForm());
		
		//request.setAttribute("form", (Form)request.getAttribute("form"));
		request.setAttribute("mensagem", "Os dados foram salvos com sucesso.");
		return  "cadastros/UsuarioForm.jsp";//"index.jsp";
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
		return "cadastros/LoginForm.jsp";
	}

	@Override
	public String form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String  retorno = "";
		
		LoginForm loginForm = (LoginForm) request.getAttribute("form");
		
				
		if(loginForm == null) {

			request.setAttribute("mensagem", "Usuário invalido.");
			retorno = "cadastros/LoginForm.jsp";
			
		}else {
			
			LoginDao dao = (LoginDao) ActionDao.loadClasse("LoginDao");		
			loginForm = (LoginForm)dao.consulta(loginForm);
			
			if(loginForm !=null) {
				
				request.getSession(true);			
				request.getSession().setAttribute("form", loginForm);	
				request.getSession().setAttribute("minIndex", "1");
				request.getSession().setAttribute("maxIndex", "50");
				request.setAttribute("acao", "Principal");
				request.setAttribute("metodo", "loadList");
				retorno = "/controler";
				
			}
			else{
				request.setAttribute("mensagem", "Usuário não cadastrado.");
				retorno = "cadastros/LoginForm.jsp";
			}

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
