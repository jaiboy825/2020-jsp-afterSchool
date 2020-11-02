package vo;

public class BookVO {
	private String isBn;
	private String title;
	private String author;
	private String company;
	private int price;
	public BookVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookVO(String isBn, String title, String author, String company, int price) {
		super();
		this.isBn = isBn;
		this.title = title;
		this.author = author;
		this.company = company;
		this.price = price;
	}
	public String getIsBn() {
		return isBn;
	}
	public void setIsBn(String isBn) {
		this.isBn = isBn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
