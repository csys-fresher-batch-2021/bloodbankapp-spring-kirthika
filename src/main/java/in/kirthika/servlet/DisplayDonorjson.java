package in.kirthika.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.kirthika.model.DonorDetail;
import in.kirthika.service.DonorManager;

/**
 * Servlet implementation class DisplayDonorjson
 */
@WebServlet("/DisplayDonorjson")
public class DisplayDonorjson extends HttpServlet {

	private static final long serialVersionUID = 1L;
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DonorManager donor = new DonorManager();
		List<DonorDetail> donorList = donor.displayDonorList();
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String json = gson.toJson(donorList);
		out.print(json);
		out.flush();
	}

}
