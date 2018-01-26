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

public class SimulHoldDAO {
	public DataSource dataFactory;
	private Connection conn;
	private String sql;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ArrayList<SimulHoldDTO> holdList;
	private int cnt;
	
	public SimulHoldDAO() {
		try {
			Context ctx = new InitialContext();
			holdList = new ArrayList<SimulHoldDTO>();
			dataFactory=(DataSource)ctx.lookup(ConstVal.DB_NAME);
			conn = dataFactory.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void holdinsert(SimulHoldDTO simulHoldDTO) {
		sql="insert into holdmoney(nal,placem,wage,tax) values(?,?,?,?)";
		try {		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, simulHoldDTO.getNal());
			pstmt.setInt(2, simulHoldDTO.getPlacem());
			pstmt.setInt(3, simulHoldDTO.getWage());
			pstmt.setInt(4, simulHoldDTO.getTax());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
