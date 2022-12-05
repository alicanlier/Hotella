package org.vision.hotel.serviceboard;

import java.sql.SQLException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.vision.hotel.common.Constant;
import org.vision.hotel.common.IService;
import org.vision.hotel.model.HotelBoard;
import org.vision.hotel.model.HotelBoardDao;
public class B_ContentService implements IService {

	private HotelBoardDao dao;
	private SqlSession sqlSession = Constant.sqlSession;
	
	@Override
	public void execute(Model model) {
		// TODO 목록의 제목을 클릭했을 때 보여줄 상세내용을 위한 서비스 
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpSession session = request.getSession();
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("B_ContentService is executed.");

		dao = sqlSession.getMapper(HotelBoardDao.class);
		try {
			dao.upHit(num);
			HotelBoard dto = dao.select(num);
			model.addAttribute("content",dto);
			model.addAttribute("request",request);
//			model.addAttribute("model_writer",dto.getWriter());
//			session.setAttribute("writer",dto.getWriter());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
