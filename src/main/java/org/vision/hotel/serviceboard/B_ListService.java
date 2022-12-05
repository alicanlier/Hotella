package org.vision.hotel.serviceboard;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.vision.hotel.common.Constant;
import org.vision.hotel.common.IService;
import org.vision.hotel.model.HotelBoardDao;

public class B_ListService implements IService {
	private HotelBoardDao dao;
	SqlSession sqlSession = Constant.sqlSession;
	@Override
	public void execute(Model model) {
		dao = sqlSession.getMapper(HotelBoardDao.class);
		try {
			model.addAttribute("list", dao.selectAll());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
