package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArtistDAO;
import vo.ArtistVO;

public class InsertController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String artist_id = req.getParameter("artist_id");
		String artist_name = req.getParameter("artist_name");
		String artist_birth = req.getParameter("artist_birth");
		String artist_gender = req.getParameter("artist_gender");
		String talent = req.getParameter("talent");
		String agency = req.getParameter("agency");

		ArtistVO vo = new ArtistVO();

		vo.setArtist_id(artist_id);
		vo.setAgency(agency);
		vo.setArtist_birth(artist_birth);
		vo.setArtist_name(artist_name);
		vo.setTalent(talent);
		vo.setArtist_gender(artist_gender);
		ArtistDAO dao = new ArtistDAO();
		int n = dao.insertArtist(vo);
		if (n > 0) {
			req.getRequestDispatcher("/list.do").forward(req, resp);
		} else {
			
		}

	}

}
