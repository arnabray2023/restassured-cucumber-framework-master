package endpoints;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.User;
import stepdefs.World;

public class UserEndpoint extends BaseEndpoints {
	private final String USER_ENDPOINT_PATH = "/users";
	private User defaultUser;

	public UserEndpoint() {
		super();
		defaultUser = new User();
	}

	public String getPath() {
		return this.USER_ENDPOINT_PATH;
	}

	public User getDefaultUser() {
		return this.defaultUser;
	}

	public Response getUserByUsername(RequestSpecification request) {
		return getUserByUsername(request, getDefaultUser().getUsername());
	}

	public Response getUserByUsername(RequestSpecification request, String username) {
		String url = getBaseUrl() + this.getPath() + username;
		return sendRequest(request, BaseEndpoints.GET_REQUEST, url, null);
	}

	public void createUser(World world) {
		world.setRequest(getRequestWithJSONHeaders());
		world.setResponse(createUser(world.getRequest()));
	}

	public Response createUser(RequestSpecification request) {
		return createUser(request, defaultUser);
	}

	public Response createUser(RequestSpecification request, User user) {
		String url = getBaseUrl() + this.getPath();
		return sendRequest(request, BaseEndpoints.GET_REQUEST, url, user);
	}

	public void verifyUserValuesAreAsExpected(Response response, User user) {
		String expectedId = user.getId().toString();
		String expectedName = user.getName().toString();
		String expectedUserName = user.getUsername().toString();
		String expecteddEmail = user.getEmail().toString();
		String expectedCity = user.getAddress().getCity().toString();
		String expectedZipCode = user.getAddress().getZipcode().toString();
		String expectedComapanyName = user.getCompany().getName().toString();
		String expectedAddressGeoLong = user.getAddress().getGeo().getLng().toString();
		verifyResponseKeyValues("id", expectedId, response);
		verifyResponseKeyValues("name", expectedName, response);
		verifyResponseKeyValues("username", expectedUserName, response);
		verifyResponseKeyValues("email", expecteddEmail, response);
		verifyNestedResponseKeyValues("address", "city", expectedCity, response);
		verifyNestedResponseKeyValues("address", "zipcode", expectedZipCode, response);
		verifyNestedResponseKeyValues("company", "name", expectedComapanyName, response);
		verifyNested2ResponseKeyValues("address", "geo", "lng", expectedAddressGeoLong, response);

	}

}
