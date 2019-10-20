package br.com.qi.form;

import java.io.Serializable;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UsuarioForm implements Form,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idUsuario;
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	private String celular;
	private String email;
	private LoginForm loginForm;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + (int) (idUsuario ^ (idUsuario >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());		
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
		UsuarioForm other = (UsuarioForm) obj;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (idUsuario != other.idUsuario)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;		
		return true;
	}

	public LoginForm getLoginForm() {
		return this.loginForm;
	}
	
	public void setLoginForm(LoginForm loginForm) {
		this.loginForm = loginForm;
	}
	
	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String getNomeForm() {
		// TODO Auto-generated method stub
		return this.nome;
	}

	@Override
	public String getDescricaoForm() {
		// TODO Auto-generated method stub
		return nome +"\n"+ email;
	}

	@Override
	public Form parse(ServletRequest req, ServletResponse resp) {
		// TODO Auto-generated method stub
		String mensagem = "";
		
		if(req.getParameter("nome") == null || "".equals(req.getParameter("nome")) ) {
			mensagem += "O campo nome é de preenchimento origatório <br />";
			//req.setAttribute("mensagem", "Erro ao cadastrar o nome");
			//return null;
		}
		if(req.getParameter("cpf") == null || "".equals(req.getParameter("cpf")) ) {
			mensagem += "O campo CPF é de preenchimento obrigatório <br />";
			//req.setAttribute("mensagem", "Erro ao cadastrar o cpf");
			//return null;
		}
		if(req.getParameter("telefone") == null || "".equals(req.getParameter("telefone")) ) {
			mensagem += "O campo Telefone é de preenchimento obrigatório <br />";
			//req.setAttribute("mensagem", "Erro ao cadastrar o telefone");
			//return null;
		}
		if(req.getParameter("celular") == null || "".equals(req.getParameter("celular")) ) {
			mensagem += "O campo Celular é de preenchimento obrigatório <br />";
			//req.setAttribute("mensagem", "Erro ao cadastrar o celular");
			//return null;
		}
		if(req.getParameter("email") == null || "".equals(req.getParameter("email")) ) {
			mensagem += "O campo E-mail é de preenchimento obrigatório <br />";
			//req.setAttribute("mensagem", "Erro ao cadastrar o e-mail");
			//return null;		
		}
		if(req.getParameter("endereco") == null || "".equals(req.getParameter("endereco")) ) {
			mensagem += "O campo Endereco é de preenchimento obrigatório <br />";
			//req.setAttribute("mensagem", "Erro ao cadastrar o endereço");
			//return null;
		}					
		if(req.getParameter("senha") == null || "".equals(req.getParameter("senha")) ) { 			
			mensagem += "O campo Senha é de preenchimento obrigatório <br />";
			//req.setAttribute("mensagem", "Erro ao cadastrar a senha");
			//return null;
		}
		if(req.getParameter("csenha") == null || "".equals(req.getParameter("csenha")) ) { 			
			mensagem += "O campo Confirmação de senha é de preenchimento obrigatório <br />";
			//req.setAttribute("mensagem", "Erro ao confirmar senha");
			//return null;		
		}

		System.out.println(req.getParameter("senha")+" - "+req.getParameter("csenha"));

	if(req.getParameter("senha") != null && req.getParameter("csenha") != null)
		if(!req.getParameter("senha").equals(req.getParameter("csenha"))) {
			mensagem = "As senhas estão diferentes \n <br />";
			//req.setAttribute("mensagem", "Erro, as senhas são diferentes");
			//return null;		
		}
	
	
	if(!"".equalsIgnoreCase(mensagem)) {
		//req.setAttribute("formlario", u);
		req.setAttribute("mensagem",mensagem);
		return null;
	}
	
		UsuarioForm u = new UsuarioForm();
		
		//u.setIdUsuario(req.getParameter("idUsuario")!=null ? Long.parseLong(req.getParameter("idUsuario")): 0 );
		u.setNome(req.getParameter("nome"));
		u.setCpf(req.getParameter("cpf"));
		u.setEndereco(req.getParameter("endereco"));
		u.setTelefone(req.getParameter("telefone"));
		u.setCelular(req.getParameter("celular"));
		u.setEmail(req.getParameter("email"));
		
		this.loginForm = new LoginForm();
		//this.loginForm.setId(req.getParameter("id") != null ? Integer.parseInt(req.getParameter("id")): 0 );
		this.loginForm.setNome(req.getParameter("nome"));
		this.loginForm.setEmail(req.getParameter("email"));
		this.loginForm.setSenha(req.getParameter("senha"));
		//this.loginForm.setCsenha(req.getParameter("csenha"));
		
		u.setLoginForm(loginForm);
		

		
		return u;
	}
	
	

}
