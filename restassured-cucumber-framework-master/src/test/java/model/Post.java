package model;

public class Post {
	
	private Integer id;
	private Integer userID;
	private String title;
	private String body;
	
	public Post(Integer id, Integer userID, String title, String body) {
		this.id = id;
		this.userID = userID;
		this.title = title;
		this.body = body;
	}
	
	public Post(){
		setId(101);
		setUserID(1);
		setTitle("Test Title");
		setBody("Post Body");
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	

}
