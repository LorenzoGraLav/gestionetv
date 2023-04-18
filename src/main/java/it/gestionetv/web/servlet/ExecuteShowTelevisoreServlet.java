package it.gestionetv.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.gestionetv.service.MyServiceFactory;


/**
 * Servlet implementation class ExecuteShowTelevisoreServlet
 */
@WebServlet("/ExecuteShowTelevisoreServlet")
public class ExecuteShowTelevisoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// binding
				String parametroIdDelTelevisoreDiCuiVoglioIlDettaglio = request.getParameter("idDaInviareComeParametro");
				Long idTelevisoreLong = Long.parseLong(parametroIdDelTelevisoreDiCuiVoglioIlDettaglio);
				// qui andrebbe fatta una validazione che non facciamo al momento

				request.setAttribute("televisoreDaInviareAPaginaDettaglio",
						MyServiceFactory.getTelevisoreServiceInstance().caricaSingolo(idTelevisoreLong));

				request.getRequestDispatcher("dettaglio.jsp").forward(request, response);

	}

	

}
