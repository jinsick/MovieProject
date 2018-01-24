package kr.co.daegu.analysis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.daegu.analysis.*;;

public class AnalysisDAO {
	public DataSource dataFactory;
	private Connection conn;
	private String sql;
	private PreparedStatement pstmt;
	private int cnt;
	private ResultSet rs;
	private boolean result=false;
	private ArrayList<AnalysisDTO> analysisList;
	
	public AnalysisDAO() {//贸府苞沥
		try {
			Context ctx = new InitialContext();
			analysisList = new ArrayList<AnalysisDTO>();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn=dataFactory.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//贸府苞沥
	
	public void analysisDayAver(AnalysisDTO analysisDTO) {
		sql="select avg(original*toriginal + ) from ticketcount where nal between ? and ?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, analysisDTO.getNal1());
			pstmt.setString(2, analysisDTO.getNal2());
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
