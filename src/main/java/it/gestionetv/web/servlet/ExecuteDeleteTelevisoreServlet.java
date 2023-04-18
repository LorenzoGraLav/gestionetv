package it.gestionetv.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.gestionetv.service.MyServiceFactory;
import it.gestionetv.service.televisore.TelevisoreService;

@WebServlet("/ExecuteDeleteTelevisoreServlet")
public class ExecuteDeleteTelevisoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// iniziamo il binding
		String parametroIdDelTelevisoreCheVoglioEliminare = request.getParameter("idDaRimuovere");
		Long idTelevisoreDaRimuovere = Long.parseLong(parametroIdDelTelevisoreCheVoglioEliminare);
		
		// validazione al momento vuota!
		
		//iniziamo il business!
		
		TelevisoreService televisoreService = MyServiceFactory.getTelevisoreServiceInstance();
		televisoreService.elimina(idTelevisoreDaRimuovere);
		request.setAttribute("listTelevisoriAttributeMarca", televisoreService.listAll());
		
		//ora posso fare il forward
		
		request.getRequestDispatcher("results.jsp").forward(request, response);
		
	}

}
