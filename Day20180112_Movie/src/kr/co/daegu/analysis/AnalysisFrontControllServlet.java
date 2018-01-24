package kr.co.daegu.analysis;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AnalysisFrontControllServlet
 */
@WebServlet("*.analysis")
public class AnalysisFrontControllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		private AnalysisDAO analysisDAO;
		private AnalysisDTO analysisDTO;
		private ArrayList<AnalysisDTO> analysisList;
		
	public AnalysisFrontControllServlet() {
		analysisDAO = new AnalysisDAO();
		analysisDTO = new AnalysisDTO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String requestURI  =request.getRequestURI();//jsp메인에 작성된  action주소로 보낸다고 해서 다 가는게아니다. localhost라고해서 (주소 맨앞)모든게 다 넘어감. 근데 이 과정을 거친 순간 자바변수에 담긴다.
		String contextPath = request.getContextPath();//
		String command = requestURI.substring(contextPath.length());//위에 두개에서 자르고 남은 부분을 substring짜르겠다. 전체주소중에 contextPath.length만큼을 짜른다. 그리고 아랫족 if문안에 boardList.boa와 비교한다.
		
		if(command.equals("/dayAver.analysis")) {
			String nal1 = request.getParameter("nal1");
			String nal2 = request.getParameter("nal2");
			analysisDTO.setNal1(nal1);
			analysisDTO.setNal2(nal2);
			response.sendRedirect("analysisList.analysis");
		}//검색 날짜
	
	}

}
