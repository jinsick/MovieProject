package kr.co.four;

import java.io.Serializable;

public class SimulHoldDTO implements Serializable {
	private String nal;
	private int placem;
	private int wage;
	private int tax;
	
	public SimulHoldDTO(String nal, int placem, int wage, int tax) {
		super();
		this.nal = nal;
		this.placem = placem;
		this.wage = wage;
		this.tax = tax;
	}


	public SimulHoldDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getNal() {
		return nal;
	}


	public void setNal(String nal) {
		this.nal = nal;
	}


	public int getPlacem() {
		return placem;
	}


	public void setPlacem(int placem) {
		this.placem = placem;
	}


	public int getWage() {
		return wage;
	}


	public void setWage(int wage) {
		this.wage = wage;
	}


	public int getTax() {
		return tax;
	}


	public void setTax(int tax) {
		this.tax = tax;
	}


	
	@Override
	public String toString() {
		return "SimulHoldDTO [nal=" + nal + ", placem=" + placem + ", wage=" + wage + ", tax=" + tax + "]";
	}
}
