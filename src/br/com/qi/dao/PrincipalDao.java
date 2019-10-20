package br.com.qi.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.qi.form.Form;
import br.com.qi.form.LojaForm;

public class PrincipalDao extends ActionDao {

	private String sql = "";
	private Hashtable<String , List<Form>> tabela;
	private List<Form> listForms;
	
	@Override
	public void adicionar(Form frm) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void alterar(Form frm) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Form consulta(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Form> lista(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Form> lista() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(Long id) throws Exception {
		// TODO Auto-generated method stub

	}

	public Hashtable<String, List<Form>> listaTabela(int minIndex, int maxIndex)throws Exception{
		
		int nPaginas = 0 , y = 0 ;
		int totalRegistros = 0 ;
		
		tabela = new Hashtable<String, List<Form>>();
		
		sql = "SELECT * \n"; 
		sql += " FROM ( \n";
		sql += "       SELECT B.*,   ROWNUM RNUM \n";    
		sql += "           FROM(  \n";    
		sql += " 		SELECT IDEMPRESA, NOME_EMPRESA, NOME_FANTASIA, CNPJ ,TELEFONE, CELULAR, EMAIL, CODTIPOEMPRESA, ENDERECO_EMPRESA, NOME_PROPIETOR, CPF, ENDERECO, IDUSUARIO \n";
		sql += " 		FROM EMPRESA E \n";
		sql += "              	WHERE ROWNUM <= ? --MAX_ROWS  \n";         
		sql += "	        ORDER BY IDEMPRESA  \n";
		sql += "              ) B \n";
		sql += "    ) A \n";
		sql += " WHERE A.RNUM >= ? --MIN_ROWS \n";  
		
		
			LojaForm form = null;
			
			// CALCULA O NUMERO DE PAGINAS
			totalRegistros = this.getQuantidade("EMPRESA");
			
			if(totalRegistros % maxIndex != 0) {
				nPaginas = ((int)totalRegistros / maxIndex )+ 1;
			}else {
				nPaginas = ((int)totalRegistros / maxIndex );
			}
			
			pstm = getConnection().prepareStatement(sql);
			pstm.setInt(1, maxIndex);
			pstm.setInt(2, minIndex);
			
			rs = pstm.executeQuery();
			
			for(int i = 1;i <= nPaginas; i++) {
				y = 1;
				listForms = new ArrayList<Form>();
				
				while (rs.next() && y <= 50) {
					form = new LojaForm();
					form.setID(rs.getLong("IDEMPRESA"));
					form.setNome(rs.getString("NOME_EMPRESA"));
					form.setNomeFantasia(rs.getString("nome_fantasia"));
					form.setCNPJ(rs.getString("CNPJ"));				
					form.setTelefone(rs.getString("telefone"));
					form.setCelular(rs.getString("celular"));
					form.setEmail(rs.getString("email"));
					form.setCodTipoEmpresa(rs.getLong("codtipoempresa"));
					form.setEndereco(rs.getString("endereco"));
					form.setIdUsuaio(rs.getLong("idusuario"));
					
					listForms.add(form);
					
					y++;					
				}
				tabela.put(i+"", listForms);
			}
			
			rs.close();
			pstm.close();
			
			
		return this.tabela;
	}
	
	public Hashtable<String, List<Form>> listaTabela()throws Exception{
		
		int nPaginas = 0 , y = 0 ;
		int totalRegistros = 0 ;
		
		tabela = new Hashtable<String, List<Form>>();
		
		sql = "SELECT * \n"; 
		sql += " FROM ( \n";
		sql += "       SELECT B.*,   ROWNUM RNUM \n";    
		sql += "           FROM(  \n";    
		sql += " 		SELECT IDEMPRESA, NOME_EMPRESA, NOME_FANTASIA, CNPJ ,TELEFONE, CELULAR, EMAIL, CODTIPOEMPRESA, ENDERECO_EMPRESA, NOME_PROPIETOR, CPF, ENDERECO, IDUSUARIO \n";
		sql += " 		FROM EMPRESA E \n";
		sql += "              	WHERE ROWNUM <= ? --MAX_ROWS  \n";         
		sql += "	        ORDER BY IDEMPRESA  \n";
		sql += "              ) B \n";
		sql += "    ) A \n";
		sql += " WHERE A.RNUM >= ? --MIN_ROWS \n";  
		
		
			LojaForm form = null;
			
			// CALCULA O NUMERO DE PAGINAS
			totalRegistros = this.getQuantidade("EMPRESA");
			
			if(totalRegistros % 50 != 0) {
				nPaginas = ((int)totalRegistros / 50 )+ 1;
			}else {
				nPaginas = ((int)totalRegistros / 50 );
			}
			
			pstm = getConnection().prepareStatement(sql);
			pstm.setInt(1, totalRegistros);
			pstm.setInt(2, 1);
			
			rs = pstm.executeQuery();
			
			for(int i = 1;i <= nPaginas; i++) {
				y = 1;
				listForms = new ArrayList<Form>();
				
				while (rs.next() && y <= 50) {
					form = new LojaForm();
					form.setID(rs.getLong("IDEMPRESA"));
					form.setNome(rs.getString("NOME_EMPRESA"));
					form.setNomeFantasia(rs.getString("nome_fantasia"));
					form.setCNPJ(rs.getString("CNPJ"));				
					form.setTelefone(rs.getString("telefone"));
					form.setCelular(rs.getString("celular"));
					form.setEmail(rs.getString("email"));
					form.setCodTipoEmpresa(rs.getLong("codtipoempresa"));
					form.setEndereco(rs.getString("endereco"));
					form.setIdUsuaio(rs.getLong("idusuario"));
					
					listForms.add(form);
					
					y++;					
				}
				tabela.put(i+"", listForms);
			}
			
			rs.close();
			pstm.close();
			
			
		return this.tabela;
	}
	
	public List<Form> getLista(int minIndex, int maxIndex)throws Exception{
		
		this.listForms = new ArrayList<Form>();
		
		sql = "SELECT * \n"; 
		sql += " FROM ( \n";
		sql += "       SELECT B.*,   ROWNUM RNUM \n";    
		sql += "           FROM(  \n";    
		sql += " 		SELECT IDEMPRESA, NOME_EMPRESA, NOME_FANTASIA, CNPJ ,TELEFONE, CELULAR, EMAIL, CODTIPOEMPRESA, ENDERECO_EMPRESA, NOME_PROPIETOR, CPF, ENDERECO, IDUSUARIO \n";
		sql += " 		FROM EMPRESA E \n";
		sql += "              	WHERE ROWNUM <= ? --MAX_ROWS  \n";  
		//sql += "              	AND CODTIPOEMPRESA = 2 \n";
		sql += "	        ORDER BY IDEMPRESA  \n";
		sql += "              ) B \n";
		sql += "    ) A \n";
		sql += " WHERE A.RNUM >= ? --MIN_ROWS \n";  
		
		//sql = "SELECT IDEMPRESA, NOME_EMPRESA, NOME_FANTASIA, CNPJ ,TELEFONE, CELULAR, EMAIL, CODTIPOEMPRESA, ENDERECO_EMPRESA, NOME_PROPIETOR, CPF, ENDERECO, IDUSUARIO FROM EMPRESA";
			LojaForm form = null;
			pstm = getConnection().prepareStatement(sql);
			pstm.setInt(1, maxIndex);
			pstm.setInt(2, minIndex);
			
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				form = new LojaForm();
				form.setID(rs.getLong("IDEMPRESA"));
				form.setNome(rs.getString("NOME_EMPRESA"));
				form.setNomeFantasia(rs.getString("nome_fantasia"));
				form.setCNPJ(rs.getString("CNPJ"));				
				form.setTelefone(rs.getString("telefone"));
				form.setCelular(rs.getString("celular"));
				form.setEmail(rs.getString("email"));
				form.setCodTipoEmpresa(rs.getLong("codtipoempresa"));
				form.setEndereco(rs.getString("endereco"));
				form.setIdUsuaio(rs.getLong("idusuario"));
				
				listForms.add(form);
				
			}
			
			rs.close();
			pstm.close();
			//con.close();
		
		return listForms;
	}
	
	private int getQuantidade(String tabela) throws Exception {
		int qtd = 0;
		
		pstm = getConnection().prepareStatement("select count(*) qtd from "+tabela);
		rs = pstm.executeQuery();
		
		if(rs.next()) {
			qtd = rs.getInt("qtd");
		}
		return qtd;
	}
}
