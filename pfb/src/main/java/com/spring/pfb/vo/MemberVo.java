package com.spring.pfb.vo;

public class MemberVo {
	
	private int idx;
	private String mid;
	private String pwd;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "MemberVo [idx=" + idx + ", mid=" + mid + ", pwd=" + pwd + "]";
	}
	
	
}
