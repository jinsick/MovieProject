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
<<<<<<< HEAD
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
   public ArrayList<BoardDTO> boardList(BoardDTO boardDTO) {//Í≤åÏãúÌåêÏ†ÑÏ≤¥Ï∂úÎ†•
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
}//Í≤åÏãúÌåêÏ†ÑÏ≤¥Ï∂úÎ†•
   public void boardSqlInsert() {
      sql="select max(no) as no from userboard";
   }
   public void boardBunho() {//dbÌïôÏÉùÎ≤àÌò∏
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
         
   }//ÌïôÏÉùÎ≤àÌò∏
   
   public void boardWrite(BoardDTO boardDTO) {//Í∏ÄÏì∞Í∏∞ Î©îÏÜåÎìú
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
   }//Í∏ÄÏì∞Í∏∞
   public ArrayList<BoardDTO> boardSearch(BoardDTO boardDTO) {//Í≤åÏãúÍ∏Ä Í≤ÄÏÉâ
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
   }//Í≤åÏãúÍ∏Ä Í≤ÄÏÉâ
   public BoardDTO boardContent(BoardDTO boardDTO){//ÏÇ≠Ï†úÌïòÍ∏∞ Ï†Ñ Í≤åÏãúÍ∏Ä
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
   }//ÏÇ≠Ï†ú Í≤åÏãúÍ∏Ä Ï†Ñ ÎÇ¥Ïö©
   public void boardDelete(BoardDTO boardDTO) {//Í≤åÏãúÍ∏Ä ÏÇ≠Ï†ú
      try {
         sql="delete from userboard where no=?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, boardDTO.getNo());
         cnt=pstmt.executeUpdate();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
   }//Í≤åÏãúÍ∏Ä ÏÇ≠Ï†ú
   public void boardUpdate(BoardDTO boardDTO) {//Í≤åÏãúÍ∏Ä ÏàòÏ†ï
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
   }//Í≤åÏãúÍ∏Ä ÏàòÏ†ï
   public BoardDTO boardReadCount(BoardDTO boardDTO) {//Ï°∞ÌöåÏàò Ï¶ùÍ∞Ä
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
   }//Ï°∞ÌöåÏàò Ï¶ùÍ∞Ä
}
=======
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
	public ArrayList<BoardDTO> boardList(BoardDTO boardDTO) {//∞‘Ω√∆«¿¸√º√‚∑¬
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
}//∞‘Ω√∆«¿¸√º√‚∑¬
	public void boardSqlInsert() {
		sql="select max(no) as no from userboard";
	}
	public void boardBunho() {//db«–ª˝π¯»£
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
			
	}//«–ª˝π¯»£
	
	public void boardWrite(BoardDTO boardDTO) {//±€æ≤±‚ ∏ﬁº“µÂ
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
	}//±€æ≤±‚
	public ArrayList<BoardDTO> boardSearch(BoardDTO boardDTO) {//∞‘Ω√±€ ∞Àªˆ
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
	}//∞‘Ω√±€ ∞Àªˆ
	public BoardDTO boardContent(BoardDTO boardDTO){//ªË¡¶«œ±‚ ¿¸ ∞‘Ω√±€
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
	}//ªË¡¶ ∞‘Ω√±€ ¿¸ ≥ªøÎ
	public void boardDelete(BoardDTO boardDTO) {//∞‘Ω√±€ ªË¡¶
		try {
			sql="delete from userboard where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardDTO.getNo());
			cnt=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//∞‘Ω√±€ ªË¡¶
	public void boardUpdate(BoardDTO boardDTO) {//∞‘Ω√±€ ºˆ¡§
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
	}//∞‘Ω√±€ ºˆ¡§
	public BoardDTO boardReadCount(BoardDTO boardDTO) {//¡∂»∏ºˆ ¡ı∞°
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
	}//¡∂»∏ºˆ ¡ı∞°
}

>>>>>>> branch 'master' of https://github.com/jinsick/MovieProject.git
