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

//spring-test 사용
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class TestOfHotelReserveDao {
	@Autowired
	private SqlSession sqlSession;
	private HotelReserveDao dao;
	
	@Before
	public void init() {
		System.out.println("start test...");
		dao = sqlSession.getMapper(HotelReserveDao.class);
	}
	@Test
	public void connectionTest() {
		try {
			List<RESERVE_VIEW> list = dao.getReserveViewData("hgd");
			System.out.println(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void batchTest() {
//		RentMember a = new RentMember("hgd", "1234","hgd@naver.com","010-2323-3232","20대","실업자","보드,서핑,바둑,컴퓨터게임");
//		RentMember b = new RentMember("hgs", "1234","hgs@naver.com","010-2323-4343","10대","학생","바느질,걸래빨기,요리");
//		List<RentMember> list = Arrays.asList(a,b);
//		
//		try {
//			dao.batch(list);
//			RentMember res1 = dao.select("hgd");
//			RentMember res2 = dao.select("hgs");
//			assertEquals(res1,a);
//			assertEquals(res2,b);
//			//------------
//			dao.delete("hgd");
//			dao.delete("hgs");
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		
		
	}
	
	
	@After
	public void tearDown() {
		System.out.println("bye~~~~~~~~");
	}
}
