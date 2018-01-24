package kr.co.four;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.market")
public class SimulMarketDrontCintroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
		private SimulMarketDAO simulMarketDAO;
		private SimulMarketDTO simulMarketDTO;
		private ArrayList<SimulMarketDTO> simulMarketList;
		
		public SimulMarketDrontCintroller() {
			simulMarketDAO = new SimulMarketDAO();
			simulMarketDTO = new SimulMarketDTO();
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
		if(command.equals("/enter.market")) {//마켓 갯수넘기기
			String nal = request.getParameter("nal");
			int pop = Integer.parseInt(request.getParameter("pop"))*5000;
			int col = Integer.parseInt(request.getParameter("col"))*2000;
			int oging = Integer.parseInt(request.getParameter("oging"))*5000;
			int dog = Integer.parseInt(request.getParameter("dog"))*4000;
			int chiken = Integer.parseInt(request.getParameter("chiken"))*8000;
			int coffee = Integer.parseInt(request.getParameter("coffee"))*4000;
			int combo1 = Integer.parseInt(request.getParameter("combo1"))*8500;
			int combo2 = Integer.parseInt(request.getParameter("combo2"))*20000;
			int water1 = Integer.parseInt(request.getParameter("water1"))*1500;
			simulMarketDTO.setNal(nal);
			simulMarketDTO.setPop(pop);
			simulMarketDTO.setCol(col);
			simulMarketDTO.setOging(oging);
			simulMarketDTO.setDog(dog);
			simulMarketDTO.setChiken(chiken);
			simulMarketDTO.setCoffee(coffee);
			simulMarketDTO.setCombo1(combo1);
			simulMarketDTO.setCombo2(combo2);
			simulMarketDTO.setWater1(water1);
			simulMarketDAO.marketinsert(simulMarketDTO);
			response.sendRedirect("template.jsp?page=simulator");
			
		}//마켓갯수넘기기
	
	}

}
