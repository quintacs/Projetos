package br.com.qi.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.qi.form.Form;
import br.com.qi.form.LoginForm;
import br.com.qi.form.ProdutoForm;
import br.com.qi.form.UsuarioForm;

public class UsuarioDao extends ActionDao {

	@Override
	public void adicionar(Form frm) throws Exception {
		// TODO Auto-generated method stub

		String sql = "insert into USUARIO (nome, cpf, endereco, telefone, celular, email) values (?,?,?,?,?,?)";
		
		UsuarioForm form = (UsuarioForm)frm;
		
		pstm = getConnection().prepareStatement(sql);
		
		pstm.setString(1, form.getNome());
		pstm.setString(2, form.getCpf());
		pstm.setString(3, form.getEndereco());
		pstm.setString(4, form.getTelefone());
		pstm.setString(5, form.getCelular());
		pstm.setString(6, form.getEmail());
		
		
		pstm.execute();
		pstm.close();	
		
		//LoginDao ld = new LoginDao();		
		//ld.adicionar(form.getLoginForm());
		
	}

	@Override
	public void alterar(Form frm) throws Exception {
		// TODO Auto-generated method stub
		String sql = " update usuario set nome=?, cpf=?, endereco=?, telefone=?, celular=?, email=? where idusuario=? ";
		
		UsuarioForm form = (UsuarioForm)frm;
		
		pstm = getConnection().prepareStatement(sql);
				
		pstm.setString(1, form.getNome());
		pstm.setString(2, form.getCpf());
		pstm.setString(3, form.getEndereco());
		pstm.setString(4, form.getTelefone());
		pstm.setString(5, form.getCelular());
		pstm.setString(6, form.getEmail());
		pstm.setLong(7, form.getIdUsuario());
		
		pstm.execute();
		pstm.close();	
	}

	@Override
	public Form consulta(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = " select idusuario, nome, cpf, endereco, telefone, celular, email from usuario where idusuario=? ";
		
		UsuarioForm form = null;

			pstm = getConnection().prepareStatement(sql);
			pstm.setInt(1, id);
			
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				form = new UsuarioForm();
				form.setIdUsuario(rs.getLong("idusuario"));
				form.setNome(rs.getString("nome"));
				form.setCpf(rs.getString("cpf"));
				form.setEndereco(rs.getString("endereco"));
				form.setTelefone(rs.getString("telefone"));
				form.setCelular(rs.getString("celular"));
				form.setEmail(rs.getString("email"));
				
			}
			rs.close();
			pstm.close();
			
