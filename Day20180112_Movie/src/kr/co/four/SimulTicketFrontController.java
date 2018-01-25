package kr.co.four;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.ticket")
public class SimulTicketFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SimulTicketDAO simulTicketDAO;
	private SimulTicketDTO simulTicketDTO;
	private ArrayList<SimulTicketDTO> simulTicketList;

	public SimulTicketFrontController() {
		simulTicketDAO = new SimulTicketDAO();
		simulTicketDTO = new SimulTicketDTO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;Charset=utf-8");
		PrintWriter out = response.getWriter();
		String requestURL = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURL.substring(contextPath.length());

		System.out.println(command);
		if (command.equals("/enter.ticket")) {// 갯수 액 넘기기
			String nal = request.getParameter("nal");
			int original = Integer.parseInt(request.getParameter("original"))*10000;
			int morning = Integer.parseInt(request.getParameter("morning"))*8000;
			int night = Integer.parseInt(request.getParameter("night"))*8000;
			int coupon = Integer.parseInt(request.getParameter("coupon"))*(-2000);
			int wend = Integer.parseInt(request.getParameter("wend"))*2000;
			int ticketsu = Integer.parseInt(request.getParameter("original"))+Integer.parseInt(request.getParameter("morning"))+Integer.parseInt(request.getParameter("night"));
			simulTicketDTO.setNal(nal);
			simulTicketDTO.setOriginal(original);
			simulTicketDTO.setMorning(morning);
			simulTicketDTO.setNight(night);
			simulTicketDTO.setCoupon(coupon);
			simulTicketDTO.setWend(wend);
			simulTicketDTO.setTicketsu(ticketsu);
			simulTicketDAO.ticketInsert(simulTicketDTO);
			response.sendRedirect("template.jsp?page=simulator");
		} // 갯수 액 넘기기

	}

}
