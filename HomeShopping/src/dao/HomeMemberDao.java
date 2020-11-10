package dao;

import java.sql.*;
import java.util.ArrayList;

import common.JdbcUtil;
import vo.MemberMoneyVO;
import vo.MemberVO;

public class HomeMemberDao {
	public int nextNum() {
		int n = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement("select max(custno) num from member_tbl_02");
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				n = rs.getInt("num");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n + 1;
	}

	public int insertMember(MemberVO member) {
		int n = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement("insert into member_tbl_02 values(?,?,?,?,?,?,?)");
			pstmt.setInt(1, member.getCustno());
			pstmt.setString(2, member.getCustname());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getAddress());
			pstmt.setDate(5, member.getJoindate());
			pstmt.setString(6, member.getGrade());
			pstmt.setString(7, member.getCity());
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}

	public ArrayList<MemberVO> getList() {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();

		Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from member_tbl_02 order by custno asc");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setCustno(Integer.parseInt(rs.getString("custno")));
				vo.setCustname(rs.getString("custname"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setJoindate(rs.getDate("joindate"));
				vo.setGrade(rs.getString("grade"));
				vo.setCity(rs.getString("city"));
				list.add(vo);

			}
			System.out.println("멤버목록 출력 완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("멤버목록 출력 실패");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}

		return list;
	}

	public MemberVO findUser(int custno) {
		MemberVO vo = new MemberVO();

		Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from member_tbl_02 where custno = ?");
			pstmt.setInt(1, custno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo.setCustno(Integer.parseInt(rs.getString("custno")));
				vo.setCustname(rs.getString("custname"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setJoindate(rs.getDate("joindate"));
				vo.setGrade(rs.getString("grade"));
				vo.setCity(rs.getString("city"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}

		return vo;
	}

	public int updateMember(MemberVO member) {
		int n = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(
					"update member_tbl_02 set custname = ?, phone = ?, address = ?, grade = ?, city = ? where custno = ?");
			pstmt.setString(1, member.getCustname());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getAddress());
			pstmt.setString(4, member.getGrade());
			pstmt.setString(5, member.getCity());
			pstmt.setInt(6, member.getCustno());
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}

	public ArrayList<MemberMoneyVO> getMoneyList() {
		ArrayList<MemberMoneyVO> list = new ArrayList<MemberMoneyVO>();

		Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select A.custno, A.custname, decode(A.grade, 'A','VIP','B','일반','C','직원') grade, sum(B.price) price \r\n"
					+ "from member_tbl_02 A, money_tbl_02 B \r\n"
					+ "where A.custno = B.custno \r\n"
					+ "group by A.custno, A.custname, A.grade \r\n"
					+ "order by price desc");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberMoneyVO vo = new MemberMoneyVO();
				vo.setCustNo(rs.getInt(1));
				vo.setCustName(rs.getString(2));
				vo.setGrade(rs.getString(3));
				vo.setTotal(rs.getInt(4));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}

		return list;
	}

}
