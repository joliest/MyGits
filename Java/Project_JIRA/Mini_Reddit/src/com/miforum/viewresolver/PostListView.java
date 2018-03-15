package com.miforum.viewresolver;

import java.io.StringWriter;

import com.miforum.components.Post;

public class PostListView {
	
	private Post post;
	
	public PostListView(Post post) {
		this.post = post;
	}
	
	/*
	 Format:
	 	<tr>
			<td rowspan="2">
				&#11165; <br />
				&#11167;
			</td>
			<td id="post_row" postId="12345">Title</td>
		</tr>
		<tr>
			<td>&#11165; : upVotes &#11167; : downVotes</td>
		</tr>
	 */

	@Override
	public String toString() {
		StringWriter sw = new StringWriter();
		
		String upVotes = Integer.toString(post.getUpVotes());
		String downVotes = Integer.toString(post.getDownVotes());
		
		sw.append("<tr> <td rowspan=\"2\">");
		sw.append("&#11165; <br /> &#11167;");
		sw.append("</td>");
		sw.append("<td>");
		sw.append("<a href=\"/Mini_Reddit/comments?postId=" +  post.getId() + " \">");
		sw.append(post.getTitle());
		sw.append("</a>");
		sw.append("</td> </tr>");
		sw.append("<tr> <td>");
		sw.append("&#11165; : " + post.getUpVotes() + " ");
		sw.append(" &#11167; : " + post.getDownVotes());
		sw.append("</td></tr>");
		
		//System.out.println(sw.toString());
		
		return (sw.toString() + "\n");
	}	
	
}
