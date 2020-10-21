package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDAO;
import vo.EmpVO;

/**
 * Servlet implementation class InsertEmp
 */
@WebServlet("/InsertEmp")
public class InsertEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertEmp() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// emp 테이블에 사원정보 저장하라고 지시, 성공하면 홤녀에 목록을 출력
		request.setCharacterEncoding("utf-8");

		EmpVO vo = new EmpVO();
		vo.setName(request.getParameter("name"));
		vo.setAge(Integer.parseInt(request.getParameter("age")));
		vo.setScore(Integer.parseInt(request.getParameter("score")));

		EmpDAO biz = new EmpDAO();
		int n = biz.insertEmp(vo);
		if (n > 0) {
			response.sendRedirect("/listEmp");
		} else {
			response.sendRedirect("/index.jsp");
		}

	}

}
