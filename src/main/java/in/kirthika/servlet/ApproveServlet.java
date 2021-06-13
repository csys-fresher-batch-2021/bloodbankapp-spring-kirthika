package in.kirthika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.kirthika.service.SeekerManager;

/**
 * Servlet implementation class ApproveServlet
 */
@WebServlet("/ApproveServlet")
public class ApproveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			SeekerManager manager = new SeekerManager();
			Long seekerNum = Long.parseLong(request.getParameter("mobileNumber"));
			String seekerName = request.getParameter("receiverName");
			manager.approveSeeker(seekerNum, seekerName);
			response.sendRedirect("seekerRequest.jsp");

		} catch (Exception e) {
			e.getMessage();
		}

	}

}
