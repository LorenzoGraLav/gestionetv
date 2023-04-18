package it.gestionetv.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.gestionetv.service.MyServiceFactory;


@WebServlet("/PrepareDeleteTelevisoreServlet")
public class PrepareDeleteTelevisoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// iniziamo il binding
		String parametroIdDelTelevisoreCheVoglioEliminare = request.getParameter("idDaInviareComeParametro");
		Long idTelevisoreDaRimuovere = Long.parseLong(parametroIdDelTelevisoreCheVoglioEliminare);
		
		// validazione al momento vuota!
		
		
		//iniziamo il business!
		
		request.setAttribute("televisoreDaInviareAPaginaRimozione", MyServiceFactory.getTelevisoreServiceInstance().caricaSingolo(idTelevisoreDaRimuovere));
		
		//ora possiamo fare il forward!
		
		request.getRequestDispatcher("delete.jsp").forward(request, response);
		
	}

}
