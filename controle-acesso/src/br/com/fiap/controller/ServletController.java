package br.com.fiap.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletController
 */
@WebServlet(urlPatterns = {"/index.aspx","/validador"})
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Teste de Request
		System.out.println("Olá Mundo!");
		
		/***
		 * Bloco de processamento
		 */
		
		String nomeUsuario  = "";
		String senhaUsuario = "";
		
		//Utilizando o request recupere os dados do FORM passando para as variáveis.
		// utilize o método getParameter(nome do campo do form)
		nomeUsuario  = request.getParameter("nome");
		senhaUsuario = request.getParameter("senha");
		
		
		//Imprimindo a informação do usuário
		System.out.println("Nome  do usuário :"+nomeUsuario);
		System.out.println("Senha do usuário :"+senhaUsuario);
		
		/***
		 * Bloco de processamento
		 */
		
		//Redirecionamento
		//Utilize o response e use o método 
		// sendRedirect(Path=caminho ou uma URI)
		response.sendRedirect("login.jsp");

	}

}
