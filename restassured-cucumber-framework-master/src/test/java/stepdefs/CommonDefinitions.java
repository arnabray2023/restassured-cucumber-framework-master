package stepdefs;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.core.IsNull;
import org.hamcrest.CoreMatchers.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import endpoints.BaseEndpoints;

public class CommonDefinitions {

	private World world;
	private BaseEndpoints be = new BaseEndpoints();

	public CommonDefinitions(World world) {
		this.world = world;
	}

	@Given("^the Social Network API is available$")
	public void the_social_network_api_is_available() {
		String url = be.getBaseUrl();
		be.sendRequest(null, BaseEndpoints.GET_REQUEST, url, null).then().statusCode(200);
	}

	@Then("^the requests response will contain the value '(.*?)' for the '(.*?)' field$")
	public void checkResponse(String val, String key) {
		be.verifyResponseKeyValues(key, val, world.getResponse());
	}

}
