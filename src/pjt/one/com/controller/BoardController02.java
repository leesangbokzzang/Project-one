package pjt.one.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pjt.one.com.dao.BoardDao02;
import pjt.one.com.dao.BoardDao02;
import pjt.one.com.vo.BoardListVo;


@WebServlet("/board02")
public class BoardController02 extends HttpServlet {
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
			HttpSession session = request.getSession();
			String user_name = (String) session.getAttribute("user_id");
			if(user_name==null) {
				response.sendRedirect("/user?cmd=LOGINFORM");
			} else {
			BoardDao02 dao= new BoardDao02();
			List<BoardListVo> boardList = dao.getBoardList();
			request.setAttribute("boardList", boardList);
			String link = "/view02/list02.jsp";
			request.getRequestDispatcher(link).forward(request, response);
			}
		}
	
		
		//새글쓰기 CMD
		if(cmd.equals("BOARDWRITEFORM")) { 
			String link = "/view02/write02.jsp"; 
			request.getRequestDispatcher(link).forward(request, response);
		}		
		if(cmd.equals("BOARDWRITE")) {	
			String title= request.getParameter("title");
			String cont= request.getParameter("cont");
			
			cont=cont.replace("<", "&lt;");
			cont=cont.replace(">", "&gt;");		
			
			BoardDao02 dao=new BoardDao02();
			dao.insertBoared(title, cont);
			
		 String link = "/board02?cmd=FIRSTLIST"; 
		 request.getRequestDispatcher(link).forward(request, response);
		

		}
		
		//게시글읽기 CMD
		if(cmd.equals("BOARDREAD")) { 
			String idx = request.getParameter("IDX");
			BoardDao02 dao= new BoardDao02();
			BoardListVo vo = dao.getBoardRead(idx);
			
			vo.setCONT(vo.getCONT().replace("\n", "<br/>"));
			
			request.setAttribute("vo", vo);
			
			String link = "/view02/read02.jsp";
			request.getRequestDispatcher(link).forward(request, response);
		}
		
		//글수정 CMD
		if(cmd.equals("EDIT")) { 
			request.setCharacterEncoding("utf-8");
			
			String idx = request.getParameter("idx");
			
			BoardDao02 dao = new BoardDao02();
			BoardListVo listViewOne = dao.getListViewOne(idx);
			
			request.setAttribute("listViewOne", listViewOne);
			
			String link = "/view02/edit02.jsp";
			request.getRequestDispatcher(link).forward(request, response);
		}
		if(cmd.equals("BOARDUPDATE")){
			request.setCharacterEncoding("utf-8");
			
			String idx = request.getParameter("idx");
			String title = request.getParameter("title");
			String cont = request.getParameter("cont");
			
			
			BoardDao02 dao = new BoardDao02();
			dao.boardUpdate(idx, title, cont);
			
			PrintWriter out = response.getWriter();
			
			response.setContentType("text/html; charset=UTF-8");
			out.println("<script>alert('UPDATE OK'); location.href='/board02?cmd=FIRSTLIST';</script>");
			out.flush();
		}
		
		//글삭제 CMD
		if(cmd.equals("DELETE")) { 
			String idx = request.getParameter("idx");
			System.out.println("idx="+idx);

			//데이터 삭제
			BoardDao02 dao= new BoardDao02();
			dao.deleteBoard(idx);

			//삭제 후 글 목록으로 페이지 이동 
			String link = "/board02?cmd=FIRSTLIST"; 
			request.getRequestDispatcher(link).forward(request, response);

		}
	}

}
