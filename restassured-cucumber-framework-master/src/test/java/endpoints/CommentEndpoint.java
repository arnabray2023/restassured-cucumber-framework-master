package endpoints;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.Comment;
import stepdefs.World;

public class CommentEndpoint extends BaseEndpoints {
	private final String COMMENT_ENDPOINT_PATH = "/comments";
	private Comment defaultComment;

	public CommentEndpoint() {
		super();
		defaultComment = new Comment();
	}

	public String getPath() {
		return this.COMMENT_ENDPOINT_PATH;
	}

	public Comment getDefaultComment() {
		return this.defaultComment;
	}

	public Response addCommentWithBody(RequestSpecification request, String body) {
		String url = getBaseUrl() + this.getPath();
		request.body(body);
		return sendRequest(request, BaseEndpoints.POST_REQUEST, url, null);
	}

	public void addComment(World world) {
		world.setRequest(getRequestWithJSONHeaders());
		world.setResponse(addComment(world.getRequest()));
	}

	public void addComment(World world, Comment comment) {
		world.setComment(comment);
		world.setRequest(getRequestWithJSONHeaders());
		world.setResponse(addComment(world.getRequest(), comment));
	}

	public Response addComment(RequestSpecification request) {
		return addComment(request, getDefaultComment());
	}

	public Response addComment(RequestSpecification request, Comment comment) {
		String url = getBaseUrl() + this.getPath();
		return sendRequest(request, BaseEndpoints.POST_REQUEST, url, comment);
	}

	public Response deleteComment(RequestSpecification request) {
		return deleteComment(request, getDefaultComment());
	}

	public Response deleteComment(RequestSpecification request, Comment comment) {

		String id = comment.getId().toString();
		String url = getBaseUrl() + this.getPath() + id;
		return sendRequest(request, BaseEndpoints.DELETE_REQUEST, url, null);
	}

	public Response getCommentById(RequestSpecification request) {
		return getCommentById(request, getDefaultComment().getId().toString());
	}

	public Response getCommentById(RequestSpecification request, String id) {
		String url = getBaseUrl() + this.getPath() + id;
		return sendRequest(request, BaseEndpoints.GET_REQUEST, url, null);
	}

	public void verifyCommentValuesAreAsExpected(Response response, Comment comment) {
	}

	public void verifyCommentHasPostId(Response response) {
		String idVal = response.jsonPath().getString("id");
		verifyTrue(idVal != null);
		verifyTrue(!idVal.equalsIgnoreCase(""));
		verifyTrue(Long.parseLong(idVal) > 0);
	}

}
