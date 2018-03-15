package com.miforum.components;

public class Comment implements Component{
	
	private Post post;
	private Account account;
	
	private String comment;
	private String date;
	
	private int id;
	private int downVotes;
	private int upVotes;
	
	public Comment(Post post, Account account, String comment) {
		this.post = post;
		this.account = account;
		this.comment = comment;
	}
	
	public Comment(Post post, Account account) {
		this.post = post;
		this.account = account;
	}
	
	@Override
	public String getId() {
		String id = Integer.toString(this.id);
		return id;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
}
