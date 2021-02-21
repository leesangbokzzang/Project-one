package pjt.one.com.vo;

public class UserListVo {
	private String USER_ID;
	private String USER_NAME;
	private String USER_PWD;
	private String USER_PHONE;
	private String ADDRESS;
	public UserListVo(String USER_ID, String USER_NAME, String USER_PWD, String USER_PHONE, String ADDRESS) {
		this.USER_ID = USER_ID;
		this.USER_NAME = USER_NAME;
		this.USER_PWD = USER_PWD;
		this.USER_PHONE = USER_PHONE;
		this.ADDRESS = ADDRESS;
	}
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String USER_ID) {
		this.USER_ID = USER_ID;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String USER_NAME) {
		this.USER_NAME = USER_NAME;
	}
	public String getUSER_PWD() {
		return USER_PWD;
	}
	public void setUSER_PWD(String USER_PWD) {
		this.USER_PWD = USER_PWD;
	}
	public String getUSER_PHONE() {
		return USER_PHONE;
	}
	public void setUSER_PHONE(String USER_PHONE) {
		this.USER_PHONE = USER_PHONE;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String ADDRESS) {
		this.ADDRESS = ADDRESS;
	}
	@Override
	public String toString() {
		return "UserListVo [USER_ID=" + USER_ID + ", USER_NAME=" + USER_NAME + ", USER_PWD=" + USER_PWD
				+ ", USER_PHONE=" + USER_PHONE + ", ADDRESS=" + ADDRESS + "]";
	}
}
