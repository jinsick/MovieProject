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

public class SimulMarketDAO {
	public DataSource dataFactory;
	private Connection conn;
	private String sql;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ArrayList<SimulMarketDTO> marketList;
	private int cnt;
	
	public SimulMarketDAO() {
		try {
			Context ctx = new InitialContext();
			marketList = new ArrayList<SimulMarketDTO>();
			dataFactory=(DataSource)ctx.lookup(ConstVal.DB_NAME);
			conn = dataFactory.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void marketinsert(SimulMarketDTO simulMarketDTO) {
		sql = "insert into market(nal,pop,col,oging,dog,chiken,coffee,combo1,combo2,water1) values(?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, simulMarketDTO.getNal());
			pstmt.setInt(2,simulMarketDTO.getPop());
			pstmt.setInt(3, simulMarketDTO.getCol());
			pstmt.setInt(4, simulMarketDTO.getOging());
			pstmt.setInt(5, simulMarketDTO.getDog());
			pstmt.setInt(6, simulMarketDTO.getChiken());
			pstmt.setInt(7, simulMarketDTO.getCoffee());
			pstmt.setInt(8, simulMarketDTO.getCombo1());
			pstmt.setInt(9, simulMarketDTO.getCombo2());
			pstmt.setInt(10, simulMarketDTO.getWater1());
			cnt=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
