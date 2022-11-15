package br.com.ProjetoFinalCrud.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.ProjetoFinalCrud.factory.ConnectionFactory;
import br.com.ProjetoFinalCrud.model.Doador;

public class DoadorDAO {
	
	public void save(Doador doador) {
		String sql = "INSERT INTO doador(nome,telefone,cpf)"+
	"VALUES(?,?,?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, doador.getNome());
			pstm.setInt(2, doador.getTelefone());
			pstm.setInt(3, doador.getCpf());
			
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
		String sql = "DELETE FROM doador WHERE id = ?";
		
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
	public void update(Doador doador) {
		String sql = "UPDATE doador SET nome = ?,"
				+ " telefone = ?,cpf = ? " + "WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, doador.getNome());
			pstm.setInt(2, doador.getTelefone());
			pstm.setInt(3, doador.getCpf());
			pstm.setInt(4, doador.getId());
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
	public List<Doador> getDoadores(){
		String sql = "SELECT * FROM doador";
		List<Doador> doadores = new ArrayList<Doador>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Doador doador = new Doador();
				doador.setId(rset.getInt("id"));
				doador.setNome(rset.getString("nome"));
				doador.setTelefone(rset.getInt("telefone"));
				doador.setCpf(rset.getInt("cpf"));
				doadores.add(doador);
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
		return doadores;
	}
}

