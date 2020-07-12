package com.miforum.viewresolver;

import java.io.StringWriter;

import com.miforum.components.Post;

public class PostView {
	
	private Post post;
	
	public PostView(Post post) {
		this.post = post;
	}
	
	/*
	 	<tr> <td colspan=\"2\"> TITLE <br />
	 							by: user
	 		</td>
	 	</tr>
	 	
	 	<tr>
	 	 	<td colspan=\"2\"> MY MESSAGE </td> 
	 	</tr>
	 	 	
	 	<tr>
	 		<td>upVotes</td>
	 		<td>downVotes</td>
	 	</tr>
	 	
	 */

	@Override
	public String toString() {
		StringWriter sw = new StringWriter();
		
		String upVotes = Integer.toString(post.getUpVotes());
		String downVotes = Integer.toString(post.getDownVotes());
		
		sw.append("<tr> <td colspan=\"2\">");
		sw.append(post.getTitle());
		sw.append("<br />");
		sw.append("by: " + post.getAccount());
		sw.append("</td> </tr>");
		
		sw.append("<tr> <td colspan=\"2\">");
		sw.append(post.getBody());
		sw.append("</td> </tr>");
		
		sw.append("<tr>");
		sw.append("<td>" + upVotes + "</td>");
		sw.append("<td>" + downVotes + "</td>");
		sw.append("</tr>");
		
		return (sw.toString() + "\n");
	}
	
	
}
