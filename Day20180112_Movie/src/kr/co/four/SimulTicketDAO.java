package kr.co.four;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.ac.daegu.ConstVal;



public class SimulTicketDAO {
	public DataSource dataFactory;
	private Connection conn;
	private String sql;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ArrayList<SimulTicketDTO> ticketList;
	private int cnt;
	
	public SimulTicketDAO() {
		try {
			Context ctx = new InitialContext();
			ticketList = new ArrayList<SimulTicketDTO>();
			dataFactory=(DataSource)ctx.lookup(ConstVal.DB_NAME);
			conn = dataFactory.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ticketInsert(SimulTicketDTO simulTicketDTO) {
		sql="insert into ticket(nal,original,morning,night,coupon,wend,ticketsu) values(?,?,?,?,?,?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, simulTicketDTO.getNal());
			pstmt.setInt(2, simulTicketDTO.getOriginal());
			pstmt.setInt(3, simulTicketDTO.getMorning());
			pstmt.setInt(4, simulTicketDTO.getNight());
			pstmt.setInt(5, simulTicketDTO.getCoupon());
			pstmt.setInt(6, simulTicketDTO.getWend());
			pstmt.setInt(7, simulTicketDTO.getTicketsu());
			cnt=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
