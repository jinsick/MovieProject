package kr.ac.daegu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class MovieDAO {

   private DataSource datafactory;
   private Connection conn;
   private PreparedStatement pstmt;
   private ResultSet rs;
   private String sql;
   private int cnt;
   private ArrayList<MovieDTO> movieList;
   
   public MovieDAO() {
      try {
         Context ctx = new InitialContext();
         datafactory = (DataSource) ctx.lookup(ConstVal.DB_NAME);
         conn = datafactory.getConnection();
      } catch (NamingException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   public int movieNoMax() {
      try {
         sql = "select max(movie_no) as no from Movie";
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();
         while(rs.next()) {
            cnt = rs.getInt("no");
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return cnt;
   }
   
   
   public int movieRegist(MovieDTO mdto) {
      try {
         sql = "insert into Movie(movie_no,movie_picture,movie_title,movie_kind,movie_grade,movie_rank,movie_director,movie_actor) values(?,?,?,?,?,?,?,?)";
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, mdto.getNo());
         pstmt.setString(2, mdto.getPicture());
         pstmt.setString(3, mdto.getTitle());
         pstmt.setString(4, mdto.getKind());
         pstmt.setString(5, mdto.getGrade());
         pstmt.setString(6, mdto.getRank());
         pstmt.setString(7, mdto.getDirector());
         pstmt.setString(8, mdto.getActor());
         cnt=pstmt.executeUpdate();
         System.out.println(mdto.getNo());
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return cnt;
   }
   
   public ArrayList<MovieDTO> movieList(MovieDTO mdto) {
      try {
         sql="select * from Movie";
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();
         movieList = new ArrayList<MovieDTO>();
         while(rs.next()) {
            mdto = new MovieDTO();
            mdto.setNo(rs.getInt("movie_no"));
            mdto.setPicture(rs.getString("movie_picture"));
            mdto.setTitle(rs.getString("movie_title"));
            mdto.setRank(rs.getString("movie_rank"));
            mdto.setKind(rs.getString("movie_kind"));
            mdto.setGrade(rs.getString("movie_grade"));
            mdto.setDirector(rs.getString("movie_director"));
            mdto.setActor(rs.getString("movie_actor"));
            movieList.add(mdto);
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return movieList;
   }
   
   public void movieUpdate() {
      sql = "update ";
   }
   
}