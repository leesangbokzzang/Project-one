package pjt.one.com.vo;

public class BoardListVo {
	private String IDX;
	private String TITLE;
	private String CONT ;
	private String READCOUNT;
	private String REGDATE ;
	private String USER_ID;
	public BoardListVo() {}
	public BoardListVo(String IDX, String TITLE, String CONT, String READCOUNT, String REGDATE, String USER_ID) {
		this.IDX = IDX;
		this.TITLE = TITLE;
		this.CONT = CONT;
		this.READCOUNT = READCOUNT;
		this.REGDATE = REGDATE;
		this.USER_ID = USER_ID;
	}
	public String getIDX() {
		return IDX;
	}
	public void setIDX(String IDX) {
		this.IDX = IDX;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String TITLE) {
		this.TITLE = TITLE;
	}
	public String getCONT() {
		return CONT;
	}
	public void setCONT(String CONT) {
		this.CONT = CONT;
	}
	public String getREADCOUNT() {
		return READCOUNT;
	}
	public void setREADCOUNT(String READCOUNT) {
		this.READCOUNT = READCOUNT;
	}
	public String getREGDATE() {
		return REGDATE;
	}
	public void setREGDATE(String REGDATE) {
		this.REGDATE = REGDATE;
	}
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String USER_ID) {
		this.USER_ID = USER_ID;
	}
	@Override
	public String toString() {
		return "BoardListVo [IDX=" + IDX + ", TITLE=" + TITLE + ", CONT=" + CONT + ", READCOUNT=" + READCOUNT
				+ ", REGDATE=" + REGDATE + ", USER_ID=" + USER_ID + "]";
	}
}
