package br.com.qi.form;

import java.io.Serializable;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FaleForm implements Form, Serializable {

	private int id;
	private String nome;
	private String email;
	private String mensagem;
	
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public String getNomeForm() {
		// TODO Auto-generated method stub
		return this.nome;
	}

	@Override
	public String getDescricaoForm() {
		// TODO Auto-generated method stub
		return this.email+"\n\n"+this.mensagem+"\n";
	}

	@Override
	public Form parse(ServletRequest req, ServletResponse resp) {
		// TODO Auto-generated method stub
		
		if(req.getParameter("nome") == null || "".equals(req.getParameter("nome")) )
			return null;
		if(req.getParameter("email") == null || "".equals(req.getParameter("email")) )
			return null;
		if(req.getParameter("mensagem") == null || "".equals(req.getParameter("mensagem")) )
			return null;
		
		FaleForm faleForm = new FaleForm();
		faleForm.setNome(req.getParameter("nome"));
		faleForm.setEmail(req.getParameter("email"));
		faleForm.setMensagem(req.getParameter("mensagem"));
		
		return faleForm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((mensagem == null) ? 0 : mensagem.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		FaleForm other = (FaleForm) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (mensagem == null) {
			if (other.mensagem != null)
				return false;
		} else if (!mensagem.equals(other.mensagem))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
