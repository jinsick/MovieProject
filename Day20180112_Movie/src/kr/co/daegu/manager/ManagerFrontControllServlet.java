package kr.co.daegu.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("*.manager")
public class ManagerFrontControllServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       managerDTO mdto;
       managerDAO mdao; 
    public ManagerFrontControllServlet() {
       mdto = new managerDTO();
       mdao = new managerDAO();
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   doPost(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   request.setCharacterEncoding("utf-8");
   response.setContentType("text/html; charset=utf-8");
   PrintWriter out = response.getWriter();
   String requestURI = request.getRequestURI();
   String contextPath = request.getContextPath();
   String command = requestURI.substring(contextPath.length());
   if (command.equals("/Register.manager")) {//등록
      String id = request.getParameter("id");
      String pw = request.getParameter("pw");
      String pwsh = request.getParameter("pwsh");
      String lv = request.getParameter("lv");
      String part = request.getParameter("part");
      String name = request.getParameter("name");
      mdto.setId(id);
      mdto.setPw(pw);
      mdto.setPwsh(pwsh);
      mdto.setLv(lv);
      mdto.setPart(part);
      mdto.setName(name);
      mdao.managerRegister(mdto);
      out.print("등록되었습니다.");
      response.sendRedirect("template.jsp");
   }//등록
   
   
   else if(command.equals("/idcheck.manager")) {//아이디 중복여부
      String id = request.getParameter("id");
      mdto.setId(id);
      boolean idcheck = mdao.managerIdCheck(mdto);
      if(idcheck==true) {
         out.print("아이디가 이미 사용중입니다.");
      }else {
         out.print("아이디가 사용 가능합니다.");
      }
      out.print("<input type='button' value='종료' onClick='self.close()'>");
   }//아이디 중복여부
   
   
   else if(command.equals("/idSearch.manager")) {//아이디찾기
      String name = request.getParameter("name");
      String part = request.getParameter("part");
      mdto.setName(name);
      mdto.setPart(part);
      String id = mdao.managerIdSearch(mdto);
      if(id==null) {
         out.print("이름이나 부서가 잘못되었습니다.");
      }else {
         out.print("찾으시는 아이디는="+id+"입니다.");
      }
      out.print("<input type='button' value='종료' onClick='self.close()'>");
   }//아이디찾기
   
   
   else if(command.equals("/pwSearch.manager")) {//비밀번호 찾기
      String id = request.getParameter("id");
      String name = request.getParameter("name");
      String part = request.getParameter("part");
      mdto.setId(id);
      mdto.setName(name);
      mdto.setPart(part);
      String pw = mdao.managerPwSearch(mdto);
      if(pw==null) {
         out.print("id나 이름이나 부서이 잘못되었습니다.");
      }else {
         out.print("찾으시는 비밀번호는"+pw+"입니다.");
      }
      out.print("<input type='button' value='종료' onClick='self.close()'>");
   }//비밀번호 찾기
   
   
   else if(command.equals("/loginform.manager")) {//로그인
      HttpSession session = request.getSession(false);
      String id = request.getParameter("id");
      String pw = request.getParameter("pw");
      mdto.setId(id);
      mdto.setPw(pw);
      boolean login=mdao.managerLogin(mdto);
      if(login==true) {
         session.setAttribute("id",id);
         System.out.println(session.getAttribute("id"));
         response.sendRedirect("template.jsp");
      }else {
         response.sendRedirect("template.jsp?page=managerLogin");
      }
   }//로그인
   
   
   else if(command.equals("/logout.manager")) {//로그아웃
      HttpSession session = request.getSession(false);
      session.removeAttribute("id");
      response.sendRedirect("template.jsp");
   }//로그아웃
   
   
   else if(command.equals("/updateView.manager")) {//수정view
      String id = request.getParameter("id");
      String pw = request.getParameter("pw");
      String pwsh = request.getParameter("pwsh");
      String lv = request.getParameter("lv");
      String name = request.getParameter("name"); 
      String part = request.getParameter("part");
      mdto.setId(id);
      mdto.setPw(pw);
      mdto.setPwsh(pwsh);
      mdto.setLv(lv);
      mdto.setName(name);
      mdto.setPart(part);
      mdao.managerUpdate(mdto);
      out.print("정보가 수정되었습니다.");
      response.sendRedirect("template.jsp?page=managerLogin");
   }//수정view
   else if(command.equals("/update.manager")) {//수정
      HttpSession session = request.getSession(false);
      String id = (String) session.getAttribute("id");
      mdto.setId(id);
      System.out.println();
      mdto=mdao.managerUpdateView(mdto);
      RequestDispatcher dis = request.getRequestDispatcher("template.jsp?page=managerUpdate2");
      request.setAttribute("mdto", mdto);
      dis.forward(request, response);
   }//수정
   else if(command.equals("/delete.manager")) {//삭제
      HttpSession session = request.getSession(false);
      String id = (String) session.getAttribute("id");
      mdto.setId(id);
      mdao.managerLeave(mdto);
      session.removeAttribute("id");
      response.sendRedirect("template.jsp");
   }//삭제
  }
}