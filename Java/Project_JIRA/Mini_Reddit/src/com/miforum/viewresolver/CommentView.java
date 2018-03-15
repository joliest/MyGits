package com.miforum.viewresolver;

import java.io.StringWriter;

import com.miforum.components.Account;
import com.miforum.components.Comment;

public class CommentView {
	
	private Comment comment;
	private String commentOwner;
	
	public CommentView(Comment comment) {
		this.comment = comment;
		Account account = comment.getAccount();
		commentOwner = account.getUsername();
	}
	
	/*
	    <tr>
			<td rowspan="3">
				&#11165; <br>
				&#11167;
			</td>
			<td>User</td>
		</tr>
		<tr>
			<td>Comment</td>
		</tr>
		<tr>
			<td>0 upvotes | 0 downvotes</td>
		</tr>
	 */
	@Override
	public String toString() {
		StringWriter sw = new StringWriter();
		
		sw.append("<tr> <td rowspan=\"3\">");
		sw.append("&#11165; <br> &#11167;");
		sw.append("</td>");
		sw.append("<td>");
		sw.append(commentOwner);
		sw.append("</td></tr>");
		sw.append("<tr><td>");
		sw.append(comment.getComment());
		sw.append("</td></tr>");
		sw.append("<tr><td>");
		sw.append(comment.getUpVotes() + " upvotes | ");
		sw.append(comment.getDownVotes() + " downvotes ");
		sw.append("</td></tr>");

		
		return (sw.toString() + "\n");
	}
	
	
}