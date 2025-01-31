package kh.semi.reviewBook.admin.vo;

import java.sql.Date;

public class NoticeVo {
//	NT_NO	NUMBER	✔	PK	
//	NT_TITLE	VARCHAR2(300)	✔		
//	NT_CONTENT	VARCHAR2(3000)	✔		
//	NT_CNT	NUMBER	✔		0
//	NT_DATE	TIMESTAMP	✔		SYSTIMESTAMP
//	NT_NICKNAME	VARCHAR2(45)	✔		
//	AD_ID	VARCHAR2(30)	✔	FK	

	private int ntNo;
	private String ntTitle;
	private String ntContent;
	private int ntCnt;
	private Date ntDate;
	private String ntNickname;
	private String adId;
	
	@Override
	public String toString() {
		return "UserNoticeVo [ntNo=" + ntNo + ", ntTitle=" + ntTitle + ", ntContent=" + ntContent + ", ntCnt=" + ntCnt
				+ ", ntDate=" + ntDate + ", ntNickname=" + ntNickname + ", adId=" + adId + "]";
	}

	public int getNtNo() {
		return ntNo;
	}

	public void setNtNo(int ntNo) {
		this.ntNo = ntNo;
	}

	public String getNtTitle() {
		return ntTitle;
	}

	public void setNtTitle(String ntTitle) {
		this.ntTitle = ntTitle;
	}

	public String getNtContent() {
		return ntContent;
	}

	public void setNtContent(String ntContent) {
		this.ntContent = ntContent;
	}

	public int getNtCnt() {
		return ntCnt;
	}

	public void setNtCnt(int ntCnt) {
		this.ntCnt = ntCnt;
	}

	public Date getNtDate() {
		return ntDate;
	}

	public void setNtDate(Date ntDate) {
		this.ntDate = ntDate;
	}

	public String getNtNickname() {
		return ntNickname;
	}

	public void setNtNickname(String ntNickname) {
		this.ntNickname = ntNickname;
	}

	public String getAdId() {
		return adId;
	}

	public void setAdId(String adId) {
		this.adId = adId;
	}
	
	
	
	
}