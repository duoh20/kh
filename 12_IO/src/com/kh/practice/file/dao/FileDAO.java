package com.kh.practice.file.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDAO {
	
	public boolean checkName(String file) {
		File f = new File(file);
		return f.exists();
	}
	
	public void fileSave(String file, String s) {
		try(FileWriter fw = new FileWriter(file)) {
			fw.write(s);
		} catch (IOException e) {
			e.getMessage();
		}
	}	

	public StringBuilder fileOpen(String file) {
		StringBuilder sb = new StringBuilder();
		try(FileReader fr = new FileReader(file)) {
			int value;
			while((value = fr.read()) != -1) {
				sb.append((char)value);
			}
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
		return sb;
	}
	
	public void fileEdit(String file, String s) {
		try (FileWriter fw = new FileWriter(file, true)) {
			fw.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
