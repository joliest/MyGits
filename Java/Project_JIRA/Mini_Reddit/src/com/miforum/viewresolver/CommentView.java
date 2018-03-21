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
				<span id="comment_up_arrow" commentId="123">"
					&#11165; 
				</span>
				<br>
				<span id="comment_down_arrow" commentId="123">"
					&#11167;
				</span>
			</td>
			<td>User</td>
		</tr>
		<tr>
			<td>Comment</td>
		</tr>
		<tr>
			<td>
				<span id="comment_upVote_label" commentId="12">
					upVotes 
				</span>
			upvotes | 
				<span id="comment_downVote_label" commentId="12">
					downVotes 
				</span>
			downvotes</td>
		</tr>
	 */
	@Override
	public String toString() {
		StringWriter sw = new StringWriter();
		
		String commentBody = comment.getComment();
		String upVotes = Integer.toString(comment.getUpVotes());
		String downVotes = Integer.toString(comment.getDownVotes());
		
		sw.append("<tr> <td rowspan=\"3\">");
		sw.append("<span id=\"comment_up_arrow\" commentId=\"" + comment.getId() + "\">");
		sw.append("&#11165;");
		sw.append("</span>");
		sw.append("<br>");
		sw.append("<span id=\"comment_down_arrow\" commentId=\"" + comment.getId() + "\">");
		sw.append("&#11167;");
		sw.append("</span>");
		
		
		//sw.append("&#11165; <br> &#11167;");
		sw.append("</td>");
		sw.append("<td>");
		sw.append(commentOwner);
		sw.append("</td></tr>");
		sw.append("<tr><td>");
		sw.append(commentBody);
		sw.append("</td></tr>");
		sw.append("<tr><td>");
		sw.append("<span id=\"comment_upVote_label\" commentId=\"" + comment.getId() + "\">");
		sw.append(upVotes);
		sw.append("</span>");
		sw.append(" upvotes | ");
		sw.append("<span id=\"comment_downVote_label\" commentId=\"" + comment.getId() + "\">");
		sw.append(downVotes);
		sw.append("</span>");
		sw.append( " downvotes ");
		sw.append("</td></tr>");

		
		return (sw.toString() + "\n");
	}
	
	
}