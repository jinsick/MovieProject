package kr.co.daegu.ticketing;

public class TicketingDTO {
	private int nal;
	private String kind;
	private int seatnumber;
	private int price;
	private String username;
	private int no;
	private int pop;
	private int col;
	private int oging;
	private int dog;
	private int chiken;
	private int coffee;
	private int combo1;
	private int combo2;
	private int water1;
	public TicketingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TicketingDTO(int nal, String kind, int seatnumber, int price, String username, int no, int pop, int col,
			int oging, int dog, int chiken, int coffee, int combo1, int combo2, int water1) {
		super();
		this.nal = nal;
		this.kind = kind;
		this.seatnumber = seatnumber;
		this.price = price;
		this.username = username;
		this.no = no;
		this.pop = pop;
		this.col = col;
		this.oging = oging;
		this.dog = dog;
		this.chiken = chiken;
		this.coffee = coffee;
		this.combo1 = combo1;
		this.combo2 = combo2;
		this.water1 = water1;
	}
	public int getNal() {
		return nal;
	}
	public void setNal(int nal) {
		this.nal = nal;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getSeatnumber() {
		return seatnumber;
	}
	public void setSeatnumber(int seatnumber) {
		this.seatnumber = seatnumber;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getPop() {
		return pop;
	}
	public void setPop(int pop) {
		this.pop = pop;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getOging() {
		return oging;
	}
	public void setOging(int oging) {
		this.oging = oging;
	}
	public int getDog() {
		return dog;
	}
	public void setDog(int dog) {
		this.dog = dog;
	}
	public int getChiken() {
		return chiken;
	}
	public void setChiken(int chiken) {
		this.chiken = chiken;
	}
	public int getCoffee() {
		return coffee;
	}
	public void setCoffee(int coffee) {
		this.coffee = coffee;
	}
	public int getCombo1() {
		return combo1;
	}
	public void setCombo1(int combo1) {
		this.combo1 = combo1;
	}
	public int getCombo2() {
		return combo2;
	}
	public void setCombo2(int combo2) {
		this.combo2 = combo2;
	}
	public int getWater1() {
		return water1;
	}
	public void setWater1(int water1) {
		this.water1 = water1;
	}
	@Override
	public String toString() {
		return "TicketingDTO [nal=" + nal + ", kind=" + kind + ", seatnumber=" + seatnumber + ", price=" + price
				+ ", username=" + username + ", no=" + no + ", pop=" + pop + ", col=" + col + ", oging=" + oging
				+ ", dog=" + dog + ", chiken=" + chiken + ", coffee=" + coffee + ", combo1=" + combo1 + ", combo2="
				+ combo2 + ", water1=" + water1 + "]";
	}
	
	

}
