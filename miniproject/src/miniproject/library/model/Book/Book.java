package miniproject.library.model.Book;

public class Book {
	private String bookID;
	private String title;
	private String author;
	private String category;
	private boolean isRentalable;
	
	public Book() {};
	
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

	public boolean isRentalable() {
		return isRentalable;
	}

	public void setisRentalable(boolean isRentalable) {
		this.isRentalable = isRentalable;
	}
	
	@Override
	public String toString() {
		return bookID + title + author + isRentalable;
	}
}
