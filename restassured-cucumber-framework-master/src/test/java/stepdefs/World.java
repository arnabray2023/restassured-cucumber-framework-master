package stepdefs;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.Comment;
import model.Post;
import model.User;

public class World {
	private Response response;
	private RequestSpecification request;
	private User user;
	private Comment comment;
	private Post post;

	public Comment getComment() {
		return comment;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public Response getResponse() {
		return this.response;
	}

	public void setRequest(RequestSpecification request) {
		this.request = request;
	}

	public RequestSpecification getRequest() {
		return this.request;
	}

}
