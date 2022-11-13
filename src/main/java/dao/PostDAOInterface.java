package dao;

import java.util.List;

import entity.Post;

public interface PostDAOInterface {

	public Post getPost();

	public void setPost(Post post);

	public List<Post> findallposts();

}
