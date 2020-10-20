package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import vo.EmpVO;

public class EmpDAO {
	// CRUD
	public int insertEmp(EmpVO vo) {
		int n = 0;
		//DB 연동 코드 추가
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("오라클 연동 실패");
		}
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUser = "hr";
		String dbPassword = "hr";
		try {
			conn = DriverManager.getConnection(url,dbUser, dbPassword);
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("db 연결 실패. 연결 스트림, 이름 등을 확인할 것");
		}
		if(conn == null) {
			return -1;
		}
		
		//insert into 실행
		PreparedStatement pstmt = null;
		String sql = "insert into emp(num, name, age, score) values(seq_num.nextval, ?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);		
			pstmt.setString(1,vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setInt(3, vo.getScore());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();					
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		}
		return n;
		
	}
}
