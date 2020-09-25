package br.com.fiap.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.fiap.bean.Cliente;
import br.com.fiap.connection.ConnectionFactory;

public class Teste {

	public static void main(String[] args) {
		
		ConnectionFactory cf = new ConnectionFactory();
		
		try {
			Connection con = cf.DBConnectionManager();
			Cliente cli = new Cliente();
			cli.setNome("Lulu");
			cli.setSobrenome("Nobre");
			cli.setDataNasc(new SimpleDateFormat("yyyy-MM-dd").parse("1966-06-09"));
			cli.setGenero('m');
			cli.setTelefone("11987659087");
			
				//CRIANDO A INSTRUÇÃO SQL
				String sql = "INSERT INTO TBL_CLIENTE VALUES(SEQ_CLIENTE_A.NEXTVAL,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?)";
				
				//CRIANDO A CONEXÃO
				PreparedStatement ps = con.prepareStatement(sql); 
						
				//POPULANDO A CONEXÃO
				ps.setString(1, cli.getNome());
				ps.setString(2, cli.getSobrenome());
				ps.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(cli.getDataNasc()));
				ps.setString(4, String.valueOf(cli.getGenero()));
				ps.setLong(5, Long.parseLong(cli.getTelefone()));
				
				//EXECUTANDO A INSTRUÇÃO COM O EXECUTE-UPDATE E SE RETORNAR 1 É PORQUE FOI SUCESSO!
				int status = ps.executeUpdate();
				
				System.out.println("STATUS : " + status);
				
				
				}catch (SQLException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						

		

	}

}
