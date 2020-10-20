package common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;
// com.oreilly.servlet == cos.jar를 의미, cos.jar 파일이 없으면 찾을 수 없음

public class MyFileRenamePolicy implements FileRenamePolicy{

	@Override
	public File rename(File originFile) {
		
		long currentTime = System.currentTimeMillis();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		int ranNum = (int)(Math.random()*1000000);
		
		String name = originFile.getName();
		String ext = null;
		
		int dot = name.lastIndexOf(".");
		//마지막 .이 확장자로 표기되므로
		
		if(dot != -1) { //.이 존재함
			ext = name.substring(dot);
		} else {
			ext = "";
		}
		
		String fileName = sdf.format(new Date(currentTime)) + ranNum  + ext; //여기서 Date는 util 패키지의 Date
		File newFile = new File(originFile.getParent(), fileName);
		
		return newFile;
	}

}
