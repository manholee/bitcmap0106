package com.bitcamp.web.domain;

import org.springframework.stereotype.Component;

//빈 객체는 Component
@Component
public class Board {

	private String seq, title, content, reg_date, id;

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Boar [seq=" + seq + ", title=" + title + ", content=" + content + ", reg_date=" + reg_date + ", id="
				+ id + "]";
	}

}
