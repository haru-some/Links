package kr.co.iei.admin.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class BusinessRowMapper implements RowMapper<Inquiry> {

	@Override
	public Inquiry mapRow(ResultSet rs, int rowNum) throws SQLException {
		Inquiry i = new Inquiry();
		i.setInquiryNo(rs.getInt("inquiry_no"));
		i.setCompanyName(rs.getString("company_name"));
		i.setMemberPhone(rs.getString("member_phone"));
		i.setInquiryDate(rs.getString("inquiry_date"));
		i.setInquiryProgress(rs.getInt("inquiry_progress"));
		return i;
	}

}
