package in.kirthika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import in.kirthika.service.AdminManager;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("password");
		boolean isValid = AdminManager.adminCheck(userName, userPassword);

		if (isValid) {

			HttpSession session = request.getSession();
			session.setAttribute("LOGIN_USER", userName);
			response.sendRedirect("adminManager.jsp");
		} else {
			String errorMessage = "Invalid Credentials";
			response.sendRedirect("login.jsp?message=" + errorMessage);
		}
	}
}
