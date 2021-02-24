package pjt.one.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pjt.one.com.db.DBConn;
import pjt.one.com.vo.BoardListVo;

public class BoardDao {
	public List<BoardListVo> getBoardList() {
		List<BoardListVo>   boardList = new ArrayList<BoardListVo>();
		Connection 				conn  = null;
		PreparedStatement 		pstmt = null;
		ResultSet 				rs    = null;
		DBConn 					db    = null;
		
		try {
			db = new DBConn();
			conn = db.getConnection();
			String sql = "SELECT IDX, TITLE, REGDATE, NVL(READCOUNT,0) READCOUNT, USER_ID FROM BOARD"
					   + " ORDER BY IDX DESC ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//IDX, TITLE, CONT, READCOUNT, REGDATE, USER_ID
			while(rs.next()) {
				BoardListVo vo = new BoardListVo();
				vo.setIDX(rs.getString("IDX"));
				vo.setTITLE(rs.getString("TITLE"));
				vo.setREGDATE(rs.getString("REGDATE")); 
				vo.setREADCOUNT(rs.getString("READCOUNT"));
				vo.setUSER_ID(rs.getString("USER_ID"));
				
				boardList.add(vo);
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
		return boardList;
	}

	public BoardListVo getBoardRead(String idx) {
		Connection 			conn  = null;
		PreparedStatement 	pstmt = null;
		ResultSet 			rs    = null;
		DBConn 				db    = null;
		BoardListVo         vo    = new BoardListVo();
		
		try {
			db = new DBConn();
			conn = db.getConnection();
			String sql = "SELECT IDX, TITLE, REGDATE, USER_ID, READCOUNT,CONT FROM BOARD WHERE IDX=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idx);
			rs = pstmt.executeQuery();
			rs.next();
			
			vo.setIDX(rs.getString("IDX"));			 	vo.setTITLE(rs.getString("TITLE"));
			vo.setREGDATE(rs.getString("REGDATE"));  	vo.setUSER_ID(rs.getString("USER_ID"));
			vo.setREADCOUNT(rs.getString("READCOUNT")); vo.setCONT(rs.getString("CONT"));
			System.out.println(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)    rs.close();
				if(pstmt!=null) pstmt.close();
				                db.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return vo;
	}
	
	public void InsertBoared ( String title, String cont) {
		Connection 				conn  = null;
		PreparedStatement 		pstmt = null;
		ResultSet 				rs    = null;
		DBConn 					db    = null;
		
		cont = cont.replace("<", "&lt;");
		cont = cont.replace(">", "&gt;");
		try {
			db = new DBConn();
			conn = db.getConnection();
			String sql =  " insert into board(idx,title, cont)";
			sql       +=  " values(";
			sql       +=  " ( SELECT NVL(MAX(IDX),0)+1  FROM BOARD)";
			sql       +=  " ,?, ?) ";
			
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString (1, title);
			pstmt.setString (2, cont);
			
			 pstmt.executeUpdate();
			//IDX, TITLE, CONT, READCOUNT, REGDATE, USER_ID
			
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				db.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}

	public BoardListVo getListViewOne(String idx) {
		
		BoardListVo bListVo = null;
		Connection 				conn  = null;
		PreparedStatement 		pstmt = null;
		ResultSet 				rs    = null;
		DBConn 					db    = null;
		
		
		try {
			db = new DBConn();
			conn = db.getConnection();
			String sql = "SELECT * FROM BOARD WHERE IDX = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString (1, idx);
			
			 rs = pstmt.executeQuery();
			 if(rs.next()) {
				 
				 String IDX = rs.getString("IDX");
				 String TITLE = rs.getString("TITLE");
				 String CONT = rs.getString("CONT");
				 String READCOUNT = rs.getString("READCOUNT");
				 String REGDATE = rs.getString("REGDATE");
				 String USER_ID = rs.getString("USER_ID");
				 
				 bListVo = new BoardListVo(IDX, TITLE, CONT, READCOUNT, REGDATE, USER_ID);
			 }
			 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				db.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bListVo;
	}

	public void BoardUpdate(String idx, String title, String cont) {
		Connection 				conn  = null;
		PreparedStatement 		pstmt = null;
		ResultSet 				rs    = null;
		DBConn 					db    = null;
		
		cont = cont.replace("<", "&lt;");
		cont = cont.replace(">", "&gt;");
		
		try {
			db = new DBConn();
			conn = db.getConnection();
			String sql = "UPDATE BOARD SET TITLE=?, CONT=? WHERE IDX = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString (1, title);
			pstmt.setString (2, cont);
			pstmt.setString (3, idx);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				db.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
}
