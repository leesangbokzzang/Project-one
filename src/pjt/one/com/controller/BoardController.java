package pjt.one.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pjt.one.com.dao.BoardDao;
import pjt.one.com.vo.BoardListVo;


@WebServlet("/board")
public class BoardController extends HttpServlet {
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
		
		if(cmd.equals("FISRTLIST")) { //메인리스트 CMD
			BoardDao dao= new BoardDao();
			List<BoardListVo> boardList = dao.getBoardList();
			
			//System.out.println(boardList); 리스트 불러오기 확인 ->OK!
			request.setAttribute("boardList", boardList);
			
			String link = "/view/list.jsp";
			request.getRequestDispatcher(link).forward(request, response);
		}
		
		if(cmd.equals("BOARDWRITEFORM")) { //새글쓰기 CMD
			String link = "/view/write.jsp"; // 
			request.getRequestDispatcher(link).forward(request, response);
		}
			
		if(cmd.equals("BOARDWRITE")) {	
			String title= request.getParameter("title");
			String cont= request.getParameter("cont");
			
			cont=cont.replace("<", "&lt;");
			cont=cont.replace(">", "&gt;");
			
			
			BoardDao dao=new BoardDao();
			dao.InsertBoared(title, cont);
			
		


		 String link = "/board?cmd=FISRTLIST"; 
		 request.getRequestDispatcher(link).forward(request, response);
		

		}
		
		
		
		if(cmd.equals("BOARDREAD")) { //게시글읽기 CMD
			String idx = request.getParameter("IDX");
			BoardDao dao= new BoardDao();
			BoardListVo vo = dao.getBoardRead(idx);
			request.setAttribute("vo", vo);
			
			String link = "/view/read.jsp";
			request.getRequestDispatcher(link).forward(request, response);
		}
		if(cmd.equals("EDIT")) { //글수정 CMD
			request.setCharacterEncoding("utf-8");
			
			String idx = request.getParameter("idx");
			
			BoardDao dao = new BoardDao();
			BoardListVo listViewOne = dao.getListViewOne(idx);
			
			request.setAttribute("listViewOne", listViewOne);
			
			String link = "/view/edit.jsp";
			request.getRequestDispatcher(link).forward(request, response);
		}
		if(cmd.equals("BOARDUPDATE")){
			request.setCharacterEncoding("utf-8");
			
			String idx = request.getParameter("idx");
			String title = request.getParameter("title");
			String cont = request.getParameter("cont");
			
			
			BoardDao dao = new BoardDao();
			dao.BoardUpdate(idx, title, cont);
			
			PrintWriter out = response.getWriter();
			
			response.setContentType("text/html; charset=UTF-8");
			out.println("<script>alert('UPDATE OK'); location.href='/board?cmd=FISRTLIST';</script>");
			out.flush();
		}
		if(cmd.equals("DELETE")) { //글삭제 CMD
			//삭제는 페이지 없어요 여기에 바로 코딩하시면됩니다
		}
	}

}
