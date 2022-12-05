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

public class R_DeleteService implements IService {

	private HotelReserveDao dao;
	SqlSession sqlSession = Constant.sqlSession;
	@Override
	public void execute(Model model) {
		dao = sqlSession.getMapper(HotelReserveDao.class);
		Map<String,Object> map = model.asMap();
		int regno = (Integer) map.get("regno");
		
				
		try {
			dao.reserveCancel(regno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Reservation deleted. Regno:"+regno);

	}


}
