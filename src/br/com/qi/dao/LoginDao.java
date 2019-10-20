package br.com.qi.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.qi.form.Form;
import br.com.qi.form.LoginForm;

public class LoginDao extends ActionDao {

	@Override
	public void adicionar(Form frm) throws Exception {
		// TODO Auto-generated method stub

		String sql = "insert into login (email,senha,nome) values (?,?,?)";
		
		LoginForm form = (LoginForm)frm;
		
		pstm = getConnection().prepareStatement(sql);
		
		pstm.setString(1, form.getEmail());
		pstm.setString(2, form.getSenha());
		pstm.setString(3, form.getNome());
		
		pstm.execute();
		pstm.close();		
	}

	@Override
	public void alterar(Form frm) throws Exception {
		// TODO Auto-generated method stub
		
		String sql = " update login set email=?, senha=? , nome=? where IDLOGIN=? ";
		
		LoginForm form = (LoginForm)frm;
		
		pstm = getConnection().prepareStatement(sql);
				
		pstm.setString(1, form.getEmail());
		pstm.setString(2, form.getSenha());
		pstm.setString(3, form.getNome());
		pstm.setInt(4, form.getId());		
		
		pstm.execute();
		pstm.close();		
	}

	@Override
	public Form consulta(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = " select IDLOGIN, nome, email, senha from login where IDLOGIN=? ";
		
		LoginForm form = null;

			pstm = getConnection().prepareStatement(sql);
			pstm.setInt(1, id);
			
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				form = new LoginForm();
				form.setId(rs.getInt("IDLOGIN"));
				form.setNome(rs.getString("nome"));
				form.setEmail(rs.getString("email"));
				form.setSenha(rs.getString("senha"));
			}
			rs.close();
			pstm.close();
			
		return form;
	}

	public Form consulta(String email) throws Exception {
		// TODO Auto-generated method stub
		String sql = " select IDLOGIN, nome, email, senha from login where email=? ";
		
		LoginForm form = null;

			pstm = getConnection().prepareStatement(sql);
			pstm.setString(1, email);
			
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				form = new LoginForm();
				form.setId(rs.getInt("IDLOGIN"));
				form.setNome(rs.getString("nome"));
				form.setEmail(rs.getString("email"));
				form.setSenha(rs.getString("senha"));
			}
			rs.close();
			pstm.close();
			
		return form;
	}

	public Form consulta(LoginForm frm) throws Exception {
		// TODO Auto-generated method stub
		String sql = " select IDLOGIN, nome, email, senha from login where email=? and senha=?";
		
		LoginForm form = null;

			pstm = getConnection().prepareStatement(sql);
			pstm.setString(1, frm.getEmail());
			pstm.setString(2, frm.getSenha());
			
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				form = new LoginForm();
				form.setId(rs.getInt("IDLOGIN"));
				form.setNome(rs.getString("nome"));
				form.setEmail(rs.getString("email"));
				form.setSenha(rs.getString("senha"));
				
			}
			rs.close();
			pstm.close();
			
		return form;
	}
	
	@Override
	public List<Form> lista(int id) throws Exception {
		// TODO Auto-generated method stub
		
		String sql = " select IDLOGIN, nome, email, senha from login where id=? ";
		
		LoginForm form = null;
		List<Form> forms = new ArrayList<>();
		
			pstm = getConnection().prepareStatement(sql);
			pstm.setInt(1, id);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				form = new LoginForm();
				form.setId(rs.getInt("IDLOGIN"));
				form.setNome(rs.getString("nome"));
				form.setEmail (rs.getString("email"));
				form.setSenha(rs.getString("senha"));
				
				forms.add(form);
			}
			
			rs.close();
			pstm.close();
			
		return forms;		
	}
	
	public List<Form> lista(LoginForm frm) throws Exception {
		// TODO Auto-generated method stub
		String sql = " select IDLOGIN, nome, email, senha from login where email=? and senha=?";
		
		LoginForm form = null;
		List<Form> forms = new ArrayList<>();
		
			pstm = getConnection().prepareStatement(sql);
			pstm.setString(1, frm.getEmail());
			pstm.setString(2, frm.getSenha());
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				form = new LoginForm();
				form.setId(rs.getInt("IDLOGIN"));
				form.setNome(rs.getString("nome"));
				form.setEmail(rs.getString("email"));
				form.setSenha(rs.getString("senha"));
				
				forms.add(form);
			}
			rs.close();
			pstm.close();
			
		return forms;
	}	

	public List<Form> lista(String email) throws Exception {
		// TODO Auto-generated method stub
		
		String sql = " select IDLOGIN, nome, email, senha from login where email=? ";
		
		LoginForm form = null;
		List<Form> forms = new ArrayList<>();
		
			pstm = getConnection().prepareStatement(sql);
			pstm.setString(1, email);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				form = new LoginForm();
				form.setId(rs.getInt("IDLOGIN"));
				form.setNome(rs.getString("nome"));
				form.setEmail (rs.getString("email"));
				form.setSenha(rs.getString("senha"));
				
				forms.add(form);
			}
			
			rs.close();
			pstm.close();
			
		return forms;		
	}
	
	@Override
	public List<Form> lista() throws Exception {
		// TODO Auto-generated method stub
		String sql = " select IDLOGIN, nome, email, senha senha from login ";
		
		LoginForm form = null;
		List<Form> forms = new ArrayList<>();
								
			con = getConnection();			
			pstm = con.prepareStatement(sql);												
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				form = new LoginForm();
				form.setId(rs.getInt("IDLOGIN"));
				form.setNome(rs.getString("nome"));
				form.setEmail(rs.getString("email"));
				form.setSenha(rs.getString("senha"));
				
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
		String sql = " delete from login where IDLOGIN=? ";
		
		pstm = getConnection().prepareStatement(sql);
		pstm.setLong(1, id);		
		pstm.execute();
		pstm.close();
	}

}
