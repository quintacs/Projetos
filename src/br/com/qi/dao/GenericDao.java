package br.com.qi.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.qi.form.Form;
import br.com.qi.form.LojaForm;
import br.com.qi.form.OficinaForm;
import br.com.qi.form.PecaForm;
import br.com.qi.form.ProdutoForm;
import br.com.qi.form.ServicoForm;

public class GenericDao {


	private List<Object> listaGenerica = null; 
		
	public List<Object> listaString() throws Exception {
		
		listaGenerica = new ArrayList<>();
		
		int indice = 1;
		
		LojaDao lojas = (LojaDao) ActionDao.loadClasse("LojaDao");								
		for(Form frm : lojas.lista()) {			
			LojaForm loja = (LojaForm)frm;
			
			if(indice < 5) 			
				listaGenerica.add(loja);
			
			if(indice == lojas.lista().size() || indice == 5 )
				break;
			
			indice+=1;
		}
		
		indice = 1;	
		OficinaDao oficinas = (OficinaDao) ActionDao.loadClasse("OficinaDao");
		for(Form frm : oficinas.lista()) {			
																		
			OficinaForm oficina = (OficinaForm)frm;

			if(indice < 5) 			
				listaGenerica.add(oficina);
			
			if(indice == oficinas.lista().size() || indice == 5 )
				break;
			
			indice+=1;
	    }
		
		indice = 1;
		PecaDao pecas = (PecaDao) ActionDao.loadClasse("PecaDao");
		for(Form frm : pecas.lista()) {
						 
				PecaForm peca = (PecaForm)frm;
				if(indice < 5) 			
					listaGenerica.add(peca);
				
				if(indice == pecas.lista().size() || indice == 5 )
					break;
				
				indice+=1;
		  }
				
		indice = 1;
		ProdutoDao produtos = (ProdutoDao) ActionDao.loadClasse("ProdutoDao");	
		for(Form frm : produtos.lista()) {
					
			ProdutoForm produto = (ProdutoForm)frm;
			if(indice < 5) 			
				listaGenerica.add(produto);
			
			if(indice == produtos.lista().size() || indice == 5 )
				break;		
			
			indice+=1;
		}
		
		indice = 1;
		ServicoDao servicos = (ServicoDao) ActionDao.loadClasse("ServicoDao");	
		for(Form frm :servicos.lista()) {
					
			ServicoForm servico = (ServicoForm)frm;
			if(indice < 5) 			
				listaGenerica.add(servico);
			
			if(indice == servicos.lista().size() || indice == 5 )
				break;
			
			indice+=1;
		}			
	
	return listaGenerica;
}
	
	
	
	public void adicionar(Object object) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public void alterar(Object object) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public Form consulta(Object object) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Form> lista(Object object) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void excluir(Object object) throws Exception {
		// TODO Auto-generated method stub
		
	}	
}
