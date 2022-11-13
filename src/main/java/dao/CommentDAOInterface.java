package dao;

import java.util.List;

import entity.Comment;

public interface CommentDAOInterface {
	
	public List<Comment> findallPostsById(int post_id);

}
