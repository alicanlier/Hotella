package org.vision.hotel.servicemember;

import java.sql.SQLException;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.vision.hotel.common.Constant;
import org.vision.hotel.common.IService;
import org.vision.hotel.model.HotelMember;
import org.vision.hotel.model.HotelMemberDao;

public class M_ListService implements IService {
	
	private HotelMemberDao dao;
	SqlSession sqlSession = Constant.sqlSession;
	
	@Override
	public void execute(Model model) {
		try {
			System.out.println("ListService 실행");
			dao = sqlSession.getMapper(HotelMemberDao.class);
			//HashMap<String,RentMember> map = dao.selectAll();
			model.addAttribute("list",dao.selectAll());
			System.out.println("ListService 실행 end");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
