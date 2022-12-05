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
import org.vision.hotel.model.Hotel;
import org.vision.hotel.model.HotelDao;

//spring-test 사용
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class JDBCTest {
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
