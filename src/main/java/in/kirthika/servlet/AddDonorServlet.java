package in.kirthika.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.kirthika.model.DonorDetail;
import in.kirthika.service.DonorManager;
import in.kirthika.util.MobileNumberValidator;
import in.kirthika.util.NameValidator;
import in.kirthika.validator.AgeValidator;
import in.kirthika.validator.BloodGroupValidator;
import in.kirthika.validator.DonorValidator;
import in.kirthika.validator.PlaceValidator;

/**
 * Servlet implementation class AddDonorServlet
 */
@WebServlet("/AddDonorServlet")
public class AddDonorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String ACTION = "addDonor.jsp?errorMessage=";
		try {
			DonorDetail detail = new DonorDetail();
			String donorName = request.getParameter("donorName");
			String donorBlood = request.getParameter("bloodGroup");
			Long donorNumber = Long.parseLong(request.getParameter("mobileNumber"));
			Integer donorAge = Integer.parseInt(request.getParameter("age"));
			String donorPlace = request.getParameter("place");

			NameValidator.isValidName(donorName);
			DonorValidator.isAlreadyExist(donorName, donorNumber, "Donor Already Exist");
			BloodGroupValidator.donorBloodGroupValidator(donorBlood, "Blood Group cannot be Empty");
			MobileNumberValidator.isValidMobileNumber(donorNumber);
			AgeValidator.isEligibleDonor(donorAge, "Invalid Age for Donor");
			PlaceValidator.donorPlaceValidator(donorPlace, "Invalid Place");

			detail.setName(donorName);
			detail.setBloodGroup(donorBlood);
			detail.setMobileNumber(donorNumber);
			detail.setAge(donorAge);
			detail.setPlace(donorPlace);

			DonorManager manager = new DonorManager();
			boolean valid = manager.addDonor(detail);

			if (valid) {
				String errorMessage = "Donor already exist";
				response.sendRedirect(ACTION + errorMessage);

			} else {
				String errorMessage = "Donor added";
				response.sendRedirect(ACTION + errorMessage);
			}
		} catch (Exception e) {
			response.sendRedirect(ACTION + e.getMessage());
		}
	}

}
