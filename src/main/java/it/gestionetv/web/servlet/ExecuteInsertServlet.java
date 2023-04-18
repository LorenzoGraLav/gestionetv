package it.gestionetv.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.gestionetv.model.Televisore;
import it.gestionetv.service.MyServiceFactory;
import it.gestionetv.service.televisore.TelevisoreService;
import it.gestionetv.utility.UtilityForm;

@WebServlet("/ExecuteInsertServlet")
public class ExecuteInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Binding

		String marcaTelevisoreParam = request.getParameter("marcaInput");
		String modelloTelevisoreParam = request.getParameter("modelloInput");
		String prezzoTelevisoreParam = request.getParameter("prezzoInput");
		String numeroPolliciTelevisoreParam = request.getParameter("numeroPolliciInput");
		String codiceTelevisoreParam = request.getParameter("codiceInput");
		Integer prezzoResult = UtilityForm.parseFromString(prezzoTelevisoreParam);
		Integer numeroPolliciResult = UtilityForm.parseFromString(numeroPolliciTelevisoreParam);
		Televisore televisoreDaInserire = new Televisore(marcaTelevisoreParam, modelloTelevisoreParam, prezzoResult,
				numeroPolliciResult, codiceTelevisoreParam);

		// se arrivo qui significa che il binding è terminato . Ora iniziano le
		// validazioni!

		if (televisoreDaInserire.getMarca().isBlank() || televisoreDaInserire.getModello().isBlank()
				|| prezzoResult == null || numeroPolliciResult == null || televisoreDaInserire.getCodice().isBlank()) {
			// se entro qui vuol dire che devo tornare al form facendo notare all utente che
			// qualcosa non è andata bene!
			String messaggioDaInviareAPagina = "Attenzione! E' Necessario valorizzare correttamente tutti i campi!";
			request.setAttribute("messaggioDiErrore", messaggioDaInviareAPagina);
			request.getRequestDispatcher("insert.jsp").forward(request, response);
			return;
		}

		// se sono qui vuol dire che è tutto okei. E' il momento di occuparci delle
		// regole di business!
		
		TelevisoreService televisoreService = MyServiceFactory.getTelevisoreServiceInstance();
		televisoreService.inserisci(televisoreDaInserire);
		request.setAttribute("listTelevisoriAttributeMarca", televisoreService.listAll());
		
		//dopo aver finito le operazioni di business posso fare i forward!
		
		request.getRequestDispatcher("results.jsp").forward(request, response);

	}

}
