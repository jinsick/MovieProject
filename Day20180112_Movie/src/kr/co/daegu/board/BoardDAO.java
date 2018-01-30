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
	public ArrayList<BoardDTO> boardList(BoardDTO boardDTO) {//�Խ�����ü���
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
}//�Խ�����ü���
	public void boardSqlInsert() {
		sql="select max(no) as no from userboard";
	}
	public void boardBunho() {//db�л���ȣ
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
			
	}//�л���ȣ
	
	public void boardWrite(BoardDTO boardDTO) {//�۾��� �޼ҵ�
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
	}//�۾���
	public ArrayList<BoardDTO> boardSearch(BoardDTO boardDTO) {//�Խñ� �˻�
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
	}//�Խñ� �˻�
	public BoardDTO boardContent(BoardDTO boardDTO){//�����ϱ� �� �Խñ�
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
	}//���� �Խñ� �� ����
	public void boardDelete(BoardDTO boardDTO) {//�Խñ� ����
		try {
			sql="delete from userboard where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardDTO.getNo());
			cnt=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//�Խñ� ����
	public void boardUpdate(BoardDTO boardDTO) {//�Խñ� ����
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
	}//�Խñ� ����
	public BoardDTO boardReadCount(BoardDTO boardDTO) {//��ȸ�� ����
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
	}//��ȸ�� ����
}

