package kr.co.daegu.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.boa")
public class BoardFrontController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private BoardDAO boardDAO;
   private BoardDTO boardDTO;
   private ArrayList<BoardDTO> boardList;
   
   public BoardFrontController() {
      boardDAO = new BoardDAO();
      boardDTO = new BoardDTO();
   }
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request,response);
   }

   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
       response.setContentType("text/html;charset=utf-8");
       PrintWriter out = response.getWriter();
       String requestURI  =request.getRequestURI();
       String contextPath = request.getContextPath();
       String command = requestURI.substring(contextPath.length());
       if(command.equals("/boardList.boa")) {//게시판전체출력
          boardList=boardDAO.boardList(boardDTO);
          RequestDispatcher dispatcher=request.getRequestDispatcher("template.jsp?page=board");
          request.setAttribute("boardList", boardList);
          dispatcher.forward(request, response);
          /*dispatcher.include(request, response);
           out.print("<table border='1' width = '80%'>");
            out.print("<tr align = 'center'>");

          out.print("<td>번호</td><td>제목</td><td>사진</td><td>작성자</td><td>날짜</td><td>조회수</td>");
          out.print("</tr>");
          for(int indexI=0;indexI<boardList.size();indexI++) {
             boardDTO = boardList.get(indexI);
             out.print("<tr align='center'><td>"+boardDTO.getNo()+"</td><td>"+boardDTO.getTitle()+"</td><td><img src='images/"+boardDTO.getIcon()+"'></td><td>"+boardDTO.getAuthor()+"</td><td>"+boardDTO.getNal()+"</td><td>"+boardDTO.getReadcount()+"</td></tr>");
             
          }
       */   
       }//게시판전체출력
       else if(command.equals("/boardWrite.boa")) {//글쓰기
          String title=request.getParameter("title");
          String movie=request.getParameter("movie");
          String author=request.getParameter("author");
          String nal=request.getParameter("nal");
          
          
          boardDTO.setTitle(title);
          boardDTO.setMovie(movie);
          boardDTO.setAuthor(author);
          boardDTO.setNal(nal);
          boardDTO.setReadcount(0);
          boardDAO.boardWrite(boardDTO);
          boardList=boardDAO.boardList(boardDTO);
          response.sendRedirect("boardList.boa");
          /*RequestDispatcher dispatcher =request.getRequestDispatcher("template.jsp?page=board");
          request.setAttribute("boardList", boardList);
          dispatcher.include(request, response);*/
          
       }//글쓰기
       else if(command.equals("/boardSearch.boa")) {//게시글 검색
          String title=request.getParameter("title");
          boardDTO.setTitle(title);
          boardList=boardDAO.boardSearch(boardDTO);
          RequestDispatcher dispatcher=request.getRequestDispatcher("template.jsp?page=board");
          request.setAttribute("boardList", boardList);
          dispatcher.forward(request, response);
          
       }//게시글 검색
       else if(command.equals("/boardDelete.boa")) {//게시글 삭제
          String no=request.getParameter("no");
          boardDTO.setNo(Integer.parseInt(no));
          boardDAO.boardDelete(boardDTO);
          response.sendRedirect("boardList.boa");
      
       }//게시글 삭제
       else if(command.equals("/boardUpdate.boa")) {//게시글 수정
          String no=request.getParameter("no");
          String movie=request.getParameter("moive");
          String title = request.getParameter("title");
          String author =request.getParameter("author");
          
          boardDTO.setNo(Integer.parseInt(no));
          boardDTO.setMovie(movie);
          boardDTO.setTitle(title);
          boardDTO.setAuthor(author);
          boardDAO.boardUpdate(boardDTO);
          response.sendRedirect("boardList.boa");
       }//게시글 수정
       else if(command.equals("/boardContent.boa")) {//게시글 내용
          String no=request.getParameter("no");
          boardDTO.setNo(Integer.parseInt(no));
          boardDTO=boardDAO.boardContent(boardDTO);
          boardDAO.boardReadCount(boardDTO);
          RequestDispatcher dis =request.getRequestDispatcher("template.jsp?page=boardContent");
          request.setAttribute("boardDTO", boardDTO);
          dis.forward(request, response);
       }//게시글 내용
       
   }
}