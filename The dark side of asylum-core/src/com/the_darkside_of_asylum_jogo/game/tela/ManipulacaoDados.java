package com.the_darkside_of_asylum_jogo.game.tela;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class ManipulacaoDados {

	public static Connection con;
	public static PreparedStatement stmt;
	public static boolean temDados = false; 

	public void InserirDadosBanco(Escolhas escolhaP){

		String sql = "INSERT INTO SALVAR(ID_SALVAR,ESCOLHA,DATA_ESCOLHA) VALUES(SEQ_SALVAR.NEXTVAL,?,TO_CHAR(SYSDATE,'DD-MM-YYYY HH24:MI:SS'))";

		try {			
			//conectando a base
			con = ConexaoBD.getConnection();
			//cria statement
			stmt = con.prepareStatement(sql);

			//preenche os valores
			stmt.setString(1, escolhaP.getNome_escolha());
			//executa
			stmt.execute();
			stmt.close();
			con.close();
			System.out.println("Gravados");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	public void BuscarDados(Escolhas escolhaP){
		String sql = "SELECT ESCOLHA FROM \r\n" + 
				"(\r\n" + 
				"SELECT ESCOLHA,\r\n" + 
				"ROW_NUMBER() OVER(ORDER BY DATA_ESCOLHA DESC) AS RN \r\n" + 
				"        FROM SALVAR\r\n" + 
				") \r\n" + 
				"WHERE RN = 1";
		try {
			con = ConexaoBD.getConnection();

			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				escolhaP.setNome_escolha(rs.getString("ESCOLHA"));
				escolhaP.Consultar_texto();
			}
			stmt.close();
			con.close();
		} 
		catch (SQLException e) {
			System.out.println(e);
		}
	} 


	public void DeletarDoBanco(){
		String sql = "DELETE FROM SALVAR";
		try {
			con = ConexaoBD.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.execute();
			con.close();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}	
	}
	
	public void TemDadosNoBanco() {
		String sql = "SELECT ESCOLHA FROM \r\n" + 
				"(\r\n" + 
				"SELECT ESCOLHA,\r\n" + 
				"ROW_NUMBER() OVER(ORDER BY DATA_ESCOLHA DESC) AS RN \r\n" + 
				"        FROM SALVAR\r\n" + 
				") \r\n" + 
				"WHERE RN = 1";
		try {
			con = ConexaoBD.getConnection();

			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				if(rs.getString("ESCOLHA") == null) {
					temDados = false;
					}
				else {
					temDados = true;
					
				}
			}
			stmt.close();
			con.close();
		} 
		catch (SQLException e) {
			System.out.println(e);
		}
	}
}