package br.com.qi.form;

import java.io.File;
import java.io.Serializable;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ProdutoForm implements Form,Serializable	{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8219363951450535573L;

	private Long id;
	private String nome;
	private String marca;
	private String descricao;
	private File imagem;
	private Long idEmpresa;
	
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
	
	public File getImagem() {
		return imagem;
	}
	
	public String getNome() {
		return nome;
	}
	public String getMarca() {
		return marca;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public void setImagem(File imagem) {
		this.imagem = imagem;
	}
			
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setMarca(String marca) {
		this.marca = marca;
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
		
		if(req.getParameter("marca") == null || "".equals(req.getParameter("marca")) ) 
			mensagem += "O campo marca é de preenchimento origatório <br />";
		
		if(req.getParameter("descricao") == null || "".equals(req.getParameter("descricao")) ) 
			mensagem += "O campo descricao é de preenchimento origatório <br />";

		if(req.getParameter("idEmpresa") == null || "".equals(req.getParameter("idEmpresa")) ) 			
			mensagem = "É necessário que ao menos um funcionário esteja logado <br />";
			
		if(!"".equalsIgnoreCase(mensagem)) {
			//req.setAttribute("formlario", u);
			req.setAttribute("mensagem",mensagem);
			return null;
		}
		
		ProdutoForm produtoForm = new ProdutoForm();
		produtoForm.setNome(req.getParameter("nome"));
		produtoForm.setMarca(req.getParameter("marca"));
		produtoForm.setDescricao(req.getParameter("descricao"));
		
		produtoForm.setIdEmpresa(Long.parseLong(req.getParameter("idEmpresa") == null ? "5" : 
			"".equals(req.getParameter("idEmpresa"))? "5" :req.getParameter("idEmpresa")));		
		
		return produtoForm;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idEmpresa == null) ? 0 : idEmpresa.hashCode());
		result = prime * result + ((imagem == null) ? 0 : imagem.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
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
		ProdutoForm other = (ProdutoForm) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
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
		if (imagem == null) {
			if (other.imagem != null)
				return false;
		} else if (!imagem.equals(other.imagem))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
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
		return getMarca()+" "+getDescricao();
	}
	
	
	
}