		return form;		
	}

	public Form consulta(String email) throws Exception {
		// TODO Auto-generated method stub
		String sql = " select idusuario, nome, cpf, endereco, telefone, celular, email from usuario where email=? ";
		
		UsuarioForm form = null;

			pstm = getConnection().prepareStatement(sql);
			pstm.setString(1, email);
			
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				form = new UsuarioForm();
				form.setIdUsuario(rs.getLong("idusuario"));
				form.setNome(rs.getString("nome"));
				form.setCpf(rs.getString("cpf"));
				form.setEndereco(rs.getString("endereco"));
				form.setTelefone(rs.getString("telefone"));
				form.setCelular(rs.getString("celular"));
				form.setEmail(rs.getString("email"));
			}
			rs.close();
			pstm.close();
			
		return form;
	}

	public Form consulta(UsuarioForm frm) throws Exception {
		// TODO Auto-generated method stub
		String sql = " select idusuario, nome, cpf, endereco, telefone, celular, email from usuario where email=? and cpf=?";
		
		UsuarioForm form = null;

			pstm = getConnection().prepareStatement(sql);
			pstm.setString(1, frm.getEmail());
			pstm.setString(2, frm.getCpf());
			
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				form = new UsuarioForm();
				form.setIdUsuario(rs.getLong("idusuario"));
				form.setNome(rs.getString("nome"));
				form.setCpf(rs.getString("cpf"));
				form.setEndereco(rs.getString("endereco"));
				form.setTelefone(rs.getString("telefone"));
				form.setCelular(rs.getString("celular"));
				form.setEmail(rs.getString("email"));
			}
			rs.close();
			pstm.close();
			
		return form;
	}
			
	@Override
	public List<Form> lista(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = " select idusuario, nome, cpf, endereco, telefone, celular, email from usuario where idusuario=? ";
		
		UsuarioForm form = null;
		List<Form> forms = new ArrayList<>();
		
			pstm = getConnection().prepareStatement(sql);
			pstm.setInt(1, id);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				form = new UsuarioForm();
				form.setIdUsuario(rs.getLong("idusuario"));
				form.setNome(rs.getString("nome"));
				form.setCpf(rs.getString("cpf"));
				form.setEndereco(rs.getString("endereco"));
				form.setTelefone(rs.getString("telefone"));
				form.setCelular(rs.getString("celular"));
				form.setEmail(rs.getString("email"));
				
				forms.add(form);
			}
			
			rs.close();
			pstm.close();
			
		return forms;		
	}

	public List<Form> lista(String email) throws Exception {
		// TODO Auto-generated method stub
		
		String sql = " select idusuario, nome, cpf, endereco, telefone, celular, email from usuario where email=? ";
		
		UsuarioForm form = null;
		List<Form> forms = new ArrayList<>();
		
			pstm = getConnection().prepareStatement(sql);
			pstm.setString(1, email);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				form = new UsuarioForm();
				form.setIdUsuario(rs.getLong("idusuario"));
				form.setNome(rs.getString("nome"));
				form.setCpf(rs.getString("cpf"));
				form.setEndereco(rs.getString("endereco"));
				form.setTelefone(rs.getString("telefone"));
				form.setCelular(rs.getString("celular"));
				form.setEmail(rs.getString("email"));
				
				forms.add(form);
			}
			
			rs.close();
			pstm.close();
			
		return forms;		
	}


	public List<Form> lista(UsuarioForm frm) throws Exception {
		// TODO Auto-generated method stub
		String sql = " select idusuario, nome, cpf, endereco, telefone, celular, email from usuario where email=? and cpf=?";
		
		UsuarioForm form = null;
		List<Form> forms = new ArrayList<>();
		
			pstm = getConnection().prepareStatement(sql);
			pstm.setString(1, frm.getEmail());
			pstm.setString(2, frm.getCpf());
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				form = new UsuarioForm();
				form.setIdUsuario(rs.getLong("idusuario"));
				form.setNome(rs.getString("nome"));
				form.setCpf(rs.getString("cpf"));
				form.setEndereco(rs.getString("endereco"));
				form.setTelefone(rs.getString("telefone"));
				form.setCelular(rs.getString("celular"));
				form.setEmail(rs.getString("email"));
				
				forms.add(form);
			}
			rs.close();
			pstm.close();
			
		return forms;
	}	
	
	@Override
	public List<Form> lista() throws Exception {
		// TODO Auto-generated method stub
		String sql = " select idusuario, nome, cpf, endereco, telefone, celular, email from usuario ";
		
		UsuarioForm form = null;
		List<Form> forms = new ArrayList<>();
								
			con = getConnection();			
			pstm = con.prepareStatement(sql);												
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				form = new UsuarioForm();
				form.setIdUsuario(rs.getLong("idusuario"));
				form.setNome(rs.getString("nome"));
				form.setCpf(rs.getString("cpf"));
				form.setEndereco(rs.getString("endereco"));
				form.setTelefone(rs.getString("telefone"));
				form.setCelular(rs.getString("celular"));
				form.setEmail(rs.getString("email"));
				
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
		String sql = " delete from usuario where idusuario=? ";
		
		pstm = getConnection().prepareStatement(sql);
		pstm.setLong(1, id);		
		pstm.execute();
		pstm.close();
	}

}
