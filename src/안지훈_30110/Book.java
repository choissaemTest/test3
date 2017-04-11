package æ»¡ˆ»∆_30110;

public class Book {
	private String name;
	private String author;
	private String publisher;
	private String cost;
	private String lent;
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}
	public String toString(){
		return name + "," + author + "," + publisher + "," + cost + "," + lent;
	}

	public String getLent() {
		return lent;
	}

	public void setLent(String lent) {
		this.lent = lent;
	}

}
