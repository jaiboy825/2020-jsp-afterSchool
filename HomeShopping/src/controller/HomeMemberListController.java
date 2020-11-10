package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HomeMemberDao;
import vo.MemberVO;

public class HomeMemberListController implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HomeMemberDao dao = new HomeMemberDao();

		ArrayList<MemberVO> list = dao.getList();

		req.setAttribute("list", list);
		req.getRequestDispatcher("/view/memberList.jsp").forward(req, resp);
	}
}
