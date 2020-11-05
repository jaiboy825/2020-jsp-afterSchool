package dao;

import java.sql.*;

import common.JdbcUtil;
import vo.MemberVO;

public class MemberDao {
	public MemberVO searchMember(String id) {
		MemberVO member = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement("select * from member2 where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setMail(rs.getString("mail"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return member;
	}

	public int insertMember(MemberVO member) {
		int n = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement("insert into member2 values(?,?,?,?)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getMail());
			n = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}

	public int updateMember(MemberVO member) {
		int n = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement("UPDATE member2 SET passwd = ?, name = ?, mail = ? WHERE id = ?");
			pstmt.setString(1, member.getPasswd());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getMail());
			pstmt.setString(4, member.getId());
			n = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}
}
