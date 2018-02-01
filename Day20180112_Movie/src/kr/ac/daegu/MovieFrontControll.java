package kr.ac.daegu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("*.mo")
@MultipartConfig(maxFileSize = 1024*1024*2 , location="C:\\Develop\\WorkSpaceJPS\\Day20180112\\WebContent\\images")
public class MovieFrontControll extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private MovieDAO mdao;
   private MovieDTO mdto;
   private int cnt;
   private ArrayList<MovieDTO> movieList;
   private String picture;

   public MovieFrontControll() {
      mdao = new MovieDAO();
      mdto = new MovieDTO();

   }
   
   private String getFilename(Part part) {
      String fileName = null;
      String contentDispositionHeader = part.getHeader("content-disposition");
      String[] elements = contentDispositionHeader.split(";");
      for (String element : elements) {
         if (element.trim().startsWith("filename")) {
            fileName = element.substring(element.indexOf('=') + 1);
            fileName = fileName.trim().replace("\"", "");
         }
      }
      return fileName;
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      doPost(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      
      
      request.setCharacterEncoding("utf-8");
      response.setContentType("text/html;charset=utf-8");
      PrintWriter out = response.getWriter();

      String requestURI = request.getRequestURI();
      String contextPath = request.getContextPath();
      String command = requestURI.substring(contextPath.length());
      
   

      if (command.equals("/SM_MovieRegist.mo")) {
         Part part = request.getPart("theFile");
         String fileName = getFilename(part);
         if( fileName != null && !fileName.isEmpty()){
            // part.write("c:\\upload\\"+ fileName);
            part.write(fileName);
         }
         mdto.setNo(mdao.movieNoMax() + 1);
         mdto.setTitle(request.getParameter("title"));
         mdto.setPicture(fileName);
         mdto.setKind(request.getParameter("genre"));
         mdto.setDirector(request.getParameter("director"));
         mdto.setActor(request.getParameter("actor"));
         mdto.setRank(request.getParameter("rank"));
         mdto.setGrade(request.getParameter("review"));
         cnt = mdao.movieRegist(mdto);
         RequestDispatcher dispatcher = request.getRequestDispatcher("movieList.mo");
         dispatcher.forward(request, response);
      } else if (command.equals("/movieList.mo")) {
          movieList = mdao.movieList(mdto);
          if(request.getParameter("name").equals("user")) {
         	 RequestDispatcher dispatcher = request.getRequestDispatcher("usertemplate.jsp?page=Main_Movie_User");
              request.setAttribute("movieList", movieList);
              dispatcher.forward(request, response);
              
          }else if(request.getParameter("name").equals("manager")) {
          RequestDispatcher dispatcher1 = request.getRequestDispatcher("template.jsp?page=Main_Movie_manager");
          request.setAttribute("movieList", movieList);
          dispatcher1.forward(request, response);}
       }//�Ŵ��� ��Ʈ�� ���� ��
       
      /* else if(command.equals("/movieUpdate")) {
     	 movieUpdate = mdao.movieUpdete(mdto);
     	 if(request.getParameter("name").equals("user")) {
         	 RequestDispatcher dispatcher = request.getRequestDispatcher("template.jsp?page=Main_Movie_User");
              request.setAttribute("movieList", movieList);
              dispatcher.forward(request, response);
          }else if(request.getParameter("name").equals("manager")) {
          RequestDispatcher dispatcher1 = request.getRequestDispatcher("template.jsp?page=Main_Movie_manager");
          request.setAttribute("movieList", movieList);
          dispatcher1.forward(request, response);}
       }*/

   }

}