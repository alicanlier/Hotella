package org.vision.hotel;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.vision.hotel.model.HotelBoard;
import org.vision.hotel.model.HotelBoardDao;

//spring-test 사용
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

public class TestOfHotelBoardDao {
	@Autowired
	private SqlSession sqlSession;
	private HotelBoardDao dao;
	@Before
	public void init() {
		System.out.println("start test...");
		dao = sqlSession.getMapper(HotelBoardDao.class);
	}
	@Test
	public void connectionTest() {
		try {
			List<HotelBoard> list = dao.selectAll();
			System.out.println(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@After
	public void tearDown() {
		System.out.println("bye~~~~~~~~");
	}
}
