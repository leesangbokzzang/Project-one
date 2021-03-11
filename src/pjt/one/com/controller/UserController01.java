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
import pjt.one.com.dao.UserDao01;
import pjt.one.com.vo.BoardListVo;
import pjt.one.com.vo.UserListVo;

@WebServlet("/user")
public class UserController01 extends HttpServlet {
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
		if(cmd.equals("JOINFORM")) {
			String path = "/view01/join.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}
		if(cmd.equals("JOIN")) { 
			UserDao01 dao= new UserDao01();
			String in_id = request.getParameter("in_id");
			String in_pw = request.getParameter("in_pw");
			String in_name = request.getParameter("in_name");
			String in_gender = request.getParameter("in_gender");
			String in_tel = request.getParameter("telbox1")+"-"+request.getParameter("telbox2")+"-"+request.getParameter("telbox3");
			String in_addr = request.getParameter("in_addr1")+" "+request.getParameter("in_addr2");
			String in_email = request.getParameter("in_email1")+"@"+request.getParameter("in_email2");
			dao.insertUser(in_id,in_pw,in_name,in_gender,in_tel,in_addr,in_email);
			System.out.println("회원가입 전송완료");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('회원가입이 완료되었습니다'); location.href='../index.jsp'</script>");
			out.flush();
			
		}
	}

}
