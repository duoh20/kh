package com.kh.practice.file.controller;
import com.kh.practice.file.dao.FileDAO;

public class FileController {
	FileDAO fd = new FileDAO();
	
	public boolean checkName(String file) {
		return fd.checkName(file);
	}
	
	public void fileSave(String file, StringBuilder sb) {
		String s = "";
		s = sb.toString();
		fd.fileSave(file, s);
	}
	
	public StringBuilder fileOpen(String file) {
		StringBuilder sb = new StringBuilder(fd.fileOpen(file));
		return sb;
	}
	
	public void fileEdit(String file, StringBuilder sb) {
		String s = sb.toString();
		fd.fileEdit(file, s);
	}
}
