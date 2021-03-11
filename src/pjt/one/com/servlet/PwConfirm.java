package pjt.one.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pwconfirm")
public class PwConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pwConfirm(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pwConfirm(request, response);
	}
	private void pwConfirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String in_pw = request.getParameter("in_pw");
		String in_pw_cf = request.getParameter("in_pw_cf");
		//System.out.println(in_pw + " : " +in_pw_cf ); 넘어온 값 확인
		String html = "<b";
		if (in_pw.equals(in_pw_cf)) {
			html += " class='blue' >비밀번호 확인 완료";
			html += "</b>";
		} else {
			html += " class='red' >비밀번호를 확인해 주세요";
			html += "</b>";
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(html);
		out.flush();
		out.close();
	}

}
