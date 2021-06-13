package in.kirthika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.kirthika.model.SeekerDetail;
import in.kirthika.service.SeekerManager;
import in.kirthika.util.MobileNumberValidator;
import in.kirthika.util.NameValidator;
import in.kirthika.validator.SeekerValidator;

/**
 * Servlet implementation class SeekerStatus
 */
@WebServlet("/SeekerStatus")
public class SeekerStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String name = request.getParameter("seekerName");
			Long donorNumber = Long.parseLong(request.getParameter("mobileNumber"));
			NameValidator.isValidName(name);
			MobileNumberValidator.isValidMobileNumber(donorNumber);

			SeekerValidator.seekerNumberValidator(donorNumber, name, "Seeker not registered");
			SeekerDetail detail = new SeekerDetail();
			detail.setMobileNumber(donorNumber);
			detail.setName(name);

			SeekerManager manager = new SeekerManager();
			boolean isValid = manager.seekerStatus(detail);

			if (isValid) {
				String status = "Donor Available";
				response.sendRedirect(
						"statusDisplay.jsp?name=" + name + "&number=" + donorNumber + "&status=" + status);
			} else {
				String status = "Donor unavailable-Check after sometimes";
				response.sendRedirect(
						"statusDisplay.jsp?name=" + name + "&number=" + donorNumber + "&status=" + status);
			}
		} catch (Exception e) {
			response.sendRedirect("seekerStatus.jsp?errorMessage=" + e.getMessage());

		}

	}

}
