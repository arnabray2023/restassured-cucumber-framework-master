package model;

public class User {

	private Integer id;
	private String name;
	private String username;
	private String email;
	private Address address;
	private String phone;
	private String website;
	private Company company;
	
	public User(){
		setId(1);
		setName("Test Name");
		setUsername("Bret");
		setEmail("TestEmail@email.com");
		setAddress(new Address("Test Street", "Test Suite", "Test City", "Test Zip", new Geo("-43.9509", "-34.4618")));
		setPhone("1234567890");
		setWebsite("www.test.com");
		setCompany(new Company("TestName", "TestcatchPhrase", "Testbs"));
	}

	public User(Integer id, String name, String username, String email, Address address, String phone, String website,
			Company company) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.website = website;
		this.company = company;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return this.username;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return this.phone;
	}

}
