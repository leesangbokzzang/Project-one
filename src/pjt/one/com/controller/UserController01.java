package pjt.one.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		if(cmd.equals("LOGINFORM")) {
			String referer = request.getHeader("Referer");
			request.setAttribute("referer", referer);
			String path = "/view01/loginform.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}
		
		if(cmd.equals("LOGIN")) {
			String in_id = request.getParameter("in_id");
			String in_pw = request.getParameter("in_pw");
			String referer = request.getParameter("referer");
			UserDao01 userDao = new UserDao01();
			UserListVo userVo = userDao.loginCheck(in_id, in_pw);
			System.out.println(userVo);
			System.out.println(userVo.getUser_id());
			
			if(userVo.getUser_id().equals(in_id)) {
				//로그인 성공 시 (user_id)
				HttpSession session = request.getSession();
				session.setAttribute("user_id", userVo.getUser_id());		//여기서 vo값 세션에 저장, 배열값으로 저장 가능한지?아니면 각각?
				session.setAttribute("user_name", userVo.getUser_name());
				String cookie = request.getParameter("idrmb");
				if(cookie!=null) {
					Cookie c = new Cookie("idsave", in_id);
					c.setComment("아이디 저장");
					// 쿠키 유효기간을 설정한다. 초단위 : 60*60*24= 1일
				    c.setMaxAge(60*60*30);
				    // 응답헤더에 쿠키를 추가한다.
				    response.addCookie(c);
				} else {
					Cookie c = new Cookie("idsave", "");
					c.setComment("아이디 저장");
					c.setMaxAge(60*60*30);
					response.addCookie(c);
				}
				response.setContentType("text/html; charset=UTF-8");
				String path = referer.substring(referer.lastIndexOf("/"));
				request.getRequestDispatcher(path).forward(request, response);
//				String path = "/board01?cmd=FIRSTLIST";
//				request.getRequestDispatcher(path).forward(request,response);
//				 PrintWriter out = response.getWriter();
//				 out.println("<script> history.go(-2); </script>");
//				 out.flush();
			} else {
				//로그인 실패 시 (user_id + incorrect)
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('로그인에 실패했습니다'); location.href='javascript:history.go(-1);'</script>");
				out.flush();
			}
		}
		if(cmd.equals("LOGOUT")) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그아웃 되었습니다'); location.href='../index.jsp'</script>");
			out.flush();
		}
	}

}
