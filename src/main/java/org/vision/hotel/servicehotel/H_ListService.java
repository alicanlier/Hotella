package org.vision.hotel.servicehotel;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.vision.hotel.common.Constant;
import org.vision.hotel.common.IService;
import org.vision.hotel.model.Hotel;
import org.vision.hotel.model.HotelDao;

public class H_ListService implements IService {

	private HotelDao dao;
	SqlSession sqlSession = Constant.sqlSession;
	
	@Override
	public void execute(Model model) {
		int category = 0;
		try {
			Map<String,Object> map = model.asMap();
			category = (int) map.get("category");
		} catch (Exception e1) {
			category = 0;
		} 
		
		try {
			dao = sqlSession.getMapper(HotelDao.class);
			String type = "";
			List<Hotel> list = null;
			switch(category) {
			case 3:
				type="★★★";
				list = dao.listByCategory(3);
				break;
			case 4:
				type="★★★★";
				list = dao.listByCategory(4);
				break;
			case 5:
				type="★★★★★";
				list = dao.listByCategory(5);
				break;
			default:
				type="All";
				list = dao.selectAll();
			}
			model.addAttribute("list",list);
			model.addAttribute("type",type);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
