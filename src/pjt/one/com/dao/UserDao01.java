package pjt.one.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pjt.one.com.db.DBConn;
import pjt.one.com.vo.BoardListVo;
import pjt.one.com.vo.UserListVo;

public class UserDao01 {

	
	public String getIdCheck(String in_id) {
		String result = "";
		Connection 				conn  = null;
		PreparedStatement 		pstmt = null;
		ResultSet 				rs    = null;
		DBConn 					db    = null;
		try {
			db = new DBConn();
			conn = db.getConnection();
			String sql = "SELECT USER_ID FROM USER_INFO";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//정규식 체크
			String in_id_reg = "^[a-zA-Z]{1}[a-zA-Z0-9_]{3,15}$";	//영문대소문자+숫자+ (_) , 4~15자
			boolean id_reg = in_id.matches(in_id_reg);
			System.out.println("정규식체크 : "+id_reg);
			
			//중복 체크
			while(rs.next()) {
				if(rs.getString("USER_ID").equals(in_id)||id_reg==false) {
					result = "false"; break;
				} else {
					result = "true";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				db.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public void insertUser(String in_id, String in_pw, String in_name, String in_gender, String in_tel, String in_addr,
			String in_email) {
		Connection 				conn  = null;
		PreparedStatement 		pstmt = null;
		DBConn 					db    = null;
		try {
			db = new DBConn();
			conn = db.getConnection();
			String sql = "insert into user_info(USER_ID, USER_PWD, USER_NAME, GENDER, USER_PHONE, ADDRESS, EMAIL) " + 
					"values (?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, in_id);
			pstmt.setString(2, in_pw);
			pstmt.setString(3, in_name);
			pstmt.setString(4, in_gender);
			pstmt.setString(5, in_tel);
			pstmt.setString(6, in_addr);
			pstmt.setString(7, in_email);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				db.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public boolean getMailCheck(String email) {
		boolean email_dup = false;
		Connection 				conn  = null;
		PreparedStatement 		pstmt = null;
		ResultSet 				rs    = null;
		DBConn 					db    = null;
		try {
			db = new DBConn();
			conn = db.getConnection();
			String sql = "SELECT EMAIL FROM USER_INFO";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//중복 체크
			while(rs.next()) {
				if(rs.getString("EMAIL").equals(email)) {
					email_dup = false; break;
				} else {
					email_dup = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				db.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return email_dup;
	}

}
