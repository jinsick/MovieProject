package kr.co.four;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("*.ta")
public class TableFrontControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TableDTO tdto;
	TableDAO tdao;
	ArrayList<TableDTO> tableList;
	ArrayList<TableDTO> tableList1;

	public TableFrontControl() {
		tdto = new TableDTO();
		tdao = new TableDAO();

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

		if (command.equals("/mainList.ta")) {//테이블 평균 넘기기
			tableList = tdao.head(tdto);
			RequestDispatcher dispatcher = request.getRequestDispatcher("template.jsp?page=simulator");
			request.setAttribute("totalList", tableList);
			dispatcher.forward(request, response);
			
		}//테이블 리스트 넘기기
		
	else if (command.equals("/incomPeriod.ta")) {
			// HttpSession session = request.getSession();
			HttpSession session = request.getSession();
			session.removeAttribute("tableList");
			session.removeAttribute("list");
			session.removeAttribute("page");
			tdto.setNal1(request.getParameter("nal1"));
			tdto.setNal2(request.getParameter("nal2"));
			float totalSalse = 0;
			tableList = tdao.report(tdto, totalSalse);
			
			int curPage = 1;// 기본페이지
			if (request.getParameter("curPage") != null) {
				curPage = Integer.parseInt(request.getParameter("curPage"));
			}
			PageTo list = tdao.page(curPage, tdto,tdto.getNal1(),tdto.getNal2());
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("mainList.ta");
			session.setAttribute("tableList", tableList);
			session.setAttribute("page", list);
			session.setAttribute("list", list.getBoardlist());
			dispatcher.forward(request, response);
		} 
		else if (command.equals("/incomeDay.ta")) {// 목록
			HttpSession session = request.getSession(false);
			session.removeAttribute("tableList");
			session.removeAttribute("list");
			session.removeAttribute("page");
			String nal1 = request.getParameter("nal1");
			tdto.setNal(nal1);
			float totlaSalse=0;
			tableList = tdao.incomeDay(tdto,totlaSalse);
			
			
			int curPage = 1;// 기본페이지
			if (request.getParameter("curPage") != null) {
				curPage = Integer.parseInt(request.getParameter("curPage"));
			}
			PageTo list = tdao.page(curPage, tdto,nal1,nal1);
System.out.println(list);
			RequestDispatcher dis = request.getRequestDispatcher("mainList.ta");
			session.setAttribute("page", list);
			session.setAttribute("list", list.getBoardlist());
			session.setAttribute("tableList", tableList);
			dis.forward(request, response);

		} 
		
		else if(command.equals("/simulatorDelete.ta")) {//리스트 삭제
			tdto.setNal(request.getParameter("nal"));
			tdao.ticketDelete(tdto);
			tdao.marketDelete(tdto);
			response.sendRedirect("template.jsp?page = simulator");
			
		}//리스트삭제
		
		
	}

}
