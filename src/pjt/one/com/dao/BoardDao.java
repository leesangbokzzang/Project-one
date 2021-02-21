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
			String sql = "SELECT IDX, TITLE, REGDATE FROM BOARD ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//IDX, TITLE, CONT, READCOUNT, REGDATE, USER_ID
			while(rs.next()) {
				BoardListVo vo = new BoardListVo();
				vo.setIDX(rs.getString("IDX"));
				vo.setTITLE(rs.getString("TITLE"));
				vo.setREGDATE(rs.getString("REGDATE")); 
				//vo.setREADCOUNT(rs.getString("READCOUNT")); 추후 칼럼 추가
				//vo.setUSER_ID(rs.getString("USER_ID")); 추후 칼럼 추가
				
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
}
