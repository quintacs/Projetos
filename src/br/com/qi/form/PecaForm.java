package br.com.qi.form;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class PecaForm implements Form, Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8853039285952492057L;
	
	private Long idEmpresa;
	private Long id;
	private String nome;
	private String modelo;
	private Long ano;
	private String cor;
	private String marca;
	private List<File> imagens;

	public long getId() {
		return id;
	}
	public void  setId(long id) {
		this.id = id;  
	}	
	
	public long getIdEmpresa() {
		return idEmpresa;
	}
	public void  setIdEmpresa(long idEmpresa) {
		this.idEmpresa = idEmpresa;  
	}	
	public String getNome() {
		return nome;
	}
	public String getModelo() {
		return modelo;
	}
	public Long getAno() {
		return ano;
	}
	public String getCor() {
		return cor;
	}
	public String getMarca() {
		return marca;
	}
	public List<File> getImagens() {
		return imagens;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setAno(Long ano) {
		this.ano = ano;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setImagens(List<File> imagens) {
		this.imagens = imagens;
	}
	
	@Override
	public Form parse(ServletRequest req, ServletResponse resp) {
		// TODO Auto-generated method stub
		// return new PecaForm();
		String mensagem = "";
		
		if(req.getParameter("nome") == null || "".equals(req.getParameter("nome")) ) 			
			mensagem += "O campo nome é de preenchimento origatório <br />";

		if(req.getParameter("modelo") == null || "".equals(req.getParameter("modelo")) ) 			
			mensagem += "O campo modelo é de preenchimento origatório <br />";

		if(req.getParameter("cor") == null || "".equals(req.getParameter("cor")) ) 			
			mensagem += "O campo cor é de preenchimento origatório <br />";

		if(req.getParameter("marca") == null || "".equals(req.getParameter("marca")) ) 			
			mensagem += "O campo marca é de preenchimento origatório <br />";

		if(req.getParameter("ano") == null || "".equals(req.getParameter("ano")) ) 			
			mensagem += "O campo ano é de preenchimento origatório <br />";

		if(req.getParameter("idEmpresa") == null || "".equals(req.getParameter("idEmpresa")) ) 			
			mensagem = "É necessário que ao menos um funcionário esteja logado <br />";
				
		if(!"".equalsIgnoreCase(mensagem)) {
			//req.setAttribute("formlario", u);
			req.setAttribute("mensagem",mensagem);
			return null;
		}
		
		PecaForm pecaForm = new PecaForm();
		
		pecaForm.setNome(req.getParameter("nome"));
		pecaForm.setModelo(req.getParameter("modelo"));		
		pecaForm.setCor(req.getParameter("cor"));
		pecaForm.setMarca(req.getParameter("marca"));
		
		pecaForm.setAno(Long.parseLong(req.getParameter("ano") == null ? "0" : 
			"".equals(req.getParameter("ano"))? "0" :req.getParameter("ano")));
		
		pecaForm.setIdEmpresa(Long.parseLong(req.getParameter("idEmpresa") == null ? "5" : 
								"".equals(req.getParameter("idEmpresa"))? "5" :req.getParameter("idEmpresa")));
		
		return pecaForm;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result + ((cor == null) ? 0 : cor.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idEmpresa == null) ? 0 : idEmpresa.hashCode());
		result = prime * result + ((imagens == null) ? 0 : imagens.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
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
		PecaForm other = (PecaForm) obj;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (cor == null) {
			if (other.cor != null)
				return false;
		} else if (!cor.equals(other.cor))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idEmpresa == null) {
			if (other.idEmpresa != null)
				return false;
		} else if (!idEmpresa.equals(other.idEmpresa))
			return false;
		if (imagens == null) {
			if (other.imagens != null)
				return false;
		} else if (!imagens.equals(other.imagens))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
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
		return this.getNome();
	}
	
	@Override
	public String getDescricaoForm() {
		// TODO Auto-generated method stub
		return getMarca()+" "+getModelo()+" "+getAno();
	}
}
