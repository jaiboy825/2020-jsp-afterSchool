package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HomeMemberDao;
import vo.MemberMoneyVO;
import vo.MemberVO;

public class MemberMoneyListController implements Controller{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HomeMemberDao dao = new HomeMemberDao();

		ArrayList<MemberMoneyVO> list = dao.getMoneyList();

		req.setAttribute("list", list);
		req.getRequestDispatcher("/view/memberMoneyList.jsp").forward(req, resp);
		
	}

}
