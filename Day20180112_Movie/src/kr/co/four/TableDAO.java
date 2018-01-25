package kr.co.four;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.sun.org.apache.xml.internal.serializer.ToHTMLSAXHandler;

public class TableDAO {

	public DataSource dataFactory;
	private Connection conn;
	private String sql;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ArrayList<TableDTO> tableList;
	private int cnt;
	private Statement stmt;

	public TableDAO() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = dataFactory.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int totalCount() {// 페이징처리: 전체레코드 개수 구하기
		int count = 0;
		try {
			sql = "select count(*) from ticket";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}// 페이징처리: 전체레코드 개수 구하기

	public PageTo page(int curPage, TableDTO tdto,String nal1, String nal2) {// 페이지구현
		PageTo pageTo = new PageTo();
		int totalCount = totalCount();
		ArrayList<TableDTO> list = new ArrayList<TableDTO>();
		try {
			sql = "select ticket.nal as nal,TICKET.ORIGINAL as original,TICKET.MORNING as morning,TICKET.NIGHT as night,TICKET.COUPON as coupon,TICKET.WEND as wend,TICKET.TICKETSU as ticketsu,MARKET.POP as pop,MARKET.COL as col,MARKET.OGING as oging,market.dog as dog,MARKET.CHIKEN as chiken,market.coffee as coffee,MARKET.COMBO1 as combo1,market.combo2 as combo2,MARKET.WATER1 as water1 from ticket inner join market on ticket.nal = market.nal  where ticket.nal between ? and ?  order by ticket.nal";
			pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			pstmt.setString(1, nal1);
			pstmt.setString(2, nal2);
			System.out.println("??");
			System.out.println(nal1);
			System.out.println(nal2);
			// TYPE_SCROLL_INSENSITIVE:scroll은 가능하나, 변경된 사항은 적용되지 않음
			// 양방향, 스크롤 시 업데이트 반영안함
			// CONCUR_READ_ONLY :커서의 위치에서 정보 업데이트 불가,ResultSet의 변경이 불가능
			rs = pstmt.executeQuery();
			int perPage = pageTo.getPerPage();// 15
			int skip = (curPage - 1) * perPage;
			if (skip > 0) {
				rs.absolute(skip);
			}
			// ResultSet의 absolute메소드를 이용하여 해당 페이지의 Cursor 의 위치로 이동...
			for (int i = 0; i < perPage && rs.next(); i++) {
				String nal = rs.getString("nal");
				float ticketSalse = rs.getFloat("original") + rs.getFloat("morning") + rs.getFloat("night")
						+ rs.getFloat("wend");
				float marketSalse = rs.getFloat("pop") + rs.getFloat("col") + rs.getFloat("oging") + rs.getFloat("dog")
						+ rs.getFloat("chiken") + rs.getFloat("coffee") + rs.getFloat("combo1") + rs.getFloat("combo2")
						+ rs.getFloat("water1");
				float totalSalse = ticketSalse + marketSalse;
				float totalDiscount = rs.getFloat("coupon");
				float netIncome = totalSalse + totalDiscount;

				TableDTO data = new TableDTO();
				data.setNal(nal);
				data.setTicketSales(ticketSalse);
				data.setMarketSalse(marketSalse);
				data.setTotalSalse(totalSalse);
				data.setTotalDiscount(totalDiscount);
				data.setNetIncome(netIncome);
				list.add(data);
			}
			pageTo.setBoardlist(list);// ArrayList 저장
			pageTo.setTotalCount(totalCount);// 전체레코드개수
			pageTo.setCurPage(curPage);// 현재페이지
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pageTo;
	}// 페이지구현

	public ArrayList<TableDTO> report(TableDTO tdto, float totalSalse) {
		try {
			sql = "select ticket.nal as nal,TICKET.ORIGINAL as original,TICKET.MORNING as morning,TICKET.NIGHT as night,TICKET.COUPON as coupon,TICKET.WEND as wend,TICKET.TICKETSU as ticketsu,MARKET.POP as pop,MARKET.COL as col,MARKET.OGING as oging,market.dog as dog,MARKET.CHIKEN as chiken,market.coffee as coffee,MARKET.COMBO1 as combo1,market.combo2 as combo2,MARKET.WATER1 as water1 from ticket inner join market on ticket.nal = market.nal where ticket.nal between ? and ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tdto.getNal1());
			pstmt.setString(2, tdto.getNal2());
			String nal1 = tdto.getNal1();
			String nal2 = tdto.getNal2();
			rs = pstmt.executeQuery();
			tableList = new ArrayList<TableDTO>();
			while (rs.next()) {
				tdto = new TableDTO();
				float ticketSalse = rs.getFloat("original") + rs.getFloat("morning") + rs.getFloat("night")
						+ rs.getFloat("wend");
				float marketSalse = rs.getFloat("pop") + rs.getFloat("col") + rs.getFloat("oging") + rs.getFloat("dog")
						+ rs.getFloat("chiken") + rs.getFloat("coffee") + rs.getFloat("combo1") + rs.getFloat("combo2")
						+ rs.getFloat("water1");
				totalSalse += ticketSalse + marketSalse;
				float avgPeopleSalse = totalSalse / rs.getFloat("ticketsu");
				tdto.setTotalSalse(totalSalse);
				tdto.setAvgPeopleSalse(avgPeopleSalse);
				tdto.setToDayTicketSalse(ticketSalse);
				tdto.setToDayMarketSalse(marketSalse);
				tableList.add(tdto);
			}
			System.out.println(nal1);
			System.out.println(nal2);
			System.out.println(tableList);
			sql = "SELECT (to_date(?)-to_date(?)) as dat, nal from ticket order by nal";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, nal2);
			pstmt.setString(2, nal1);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				float avgDay = tdto.getTotalSalse() / (rs.getFloat("dat"));
				float avgMonth = tdto.getTotalSalse() / ((rs.getFloat("dat") / 12));
				float avgYear = tdto.getTotalSalse() / ((rs.getFloat("dat") / 365));
				tdto.setAvgYear(avgYear);
				tdto.setAvgDay(avgDay);
				tdto.setAvgMonth(avgMonth);
				tdto.setNal(rs.getString("nal"));
				tableList.add(tdto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tableList;
	}

	public ArrayList<TableDTO> head(TableDTO tdto) {
		try {
			sql = "select ticket.nal as nal,TICKET.ORIGINAL as original,TICKET.MORNING as morning,TICKET.NIGHT as night,TICKET.COUPON as coupon,TICKET.WEND as wend,TICKET.TICKETSU as ticketsu,MARKET.POP as pop,MARKET.COL as col,MARKET.OGING as oging,market.dog as dog,MARKET.CHIKEN as chiken,market.coffee as coffee,MARKET.COMBO1 as combo1,market.combo2 as combo2,MARKET.WATER1 as water1 from ticket inner join market on ticket.nal = market.nal ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			tableList = new ArrayList<TableDTO>();
			while (rs.next()) {
				tdto = new TableDTO();
				float ticketSalse = rs.getFloat("original") + rs.getFloat("morning") + rs.getFloat("night")
						+ rs.getFloat("wend");
				float marketSalse = rs.getFloat("pop") + rs.getFloat("col") + rs.getFloat("oging") + rs.getFloat("dog")
						+ rs.getFloat("chiken") + rs.getFloat("coffee") + rs.getFloat("combo1") + rs.getFloat("combo2")
						+ rs.getFloat("water1");
				float totalSalse = ticketSalse + marketSalse;

				tdto.setMarketSalse(marketSalse);
				tdto.setTicketSales(ticketSalse);
				tdto.setTotalSalse(totalSalse);

				tableList.add(tdto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tableList;
	}

	public ArrayList<TableDTO> incomeDay(TableDTO tdto,float totalSalse) {
		try {
			sql = "select ticket.nal as nal,TICKET.ORIGINAL as original,TICKET.MORNING as morning,TICKET.NIGHT as night,TICKET.COUPON as coupon,TICKET.WEND as wend,TICKET.TICKETSU as ticketsu,MARKET.POP as pop,MARKET.COL as col,MARKET.OGING as oging,market.dog as dog,MARKET.CHIKEN as chiken,market.coffee as coffee,MARKET.COMBO1 as combo1,market.combo2 as combo2,MARKET.WATER1 as water1 from ticket inner join market on ticket.nal = market.nal where ticket.nal between ? and ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tdto.getNal());
			pstmt.setString(2, tdto.getNal());
			rs = pstmt.executeQuery();
			tableList = new ArrayList<TableDTO>();
			while (rs.next()) {
				tdto = new TableDTO();
				float ticketSalse = rs.getFloat("original") + rs.getFloat("morning") + rs.getFloat("night")
						+ rs.getFloat("wend");
				float marketSalse = rs.getFloat("pop") + rs.getFloat("col") + rs.getFloat("oging") + rs.getFloat("dog")
						+ rs.getFloat("chiken") + rs.getFloat("coffee") + rs.getFloat("combo1") + rs.getFloat("combo2")
						+ rs.getFloat("water1");
				totalSalse = ticketSalse + marketSalse;
				float avgPeopleSalse = totalSalse / rs.getFloat("ticketsu");
				tdto.setMarketSalse(marketSalse);
				tdto.setTicketSales(ticketSalse);
				tdto.setAvgPeopleSalse(avgPeopleSalse);
				tableList.add(tdto);
				System.out.println("???");
				System.out.println(tableList);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tableList;

	}

	public void ticketDelete(TableDTO tdto) {
		try {
			sql = "delete from ticket where nal= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tdto.getNal());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void marketDelete(TableDTO tdto) {
		try {
			sql = "delete from market where nal=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tdto.getNal());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
