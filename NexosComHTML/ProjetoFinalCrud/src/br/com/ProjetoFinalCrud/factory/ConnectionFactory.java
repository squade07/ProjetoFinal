package br.com.ProjetoFinalCrud.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "5963";
	
	private static final String DATABASE_URL =
			"jdbc:mysql://localhost:3306/db_projetofinal";
	
	public static Connection createConnectionToMySQL() throws 
	Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = 
				DriverManager.getConnection(DATABASE_URL, USERNAME,PASSWORD);
		return conn;
	}
	public static void main(String [] args)throws Exception{
		Connection con = createConnectionToMySQL();
		if(con != null) {
			System.out.println("Conexao obtida com sucesso!" + con);
			con.close();
		}
	}
}
