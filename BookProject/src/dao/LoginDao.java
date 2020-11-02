package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JdbcUtil;
import vo.MemberVO;

public class LoginDao {
//DB CRUD
	public boolean getLoginUser(String userId, String userPwd) {
//userId, userPwd 에 해당하는 DB 레코드 검색해서 결과를 리턴함
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where userid = ? and userpwd = ?";

		MemberVO vo = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo = new MemberVO();
				vo.setUserId(rs.getString("userid"));
				vo.setUserPwd(rs.getString("userpwd"));
			}

		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);

		}

		return vo != null ? true : false;
	}
}