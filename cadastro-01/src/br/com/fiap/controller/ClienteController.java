package br.com.fiap.controller;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

import br.com.fiap.bean.Cliente;
import br.com.fiap.bo.ClienteBO;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet(urlPatterns =  {"/cliente","/listaall","/listar", "/update", "/excluir", "/auxiliar"})
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
		
		switch (request.getRequestURI()) {
		case "/cadastro-01/cliente":
			//Realizando a chamada para o método inserirCliente
			// e passando os parâmetros request e response.
			inserirCliente(request, response);
			break;

		case "/cadastro-01/listaall":
			listarCliente(request, response);
			break;
			
		case "/cadastro-01/listar":
			listarCliente(request, response, Integer.parseInt(request.getParameter("id_cli")));
			break;

		case "/cadastro-01/update":
			atualizarCliente(request, response);
			break;

		case "/cadastro-01/excluir":
			excluirCliente(request, response);
			break;

		case "/cadastro-01/auxiliar":
			alteraLingua(request, response);
			break;
			
		default:
			response.sendRedirect("index.jsp");
		}
		
				
	}
	
	public void alteraLingua(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		//Recuperando o parâmetro Locale que vêm da página selecionada pelo usuário.
		Locale locale = new Locale(req.getParameter("lingua"));
		
		//Realizando as alterções no Locale do sistema e do usuário.
		Config.set(req.getSession(), Config.FMT_LOCALE, locale);
		//Realizando as alterções no Locale do usuário e do usuário.
		Config.set(req.getSession(), Config.FMT_FALLBACK_LOCALE, locale);
		
		resp.sendRedirect("index.jsp");
	}

	//APAGANDO CLIENTE
	private void excluirCliente(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//Passar os dados para o BO
		ClienteBO cb = new ClienteBO();
		int resultado = cb.apagaCliente(Integer.parseInt(request.getParameter("id_cli")));
		
		//Verificaï¿½ï¿½o do resultado para gerar uma mensagem 
		// para o usuï¿½rio.
		if(resultado == 1) {

			//Criando um redirecionamento com parï¿½metros.
			//Obs:Para carregar parï¿½metros no JSP ï¿½ necessï¿½rio utilizarmos o escopo PARAM
			//Ex: param.nomeDoParametro
			response.sendRedirect("index.jsp?msgStatus=sucesso.del");
		}else {
			//Criando um redirecionamento com parï¿½metros.
			//Obs:Para carregar parï¿½metros no JSP ï¿½ necessï¿½rio utilizarmos o escopo PARAM
			//Ex: param.nomeDoParametro
			response.sendRedirect("index.jsp?msgStatus=erro.del_err");
		}

	}

	//ATUALIZANDO UM CLIENTE
	private void atualizarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//Recuperando os dados do request e adicionando em um objeto.
		Cliente cli = null;
		cli = new Cliente();
		cli.setNome(request.getParameter("txtNm"));
		cli.setSobrenome(request.getParameter("txtSnm"));
		cli.setDataNasc(request.getParameter("txtDtNasc"));
		cli.setGenero(request.getParameter("txtGen").charAt(0));
		cli.setTelefone(request.getParameter("txtTel"));
		
		//Passar os dados para o BO
		ClienteBO cb = new ClienteBO();
		int resultado = cb.atualizaCliente(cli, Integer.parseInt(request.getParameter("txtIdCli")));
		
		//Verificaï¿½ï¿½o do resultado para gerar uma mensagem 
		// para o usuï¿½rio.
		if(resultado == 1) {

			//Criando um redirecionamento com parï¿½metros.
			//Obs:Para carregar parï¿½metros no JSP ï¿½ necessï¿½rio utilizarmos o escopo PARAM
			//Ex: param.nomeDoParametro
			response.sendRedirect("index.jsp?msgStatus=sucesso.upd");
		}else {
			//Criando um redirecionamento com parï¿½metros.
			//Obs:Para carregar parï¿½metros no JSP ï¿½ necessï¿½rio utilizarmos o escopo PARAM
			//Ex: param.nomeDoParametro
			response.sendRedirect("index.jsp?msgStatus=erro.upd_err");
		}
				
	}

	//LISTANDO CLIENTE BY ID
	private void listarCliente(HttpServletRequest request, HttpServletResponse response, int idCli) throws ServletException, IOException {
		//Instanciar a classe BO
		ClienteBO cb = new ClienteBO();
		Cliente cli = cb.listagemCliente(idCli);
		
		if(cli != null) {
			//Criando um atributo no request  com o ObjCliente
			request.setAttribute("objCli", cli);
			request.setAttribute("objIdCli", idCli);
			
			//Realizar o encaminhamento para a pï¿½gina atualiza.jsp.
			request.getRequestDispatcher("atualiza.jsp").forward(request, response);
		}else{
			//Criando um parï¿½metro no com uma mensagem de erro para a pï¿½gina JSP index.
			response.sendRedirect("index.jsp?msgStatus=erro.list_err");
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
		
		//Verificaï¿½ï¿½o do resultado para gerar uma mensagem 
		// para o usuï¿½rio.
		if(resultado == 1) {
			//Criando um atributo no request e enviando para a index.jsp
			//request.setAttribute("msgStatus", "Os dados foram gravados com SUCESSO!");
			
			//Criando um redirecionamento com parï¿½metros.
			//Obs:Para carregar parï¿½metros no JSP ï¿½ necessï¿½rio utilizarmos o escopo PARAM
			//Ex: param.nomeDoParametro
			response.sendRedirect("index.jsp?msgStatus=sucesso.ins");
		}else {
			//Caso ocorra algum problema envie uma mensagem de erro.
			//request.setAttribute("msgStatus", "Ocorreu um erro ao gravar os dados.");
			
			//Criando um redirecionamento com parï¿½metros.
			//Obs:Para carregar parï¿½metros no JSP ï¿½ necessï¿½rio utilizarmos o escopo PARAM
			//Ex: param.nomeDoParametro
			response.sendRedirect("index.jsp?msgStatus=erro.ins_err");
		}
		
		//REALIZANDO O ENCAMINHAMENTO.
		//request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	//LISTANDO TODOS OS CLIENTES
	public void listarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Instanciar a classe BO
		ClienteBO cb = new ClienteBO();
		
		List<Cliente> lista = cb.listagemCliente();
		
		if(lista != null) {
			//Criando um atributo no request  com a lista de clientes
			request.setAttribute("lista_cli", lista);
			
			//Realizar o encaminhamento para a pï¿½gina lista.jsp para carregar a lista de clientes.
			request.getRequestDispatcher("/WEB-INF/lista.jsp").forward(request, response);
		}else{
			//Criando um parï¿½metro no com uma mensagem de erro para a pï¿½gina JSP index.
			response.sendRedirect("index.jsp?msgStatus=erro.list_err");
		}
	}

	
	
}
