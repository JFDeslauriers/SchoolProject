package entity;
//test
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "users")
public class User implements UserInterface {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	 @NotNull
	@Column(name = "user_fn")
	private String firstName;
	 @NotNull
	@Column(name = "user_ln")
	private String lastName;
	 @Email
	 @NotNull
	@Column(name = "user_email")
	private String email;
	 @NotNull
	@Column(name = "user_password")
	private String password;
	
	private int followinguserId;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Follow> followList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Post> postList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Comment> commentList;

	public User(int userId, String firstName, String lastName, String email, String password, Follow follow,
			List<Follow> followList, List<Post> postList, List<Comment> commentList) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.followList = followList;
		this.postList = postList;
		this.commentList = commentList;
	}

	public User(String firstName, String lastName, String email, String password) {
		super();

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;

	}

	public User(String email, String password) {
		super();

		this.email = email;
		this.password = password;

	}

	public User() {
		super();

	}

	public User(User user) {
		// TODO Auto-generated constructor stub
	}
	
	public boolean follow() {
		
		
		return true;
		
	}
	
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Follow> getFollowList() {
		return followList;
	}

	public void setFollowList(List<Follow> followList) {
		this.followList = followList;
	}

	public List<Post> getPostList() {
		return postList;
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	
	

	public int getFollowinguserId() {
		return followinguserId;
	}

	public void setFollowinguserId(int followinguserId) {
		this.followinguserId = followinguserId;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
