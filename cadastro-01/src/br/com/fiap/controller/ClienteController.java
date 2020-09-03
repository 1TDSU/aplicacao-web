package br.com.fiap.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.Clinit;

import br.com.fiap.bean.Cliente;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet(
		description = "Servlet controladora de acesso e fluxo de dados.", 
		urlPatterns = { 
				"/cliente", 
				"/listar", 
				"/"
		})
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static List<Cliente> lista = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteController() {
        super();
        
        if(lista == null) {
        	//Implementando o arrayList do tipo Cliente na lista
        	lista = new ArrayList<Cliente>();
        	
        	//Criando um objeto do tipo cliente
        	Cliente cli = new Cliente();
        	cli.setNome("Alexandre");
        	cli.setSobrenome("Carlos");
        	cli.setDataNasc("21/12/1975");
        	cli.setGenero('m');
        	cli.setTelefone("(11) 97845-6325");
        	//Adicionando na lista
        	lista.add(cli);
        	
        	//ADICIONANDO UM NOVO REGISTRO
        	//Criando um objeto do tipo cliente
        	cli = new Cliente();
        	cli.setNome("Julia");
        	cli.setSobrenome("Alberto");
        	cli.setDataNasc("04/04/1982");
        	cli.setGenero('f');
        	cli.setTelefone("(48) 97568-1245");
        	//Adicionando na lista
        	lista.add(cli);
        	
        	//ADICIONANDO UM NOVO REGISTRO
        	//Criando um objeto do tipo cliente
        	cli = new Cliente();
        	cli.setNome("Jorge");
        	cli.setSobrenome("Matheus");
        	cli.setDataNasc("18/02/1965");
        	cli.setGenero('m');
        	cli.setTelefone("(12) 98569-1245");
        	//Adicionando na lista
        	lista.add(cli);
        }
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//RECEP��O DOS DADOS DO REQUEST - IN�CIO
		
		//Receber os dados do request utilizando o m�todo
		// getParameter(nomeDoCampo) e adicionando em um objeto do tipo Cliente.
		
		//Criar uma inst�ncia de Cliente
		Cliente cli = null;
		//Criar o objeto e adicionar os dados do request.
		cli = new Cliente();
		cli.setNome(request.getParameter("txtNm"));
		cli.setSobrenome(request.getParameter("txtSnm"));
		cli.setDataNasc(request.getParameter("txtDtNasc"));
		cli.setGenero(request.getParameter("txtGen").charAt(0));
		cli.setTelefone(request.getParameter("txtTel"));
		
		//Adicionando na lista
		lista.add(cli);
		
		//RECEP��O DOS DADOS DO REQUEST - FIM
		
		
	}

}














