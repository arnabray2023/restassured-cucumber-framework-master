package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import endpoints.UserEndpoint;

public class UserEndpointStepDefinitions {

	private World world;
	private UserEndpoint userEndpoint = new UserEndpoint();

	public UserEndpointStepDefinitions(World world) {
		this.world = world;
	}

	@Given("(?i)^a valid user exists$")
	public void a_valid_user_exists() {
		world.setRequest(userEndpoint.getRequestWithJSONHeaders());
		world.setResponse(userEndpoint.createUser(world.getRequest()));
		userEndpoint.verifyResponseStatusValue(world.getResponse(), UserEndpoint.SUCCESS_STATUS_CODE);
	}

	@When("(?i)^I search for the user by their username$")
	public void i_search_for_the_user_by_their_username() {
		world.setResponse(userEndpoint.getUserByUsername(world.getRequest()));
	}

	@Then("(?i)^the user is located$")
	public void the_user_is_located() {
	}

	@When("(?i)^I add a new user to the system$")
	public void userAddedtoSystem() {
		userEndpoint.createUser(world);
	}

	@Then("^the user request response has a '(\\d+)' response code$")
	public void userCreateResponseValidation(Integer rc) {
		userEndpoint.verifyResponseStatusValue(world.getResponse(), rc.intValue());
	}

	@Then("^the user requests response contains the correct json data$")
	public void userResponseJsonDataValidation() {
		userEndpoint.verifyUserValuesAreAsExpected(world.getResponse(), userEndpoint.getDefaultUser());
	}

}
