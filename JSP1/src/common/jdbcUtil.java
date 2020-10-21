package common;

import java.sql.*;

public class jdbcUtil {
	public static Connection getConnection() {
		Connection conn = null;
		// DB 연동 코드 추가
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("오라클 연동 실패");
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUser = "hr";
		String dbPassword = "hr";
		try {
			conn = DriverManager.getConnection(url, dbUser, dbPassword);

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("db 연결 실패. 연결 스트림, 이름 등을 확인할 것");
		}
		return conn;
	}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
