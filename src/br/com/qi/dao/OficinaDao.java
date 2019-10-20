package br.com.qi.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.qi.form.OficinaForm;
import br.com.qi.form.Form;

public class OficinaDao extends ActionDao {

	private PreparedStatement pstm;
	private ResultSet rs;
	
	@Override
	public void adicionar(Form frm) throws Exception{
		// TODO Auto-generated method stub
		String sql = "insert into EMPRESA (NOME_EMPRESA,nome_fantasia,CNPJ,telefone,celular,email,codtipoempresa,endereco,idusuario) values (?,?,?,?,?,?,?,?,?)";
		
			OficinaForm form = (OficinaForm)frm;
			
			pstm = getConnection().prepareStatement(sql);
			
			pstm.setString(1, form.getNome());
			pstm.setString(2, form.getnomeFantasia());
			pstm.setString(3, form.getCNPJ());
			pstm.setString(4, form.getTelefone());
			pstm.setString(5, form.getCecular());
			pstm.setString(6, form.getEmail());
			pstm.setLong(7, form.getCodTipoEmpresa());	
			pstm.setString(8, form.getEndereco());	
			pstm.setLong(9, form.getIdUsuario());	
			
			pstm.execute();
			pstm.close();			
	}

	@Override
	public void alterar(Form frm) throws Exception {
		// TODO Auto-generated method stub
		String sql = " update EMPRESA set NOME_EMPRESA=?, nome_fantasia=?, CNPJ=?, telefone=?, celular=?, email=?, codtipoempresa=?, endereco=?, idusuario=? where IDEMPRESA=? ";
		
			OficinaForm form = (OficinaForm)frm;
			
			pstm = getConnection().prepareStatement(sql);
			
			pstm.setString(1, form.getNome());
			pstm.setString(2, form.getnomeFantasia());
			pstm.setString(3, form.getCNPJ());
			pstm.setString(4, form.getTelefone());
			pstm.setString(5, form.getCecular());
			pstm.setString(6, form.getEmail());
			pstm.setLong(7, form.getCodTipoEmpresa());	
			pstm.setString(8, form.getEndereco());	
			pstm.setLong(9, form.getIdUsuario());	
			pstm.setLong(10, form.getId());
			
			pstm.execute();
			pstm.close();			
		
	}

	@Override
	public Form consulta(int id) throws Exception{
		// TODO Auto-generated method stub
		
		//nome,nome_fantasia,CNPJ,telefone,celular,email,codtipoempresa,endereco,idusuario
		
		String sql = " select NOME_EMPRESA,nome_fantasia,CNPJ,telefone,celular,email,codtipoempresa,endereco,idusuario from EMPRESA where IDEMPRESA=? ";
		OficinaForm form = null;

			pstm = getConnection().prepareStatement(sql);
			pstm.setLong(1, id);
			
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				form = new OficinaForm();
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
			}
			rs.close();
			pstm.close();
			
		return form;
	}

	@Override
	public List<Form> lista() throws Exception{
		// TODO Auto-generated method stub
		String sql = " select IDEMPRESA, NOME_EMPRESA,nome_fantasia,CNPJ,telefone,celular,email,codtipoempresa,endereco,idusuario from EMPRESA where codtipoempresa=?";
		
		OficinaForm form = null;
		List<Form> forms = new ArrayList<>();
			
		long id = 1; // REMOVER AP�S TESTES
			
			con = getConnection();
			
			pstm = con.prepareStatement(sql);			
			pstm.setLong(1, id);
						
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				form = new OficinaForm();
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
				
				forms.add(form);
				
			}
			rs.close();
			pstm.close();
			con.close();
			
		return forms;
	}

	@Override
	public void excluir(Long id) throws Exception {
		// TODO Auto-generated method stub
		String sql = " delete from EMPRESA where IDEMPRESA=? ";
		
		pstm = getConnection().prepareStatement(sql);
		pstm.setLong(1, id);		
		pstm.execute();
		pstm.close();
	}	

	@Override
	public List<Form> lista(int id) throws Exception{
		// TODO Auto-generated method stub
		String sql = " select IDEMPRESA, NOME_EMPRESA,nome_fantasia,CNPJ,telefone,celular,email,codtipoempresa,endereco,idusuario from EMPRESA where codtipoempresa=?";
		
		OficinaForm form = null;
		List<Form> forms = new ArrayList<>();
								
			con = getConnection();
			
			pstm = con.prepareStatement(sql);			
			pstm.setLong(1, id);
						
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				form = new OficinaForm();
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
				
				forms.add(form);
				
			}
			rs.close();
			pstm.close();
			con.close();
			
		return forms;
	}	
}
