package com.kh.practice.book.model.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String author;
	private int price;
	private Calendar date;
	private double discount;
	
	public Book() {}
	
	public Book(String title, String author, int price, Calendar date, double discount) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.date = date;
		this.discount = discount;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setDate(Calendar date) {
		this.date = date;
	}
	
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAutohr() {
		return author;
	}
	
	public int getPrice() {
		return price;
	}

	public Calendar getDate() {
		return date;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	@Override
	public String toString() {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일"); 
	String str = sdf.format(date.getTime());
		return title + "\t" + author + "\t" + price + "\t" + str + " " + discount;
	}

}
