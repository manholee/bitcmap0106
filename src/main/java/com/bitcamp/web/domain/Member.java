package com.bitcamp.web.domain;

public class Member {
	private String id,pw,name,email,reg_date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPass(String paw) {
		this.pw = paw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pass=" + pw + ", name=" + name + ", email=" + email + ", reg_date=" + reg_date
				+ "]";
	}
	
	
}
