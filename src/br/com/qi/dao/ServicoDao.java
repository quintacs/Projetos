package br.com.qi.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.qi.form.Form;
import br.com.qi.form.ServicoForm;

public class ServicoDao extends ActionDao{

	private PreparedStatement pstm;
	private ResultSet rs;
	
	
	@Override
	public void adicionar(Form frm) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into SERVICO (NOME,DESC_SERVICO,EMPRESAID) values (?,?,?)";
		
		ServicoForm form = (ServicoForm)frm;
		
		pstm = getConnection().prepareStatement(sql);
		
		pstm.setString(1, form.getNome());		
		pstm.setString(2, form.getDescricao());		
		pstm.setLong(3, form.getIdEmpresa());
		
		pstm.execute();
		pstm.close();
	}

	@Override
	public void alterar(Form frm) throws Exception {
		// TODO Auto-generated method stub
		String sql = " update SERVICO set NOME=?, DESC_SERVICO=?, EMPRESAID=? where ID=? ";
		
		ServicoForm form = (ServicoForm)frm;
		
		pstm = getConnection().prepareStatement(sql);
		
		pstm.setString(1, form.getNome());		
		pstm.setString(2, form.getDescricao());		
		pstm.setLong(3, form.getIdEmpresa());
		pstm.setLong(4, form.getId());
		
		pstm.execute();
		pstm.close();		
	}

	@Override
	public Form consulta(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = " select NOME,DESC_SERVICO,EMPRESAID from SERVICO where ID=? ";
		
		pstm = getConnection().prepareStatement(sql);
		pstm.setLong(1, id);
		
		rs = pstm.executeQuery();
		
		ServicoForm form = null;
		
		if(rs.next()) {
			form = new ServicoForm();
			form.setId(id);
			form.setNome(rs.getString("NOME"));			
			form.setDescricao(rs.getString("DESC_SERVICO"));							
			form.setIdEmpresa(rs.getLong("EMPRESAID"));

		}
		rs.close();
		pstm.close();
		
	return form;		
	}

	@Override
	public List<Form> lista() throws Exception {
		// TODO Auto-generated method stub
		String sql = " select ID,NOME,DESC_SERVICO,EMPRESAID from SERVICO ";
		
		ServicoForm form =  null;
		
		List<Form> forms = new ArrayList<>();
		
		con = getConnection();
		pstm = con.prepareStatement(sql);
		
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				form = new ServicoForm();
				form.setId(rs.getLong("ID"));
				form.setNome(rs.getString("NOME"));				
				form.setDescricao(rs.getString("DESC_SERVICO"));								
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
		
		String sql = " delete from SERVICO where ID=? ";
		pstm = getConnection().prepareStatement(sql);
		pstm.setLong(1, id);		
		pstm.execute();
		pstm.close();		
	}
	public List<Form> listaServicoEmpresa(Long id) throws Exception {

		String sql = " select ID,NOME,DESC_SERVICO,EMPRESAID from SERVICO where EMPRESAID=? ";
		
		pstm = getConnection().prepareStatement(sql);
		
		pstm.setLong(1, id);		

		ServicoForm form =  null;
		
		List<Form> forms = new ArrayList<>();
		
		pstm = getConnection().prepareStatement(sql);
		
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				form = new ServicoForm();
				form.setId(rs.getLong("ID"));
				form.setNome(rs.getString("NOME"));				
				form.setDescricao(rs.getString("DESC_SERVICO"));								
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
		String sql = " select ID,NOME,DESC_SERVICO,EMPRESAID from SERVICO where ID=? ";
		
		ServicoForm form =  null;		
		List<Form> forms = new ArrayList<>();
		
		pstm = getConnection().prepareStatement(sql);		
		pstm.setLong(1, id);				
		
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				form = new ServicoForm();
				form.setId(rs.getLong("ID"));
				form.setNome(rs.getString("NOME"));				
				form.setDescricao(rs.getString("DESC_SERVICO"));								
				form.setIdEmpresa(rs.getLong("EMPRESAID"));					
				
				forms.add(form);				
			}
			rs.close();
			pstm.close();
			
		return forms;		
	}			
}
