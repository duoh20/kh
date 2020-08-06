package miniproject.book.model.vo;

import java.io.Serializable;

public class Book implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7517892862778852840L;
	private String title;
	private String author;
	private String category;
	private boolean overdue;
	private boolean rental;
	
	public Book() {}
	public Book(String title, String author, String category, boolean overdue, boolean rental) {
		this.title = title;
		this.author = author;
		this.category = category;
		this.overdue = overdue;
		this.rental = rental;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public boolean isOverdue() {
		return overdue;
	}
	public void setOverdue(boolean overdue) {
		this.overdue = overdue;
	}
	public boolean isRental() {
		return rental;
	}
	public void setRental(boolean rental) {
		this.rental = rental;
	}
}
