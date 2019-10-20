package br.com.qi.form;

import java.io.Serializable;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServicoForm implements Form,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2989822169139008778L;
	
	private long id;
	private String nome;
	private String descricao;
	private Long idEmpresa;
	
	public long getIdEmpresa() {
		return idEmpresa;
	}
	public void  setIdEmpresa(long idEmpresa) {
		this.idEmpresa = idEmpresa;  
	}	
	
	public long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public Form parse(ServletRequest req, ServletResponse resp) {
		// TODO Auto-generated method stub
		
		String mensagem = "";
		
		if(req.getParameter("nome") == null || "".equals(req.getParameter("nome")) ) 
			mensagem += "O campo nome é de preenchimento origatório <br />";
		
		if(req.getParameter("descricao") == null || "".equals(req.getParameter("descricao")) ) 
			mensagem += "O campo descrição é de preenchimento origatório <br />";

		if(req.getParameter("idEmpresa") == null || "".equals(req.getParameter("idEmpresa")) ) 			
			mensagem = "É necessário que ao menos um funcionário esteja logado <br />";
			
		if(!"".equalsIgnoreCase(mensagem)) {
			//req.setAttribute("formlario", u);
			req.setAttribute("mensagem",mensagem);
			return null;
		}		
		
		ServicoForm servicoForm = new ServicoForm();
		servicoForm.setNome(req.getParameter("nome"));	
		servicoForm.setDescricao(req.getParameter("descricao"));

		servicoForm.setIdEmpresa(Long.parseLong(req.getParameter("idEmpresa") == null ? "5" : 
			"".equals(req.getParameter("idEmpresa"))? "5" :req.getParameter("idEmpresa")));	
		
		return servicoForm;		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((idEmpresa == null) ? 0 : idEmpresa.hashCode());
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
		ServicoForm other = (ServicoForm) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id != other.id)
			return false;
		if (idEmpresa == null) {
			if (other.idEmpresa != null)
				return false;
		} else if (!idEmpresa.equals(other.idEmpresa))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	@Override
	public String getNomeForm() {
		// TODO Auto-generated method stub
		return getNome();
	}
	
	@Override
	public String getDescricaoForm() {
		// TODO Auto-generated method stub
		return getDescricao();
	}
}
