package in.kirthika.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import in.kirthika.dto.StockDetail;
import in.kirthika.model.DonorDetail;
import in.kirthika.service.DonorManager;

/**
 * Servlet implementation class StockManagementServlet
 */
@WebServlet("/StockManagementServlet")
public class StockManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		String place=request.getParameter("stockPlace");
		Map<String,Integer> stockCount;
		DonorDetail detail = new DonorDetail();
		detail.setPlace(place);
	    DonorManager manager = new DonorManager();
		stockCount=manager.stockCount(detail);
		StockDetail stock=new StockDetail(stockCount);
		Gson gson = new Gson();
			String json = gson.toJson(stock);
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
			
	}
		catch(Exception e) {
			e.getMessage();
		}
	}		
	

}
