package in.kirthika.servlet;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.kirthika.model.SeekerDetail;
import in.kirthika.service.SeekerManager;
import in.kirthika.util.MobileNumberValidator;
import in.kirthika.util.NameValidator;
import in.kirthika.validator.BloodGroupValidator;
import in.kirthika.validator.DateValidator;
import in.kirthika.validator.PlaceValidator;

/**
 * Servlet implementation class SeekerServlet
 */
@WebServlet("/SeekerServlet")
public class SeekerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final String ACTION = "registrationForm.jsp?message=";
		try {
			String seekerName = request.getParameter("receiverName");
			String seekerBlood = request.getParameter("bloodGroup");
			Long seekerNumber = Long.parseLong(request.getParameter("mobileNumber"));
			Integer seekerAge = Integer.parseInt(request.getParameter("age"));
			String seekerPlace = request.getParameter("place");
			LocalDate date = LocalDate.parse(request.getParameter("date"));
			String gender = request.getParameter("gender");

			NameValidator.isValidName(seekerName);
			BloodGroupValidator.donorBloodGroupValidator(seekerBlood, "Blood Group cannot be Empty");
			MobileNumberValidator.isValidMobileNumber(seekerNumber);
			DateValidator.isValidDate(date, "Enter future date");
			PlaceValidator.donorPlaceValidator(seekerPlace, "Invalid Place");

			SeekerDetail detail = new SeekerDetail();

			detail.setName(seekerName);
			detail.setBloodGroup(seekerBlood);
			detail.setMobileNumber(seekerNumber);
			detail.setAge(seekerAge);
			detail.setPlace(seekerPlace);
			detail.setDate(date);
			detail.setGender(gender);

			SeekerManager manager = new SeekerManager();

			boolean valid = manager.addSeeker(detail);

			if (valid) {
				String message = "Registration is Unsuccessful";
				response.sendRedirect(ACTION + message);

			} else {
				String message = "Registration Successful";
				response.sendRedirect(ACTION + message);

			}
		}

		catch (Exception e) {
			response.sendRedirect(ACTION + e.getMessage());
		}

	}
}
