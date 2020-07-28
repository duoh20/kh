package com.kh.example.practice2.modle.vo;

public class Product {
	
	private String pName;
	private String brand;
	private int price;
	
	public Product() {}
	
	public void information() {
		System.out.print("pName : " + pName
					+ ", brand : "+ brand
					+ ", price: " + price);
	}
}
