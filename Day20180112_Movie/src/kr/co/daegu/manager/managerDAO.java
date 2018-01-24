package kr.co.daegu.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

   public class managerDAO {
   private DataSource dataFactory;
   private Connection conn;
   private PreparedStatement pstmt;
   private String sql;
   private ResultSet rs;
   private String id;
   private int cnt;
   public managerDAO() {
         try {
            Context ctx = new InitialContext();
            dataFactory = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
            conn = dataFactory.getConnection();
         } catch (NamingException e) {
            e.printStackTrace();
         } catch (SQLException e) {
            e.printStackTrace();
         }
   }
   
   public void managerRegister(managerDTO mdto) {//등록
      sql = "insert into manager(id,pw,pwsh,lv,part,name) values(?,?,?,?,?,?)";
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, mdto.getId());
         pstmt.setString(2, mdto.getPw());
         pstmt.setString(3, mdto.getPwsh());
         pstmt.setString(4, mdto.getLv());
         pstmt.setString(5, mdto.getPart());
         pstmt.setString(6, mdto.getName());
         pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }//등록
   public boolean managerIdCheck(managerDTO mdto) {//아이디 중복여부
      boolean idCheck = false;
      try {
         sql = "select id from manager where id=?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, mdto.getId());
         rs=pstmt.executeQuery();
         while(rs.next()) {
            idCheck=true;
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return idCheck;
   }//아이디 중복여부
   public String managerIdSearch(managerDTO mdto) {//아이디찾기
      sql = "select id from manager where name=? and part=?";
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, mdto.getName());
         pstmt.setString(2, mdto.getPart());
         rs=pstmt.executeQuery();
         while(rs.next()) {
            id=rs.getString("id");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return id;
   }//아이디찾기
   public String managerPwSearch(managerDTO mdto) {//비밀번호 찾기
      String pw=null;
      sql = "select pw from manager where id=? and name=? and part=?";
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, mdto.getId());
         pstmt.setString(2, mdto.getName());
         pstmt.setString(3, mdto.getPart());
         rs=pstmt.executeQuery();
         while(rs.next()) {
            id=rs.getString("id");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return pw;
   }//비밀번호찾기
   public boolean managerLogin(managerDTO mdto) {//로그인
      boolean login=false;
      sql = "select id,pw from manager where id=? and pw=?";
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, mdto.getId());
         pstmt.setString(2, mdto.getPw());
         rs=pstmt.executeQuery();
         while(rs.next()) {
            login=true;
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return login;
   }//로그인
   public managerDTO managerUpdateView(managerDTO mdto) {//수정
      sql = "select id,pw,pwsh,lv,part,name from manager where id=?";
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, mdto.getId());
         rs=pstmt.executeQuery();
         while(rs.next()) {
            mdto.setId(rs.getString("id"));
            mdto.setPw(rs.getString("pw"));
            mdto.setPwsh(rs.getString("pwsh"));
            mdto.setLv(rs.getString("lv"));
            mdto.setPart(rs.getString("part"));
            mdto.setName(rs.getString("name"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return mdto;
   }//수정
   public void managerUpdate(managerDTO mdto) {//수정view
      sql = "update manager set pw=?, pwsh=?, lv=?, part=?, name=? where id=?";
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(6, mdto.getId());
         pstmt.setString(1, mdto.getPw());
         pstmt.setString(2, mdto.getPwsh());
         pstmt.setString(3, mdto.getLv());
         pstmt.setString(4, mdto.getPart());
         pstmt.setString(5, mdto.getName());
         cnt = pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }//수정view
   
   public void managerLeave(managerDTO mdto) {//삭제
      try {
         sql = "delete from manager where id=?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, mdto.getId());
         cnt = pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }//삭제
}