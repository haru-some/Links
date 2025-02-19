package kr.co.iei.comment.model.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CommentRowMapper implements RowMapper<Comment>{

	@Override
	public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
		Comment c = new Comment();
		c.setCommentNo(rs.getInt("comment_no"));
		c.setMemberId(rs.getString("member_id"));
		c.setContentNo(rs.getString("content_no"));
		c.setCommentContent(rs.getString("comment_content"));
		c.setReadCount(rs.getInt("read_count"));
		c.setRegDate(rs.getString("reg_date"));
<<<<<<< HEAD
		//c.setContentTitle(rs.getString("Content_title"));
//		c.setLikeCount(rs.getInt("like_count"));
//		c.setIsLike(rs.getInt("is_like"));
=======
		
>>>>>>> parent of f8e864b (2.18)
		return c;
	}
	
}
