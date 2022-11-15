package br.com.ProjetoFinalCrud.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.ProjetoFinalCrud.factory.ConnectionFactory;
import br.com.ProjetoFinalCrud.model.Produto;

public class ProdutoDAO {
	
	public void save(Produto produto) {
		String sql = "INSERT INTO produtos(nome,categoria)"+
	"VALUES(?,?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getCategoria());
			
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
		String sql = "DELETE FROM produtos WHERE id = ?";
		
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
	public void update(Produto produto) {
		String sql = "UPDATE produto SET nome = ?,"
				+ " categoria = ? " + "WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getCategoria());
			pstm.setInt(3, produto.getId());
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
	public List<Produto> getProdutos(){
		String sql = "SELECT * FROM produtos";
		List<Produto> produtos = new ArrayList<Produto>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Produto produto = new Produto();
				produto.setId(rset.getInt("id"));
				produto.setNome(rset.getString("nome"));
				produto.setCategoria(rset.getString("categoria"));
				produtos.add(produto);
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
		return produtos;
	}
}

