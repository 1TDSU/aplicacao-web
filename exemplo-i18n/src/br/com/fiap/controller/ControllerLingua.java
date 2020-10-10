package br.com.fiap.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

/**
 * Servlet implementation class ControllerLingua
 */
@WebServlet("/change")
public class ControllerLingua extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerLingua() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//String que recebe o parâmetro com o locale selecionado/lingua
		String language = req.getParameter("lingua");
		
		//Instanciar a classe Locale
		Locale locale = new Locale(language);
		
		//Utilizando a classe Config para configurar o LOCALE do sistema e alterar o LOCALE do usuário.
		Config.set(req.getSession(), Config.FMT_LOCALE, locale);
		Config.set(req.getSession(), Config.FMT_FALLBACK_LOCALE, locale);
		
		//Redirecionando para a página index com o valor alterado.
		resp.sendRedirect("index.jsp?lingua="+locale);
	}

}










