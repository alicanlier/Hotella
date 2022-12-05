package org.vision.hotel;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.vision.hotel.common.Constant;
import org.vision.hotel.common.IService;
import org.vision.hotel.model.Hotel;
import org.vision.hotel.model.HotelDao;
import org.vision.hotel.servicehotel.H_DeleteService;
import org.vision.hotel.servicehotel.H_ListService;
import org.vision.hotel.servicehotel.H_RegService;
import org.vision.hotel.servicemember.M_JoinService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/hotel/*")
public class H_Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(H_Controller.class);
	IService service;
	HotelDao dao;
	SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		Constant.sqlSession = this.sqlSession;
		dao = sqlSession.getMapper(HotelDao.class);
		
	}

	@RequestMapping("list")
	public String list(Model model) {
		service = new H_ListService(); 
		service.execute(model);
		return "/hotel/hotellist";
	}
	
	@RequestMapping("/regForm")
	public String regForm(Model model) {
		System.out.println("regForm()");
		return "/hotel/regForm";
	}
	@RequestMapping("/registHotel")
	public String registHotel(Model model,HttpServletRequest request) {
		service = new H_RegService();
		System.out.println("registHotel() 실행");
		model.addAttribute("request", request);
		service.execute(model);
		return "redirect:list";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		// 서비스를 이용하지 않고 직접 삭제한 예 
		System.out.println("delete() 실행");
		
		int no = Integer.parseInt(request.getParameter("no"));
		try {
			dao.delete(no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:list";
	
	}


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("차량등록관련 앱입니다. The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("message","차량등록관련 앱입니다.");
		return "home";
	}
	
}
