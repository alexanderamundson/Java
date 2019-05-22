package sprint1;

import java.io.Serializable;

public class Comment implements Serializable{
	private String text;
	private Member commentor;
	private Post post;

	public Comment(String text, Member commentor, Post post) {
		this.text = text;
		this.commentor = commentor;
		this.post = post;
	}

	public String getText() {
		return text;
	}

	public void editText(String text) {
		this.text = text;
	}

	public Member getCommentor() {
		return commentor;
	}

	public Post getPost() {
		return post;
	}
}