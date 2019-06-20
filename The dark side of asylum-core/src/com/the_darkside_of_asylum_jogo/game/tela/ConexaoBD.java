package com.the_darkside_of_asylum_jogo.game.tela;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
	//Testar a verificação da conexão com o banco de dados
	public static Connection getConnection()throws SQLException{
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","smaug","smaug123456");
		}catch (ClassNotFoundException e){
			throw new SQLException(e.getMessage());
		}
	}
}

