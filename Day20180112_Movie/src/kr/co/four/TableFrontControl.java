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
			System.out.println(tableList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("template.jsp?page=simulator");
			request.setAttribute("totalList", tableList);
			dispatcher.forward(request, response);
		}//테이블 리스트 넘기기
		
	else if (command.equals("/incomPeriod.ta")) {
			// HttpSession session = request.getSession();
			HttpSession session = request.getSession();
			tdto.setNal1(request.getParameter("nal1"));
			tdto.setNal2(request.getParameter("nal2"));
			tableList = tdao.report(tdto);
			RequestDispatcher dispatcher = request.getRequestDispatcher("mainList.ta");
			session.setAttribute("tableList", tableList);
			dispatcher.forward(request, response);

		} 
		else if (command.equals("/totalList.ta")) {// 목록
			HttpSession session = request.getSession(false);
			int curPage = 1;// 기본페이지
			if (request.getParameter("curPage") != null) {
				curPage = Integer.parseInt(request.getParameter("curPage"));
			}
			PageTo list = tdao.page(curPage);

			RequestDispatcher dis = request.getRequestDispatcher("template.jsp?page=simulator");
			session.setAttribute("page", list);
			// listPage.jsp에서 목록 리스트 데이터 저장
			session.setAttribute("list", list.getBoardlist());
			// page.jsp에서 페이징 처리 데이터 저장
			dis.forward(request, response);

		} 
		
		else if(command.equals("/mainDelete")) {//리스트 삭제
			String deleteNal = request.getParameter("nal");
			tdto.setNal(deleteNal);
		}//리스트삭제
		
		
	}

}
