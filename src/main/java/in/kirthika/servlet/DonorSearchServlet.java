package in.kirthika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.kirthika.service.DonorManager;
import in.kirthika.validator.BloodGroupValidator;
import in.kirthika.validator.PlaceValidator;

/**
 * Servlet implementation class DonorSearchServlet
 */
@WebServlet("/DonorSearchServlet")
public class DonorSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String donorBlood = request.getParameter("bloodGroup");
			String donorPlace = request.getParameter("place");
			BloodGroupValidator.donorBloodGroupValidator(donorBlood, "Blood Group cannot be Empty");
			PlaceValidator.donorPlaceValidator(donorPlace, "Invalid Place");
			DonorManager manager = new DonorManager();
			boolean valid = manager.donorSearch(donorBlood, donorPlace);
			if (valid) {

				response.sendRedirect("searchDonor.jsp");
			}

		} catch (Exception e) {
			response.sendRedirect("donorSearchPage.jsp?errorMessage=" + e.getMessage());
		}

	}

}
