package board.model.vo;

import java.sql.Date;

public class Attachment {
	private int fileId;
	private int boardId;
	private String originName;
	private String changeName;
	private String filePath;
	private Date uploadDate;
	private int	filelLevel;
	private int downloadCount;
	private String status;

	public Attachment() {}
	
	public Attachment(int boardId, String changeName) {
		this.boardId = boardId;
		this.changeName = changeName;
	}

	public Attachment(int fileId, int boardId, String originName, String changeName, String filePath, Date uploadDate,
			int filelLevel, int downloadCount, String status) {
		super();
		this.fileId = fileId;
		this.boardId = boardId;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.filelLevel = filelLevel; //썸네일=1, 내옹사진=2
		this.downloadCount = downloadCount;
		this.status = status;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public int getFilelLevel() {
		return filelLevel;
	}

	public void setFilelLevel(int filelLevel) {
		this.filelLevel = filelLevel;
	}

	public int getDownloadCount() {
		return downloadCount;
	}

	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Attachment [fileId=" + fileId + ", boardId=" + boardId + ", originName=" + originName + ", changeName="
				+ changeName + ", filePath=" + filePath + ", uploadDate=" + uploadDate + ", filelLevel=" + filelLevel
				+ ", downloadCount=" + downloadCount + ", status=" + status + "]";
	}
}
