package org.vision.hotel.serviceboard;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.vision.hotel.common.Constant;
import org.vision.hotel.common.IService;
import org.vision.hotel.model.HotelBoardDao;

public class B_DeleteService implements IService {
	
	private HotelBoardDao dao;
	SqlSession sqlSession = Constant.sqlSession;

	@Override
	public void execute(Model model) {
		dao = sqlSession.getMapper(HotelBoardDao.class);
		Map<String,Object> map = model.asMap();
		int num = (Integer) map.get("num");
		
		try {
			dao.delete(num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
