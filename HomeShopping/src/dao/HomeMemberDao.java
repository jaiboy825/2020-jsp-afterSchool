package dao;

import java.sql.*;

import common.JdbcUtil;

public class HomeMemberDao {
	public int nextNum() {
		int n = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement("select max(custno) num from member_tbl_02");
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				n = rs.getInt("num");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n + 1;
	}
}
