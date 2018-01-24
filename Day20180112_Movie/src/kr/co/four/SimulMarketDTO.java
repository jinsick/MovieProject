package kr.co.four;

import java.io.Serializable;

public class SimulMarketDTO implements Serializable {
	private String nal;
	private int pop;
	private int col;
	private int oging;
	private int dog;
	private int chiken;
	private int coffee;
	private int combo1;
	private int combo2;
	private int water1;
	
	public SimulMarketDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SimulMarketDTO(String nal, int pop, int col, int oging, int dog, int chiken, int coffee, int combo1,
			int combo2, int water1) {
		super();
		this.nal = nal;
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

	public String getNal() {
		return nal;
	}

	public void setNal(String nal) {
		this.nal = nal;
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
		return "SimulMarketDTO [nal=" + nal + ", pop=" + pop + ", col=" + col + ", oging=" + oging + ", dog=" + dog
				+ ", chiken=" + chiken + ", coffee=" + coffee + ", combo1=" + combo1 + ", combo2=" + combo2
				+ ", water1=" + water1 + "]";
	}
	
}
