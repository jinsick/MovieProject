package kr.co.four;

import java.io.Serializable;

public class TableDTO implements Serializable {

	private float no;
	private String nal;
	private float ticketSales;
	private float marketSalse;
	private float totalSalse;
	private float totalDiscount;
	private float netIncome;
	private String nal1;
	private String nal2;
	private float avgDay;
	private float avgMonth;
	private float avgYear;
	private float toDayTicketSalse;
	private float toDayMarketSalse;
	private float avgPeopleSalse;

	public TableDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TableDTO(float no, String nal, float ticketSales, float marketSalse, float totalSalse, float totalDiscount,
			float netIncome, String nal1, String nal2, float avgDay, float avgMonth, float avgYear,
			float toDayTicketSalse, float toDayMarketSalse, float avgPeopleSalse) {
		super();
		this.no = no;
		this.nal = nal;
		this.ticketSales = ticketSales;
		this.marketSalse = marketSalse;
		this.totalSalse = totalSalse;
		this.totalDiscount = totalDiscount;
		this.netIncome = netIncome;
		this.nal1 = nal1;
		this.nal2 = nal2;
		this.avgDay = avgDay;
		this.avgMonth = avgMonth;
		this.avgYear = avgYear;
		this.toDayTicketSalse = toDayTicketSalse;
		this.toDayMarketSalse = toDayMarketSalse;
		this.avgPeopleSalse = avgPeopleSalse;
	}

	public float getNo() {
		return no;
	}

	public void setNo(float no) {
		this.no = no;
	}

	public String getNal() {
		return nal;
	}

	public void setNal(String nal) {
		this.nal = nal;
	}

	public float getTicketSales() {
		return ticketSales;
	}

	public void setTicketSales(float ticketSales) {
		this.ticketSales = ticketSales;
	}

	public float getMarketSalse() {
		return marketSalse;
	}

	public void setMarketSalse(float marketSalse) {
		this.marketSalse = marketSalse;
	}

	public float getTotalSalse() {
		return totalSalse;
	}

	public void setTotalSalse(float totalSalse) {
		this.totalSalse = totalSalse;
	}

	public float getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(float totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public float getNetIncome() {
		return netIncome;
	}

	public void setNetIncome(float netIncome) {
		this.netIncome = netIncome;
	}

	public String getNal1() {
		return nal1;
	}

	public void setNal1(String nal1) {
		this.nal1 = nal1;
	}

	public String getNal2() {
		return nal2;
	}

	public void setNal2(String nal2) {
		this.nal2 = nal2;
	}

	public float getAvgDay() {
		return avgDay;
	}

	public void setAvgDay(float avgDay) {
		this.avgDay = avgDay;
	}

	public float getAvgMonth() {
		return avgMonth;
	}

	public void setAvgMonth(float avgMonth) {
		this.avgMonth = avgMonth;
	}

	public float getAvgYear() {
		return avgYear;
	}

	public void setAvgYear(float avgYear) {
		this.avgYear = avgYear;
	}

	public float getToDayTicketSalse() {
		return toDayTicketSalse;
	}

	public void setToDayTicketSalse(float toDayTicketSalse) {
		this.toDayTicketSalse = toDayTicketSalse;
	}

	public float getToDayMarketSalse() {
		return toDayMarketSalse;
	}

	public void setToDayMarketSalse(float toDayMarketSalse) {
		this.toDayMarketSalse = toDayMarketSalse;
	}

	public float getAvgPeopleSalse() {
		return avgPeopleSalse;
	}

	public void setAvgPeopleSalse(float avgPeopleSalse) {
		this.avgPeopleSalse = avgPeopleSalse;
	}

	@Override
	public String toString() {
		return "TableDTO [no=" + no + ", nal=" + nal + ", ticketSales=" + ticketSales + ", marketSalse=" + marketSalse
				+ ", totalSalse=" + totalSalse + ", totalDiscount=" + totalDiscount + ", netIncome=" + netIncome
				+ ", nal1=" + nal1 + ", nal2=" + nal2 + ", avgDay=" + avgDay + ", avgMonth=" + avgMonth + ", avgYear="
				+ avgYear + ", toDayTicketSalse=" + toDayTicketSalse + ", toDayMarketSalse=" + toDayMarketSalse
				+ ", avgPeopleSalse=" + avgPeopleSalse + "]";
	}

}
