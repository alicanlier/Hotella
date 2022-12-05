package org.vision.hotel.servicemember;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.vision.hotel.common.Constant;
import org.vision.hotel.common.IService;
import org.vision.hotel.model.HotelBoardDao;
import org.vision.hotel.model.HotelMember;
import org.vision.hotel.model.HotelMemberDao;

public class M_JoinService implements IService {
	private HotelMemberDao dao;
	SqlSession sqlSession = Constant.sqlSession;

	@Override
	public void execute(Model model) {
		dao = sqlSession.getMapper(HotelMemberDao.class);
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HotelMember aman = null;
		HotelMember dto = new HotelMember();
		String id = request.getParameter("id");
		try {
			// id가 중복되는지 확인하는 코드
			aman = dao.select(id);// 존재하지 않으면 예외가 발생되고
			//System.out.println("id: "+aman.getId());
			if(aman.equals(null)) {
				throw new Exception();
			}
			System.out.println("같은 아이디가 이미 존재합니다.");
			
			return;
		} catch (Exception e) {
			dto.setId(id);

			dto.setPass(request.getParameter("pass"));
			dto.setEmail(request.getParameter("email"));
			dto.setTel(request.getParameter("tel"));
			dto.setAge(request.getParameter("age"));
			dto.setJob(request.getParameter("job"));
			dto.setHobby(request.getParameter("hobby"));

			try {
				dao.insert(dto);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			

//		} catch (NullPointerException | SQLException e) {
//			dto.setId(id);
//
//			dto.setPass(request.getParameter("pass"));
//			dto.setEmail(request.getParameter("email"));
//			dto.setTel(request.getParameter("tel"));
//			dto.setAge(request.getParameter("age"));
//			dto.setJob(request.getParameter("job"));
//			dto.setHobby(request.getParameter("hobby"));
//
//			try {
//				dao.insert(dto);
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}

	}

}
