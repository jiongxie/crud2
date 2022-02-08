package com.spring.pfb.vo;

public class BoardVo {

	private int idx;
	private String title;
	private String name;
	private String content;
	private String pwd;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@Override
	public String toString() {
		return "BoardVo [idx=" + idx + ", title=" + title + ", name=" + name + ", content=" + content + ", pwd=" + pwd
				+ "]";
	}
	
	
	
	
}
