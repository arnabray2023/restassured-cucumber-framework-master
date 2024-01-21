package model;

public class Comment {
	private Integer id;
	private Integer postID;
	private String name;
	private String email;
	private String body;
	

	public Comment(Integer id, Integer postID, String name, String email, String body) {
		this.id = id;
		this.postID = postID;
		this.name = name;
		this.email = email;
		this.body = body;
	}
	
	public Comment(){
		setId(11);
		setPostID(1);
		setName("Test Name");
		setEmail("test@email.com");
		setBody("Comment Body");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPostID() {
		return postID;
	}

	public void setPostID(Integer postID) {
		this.postID = postID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
