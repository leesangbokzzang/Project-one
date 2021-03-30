package pjt.one.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pjt.one.com.db.DBConn;
import pjt.one.com.vo.CommentVO;

public class CommentDao {
	Connection        conn  = null;
	PreparedStatement pstmt = null;
	ResultSet         rs    = null;
	DBConn            db    = new DBConn();
	
	//댓글쓰기
	public void CommntInsert(int idx, String user_id, String boardComment) {
		
		try {
			conn = db.getConnection();
			String sql ="INSERT INTO COMMENTS (idx, user_id, cont) VALUES(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, idx);
			pstmt.setString(2, user_id);
			pstmt.setString(3, boardComment);
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null)conn.close();
				if(pstmt!=null)pstmt.close();
				db.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public List<CommentVO> getCommentList(String idx){
		List<CommentVO> comList = new ArrayList<CommentVO>();
		try {
			conn = db.getConnection();
			String sql ="SELECT IDX, USER_ID, CONT, REGDATE FROM COMMENTS WHERE IDX = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, idx);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CommentVO vo = null;
				
				int idx2 = rs.getInt("idx");
				String user_id = rs.getString("user_id");
				String cont = rs.getString("cont");
				String regdate = rs.getString("regdate");
				
				vo = new CommentVO(idx2, user_id, cont, regdate);
				comList.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null)conn.close();
				if(pstmt!=null)pstmt.close();
				db.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return comList;
	}

}
