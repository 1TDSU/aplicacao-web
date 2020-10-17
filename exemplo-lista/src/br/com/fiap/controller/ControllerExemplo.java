package br.com.fiap.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ControllerExemplo
 */
@WebServlet("/exemplo")
public class ControllerExemplo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerExemplo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		
		List<String> lista = new ArrayList<String>();
		lista.add("1TDSU");
		lista.add("1TDST");
		lista.add("1TDSR");
		lista.add("1TDSS");
		lista.add("1TDSA");
		lista.add("1TDSG");
		lista.add("1TDSF");
		
		sessao.setAttribute("turmas-s", lista);
		request.setAttribute("turmas", lista);
		request.getRequestDispatcher("lista-turmas.jsp").forward(request, response);
		
	}

}
