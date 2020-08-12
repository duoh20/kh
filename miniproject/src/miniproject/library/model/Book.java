package miniproject.library.model;

import java.io.Serializable;

public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String bookID;
	private String title;
	private String author;
	private String category;
	private boolean isRentalable = true; //true  대여가능, false 대여불가
	
	public Book() {}
	
	public Book (String bookID, String title, String author, String category) {
		this.bookID = bookID;
		this.title = title;
		this.author = author;
		this.category = category;
	}
	
	public Book (String bookID, String title, String author, String category, boolean isRentalable) {
		this(bookID, title, author, category);
		this.isRentalable = isRentalable;
	}
	
	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getCategory() {
		return category;
	}

	public void setRentalable(boolean isRentalable) {
		this.isRentalable = isRentalable;
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
		return bookID + ", " + title + ", " + author + ", " + category + ", " + isRentalable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookID == null) ? 0 : bookID.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + (isRentalable ? 1231 : 1237);
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookID == null) {
			if (other.bookID != null)
				return false;
		} else if (!bookID.equals(other.bookID))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (isRentalable != other.isRentalable)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}