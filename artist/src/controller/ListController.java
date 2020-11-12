package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArtistDAO;
import vo.ArtistVO;

public class ListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArtistDAO biz = new ArtistDAO();
		ArrayList<ArtistVO> list = biz.getMemberList();
		
		
		
		if(list != null) {
			req.setAttribute("artistList", list);
			req.getRequestDispatcher("/view/artistList.jsp").forward(req, resp);
		}
		
		
	}

}
