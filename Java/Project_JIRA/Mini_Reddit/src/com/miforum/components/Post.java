package com.miforum.components;

import java.util.Date;

public class Post implements Component{
	
	private int id;
	private String title;
	private String body;
	private String account;
	private String date;
	private int downVotes;
	private int upVotes;	

	public Post(String title, String body, String account) {
		this.title = title;
		this.body = body;
		this.account = account;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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
	
	public int getDownVotes() {
		return downVotes;
	}

	public void setDownVotes(int downVotes) {
		this.downVotes = downVotes;
	}

	public int getUpVotes() {
		return upVotes;
	}

	public void setUpVotes(int upVotes) {
		this.upVotes = upVotes;
	}

	@Override
	public String getId() {
		String thisId = Integer.toString(this.id);
		return thisId;
	}
	
	
}
