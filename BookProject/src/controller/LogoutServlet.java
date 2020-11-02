package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.MemberVO;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet(name = "LOGOUT", urlPatterns = { "/logout" })
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 세션("loginOk") 제거한 뒤 처음화면 표시
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("loginOk");
		if(vo != null) {
			session.invalidate(); // or session.removeAttribute("loginOk")
			response.sendRedirect("/index.jsp");
		}
	}

}
