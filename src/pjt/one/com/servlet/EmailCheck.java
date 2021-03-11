package pjt.one.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pjt.one.com.dao.UserDao01;

@WebServlet("/emailcheck")
public class EmailCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		emailCheck(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		emailCheck(request,response);
	}
	private void emailCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String html = "<b";
		String in_email1 = request.getParameter("in_email1");
		String in_email2 = request.getParameter("in_email2");
		String email = in_email1+"@"+in_email2;
		UserDao01 userDao = new UserDao01();
		boolean email_dup = userDao.getMailCheck(email);
		String check2 = "[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
		boolean email_reg = in_email2.matches(check2);
		
		if (email_reg==false) {
			html += " class='red' >이메일 주소 부적합";
			html += "</b>";
		} else if (email_dup==false) {
			html += " class='red' >이메일 주소 중복";
			html += "</b>";
		} else {
			html += " class='blue' >이메일 주소 확인";
			html += "</b>";
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(html);
		out.flush();
		out.close();
	}

}
