package pjt.one.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pjt.one.com.dao.BoardDao01;
import pjt.one.com.dao.BoardDao01;
import pjt.one.com.vo.BoardListVo;


@WebServlet("/board01")
public class BoardController01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestFunc(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestFunc(request, response);
	}
	private void requestFunc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String cmd = request.getParameter("cmd");
		
		//메인리스트 CMD
		if(cmd.equals("FIRSTLIST")) { 
			BoardDao01 dao= new BoardDao01();
			List<BoardListVo> boardList = dao.getBoardList();
			request.setAttribute("boardList", boardList);
			
			String link = "/view01/list01.jsp";
			request.getRequestDispatcher(link).forward(request, response);
		}
	
		
		//새글쓰기 CMD
		if(cmd.equals("BOARDWRITEFORM")) { 
			String link = "/view01/write01.jsp"; 
			request.getRequestDispatcher(link).forward(request, response);
		}		
		if(cmd.equals("BOARDWRITE")) {	
			String title= request.getParameter("title");
			String cont= request.getParameter("cont");
			
			cont=cont.replace("<", "&lt;");
			cont=cont.replace(">", "&gt;");		
			
			BoardDao01 dao=new BoardDao01();
			dao.insertBoared(title, cont);
			
		 String link = "/board01?cmd=FIRSTLIST"; 
		 request.getRequestDispatcher(link).forward(request, response);
		

		}
		
		//게시글읽기 CMD
		if(cmd.equals("BOARDREAD")) { 
			String idx = request.getParameter("IDX");
			BoardDao01 dao= new BoardDao01();
			BoardListVo vo = dao.getBoardRead(idx);
			
			vo.setCONT(vo.getCONT().replace("\n", "<br/>"));
			
			request.setAttribute("vo", vo);
			
			String link = "/view01/read01.jsp";
			request.getRequestDispatcher(link).forward(request, response);
		}
		
		//글수정 CMD
		if(cmd.equals("EDIT")) { 
			request.setCharacterEncoding("utf-8");
			
			String idx = request.getParameter("idx");
			
			BoardDao01 dao = new BoardDao01();
			BoardListVo listViewOne = dao.getListViewOne(idx);
			
			request.setAttribute("listViewOne", listViewOne);
			
			String link = "/view01/edit01.jsp";
			request.getRequestDispatcher(link).forward(request, response);
		}
		if(cmd.equals("BOARDUPDATE")){
			request.setCharacterEncoding("utf-8");
			
			String idx = request.getParameter("idx");
			String title = request.getParameter("title");
			String cont = request.getParameter("cont");
			
			
			BoardDao01 dao = new BoardDao01();
			dao.boardUpdate(idx, title, cont);
			
			PrintWriter out = response.getWriter();
			
			response.setContentType("text/html; charset=UTF-8");
			out.println("<script>alert('UPDATE OK'); location.href='/board01?cmd=FIRSTLIST';</script>");
			out.flush();
		}
		
		//글삭제 CMD
		if(cmd.equals("DELETE")) { 
			String idx = request.getParameter("idx");
			System.out.println("idx="+idx);

			//데이터 삭제
			BoardDao01 dao= new BoardDao01();
			dao.deleteBoard(idx);

			//삭제 후 글 목록으로 페이지 이동 
			String link = "/board01?cmd=FIRSTLIST"; 
			request.getRequestDispatcher(link).forward(request, response);

		}
	}

}
