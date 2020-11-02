package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;
import vo.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "LOGIN", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. userid, userpwd 받아서 DB 내용과 비교하여 로그인 성공 여부 체크함.
		// 2. 록인 성공이면 "loginOk, MemberVO자료" 세션 추가 -> /login/loginOk.jsp 화면 출력
		// 실패이면 -> /login/loginFail.jsp 화면 출력
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String userId = request.getParameter("id");
		String userPwd = request.getParameter("pwd");

		LoginDao biz = new LoginDao();
		boolean result = biz.getLoginUser(userId, userPwd);
		MemberVO member = new MemberVO(userId, userPwd);
		if (result) {
			// login success
			HttpSession session = request.getSession();
			session.setAttribute("loginOk", member);
			response.sendRedirect("/login/loginOk.jsp");
		} else {
			response.sendRedirect("/login/loginFail.jsp");
		}

	}

}
