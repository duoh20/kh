package miniproject.library.model;

import java.io.Serializable;

public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private String bookID;
	private String title;
	private String author;
	private String category;
	private boolean isRentalable;
	
	public Book() {}
	
	public Book (String title, String author, String category) {
		this.title = title;
		this.author = author;
		this.category = category;
	}
	
	public Book (String title, String author, String category, boolean isRentalable) {
		this.isRentalable = isRentalable;
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
	
	public String getCategoty() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

	public boolean getIsRentalable() {
		return isRentalable;
	}

	public void setIsRentalable(boolean isRentalable) {
		this.isRentalable = isRentalable;
	}
	
	@Override
	public String toString() {
		return title + ", " + author + ", " + category + ", " + isRentalable;
	}
}