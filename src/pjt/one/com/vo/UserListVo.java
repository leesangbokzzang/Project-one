package pjt.one.com.vo;

public class UserListVo {
	//in_id,in_pw,in_name,in_gender,in_tel,in_addr,in_email
	private String user_id;
	private String user_name;
	private String user_pwd;
	private String user_phone;
	private String address;
	private String gender;
	private String email;
	public UserListVo() {}
	public UserListVo(String user_id, String user_name, String user_pwd, String user_phone, String address,
			String gender, String email) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pwd = user_pwd;
		this.user_phone = user_phone;
		this.address = address;
		this.gender = gender;
		this.email = email;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserListVo [user_id=" + user_id + ", user_name=" + user_name + ", user_pwd=" + user_pwd
				+ ", user_phone=" + user_phone + ", address=" + address + ", gender=" + gender + ", email=" + email
				+ "]";
	}
	
}
