package com.kh.practice.book.model.vo;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BookDAO {
	
	private Book[] bArr = new Book[10];
	
	public void fileSave(Book[] bArr) { //파일에 객체를 저장해야하니까 직렬화
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.txt"))) {
			for(int i = 0; i < bArr.length; i++) {
				if(bArr[i] != null) {
					oos.writeObject(bArr[i]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Book[] fileRead() { //파일부터 객체를 불러와야하니까 역직렬화
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.txt"))) {
			
			int i = 0;
			while(true) {
				bArr[i] = (Book)ois.readObject();
				i++;
				
				if(i == 10) {
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return bArr;
	}
}
