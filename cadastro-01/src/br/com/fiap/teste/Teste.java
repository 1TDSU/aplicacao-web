package br.com.fiap.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.fiap.bean.Cliente;
import br.com.fiap.connection.ConnectionFactory;

public class Teste {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ConnectionFactory cf = new ConnectionFactory();
		Connection con = cf.DBConnectionManager();
		
		Cliente cli = new Teste().select(5, con);
		
		System.out.println("Nome do cliente : " + cli.getNome());
		System.out.println("Nome do cliente : " + new SimpleDateFormat("yyyy-MM-dd").format(cli.getDataNasc()));
		
	}

	

	public Cliente select(int idCli, Connection con) {
		
		String sql = null;
		Cliente cli = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			
			// CRIANDO A INSTRUÇÃO SQL
			sql = "SELECT * FROM TBL_CLIENTE WHERE ID_CLI = ?";
			
			// Criando a conexão
			ps = con.prepareStatement(sql);
			
			//Popular a instrução SQL.
			ps.setInt(1, idCli);

			//Criando o ResultSet que vai armazenar o conteúdo da consulta.
			rs = ps.executeQuery();

			// Criando uma estrutura para ler o ResultSet
			while (rs.next()) {
				// A cada iteração, será criado um novo Objeto e este será populado
				// com os dados oriundos da base de dados.
				cli = new Cliente();
				cli.setNome(rs.getNString("nome_cli"));
				cli.setSobrenome(rs.getNString("sobrenome_cli"));
				cli.setDataNasc(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getNString("data_nasc_cli")));
				cli.setGenero(rs.getNString("genero_cli").charAt(0));
				cli.setTelefone(rs.getNString("tel_cli"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				ps.close();
				rs.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cli;
	}


	
	
	
}





//try {
//	Connection con = cf.DBConnectionManager();
//	Cliente cli = new Cliente();
//	cli.setNome("Lulu");
//	cli.setSobrenome("Nobre");
//	cli.setDataNasc(new SimpleDateFormat("yyyy-MM-dd").parse("1966-06-09"));
//	cli.setGenero('m');
//	cli.setTelefone("11987659087");
//	
//		//CRIANDO A INSTRUÇÃO SQL
//		String sql = "INSERT INTO TBL_CLIENTE VALUES(SEQ_CLIENTE_A.NEXTVAL,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?)";
//		
//		//CRIANDO A CONEXÃO
//		PreparedStatement ps = con.prepareStatement(sql); 
//				
//		//POPULANDO A CONEXÃO
//		ps.setString(1, cli.getNome());
//		ps.setString(2, cli.getSobrenome());
//		ps.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(cli.getDataNasc()));
//		ps.setString(4, String.valueOf(cli.getGenero()));
//		ps.setLong(5, Long.parseLong(cli.getTelefone()));
//		
//		//EXECUTANDO A INSTRUÇÃO COM O EXECUTE-UPDATE E SE RETORNAR 1 É PORQUE FOI SUCESSO!
//		int status = ps.executeUpdate();
//		
//		System.out.println("STATUS : " + status);
//		
//		
//		}catch (SQLException e) {
//			e.printStackTrace();
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//				
//
