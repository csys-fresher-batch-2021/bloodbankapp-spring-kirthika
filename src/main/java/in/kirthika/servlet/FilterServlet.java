package in.kirthika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.kirthika.service.DonorManager;

/**
 * Servlet implementation class FilterServlet
 */
@WebServlet("/FilterServlet")
public class FilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			DonorManager manager = new DonorManager();
			String filterBlood = request.getParameter("donorBlood");

			manager.filterBlood(filterBlood.toUpperCase());
			response.sendRedirect("displayFilterList.jsp");
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
