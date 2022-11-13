package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
//one user many follow

@SuppressWarnings("serial")
@Entity
@Component
@Table(name = "follow")
public class Follow implements Serializable {
	@Id
	@Column(name = "following_user_id")
	private int followinguserId;

	@JoinColumn(name = "user_id")
	@ManyToOne
	private User user;

	public Follow(int followinguserId, User user) {
		super();
		this.followinguserId = followinguserId;
		this.user = user;
	}

	public Follow() {
		super();
	}

	public int getFollowinguserId() {
		return followinguserId;
	}

	public void setFollowinguserId(int followinguserId) {
		this.followinguserId = followinguserId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "[followinguserId=" + followinguserId;
	}
	
	 

}
