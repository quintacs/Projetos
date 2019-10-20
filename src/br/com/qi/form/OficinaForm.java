package br.com.qi.form;

import java.io.Serializable;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class OficinaForm implements Form, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5734626167781488209L;
	
	private Long id;
	private String nome;
	private String nomeFantasia;
	private String CNPJ;	
	private String telefone;
	private String celular;
	private String email;	
	private Long codTipoEmpresa;
	private String endereco;
	private Long idUsuario;
	
	
	
	public long getId() {
		return id;
	}
	public void setID(long id) {
		this.id = id;
	}
	public void setCelular(String celular) {
	    this.celular = celular;	
	}
	
	public String getCecular() {
		return celular;
	}
	
	public void setCodTipoEmpresa(Long codTipoEmpresa) {
	    this.codTipoEmpresa = codTipoEmpresa;	
	}
	
	public void setCodTipoEmpresa(String codTipoEmpresa) {
	    this.codTipoEmpresa = Long.parseLong(codTipoEmpresa);	
	}
	
	public Long getCodTipoEmpresa() {
		return codTipoEmpresa;
	}
	
	public void setIdUsuaio(Long idUsuario) {
	    this.idUsuario = idUsuario;	
	}
	
	public void setIdUsuaio(String idUsuario) {
	    this.idUsuario = Long.parseLong(idUsuario);	
	}
	
	public Long getIdUsuario() {
		return idUsuario;
	}	

	public void setEndereco(String endereco) {
	    this.endereco = endereco;	
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEmail(String email) {
	    this.email = email;	
	}
	
	public String getEmail() {
		return email;
	}	
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getnomeFantasia() {
		return nomeFantasia;
	}


	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCNPJ() {
		return CNPJ;
	}


	public void setCNPJ(String CNPJ) {
		this.CNPJ = CNPJ;
	}
	
	@Override
	public Form parse(ServletRequest req, ServletResponse resp) {
		// TODO Auto-generated method stub
		// return new OficinaForm();
		String mensagem = "";
		
		if(req.getParameter("nome") == null || "".equals(req.getParameter("nome")) )
			mensagem +=" O campo pessoa juridica é de preenchimento obrigatório <br />";
		if(req.getParameter("nomeFantasia") == null || "".equals(req.getParameter("nomeFantasia")) )
			mensagem +=" O campo nome fantasia é de preenchimento obrigatório <br />";
		if(req.getParameter("CNPJ") == null || "".equals(req.getParameter("CNPJ")) )
			mensagem +=" O campo cnpj é de preenchimento obrigatório <br />";
		if(req.getParameter("telefone") == null || "".equals(req.getParameter("telefone")) )
			mensagem +=" O campo telefone é de preenchimento obrigatório <br />";
		if(req.getParameter("celular") == null || "".equals(req.getParameter("celular")) )
			mensagem +=" O campo celular é de preenchimento obrigatório <br />";	
		if(req.getParameter("email") == null || "".equals(req.getParameter("email")) )
			mensagem +=" O campo email é de preenchimento obrigatório <br />";

		/*if(req.getParameter("senha") == null || "".equals(req.getParameter("senha")) ) 			
			return null;
		if(req.getParameter("csenha") == null || "".equals(req.getParameter("csenha")) ) 			
			return null;		
		
		System.out.println(req.getParameter("senha")+" - "+req.getParameter("csenha"));
		
		if(!req.getParameter("senha").equals(req.getParameter("csenha")))
			return null;*/		
		
		if(!"".equalsIgnoreCase(mensagem)) {
			//req.setAttribute("formlario", u);
			req.setAttribute("mensagem",mensagem);
			return null;
		}
		
		OficinaForm oficinaForm = new OficinaForm();
		
		oficinaForm.setNome(req.getParameter("nome"));
		oficinaForm.setNomeFantasia(req.getParameter("nomeFantasia"));
		oficinaForm.setCNPJ(req.getParameter("CNPJ"));		
		oficinaForm.setTelefone(req.getParameter("telefone"));
		oficinaForm.setCelular(req.getParameter("celular"));
		oficinaForm.setEmail(req.getParameter("email"));
		oficinaForm.setEndereco(req.getParameter("endereco"));			
		oficinaForm.setCodTipoEmpresa("1");
		
		/*
		 * oficinaForm.setCodTipoEmpresa(req.getParameter("codTipoEmpresa") == null ?
		 * "1" : "".equals(req.getParameter("codTipoEmpresa"))? "1"
		 * :req.getParameter("codTipoEmpresa"));
		 */
		
		/*
		 * oficinaForm.setIdUsuaio(req.getParameter("idUsuario") == null ? "100" :
		 * "".equals(req.getParameter("idUsuario"))? "100"
		 * :req.getParameter("idUsuario"));
		 */
		
		return oficinaForm;
		 		 
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CNPJ == null) ? 0 : CNPJ.hashCode());
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((codTipoEmpresa == null) ? 0 : codTipoEmpresa.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nomeFantasia == null) ? 0 : nomeFantasia.hashCode());
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
		OficinaForm other = (OficinaForm) obj;
		if (CNPJ == null) {
			if (other.CNPJ != null)
				return false;
		} else if (!CNPJ.equals(other.CNPJ))
			return false;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (codTipoEmpresa == null) {
			if (other.codTipoEmpresa != null)
				return false;
		} else if (!codTipoEmpresa.equals(other.codTipoEmpresa))
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nomeFantasia == null) {
			if (other.nomeFantasia != null)
				return false;
		} else if (!nomeFantasia.equals(other.nomeFantasia))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	@Override
	public String getNomeForm() {
		// TODO Auto-generated method stub
		return this.getnomeFantasia();
	}
	
	@Override
	public String getDescricaoForm() {
		// TODO Auto-generated method stub
		return getTelefone()+" "+getEmail()+" "+getEndereco();
	}
}
