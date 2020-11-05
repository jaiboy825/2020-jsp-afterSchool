package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.MemberVO;

public class MemberSearchController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//파라미터 추출 -> 모델에게 일 시키고 -> 결과받으면 -> view 출력
		String id = req.getParameter("id");
		String job = req.getParameter("job");
		String path = null;
		
		if(job.equals("search")) {
			path = "/view/memberSearch.jsp";
		}else if(job.equals("update")) {
			path = "/view/memberUpdate.jsp";
		}
		//유효성 체크
		if(id.isEmpty()) {
			req.setAttribute("error", "ID를 입력해주시기 바랍니다.");
			req.getRequestDispatcher(path).forward(req, resp);
			return;
		}
		//DB연동
		MemberDao dao = new MemberDao();
		MemberVO member = dao.searchMember(id);
		
		//출력페이지 설정
		if(member == null) {
			req.setAttribute("error", "검색된 정보가 없습니다");
		}
		req.setAttribute("member", member);
		if(job.equals("search")) 
			path = "/view/memberSearchOutput.jsp";
		
		
		req.getRequestDispatcher(path).forward(req, resp);
		
		
	}
	

}
