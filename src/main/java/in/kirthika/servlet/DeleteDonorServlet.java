package in.kirthika.servlet;
import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.kirthika.service.DonorManager;

/**
 * Servlet implementation class DeleteDonorServlet
 */
@WebServlet("/DeleteDonorServlet")
public class DeleteDonorServlet extends HttpServlet {
	private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException {

		try {
			DonorManager manager = new DonorManager();
			Long donorNum = Long.parseLong(request.getParameter("mobileNumber"));
			String donorName = request.getParameter("donorName");
			manager.deleteDonor(donorNum, donorName);
			response.sendRedirect("deleteDonorDetail.jsp");
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

	}

}
