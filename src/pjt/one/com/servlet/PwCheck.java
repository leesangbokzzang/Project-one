package pjt.one.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pwcheck")
public class PwCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pwcheck(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pwcheck(request,response);
	}
	private void pwcheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String html = "<b";
		String in_pw = request.getParameter("in_pw");
		String in_pw_reg = "^(?=.*[0-9])(?=.*[a-z]).{7,15}$";	//영문 + 숫자까지, 8~15자
		//(?=.*[A-Z])대문자 (?=.*\\W) 특수문자
		boolean pw_reg = in_pw.matches(in_pw_reg);
		if (pw_reg==false) {
			html += " class='red' >영문+숫자 포함 8~15자";
			html += "</b>";
		} else {
			html += " class='blue' >사용 가능한 비밀번호 입니다";
			html += "</b>";
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(html);
		out.flush();
		out.close();
	}

}
