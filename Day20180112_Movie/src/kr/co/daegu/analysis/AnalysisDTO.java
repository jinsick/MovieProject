package kr.co.daegu.analysis;

import java.io.Serializable;

public class AnalysisDTO implements Serializable{
	private String nal1;
	private String nal2;
	
	public AnalysisDTO(String nal1, String nal2) {
		super();
		this.nal1 = nal1;
		this.nal2 = nal2;
	}

	public AnalysisDTO() {
		super();
		// TODO Auto-generated constructor stub
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
	
	@Override
	public String toString() {
		return "analysisDTO [nal1=" + nal1 + ", nal2=" + nal2 + "]";
	}
}
