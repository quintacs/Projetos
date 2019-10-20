package br.com.qi.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.qi.form.Form;
import br.com.qi.form.ProdutoForm;

public class ProdutoDao extends ActionDao{

	private PreparedStatement pstm;
	private ResultSet rs;
	
	@Override
	public void adicionar(Form frm) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into PRODUTO (NOME,MARCA,DESCRICAO,EMPRESAID) values (?,?,?,?)";
		
		ProdutoForm form = (ProdutoForm)frm;
		
		pstm = getConnection().prepareStatement(sql);
		
		pstm.setString(1, form.getNome());
		pstm.setString(2, form.getMarca());
		pstm.setString(3, form.getDescricao());		
		pstm.setLong(4, form.getIdEmpresa());
		
		pstm.execute();
		pstm.close();				
	}

	@Override
	public void alterar(Form frm) throws Exception {
		// TODO Auto-generated method stub
		String sql = " update PRODUTO set NOME=?, MARCA=?, DESCRICAO=?, EMPRESAID=? where ID=? ";
		
		ProdutoForm form = (ProdutoForm)frm;
		
		pstm = getConnection().prepareStatement(sql);
		
		pstm.setString(1, form.getNome());
		pstm.setString(2, form.getMarca());
		pstm.setString(3, form.getDescricao());		
		pstm.setLong(4, form.getIdEmpresa());
		pstm.setLong(5, form.getId());
		
		pstm.execute();
		pstm.close();		
		
	}

	@Override
	public Form consulta(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = " select NOME,MARCA,DESCRICAO,EMPRESAID from PRODUTO where ID=? ";
		
		pstm = getConnection().prepareStatement(sql);
		pstm.setLong(1, id);
		
		rs = pstm.executeQuery();
		
		ProdutoForm form = null;
		
		if(rs.next()) {
			form = new ProdutoForm();
			form.setId(id);
			form.setNome(rs.getString("nome"));
			form.setMarca(rs.getString("MARCA"));
			form.setDescricao(rs.getString("DESCRICAO"));							
			form.setIdEmpresa(rs.getLong("EMPRESAID"));

		}
		rs.close();
		pstm.close();
		
	return form;
	}

	@Override
	public List<Form> lista() throws Exception {
		// TODO Auto-generated method stub
		String sql = " select ID,NOME,MARCA,DESCRICAO,EMPRESAID from PRODUTO ";
		
		ProdutoForm form =  null;
		
		List<Form> forms = new ArrayList<>();
		
		con = getConnection();
		
		pstm = con.prepareStatement(sql);
		
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				form = new ProdutoForm();
				form.setId(rs.getLong("ID"));
				form.setNome(rs.getString("nome"));
				form.setMarca(rs.getString("MARCA"));
				form.setDescricao(rs.getString("DESCRICAO"));								
				form.setIdEmpresa(rs.getLong("EMPRESAID"));				
				
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
		
		String sql = " delete from PRODUTO where ID=? ";
		pstm = getConnection().prepareStatement(sql);
		pstm.setLong(1, id);		
		pstm.execute();
		pstm.close();		
	}
	
	public List<Form> listaProdutoEmpresa(Long id) throws Exception {
		
		String sql = " select ID,NOME,MARCA,DESCRICAO,EMPRESAID from PRODUTO where ID=? ";
		
		pstm = getConnection().prepareStatement(sql);
		
		pstm.setLong(1, id);		

		ProdutoForm form =  null;
		
		List<Form> forms = new ArrayList<>();
		
		pstm = getConnection().prepareStatement(sql);
		
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				form = new ProdutoForm();
				form.setId(rs.getLong("ID"));
				form.setNome(rs.getString("nome"));
				form.setMarca(rs.getString("MARCA"));
				form.setDescricao(rs.getString("DESCRICAO"));							
				form.setIdEmpresa(rs.getLong("EMPRESAID"));				
				
				forms.add(form);				
			}
			rs.close();
			pstm.close();
			
		return forms;		
	}

	@Override
	public List<Form> lista(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = " select ID,NOME,MARCA,DESCRICAO,EMPRESAID from PRODUTO where ID=? ";
		
		ProdutoForm form =  null;		
		List<Form> forms = new ArrayList<>();
		
		pstm = getConnection().prepareStatement(sql);		
		pstm.setLong(1, id);		
		
		pstm = getConnection().prepareStatement(sql);
		
		rs = pstm.executeQuery();
			
			while (rs.next()) {
				form = new ProdutoForm();
				form.setId(rs.getLong("ID"));
				form.setNome(rs.getString("nome"));
				form.setMarca(rs.getString("MARCA"));
				form.setDescricao(rs.getString("DESCRICAO"));							
				form.setIdEmpresa(rs.getLong("EMPRESAID"));				
				
				forms.add(form);				
			}
			rs.close();
			pstm.close();
			
		return forms;		
	}

}
