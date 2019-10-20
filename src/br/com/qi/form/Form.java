package br.com.qi.form;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public interface Form {	
	
	String getNomeForm();
	String getDescricaoForm();
	Form parse(ServletRequest req , ServletResponse resp);
}
