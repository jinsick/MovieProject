package kr.co.four;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.hold")
public class SimulHoldFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SimulHoldDTO simulHoldDTO;
	private SimulHoldDAO simulHoldDAO;
	private ArrayList<SimulHoldDTO> simulHoldList;
	
	public SimulHoldFrontController() {
		simulHoldDTO = new SimulHoldDTO();
		simulHoldDAO = new SimulHoldDAO();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;Charset=utf-8");
		PrintWriter out = response.getWriter();
		String requestURL = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURL.substring(contextPath.length());
		
		System.out.println(command);
		if(command.equals("/enter.hold")) {//∞Ì¡§µ∑
			String nal = request.getParameter("nal");
			int placem = Integer.parseInt(request.getParameter("placem"));
			int wage = Integer.parseInt(request.getParameter("wage"));
			int tax = Integer.parseInt(request.getParameter("tax"));
			simulHoldDTO.setNal(nal);
			simulHoldDTO.setPlacem(placem);
			simulHoldDTO.setWage(wage);
			simulHoldDTO.setTax(tax);
			simulHoldDAO.holdinsert(simulHoldDTO);
			response.sendRedirect("template.jsp?page=simulator");
		}//∞Ì¡§ µ∑
	}

}
