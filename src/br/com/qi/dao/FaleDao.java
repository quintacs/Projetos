package br.com.qi.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.qi.form.FaleForm;
import br.com.qi.form.Form;

public class FaleDao extends ActionDao {

	@Override
	public void adicionar(Form frm) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into CONTATO (NOME, EMAIL, MENSAGEM) values (?,?,?)";
		
		FaleForm form = (FaleForm)frm;
		
		pstm = getConnection().prepareStatement(sql);
		
		pstm.setString(1, form.getNome());
		pstm.setString(2, form.getEmail());
		pstm.setString(3, form.getMensagem());
		
		pstm.execute();
		pstm.close();		
	}

	@Override
	public void alterar(Form frm) throws Exception {
		// TODO Auto-generated method stub
		
		String sql = " update CONTATO set nome=?, EMAIL=?, MENSAGEM=? where ID_CONTATO	=?";
		
		FaleForm form = (FaleForm)frm;
		
		pstm = getConnection().prepareStatement(sql);
		
		pstm.setString(1, form.getNome());
		pstm.setString(2, form.getEmail());
		pstm.setString(3, form.getMensagem());

		pstm.execute();
		pstm.close();
		
	}

	@Override
	public Form consulta(int id) throws Exception {
		// TODO Auto-generated method stub
		FaleForm form = null;
		
		String sql = " select  ID_CONTATO, nome, EMAIL, MENSAGEM from CONTATO where ID_CONTATO=?";
		pstm = getConnection().prepareStatement(sql);
		pstm.setLong(1, id);
		
		rs = pstm.executeQuery();
		
		if(rs.next()) {
			form = new FaleForm();
			form.setId(rs.getInt("ID_CONTATO"));
			form.setNome(rs.getString("nome"));
			form.setEmail(rs.getString("email"));
			form.setMensagem(rs.getString("mensagem"));						
		}
		rs.close();
		pstm.close();		
		
		return form;
	}

	@Override
	public List<Form> lista() throws Exception {
		// TODO Auto-generated method stub
		
		FaleForm form = null;
		List<Form> forms = new ArrayList<>();
		
		String sql = " select  ID_CONTATO, nome, EMAIL, MENSAGEM from CONTATO ";
		pstm = getConnection().prepareStatement(sql);		
		
		rs = pstm.executeQuery();
		
		while(rs.next()) {
			form = new FaleForm();
			form.setId(rs.getInt("ID_CONTATO"));
			form.setNome(rs.getString("nome"));
			form.setEmail(rs.getString("email"));
			form.setMensagem(rs.getString("mensagem"));
			forms.add(form);			
		}
		rs.close();
		pstm.close();		
				
		return forms;
	}

	@Override
	public void excluir(Long id) throws Exception {
		// TODO Auto-generated method stub
		
		String sql = " delete from CONTATO where ID_CONTATO=? ";
		
		pstm = getConnection().prepareStatement(sql);
		pstm.setLong(1, id);		
		pstm.execute();
		pstm.close();
	}

	@Override
	public List<Form> lista(int id) throws Exception {
		// TODO Auto-generated method stub
		
		FaleForm form = null;
		List<Form> forms = new ArrayList<>();
		
		String sql = " select  ID_CONTATO, nome, EMAIL, MENSAGEM from CONTATO ";
		
		pstm = getConnection().prepareStatement(sql);		
		pstm.setLong(1, id);
		
		rs = pstm.executeQuery();
		
		while(rs.next()) {
			form = new FaleForm();
			form.setId(rs.getInt("ID_CONTATO"));
			form.setNome(rs.getString("nome"));
			form.setEmail(rs.getString("email"));
			form.setMensagem(rs.getString("mensagem"));
			forms.add(form);			
		}
		rs.close();
		pstm.close();		
				
		return forms;
	}	

}
