package org.vision.hotel;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.vision.hotel.model.RESERVE_VIEW;
import org.vision.hotel.model.HotelMember;
import org.vision.hotel.model.HotelMemberDao;
import org.vision.hotel.model.HotelReserve;
import org.vision.hotel.model.HotelReserveDao;
import org.vision.hotel.model.Hotel;
import org.vision.hotel.model.HotelDao;

//spring-test 사용
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class TestOfHotelDao {
	@Autowired
	private SqlSession sqlSession;
	private HotelDao dao;
	
	@Before
	public void init() {
		System.out.println("start test...");
		dao = sqlSession.getMapper(HotelDao.class);
	}
	@Test
	public void connectionTest() {
		try {
			List<Hotel> list = dao.selectAll();
			for(Hotel x:list) {
				System.out.println(x);
			}
			assertEquals(20,list.size());
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
