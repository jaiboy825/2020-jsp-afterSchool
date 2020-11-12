package vo;


public class ArtistVO {
	private String artist_id;
	private String artist_name;
	private String artist_birth;
	private String artist_gender;
	private String talent;
	private String agency;
	
	
	
	public ArtistVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArtistVO(String artist_id, String artist_name, String artist_birth, String artist_gender, String talent,
			String agency) {
		super();
		this.artist_id = artist_id;
		this.artist_name = artist_name;
		this.artist_birth = artist_birth;
		this.artist_gender = artist_gender;
		this.talent = talent;
		this.agency = agency;
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
	public String getArtist_birth() {
		return artist_birth;
	}
	public void setArtist_birth(String artist_birth) {
		this.artist_birth = artist_birth;
	}
	public String getArtist_gender() {
		return artist_gender;
	}
	public void setArtist_gender(String artist_gender) {
		this.artist_gender = artist_gender;
	}
	public String getTalent() {
		return talent;
	}
	public void setTalent(String talent) {
		this.talent = talent;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	
	

}
