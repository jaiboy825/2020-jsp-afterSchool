package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.MemberVO;

public class MemberUpdateController implements Controller{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라미터 추출 -> 모델에게 일 시키고 -> 결과받으면 -> view 출력
				String id = req.getParameter("id");
				String passwd = req.getParameter("passwd");
				String name = req.getParameter("name");
				String mail = req.getParameter("mail");

				// 유효성 체크
				if (id.isEmpty() || passwd.isEmpty() || name.isEmpty() || mail.isEmpty()) {
					req.setAttribute("error", "모든 항목을 빠짐없이 입력해주시기 바랍니다");
					req.getRequestDispatcher("/view/memberInsert.jsp").forward(req, resp);
				}
				
				// VO객체에 데이터 바인딩
				MemberVO member = new MemberVO();
				member.setId(id);
				member.setPasswd(passwd);
				member.setName(name);
				member.setMail(mail);
				
				//DB 연동
				MemberDao dao = new MemberDao();
				int n = dao.updateMember(member);
				
				if(n > 0) {
					req.setAttribute("id", id);
					req.getRequestDispatcher("/view/memberUpdateOutput.jsp").forward(req, resp);
					
				}else {
					req.setAttribute("error", "회원정보 수정 오류 입니다.");
					req.setAttribute("member", member);
					req.getRequestDispatcher("/view/memberUpdate.jsp").forward(req, resp);
				}

	}

}
