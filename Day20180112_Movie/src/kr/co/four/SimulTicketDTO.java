package kr.co.four;

import java.io.Serializable;

public class SimulTicketDTO implements Serializable{
	private String nal;
	private int original;
	private int morning;
	private int night;
	private int coupon;
	private int wend;
	private int ticketsu;
	private float totalSalse;
	public SimulTicketDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SimulTicketDTO(String nal, int original, int morning, int night, int coupon, int wend, int ticketsu) {
		super();
		this.nal = nal;
		this.original = original;
		this.morning = morning;
		this.night = night;
		this.coupon = coupon;
		this.wend = wend;
		this.ticketsu = ticketsu;
	}

	

	public String getNal() {
		return nal;
	}

	public void setNal(String nal) {
		this.nal = nal;
	}

	public int getOriginal() {
		return original;
	}

	public void setOriginal(int original) {
		this.original = original;
	}

	public int getMorning() {
		return morning;
	}

	public void setMorning(int morning) {
		this.morning = morning;
	}

	public int getNight() {
		return night;
	}

	public void setNight(int night) {
		this.night = night;
	}

	public int getCoupon() {
		return coupon;
	}

	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}

	public int getWend() {
		return wend;
	}

	public void setWend(int wend) {
		this.wend = wend;
	}

	public int getTicketsu() {
		return ticketsu;
	}

	public void setTicketsu(int ticketsu) {
		this.ticketsu = ticketsu;
	}

	@Override
	public String toString() {
		return "SimulTicketDTO [nal=" + nal + ", original=" + original + ", morning=" + morning + ", night=" + night
				+ ", coupon=" + coupon + ", wend=" + wend + ", ticketsu=" + ticketsu + "]";
	}
	
	
}
