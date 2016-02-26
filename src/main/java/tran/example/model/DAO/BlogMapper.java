package tran.example.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import tran.example.model.Blog;

public class BlogMapper implements RowMapper<Blog> {
	public Blog mapRow(ResultSet rs, int rowNum)  {
		Blog blogPost = new Blog();
		try {
			blogPost.setPostID(rs.getInt("blog_ID"));
			blogPost.setTitle(rs.getString("blog_title"));
			blogPost.setContent(rs.getString("blog_Content").replaceAll("''", "'"));
			blogPost.setAuthor(rs.getString("blog_author"));
			blogPost.setDateCreated(rs.getTimestamp("blog_dateCreated").toString());
			blogPost.setDateModified(rs.getTimestamp("blog_dateModified").toString());
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return blogPost;
	}
}