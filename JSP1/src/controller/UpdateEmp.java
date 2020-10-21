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
 * Servlet implementation class UpdateEmp
 */
@WebServlet(name = "updateEmp", urlPatterns = { "/updateEmp" })
public class UpdateEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//list.jsp에서 선택한 목혹 하나에 대한 정보를 update.jsp 화면에 출력
		request.setCharacterEncoding("utf-8");
		
		int num = Integer.parseInt(request.getParameter("num"));
		EmpDAO dao = new EmpDAO();
		EmpVO vo = dao.getEmp(num);
		
		if(vo == null) {
			response.sendRedirect("/list.jsp");
		}else {
			request.setAttribute("select_data", vo);
			request.getRequestDispatcher("/update.jsp").forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		EmpVO vo = new EmpVO();
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		vo.setName(request.getParameter("name"));
		vo.setAge(Integer.parseInt(request.getParameter("age")));
		vo.setScore(Integer.parseInt(request.getParameter("score")));
		
		EmpDAO dao = new EmpDAO();
		int n = dao.updateEmp(vo);
		if(n > 0)
			response.sendRedirect("/listEmp");
		else
			response.sendRedirect("update.jsp");
	}

}
