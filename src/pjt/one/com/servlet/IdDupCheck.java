package pjt.one.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pjt.one.com.dao.UserDao01;

@WebServlet("/idcheck")
public class IdDupCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		idcheck(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		idcheck(request,response);
	}
	private void idcheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String in_id = request.getParameter("in_id");
		
		String html = "<b";
		// 아이디 중복 확인
		UserDao01 userDao = new UserDao01();
		String result = userDao.getIdCheck(in_id);
		System.out.println(result);
		if (result.equals("false")) {
			html += " class='red' >사용 불가능";
			html += "</b>";
		} else {
			html += " class='blue' >사용 가능";
			html += "</b>";
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(html);
		out.flush();
		out.close();
	}

}
