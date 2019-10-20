package br.com.qi.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.qi.form.Form;
import br.com.qi.form.PecaForm;

public class PecaDao extends ActionDao{

	private PreparedStatement pstm;
	private ResultSet rs;
	
	@Override
	public void adicionar(Form frm) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into PECA (NOME,MARCA,MODELO,ANO,EMPRESAID) values (?,?,?,?,?)";				 	
					
		PecaForm form = (PecaForm)frm;
		
		pstm = getConnection().prepareStatement(sql);
		
		pstm.setString(1, form.getNome());
		pstm.setString(2, form.getMarca());
		pstm.setString(3, form.getModelo());
		pstm.setLong(4, form.getAno());
		pstm.setLong(5, form.getIdEmpresa());
		
		pstm.execute();
		pstm.close();						
	}

	@Override
	public void alterar(Form frm) throws Exception {
		// TODO Auto-generated method stub
		String sql = " update PECA set NOME=?, MARCA=?, MODELO=?, ANO=?, EMPRESAID=? where PECAID=? ";
		
		PecaForm form = (PecaForm)frm;
		
		pstm = getConnection().prepareStatement(sql);
		
		pstm.setString(1, form.getNome());
		pstm.setString(2, form.getMarca());
		pstm.setString(3, form.getModelo());
		pstm.setLong(4, form.getAno());
		pstm.setLong(5, form.getIdEmpresa());
		pstm.setLong(6, form.getId());
		
		pstm.execute();
		pstm.close();		
	}

	@Override
	public Form consulta(int id) throws Exception {
		// TODO Auto-generated method stub
		
		String sql = " select NOME,MARCA,MODELO,ANO,EMPRESAID from PECA where PECAID=? ";
		
		PecaForm form =  null;

			pstm = getConnection().prepareStatement(sql);
			pstm.setLong(1, id);
			
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				form = new PecaForm();
				form.setId(id);
				form.setNome(rs.getString("nome"));
				form.setMarca(rs.getString("MARCA"));
				form.setModelo(rs.getString("MODELO"));				
				form.setAno(rs.getLong("ANO"));
				form.setIdEmpresa(rs.getLong("EMPRESAID"));

			}
			rs.close();
			pstm.close();
			
		return form;
	}

	@Override
	public List<Form> lista() throws Exception {
		// TODO Auto-generated method stub
		
		String sql = " select PECAID, NOME,MARCA,MODELO,ANO,EMPRESAID from PECA ";
		
		PecaForm form =  null;
		
		List<Form> forms = new ArrayList<>();
		
		con = getConnection();
		
		pstm = con.prepareStatement(sql);
		
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				form = new PecaForm();
				form.setId(rs.getLong("PECAID"));
				form.setNome(rs.getString("nome"));
				form.setMarca(rs.getString("MARCA"));
				form.setModelo(rs.getString("MODELO"));				
				form.setAno(rs.getLong("ANO"));
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
		
		String sql = " delete from PECA where PECAID=? ";
		pstm = getConnection().prepareStatement(sql);
		pstm.setLong(1, id);		
		pstm.execute();
		pstm.close();		
		
	}
		
	public List<Form> listaPecaEmpresa(int id) throws Exception {
		
		String sql = " select PECAID,NOME,MARCA,MODELO,ANO from PECA where EMPRESAID=? ";
		
		pstm = getConnection().prepareStatement(sql);
		
		pstm.setLong(1, id);		

		PecaForm form =  null;
		
		List<Form> forms = new ArrayList<>();
		
		pstm = getConnection().prepareStatement(sql);
		
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				form = new PecaForm();
				form.setId(rs.getLong("PECAID"));
				form.setNome(rs.getString("nome"));
				form.setMarca(rs.getString("MARCA"));
				form.setModelo(rs.getString("MODELO"));				
				form.setAno(rs.getLong("ANO"));
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
		
		PecaForm form =  null;
		
		List<Form> forms = new ArrayList<>();
		
		String sql = " select PECAID,NOME,MARCA,MODELO,ANO from PECA where PECAID=? ";
		
		con = getConnection();		
		pstm = con.prepareStatement(sql);
		pstm.setLong(1, id);		
		
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				form = new PecaForm();
				form.setId(rs.getLong("PECAID"));
				form.setNome(rs.getString("nome"));
				form.setMarca(rs.getString("MARCA"));
				form.setModelo(rs.getString("MODELO"));				
				form.setAno(rs.getLong("ANO"));
				form.setIdEmpresa(rs.getLong("EMPRESAID"));				
				
				forms.add(form);				
			}
			rs.close();
			pstm.close();
			con.close();
			
		return forms;			
	}
}
