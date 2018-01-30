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
<<<<<<< HEAD
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
       if(command.equals("/boardList.boa")) {//ê²Œì‹œíŒì „ì²´ì¶œë ¥
          boardList=boardDAO.boardList(boardDTO);
          RequestDispatcher dispatcher=request.getRequestDispatcher("template.jsp?page=board");
          request.setAttribute("boardList", boardList);
          dispatcher.forward(request, response);
          /*dispatcher.include(request, response);
           out.print("<table border='1' width = '80%'>");
            out.print("<tr align = 'center'>");

          out.print("<td>ë²ˆí˜¸</td><td>ì œëª©</td><td>ì‚¬ì§„</td><td>ì‘ì„±ì</td><td>ë‚ ì§œ</td><td>ì¡°íšŒìˆ˜</td>");
          out.print("</tr>");
          for(int indexI=0;indexI<boardList.size();indexI++) {
             boardDTO = boardList.get(indexI);
             out.print("<tr align='center'><td>"+boardDTO.getNo()+"</td><td>"+boardDTO.getTitle()+"</td><td><img src='images/"+boardDTO.getIcon()+"'></td><td>"+boardDTO.getAuthor()+"</td><td>"+boardDTO.getNal()+"</td><td>"+boardDTO.getReadcount()+"</td></tr>");
             
          }
       */   
       }//ê²Œì‹œíŒì „ì²´ì¶œë ¥
       else if(command.equals("/boardWrite.boa")) {//ê¸€ì“°ê¸°
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
          
       }//ê¸€ì“°ê¸°
       else if(command.equals("/boardSearch.boa")) {//ê²Œì‹œê¸€ ê²€ìƒ‰
          String title=request.getParameter("title");
          boardDTO.setTitle(title);
          boardList=boardDAO.boardSearch(boardDTO);
          RequestDispatcher dispatcher=request.getRequestDispatcher("template.jsp?page=board");
          request.setAttribute("boardList", boardList);
          dispatcher.forward(request, response);
          
       }//ê²Œì‹œê¸€ ê²€ìƒ‰
       else if(command.equals("/boardDelete.boa")) {//ê²Œì‹œê¸€ ì‚­ì œ
          String no=request.getParameter("no");
          boardDTO.setNo(Integer.parseInt(no));
          boardDAO.boardDelete(boardDTO);
          response.sendRedirect("boardList.boa");
      
       }//ê²Œì‹œê¸€ ì‚­ì œ
       else if(command.equals("/boardUpdate.boa")) {//ê²Œì‹œê¸€ ìˆ˜ì •
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
       }//ê²Œì‹œê¸€ ìˆ˜ì •
       else if(command.equals("/boardContent.boa")) {//ê²Œì‹œê¸€ ë‚´ìš©
          String no=request.getParameter("no");
          boardDTO.setNo(Integer.parseInt(no));
          boardDTO=boardDAO.boardContent(boardDTO);
          boardDAO.boardReadCount(boardDTO);
          RequestDispatcher dis =request.getRequestDispatcher("template.jsp?page=boardContent");
          request.setAttribute("boardDTO", boardDTO);
          dis.forward(request, response);
       }//ê²Œì‹œê¸€ ë‚´ìš©
       
   }
}
=======
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
	    if(command.equals("/boardList.boa")) {//°Ô½ÃÆÇÀüÃ¼Ãâ·Â
	    	boardList=boardDAO.boardList(boardDTO);
	    	RequestDispatcher dispatcher=request.getRequestDispatcher("template.jsp?page=board");
	    	request.setAttribute("boardList", boardList);
	    	dispatcher.forward(request, response);
	    	/*dispatcher.include(request, response);
	    	 out.print("<table border='1' width = '80%'>");
	         out.print("<tr align = 'center'>");

	    	out.print("<td>¹øÈ£</td><td>Á¦¸ñ</td><td>»çÁø</td><td>ÀÛ¼ºÀÚ</td><td>³¯Â¥</td><td>Á¶È¸¼ö</td>");
	    	out.print("</tr>");
	    	for(int indexI=0;indexI<boardList.size();indexI++) {
	    		boardDTO = boardList.get(indexI);
	    		out.print("<tr align='center'><td>"+boardDTO.getNo()+"</td><td>"+boardDTO.getTitle()+"</td><td><img src='images/"+boardDTO.getIcon()+"'></td><td>"+boardDTO.getAuthor()+"</td><td>"+boardDTO.getNal()+"</td><td>"+boardDTO.getReadcount()+"</td></tr>");
	    		
	    	}
	    */	
	    }//°Ô½ÃÆÇÀüÃ¼Ãâ·Â
	    else if(command.equals("/boardWrite.boa")) {//±Û¾²±â
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
	    	
	    }//±Û¾²±â
	    else if(command.equals("/boardSearch.boa")) {//°Ô½Ã±Û °Ë»ö
	    	String title=request.getParameter("title");
	    	boardDTO.setTitle(title);
	    	boardList=boardDAO.boardSearch(boardDTO);
	    	RequestDispatcher dispatcher=request.getRequestDispatcher("template.jsp?page=board");
	    	request.setAttribute("boardList", boardList);
	    	dispatcher.forward(request, response);
	    	
	    }//°Ô½Ã±Û °Ë»ö
	    else if(command.equals("/boardDelete.boa")) {//°Ô½Ã±Û »èÁ¦
	    	String no=request.getParameter("no");
	    	boardDTO.setNo(Integer.parseInt(no));
	    	boardDAO.boardDelete(boardDTO);
	    	response.sendRedirect("boardList.boa");
	   
	    }//°Ô½Ã±Û »èÁ¦
	    else if(command.equals("/boardUpdate.boa")) {//°Ô½Ã±Û ¼öÁ¤
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
	    }//°Ô½Ã±Û ¼öÁ¤
	    else if(command.equals("/boardContent.boa")) {//°Ô½Ã±Û ³»¿ë
	    	String no=request.getParameter("no");
	    	boardDTO.setNo(Integer.parseInt(no));
	    	boardDTO=boardDAO.boardContent(boardDTO);
	    	boardDAO.boardReadCount(boardDTO);
	    	RequestDispatcher dis =request.getRequestDispatcher("template.jsp?page=boardContent");
	    	request.setAttribute("boardDTO", boardDTO);
	    	dis.forward(request, response);
	    }//°Ô½Ã±Û ³»¿ë
	    
	}
}
>>>>>>> branch 'master' of https://github.com/jinsick/MovieProject.git
