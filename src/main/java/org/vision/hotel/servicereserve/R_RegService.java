package org.vision.hotel.servicereserve;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.vision.hotel.common.Constant;
import org.vision.hotel.common.IService;
import org.vision.hotel.model.HotelReserve;
import org.vision.hotel.model.HotelReserveDao;
import org.vision.hotel.model.Hotel;
import org.vision.hotel.model.HotelDao;

public class R_RegService implements IService {

	private HotelReserveDao dao;
	SqlSession sqlSession = Constant.sqlSession;
	@Override
	public void execute(Model model) {
		dao = sqlSession.getMapper(HotelReserveDao.class);
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HotelReserve vo = (HotelReserve) map.get("reserveVo");
		
		System.out.println("RegService execute");
				
		try {
			dao.insert(vo);
			
			System.out.println("dao.insert");
			
			int regno = dao.getCurrval();
			model.addAttribute("currval",regno);
			model.addAttribute("reserveVo", vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
