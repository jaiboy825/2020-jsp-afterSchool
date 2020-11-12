package vo;

public class RankVO {
	private String artist_id;
	private String artist_name;
	private int point;
	private float avg;
	private int rank;
	public RankVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RankVO(String artist_id, String artist_name, int point, float avg, int rank) {
		super();
		this.artist_id = artist_id;
		this.artist_name = artist_name;
		this.point = point;
		this.avg = avg;
		this.rank = rank;
	}
	public String getArtist_id() {
		return artist_id;
	}
	public void setArtist_id(String artist_id) {
		this.artist_id = artist_id;
	}
	public String getArtist_name() {
		return artist_name;
	}
	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public float getAvg() {
		return avg;
	}
	public void setAvg(float avg) {
		this.avg = avg;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}

	
}
