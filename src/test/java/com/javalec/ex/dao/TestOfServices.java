package com.javalec.ex.dao;


import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.vision.hotel.model.HotelBoard;
import org.vision.hotel.model.HotelBoardDao;
import org.vision.hotel.serviceboard.B_ReplyService;
import org.vision.hotel.servicereserve.R_RegService;
import org.vision.hotel.servicemember.M_JoinService;
import org.vision.hotel.servicehotel.H_DeleteService;
//===============================================
// Test case 만들기(4가지 조건을 총족 시킬것)
// 1. public 2. void 3. 매개변수 없어야
// 4. 다른테스트케이스에 영향을 주기 않을 것
// ===============================================
public class TestOfServices {
	private Object sqlSession;

	@Test
	public void execute() {
		B_ReplyService service = new B_ReplyService();
		service.execute(Model model);
		
		HotelBoardDao dao = ((Object) sqlSession).getMapper(HotelBoardDao.class);
		HotelBoard vo = new HotelBoard();
		vo.setWriter(writer);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setRef(ref);
		vo.setRe_step(re_step);
		vo.setRe_level(re_level);		
		
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int ref = Integer.parseInt(request.getParameter("ref"));
		System.out.println(ref);
		}
	}
	
	@Test
	public void 게시글보기() {
		BDao dao = new BDao();
		dao.setIsRunMode(false);
		BDto dto = dao.contentView("1");
		assertTrue(dto!=null);
		System.out.println(dto==null);
	}
	
	@Test //failure test 게시글보기가 제대로 실패하느냐
	public void 게시글보기실패테스트() {
		BDao dao = new BDao();
		dao.setIsRunMode(false);
		BDto dto = dao.contentView("11111");
		assertTrue(dto==null);
		System.out.println(dto==null);
	}
	

	
}
