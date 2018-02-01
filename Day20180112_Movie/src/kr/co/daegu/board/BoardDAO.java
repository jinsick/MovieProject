package kr.co.daegu.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDAO {
   public DataSource dataFactory;
   private Connection conn;
   private String sql;
   private PreparedStatement pstmt;
   private ResultSet rs;
   private ArrayList<BoardDTO> boardList;
   private int cnt;
   
   public BoardDAO() {
      
         try {
            Context ctx = new InitialContext();
            boardList = new ArrayList<BoardDTO>();
            dataFactory=(DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
            conn =dataFactory.getConnection();
         } catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      
   }
   public void boardClose() {
      try {
         conn.close();
         pstmt.close();
         rs.close();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   public ArrayList<BoardDTO> boardList(BoardDTO boardDTO) {//게시판전체출력
   try {
      
      sql="select * from userboard";
      pstmt=conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      boardList=new ArrayList<BoardDTO>();
      while(rs.next()) {
         boardDTO = new BoardDTO();
         boardDTO.setNo(rs.getInt("no"));
          boardDTO.setTitle(rs.getString("title"));
          boardDTO.setAuthor(rs.getString("author"));
          boardDTO.setNal(rs.getString("nal"));
          boardDTO.setReadcount(rs.getInt("readcount"));
         boardList.add(boardDTO);
      }
   } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
   }
   return boardList;
}//게시판전체출력
   public void boardSqlInsert() {
      sql="select max(no) as no from userboard";
   }
   public void boardBunho() {//db학생번호
      try {
         
         boardSqlInsert();
         pstmt=conn.prepareStatement(sql);
         rs=pstmt.executeQuery();
         while(rs.next()) {
         cnt=rs.getInt("no");

         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
         
   }//학생번호
   
   public void boardWrite(BoardDTO boardDTO) {//글쓰기 메소드
      try {
         boardBunho();
         boardDTO.setNo(cnt+1);
         sql="insert into userboard(no,movie,title,author,nal,readcount) values(?,?,?,?,?,?)";
         pstmt=conn.prepareStatement(sql);
         pstmt.setInt(1, boardDTO.getNo());
         pstmt.setString(2, boardDTO.getMovie());
         pstmt.setString(3, boardDTO.getTitle());
         pstmt.setString(4, boardDTO.getAuthor());
         pstmt.setString(5, boardDTO.getNal());
         pstmt.setInt(6, boardDTO.getReadcount());
         cnt=pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }//글쓰기
   public ArrayList<BoardDTO> boardSearch(BoardDTO boardDTO) {//게시글 검색
      sql="select * from userboard where title like ?";
      try {
         pstmt=conn.prepareStatement(sql);
         pstmt.setString(1,"%"+boardDTO.getTitle()+"%");
         rs = pstmt.executeQuery();
         boardList=new ArrayList<BoardDTO>();
         while(rs.next()) {
            boardDTO = new BoardDTO();
            boardDTO.setNo(rs.getInt("no"));
             boardDTO.setMovie(rs.getString("movie"));
            boardDTO.setTitle(rs.getString("title"));
             boardDTO.setAuthor(rs.getString("author"));
             boardDTO.setNal(rs.getString("nal"));
             boardDTO.setReadcount(rs.getInt("readcount"));
            boardList.add(boardDTO);
         
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }   
      return boardList;
   }//게시글 검색
   public BoardDTO boardContent(BoardDTO boardDTO){//삭제하기 전 게시글
      sql="select * from userboard where no=?";
      try {
         pstmt=conn.prepareStatement(sql);
         pstmt.setInt(1,boardDTO.getNo());
         rs = pstmt.executeQuery();
         boardList=new ArrayList<BoardDTO>();
         while(rs.next()) {
            boardDTO = new BoardDTO();
            boardDTO.setNo(rs.getInt("no"));
             boardDTO.setMovie(rs.getString("movie"));
            boardDTO.setTitle(rs.getString("title"));
             boardDTO.setAuthor(rs.getString("author"));
             boardDTO.setNal(rs.getString("nal"));
             boardDTO.setReadcount(rs.getInt("readcount"));
            boardList.add(boardDTO);
         
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }   
      return boardDTO;
   }//삭제 게시글 전 내용
   public void boardDelete(BoardDTO boardDTO) {//게시글 삭제
      try {
         sql="delete from userboard where no=?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, boardDTO.getNo());
         cnt=pstmt.executeUpdate();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
   }//게시글 삭제
   public void boardUpdate(BoardDTO boardDTO) {//게시글 수정
      try {
         sql="update userboard set content=?,title=?,author=? where no=?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(2, boardDTO.getTitle());
         pstmt.setString(3, boardDTO.getAuthor());
         pstmt.setInt(4, boardDTO.getNo());
         cnt=pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }//게시글 수정
   public BoardDTO boardReadCount(BoardDTO boardDTO) {//조회수 증가
      try {
         sql="update userboard set readcount=? where no=?";
         pstmt=conn.prepareStatement(sql);
         pstmt.setInt(1,boardDTO.getReadcount()+1);
         pstmt.setInt(2, boardDTO.getNo());
         cnt=pstmt.executeUpdate();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return boardDTO;
   }//조회수 증가
}
