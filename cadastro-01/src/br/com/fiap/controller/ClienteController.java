package br.com.fiap.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bean.Cliente;
import br.com.fiap.bo.ClienteBO;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet(urlPatterns =  {"/cliente","/listaall"})
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteController() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Request do FORM da index.jsp
		if (request.getRequestURI().equals("/cadastro-01/cliente")) {
			//Realizando a chamada para o método inserirCliente
			// e passando os prâmetros request e response.
			inserirCliente(request, response);
		}else if(request.getRequestURI().equals("/cadastro-01/listaall")) {
			listagem(request, response);
		}
		
	}
	
	//INSERINDO UM CLIENTE
	public void inserirCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recuperando os dados do request e adicionando em um objeto.
		Cliente cli = null;
		cli = new Cliente();
		cli.setNome(request.getParameter("txtNm"));
		cli.setSobrenome(request.getParameter("txtSnm"));
		cli.setDataNasc(request.getParameter("txtDtNasc"));
		cli.setGenero(request.getParameter("txtGen").charAt(0));
		cli.setTelefone(request.getParameter("txtTel"));
		
		System.out.println("TESTE : " + cli.getNome());
		
		//Passar os dados para o BO
		ClienteBO cb = new ClienteBO();
		int resultado = cb.cadastroCliente(cli);
		
		//Verificação do resultado para gerar uma mensagem 
		// para o usuário.
		if(resultado == 1) {
			//Criando um atributo no request e enviando para a index.jsp
			//request.setAttribute("msgStatus", "Os dados foram gravados com SUCESSO!");
			
			//Criando um redirecionamento com parâmetros.
			//Obs:Para carregar parâmetros no JSP é necessário utilizarmos o escopo PARAM
			//Ex: param.nomeDoParametro
			response.sendRedirect("index.jsp?msgStatus=Os dados foram gravados com SUCESSO!");
		}else {
			//Caso ocorra algum problema envie uma mensagem de erro.
			//request.setAttribute("msgStatus", "Ocorreu um erro ao gravar os dados.");
			
			//Criando um redirecionamento com parâmetros.
			//Obs:Para carregar parâmetros no JSP é necessário utilizarmos o escopo PARAM
			//Ex: param.nomeDoParametro
			response.sendRedirect("index.jsp?msgStatus=Ocorreu um erro ao gravar os dados.");
		}
		
		//REALIZANDO O ENCAMINHAMENTO.
		//request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	//LISTANDO TODOS OS CLIENTES
	public void listagem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Instanciar a classe BO
		ClienteBO cb = new ClienteBO();
		
		//Através do método listagem da clsse BO camos popular
		// um atributo no request com o retorno da método.
		request.setAttribute("lista_cli", cb.listagemCliente());
		
		//Realizar o encaminhamento para a página lista.jsp para carregar a lista de clientes.
		request.getRequestDispatcher("lista.jsp").forward(request, response);
	}

}
