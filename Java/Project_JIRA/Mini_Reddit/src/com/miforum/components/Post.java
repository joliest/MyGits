package com.miforum.components;

import java.util.Date;

public class Post implements Component{
	
	private int id;
	private String title;
	private String body;
	private String account;
	private Date date;
	
	public Post(String title, String body, String account) {
		this.title = title;
		this.body = body;
		this.account = account;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Override
	public String getUniqueId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
