package br.com.qi.action;

import java.util.Hashtable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.qi.dao.ActionDao;
import br.com.qi.dao.PrincipalDao;
import br.com.qi.form.Form;
import br.com.qi.form.LoginForm;

public class PrincipalAction extends Action {

	private Hashtable<String , List<Form>> lsTabela;// = new Hashtable<String , List<Form>>();
	private List<Form> listForms = null;
	
	@Override
	public String main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String loadList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String minIndex, maxIndex, retorno =  "lista/lista1.jsp"; // "principal.jsp";
		
		LoginForm form = (LoginForm) request.getSession().getAttribute("form");
		
		minIndex = (String)request.getSession().getAttribute("minIndex") ;
		maxIndex = (String)request.getSession().getAttribute("maxIndex") ;
		
		request.setAttribute("acao", "Loja");
		
		if(minIndex == null) {
			minIndex = "1";
		}
		
		if(maxIndex == null) {
			maxIndex = "50";
		}	
		
		if(form != null) {
			
			PrincipalDao dao = (PrincipalDao) ActionDao.loadClasse("PrincipalDao");
			int x, y;
			x = Integer.parseInt(minIndex);
			y = Integer.parseInt(maxIndex);
			
			listForms = (List<Form>)  dao.getLista(x,y);
			
			request.getSession().setAttribute("form", form);
			request.getSession().setAttribute("lista", listForms);
			
		}else {
			retorno = "index";
		}
		
		return retorno;
	}

	@Override
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
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
		return null;
	}

	@Override
	public String form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
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
