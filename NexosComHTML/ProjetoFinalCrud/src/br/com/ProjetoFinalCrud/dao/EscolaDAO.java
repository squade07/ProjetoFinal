package br.com.ProjetoFinalCrud.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.ProjetoFinalCrud.factory.ConnectionFactory;
import br.com.ProjetoFinalCrud.model.Escola;

public class EscolaDAO {
	
	public void save(Escola escola) {
		String sql = "INSERT INTO escola(nome,telefone,cnpj)"+
	"VALUES(?,?,?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, escola.getNome());
			pstm.setInt(2, escola.getTelefone());
			pstm.setInt(3, escola.getCnpj());
			
			pstm.execute();			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void removeById(int id) {
		String sql = "DELETE FROM escola WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void update(Escola escola) {
		String sql = "UPDATE escola SET nome = ?,"
				+ " telefone = ?,cnpj = ? " + "WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, escola.getNome());
			pstm.setInt(2, escola.getTelefone());
			pstm.setInt(3, escola.getCnpj());
			pstm.setInt(4, escola.getId());
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public List<Escola> getEscolas(){
		String sql = "SELECT * FROM escola";
		List<Escola> escolas = new ArrayList<Escola>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Escola escola = new Escola();
				escola.setId(rset.getInt("id"));
				escola.setNome(rset.getString("nome"));
				escola.setTelefone(rset.getInt("telefone"));
				escola.setCnpj(rset.getInt("cnpj"));
				escolas.add(escola);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return escolas;
	}
}

