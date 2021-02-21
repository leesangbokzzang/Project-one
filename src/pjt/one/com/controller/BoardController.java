package pjt.one.com.controller;

import java.io.IOException;
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
		
		String cmd = request.getParameter("cmd");
		if(cmd.equals("FISRTLIST")) {
			BoardDao dao= new BoardDao();
			List<BoardListVo> list = dao.getBoardList();
			
			String link = "/view/list.jsp";
			request.getRequestDispatcher(link).forward(request, response);
		}
		
		
	}

}
