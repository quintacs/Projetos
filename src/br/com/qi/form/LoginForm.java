package br.com.qi.form;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginForm implements Form {

	private int id;
	private String email;
	private String senha;
	//private String csenha;
	private String nome; 
	
	/*
	 * public void setCsenha(String cSenha) { this.csenha = cSenha; }
	 * 
	 * public String getCsenha() { return this.csenha; }
	 */
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id; 
	}
	
	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getNome() {		
		return nome;
	}
	
	@Override
	public String getNomeForm() {
		// TODO Auto-generated method stub
		return nome;
	}

	@Override
	public String getDescricaoForm() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Form parse(ServletRequest req, ServletResponse resp) {
		// TODO Auto-generated method stub
		
		if(req.getParameter("email") == null || "".equals(req.getParameter("email")) )
			return null;
		if(req.getParameter("senha") == null || "".equals(req.getParameter("senha")) )
			return null;		
		/*
		 * if(req.getParameter("nome") == null || "".equals(req.getParameter("nome")) )
		 * return null;
		 */		
		
		LoginForm emailForm = new LoginForm();
		emailForm.setEmail(req.getParameter("email"));
		emailForm.setSenha(req.getParameter("senha"));
		//emailForm.setNome(req.getParameter("nome"));
		//emailForm.setId(req.getParameter("id") != null? Integer.parseInt(req.getParameter("id")):null);
		
		return emailForm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginForm other = (LoginForm) obj;
		if (id != other.id)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}



}
