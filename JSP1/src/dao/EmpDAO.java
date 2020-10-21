package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import common.jdbcUtil;
import vo.EmpVO;

public class EmpDAO {
	// CRUD
	public int insertEmp(EmpVO vo) {
		int n = 0;
		Connection conn = jdbcUtil.getConnection();
		if (conn == null) {
			return -1;
		}

		// insert into 실행
		PreparedStatement pstmt = null;
		String sql = "insert into emp(num, name, age, score) values(seq_num.nextval, ?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setInt(3, vo.getScore());

			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn, pstmt, null);
		}
		return n;

	}

	public List<EmpVO> listEmp() {
		List<EmpVO> list = new ArrayList<EmpVO>();

		// db select
		Connection conn = jdbcUtil.getConnection();
		if (conn == null) {
			return null; // 연결 실
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from emp order by num ";
		EmpVO vo = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new EmpVO();
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setScore(rs.getInt("score"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jdbcUtil.close(conn, pstmt, rs);
		}

		return list;
	}

	public EmpVO getEmp(int num) {
		Connection conn = jdbcUtil.getConnection();
		EmpVO vo = null;
		if(conn == null) return null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from emp where num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new EmpVO();
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setScore(rs.getInt("score"));
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			jdbcUtil.close(conn, pstmt, rs);
		}
		return vo;
		
	}

	public int updateEmp(EmpVO vo) {
		int n = 0;
		Connection conn = jdbcUtil.getConnection();
		if(conn == null)
			return -1;
		PreparedStatement pstmt = null;
		String sql = "Update emp set age = ?, score = ? where num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getAge());
			pstmt.setInt(2, vo.getScore());
			pstmt.setInt(3, vo.getNum());
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbcUtil.close(conn, pstmt, null);
		}
		
		return n;
		
	}

	public int deleteEmp(int num) {
		int n = 0;
		Connection conn = jdbcUtil.getConnection();
		if(conn == null)
			return -1;
		PreparedStatement pstmt = null;
		String sql = "delete from emp where num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}finally {
			jdbcUtil.close(conn, pstmt, null);
		}
		return n;
	}
}
