package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HomeMemberDao;
import vo.MemberVO;

public class HomeMemberUpdateController implements Controller{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 파라미터 추출 -> 모델에게 일 시키고 -> 결과받으면 -> view 출력
		int custno = Integer.parseInt(req.getParameter("custno"));
		String custname = req.getParameter("custname");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		Date joindate = Date.valueOf(req.getParameter("joindate"));
		String grade = req.getParameter("grade");
		String city = req.getParameter("city");

		// DB연동
		MemberVO member = new MemberVO();
		
		//MODEL에게 일 시키기
		HomeMemberDao dao = new HomeMemberDao();
		member.setCustno(custno);
		member.setCustname(custname);
		member.setPhone(phone);
		member.setAddress(address);
		member.setJoindate(joindate);
		member.setGrade(grade);
		member.setCity(city);
		int n = dao.updateMember(member);
		
		if(n > 0) {
			req.setAttribute("ok", "회원정보수정이 완료 되었습니다!.");
			req.getRequestDispatcher("/view/memberInsert.jsp").forward(req, resp);
			
		}
		
	}

}
