package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JdbcUtil;
import vo.ArtistVO;
import vo.MentoVO;
import vo.RankVO;

public class ArtistDAO {

	public ArrayList<ArtistVO> getMemberList() {
		ArrayList<ArtistVO> list = new ArrayList<ArtistVO>();

		Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select*from artist_tbl order by artist_id asc";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArtistVO vo = new ArtistVO();
				vo.setArtist_id(rs.getString("artist_id"));
				vo.setArtist_name(rs.getString("artist_name"));
				vo.setArtist_birth(rs.getString("artist_birth"));
				vo.setArtist_gender(rs.getString("artist_gender"));
				vo.setTalent(rs.getString("talent"));
				vo.setAgency(rs.getString("agency"));

				list.add(vo);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);

		}

		return list;
	}

	public ArrayList<MentoVO> getMentoList() {
		ArrayList<MentoVO> list = new ArrayList<MentoVO>();

		Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select  ar.artist_id artist_id , artist_name ,artist_birth,po.point point ,me.mento_name mento_name  "
				+ "from ARTIST_TBL ar inner join POINT_TBL po on ar.artist_id = po.artist_id inner join mento_tbl me  on me.mento_id = po.mento_id order by ar.artist_id asc";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MentoVO vo = new MentoVO();
				vo.setArtist_id(rs.getString("artist_id"));
				vo.setArtist_name(rs.getString("artist_name"));
				vo.setArtist_birth(rs.getString("artist_birth"));
				vo.setPoint(rs.getInt("point"));
				vo.setMento_name(rs.getString("mento_name"));
				list.add(vo);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);

		}

		return list;
	}

	public ArrayList<RankVO> getRankList() {
		ArrayList<RankVO> list = new ArrayList<RankVO>();

		Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="select  ar.artist_id ,artist_name, sum(point) sum ,round(avg(point),2) avg,rank() over(order by sum(point) desc) rank" + 
				" from ARTIST_TBL ar, POINT_TBL po where ar.artist_id = po.artist_id group by (ar.artist_id ,artist_name ) order by	 sum desc";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				RankVO vo = new RankVO();
				vo.setArtist_id(rs.getString("artist_id"));
				vo.setArtist_name(rs.getString("artist_name"));
				vo.setAvg(rs.getFloat("avg"));
				vo.setPoint(rs.getInt("sum"));
				vo.setRank(rs.getInt("rank"));

				list.add(vo);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);

		}

		return list;
	}

	public int insertArtist(ArtistVO a) {
		int n = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "INSERT INTO artist_tbl(artist_id,artist_name,artist_birth,artist_gender,talent,agency) VALUES(?,?,?,?,?,?)";
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a.getArtist_id());
			pstmt.setString(2, a.getArtist_name());
			pstmt.setString(3, a.getArtist_birth());
			pstmt.setString(4, a.getArtist_gender());
			pstmt.setString(5, a.getTalent());
			pstmt.setString(6, a.getAgency());

			n = pstmt.executeUpdate();

			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}

		return n;
	}

}
