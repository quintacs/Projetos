package br.com.qi.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import br.com.qi.form.Form;

public class FiltraRequisicao implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {				
		// TODO Auto-generated method stub
		
		String clase = null, acao = request.getParameter("acao");					
		 
		/*HttpServletRequest req =(HttpServletRequest)request;		
		System.out.println("uri: "+req.getRequestURI());
		System.out.println("url: "+req.getRequestURL());
		*/
		
		if(acao == null ) 
		   acao = (String) request.getAttribute("acao");		
		
		
        if(acao != null && !acao.equals("")) {
        	//clase = request.getServletContext().getInitParameter(acao+"Form");
        	clase = "br.com.qi.form."+acao+"Form";
        	try {
        		// TODO Auto-generated method stub      	  
        		Class classe = Class.forName(clase);  
        		Form form =(Form) classe.newInstance();
        		
        		request.setAttribute("form", form.parse(request, response));
			  
        	}catch (Exception e) {
				// TODO: handle exception
        		throw new RuntimeException(e);
			}
        }
        						
		filterChain.doFilter(request, response);
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
