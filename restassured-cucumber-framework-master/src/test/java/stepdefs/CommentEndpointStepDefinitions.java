package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import endpoints.CommentEndpoint;
import model.Comment;

public class CommentEndpointStepDefinitions {

	private World world;
	private CommentEndpoint commentEndpoint = new CommentEndpoint();

	public CommentEndpointStepDefinitions(World world) {
		this.world = world;
	}

	@When("(?i)^user search for a Comment with an id value of '(.*?)'$")
	public void searchCommentwithID(String id) {
		world.setResponse(commentEndpoint.getCommentById(world.getRequest(), id));
	}

	@When("(?i)^user add a comment on a post using Post ID of '(\\d+)'$")
	public void addCommentonPostusingPostID(Integer postId) {
		world.setRequest(commentEndpoint.getRequestWithJSONHeaders());
		world.setResponse(commentEndpoint.addComment(world.getRequest(),
				new Comment(1, postId, "TestName", "test@email.com", "testbody")));
	}

	@Then("(?i)^the comment on post request response has a '(\\d+)' response code$")
	public void validationOfResponseCode(Integer rc) {
		commentEndpoint.verifyResponseStatusValue(world.getResponse(), rc.intValue());
	}

	@Then("(?i)^the comment on post requests response contains the correct json data$")
	public void validationOfJSONResponse() {
		commentEndpoint.verifyResponseKeyValues("postId", "58", world.getResponse());
	}

	@Given("(?i)^Some comment exists for a Post$")
	public void existingCommentforPost() {
		world.setRequest(commentEndpoint.getRequestWithJSONHeaders());
		world.setResponse(commentEndpoint.addComment(world.getRequest()));
		commentEndpoint.verifyResponseStatusValue(world.getResponse(), CommentEndpoint.SUCCESS_CREATED_CODE);
	}

	@When("(?i)^user search for the Comment by its id$")
	public void searchCommentusingID() {
		world.setResponse(commentEndpoint.getCommentById(world.getRequest(),
				commentEndpoint.getDefaultComment().getId().toString()));
	}

	@Then("(?i)^the complete Comment is returned$")
	public void retrunComment() {
		commentEndpoint.verifyCommentValuesAreAsExpected(world.getResponse(), commentEndpoint.getDefaultComment());
	}

}
