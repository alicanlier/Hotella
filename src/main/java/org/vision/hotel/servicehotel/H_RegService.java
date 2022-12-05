package org.vision.hotel.servicehotel;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.vision.hotel.common.Constant;
import org.vision.hotel.common.IService;
import org.vision.hotel.model.HotelMember;
import org.vision.hotel.model.HotelMemberDao;
import org.vision.hotel.model.Hotel;
import org.vision.hotel.model.HotelDao;

public class H_RegService implements IService {
	
	private HotelDao dao;
	SqlSession sqlSession = Constant.sqlSession;
	@Override
	public void execute(Model model) {
		dao = sqlSession.getMapper(HotelDao.class);
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		Hotel dto = new Hotel();
		dto.setName(request.getParameter("name"));
		dto.setCategory(Integer.parseInt(request.getParameter("category")));
		dto.setPrice(Integer.parseInt(request.getParameter("price")));
		dto.setUsepeople(Integer.parseInt(request.getParameter("usepeople")));
		dto.setAddress(request.getParameter("address"));
		dto.setPhone(request.getParameter("phone"));
		dto.setImg(request.getParameter("img"));
				
		try {
			dao.insert(dto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
