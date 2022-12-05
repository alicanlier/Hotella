package org.vision.hotel.serviceboard;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.vision.hotel.common.Constant;
import org.vision.hotel.common.IService;
import org.vision.hotel.model.HotelBoard;
import org.vision.hotel.model.HotelBoardDao;
public class B_ModifyService implements IService {
	private SqlSession sqlSession = Constant.sqlSession;
	@Override
	public void execute(Model model) {
		// TODO 상세보기에서 수정 버튼을 눌렀을 때 해야하는 작업
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = 
				(HttpServletRequest)map.get("request");
		HotelBoardDao dao = sqlSession.getMapper(HotelBoardDao.class);
		int num = Integer.parseInt(request.getParameter("num"));
//		String password = request.getParameter("password");
		HotelBoard vo = null;
	
		try {
			vo = dao.select(num);
			
//			if(!password.equals(vo.getPassword())){
//				System.out.println("패스워드가 틀려 수정 하지 않습니다.");
//				return;
//			}
			
			String writer = request.getParameter("writer");
//			String email = request.getParameter("email");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			// 수정폼에서 새로이 읽어온 값으로 대체 함 
			vo.setWriter(writer);
//			vo.setEmail(email);
			vo.setSubject(subject);
			vo.setContent(content);
			// 
			dao.update(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
