package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import vo.BookVO;

/**
 * Servlet implementation class ListBookServlet
 */
@WebServlet(name = "LISTBOOK", urlPatterns = { "/listBook" })
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. BookDao에게 DB select 요청 -> 결과값을 attribute에 실어서 /book/booklist.jsp 출력
		BookDao biz = new BookDao();
		ArrayList<BookVO> list = biz.getBookList();
		
		if(list != null) {
			request.setAttribute("booklist", list);
			request.getRequestDispatcher("/book/bookList.jsp").forward(request, response);
		}
	}

}
