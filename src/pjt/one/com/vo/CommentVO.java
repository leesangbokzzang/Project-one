package pjt.one.com.vo;

public class CommentVO {
	private int idx;
	private String user_id;
	private String cont;
	private String regdate;
	
	public CommentVO() {}
	
	public CommentVO(int idx, String user_id, String cont, String regdate) {
		this.idx = idx;
		this.user_id = user_id;
		this.cont = cont;
		this.regdate = regdate;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getCont() {
		return cont;
	}

	public void setCont(String cont) {
		this.cont = cont;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "CommentVO [idx=" + idx + ", user_id=" + user_id + ", cont=" + cont + ", regdate=" + regdate + "]";
	}
	
	
}
