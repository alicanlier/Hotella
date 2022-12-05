package org.vision.hotel;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.vision.hotel.common.Constant;
import org.vision.hotel.common.IService;
import org.vision.hotel.model.HotelMember;
import org.vision.hotel.model.HotelMemberDao;
import org.vision.hotel.servicemember.LoginService;
import org.vision.hotel.servicemember.M_JoinBatchService;
import org.vision.hotel.servicemember.M_JoinService;
import org.vision.hotel.servicemember.M_ListService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/member/*")
public class M_Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(M_Controller.class);
	IService service;
	SqlSession sqlSession;
	HotelMemberDao dao;
		
//	@Autowired
//	public void setSqlSession(SqlSession sqlSession) {
//		this.sqlSession = sqlSession;
//		Constant.sqlSession = this.sqlSession;
//	}
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		Constant.sqlSession = this.sqlSession;
		dao = sqlSession.getMapper(HotelMemberDao.class);
	}
	
	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("id", null);
		return "redirect:/";
	} 

	
	@RequestMapping("loginForm")
	public String login(Model model) {
		return "member/loginForm";
	} 
	
	@RequestMapping("loginProc")
	public String loginProc(Model model,HttpServletRequest request,HttpServletResponse response) {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
//		HttpSession session = request.getSession();
//		session.setAttribute("id",id);
//		session.setMaxInactiveInterval(60*30);//30분
//		model.addAttribute("request", request);
		String myway="";
		try {
			HotelMemberDao dao = sqlSession.getMapper(HotelMemberDao.class);
			HotelMember vo = dao.select(id);
			if(vo==null || !(vo.getPass().equals(pass))) {
				if(request.getParameter("cookieSave")!= null) {
					Cookie cookie = new Cookie("id",id);
					cookie.setMaxAge(60*60*24);//하루 
					response.addCookie(cookie);
				}
				myway =  "member/loginNg";
			}else {
				//myway =  "member/loginComplete";
				myway =  "redirect:/";
				HttpSession session = request.getSession();
				session.setAttribute("id",id);
				session.setMaxInactiveInterval(60*30);//30분
				model.addAttribute("request", request);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			myway =  "member/loginNg";
		}finally {
			return myway;
		}
	} 

	@RequestMapping("/writeForm")
	public String writeForm() {
		return "/member/writeForm";// writeForm.jsp 실행
	}
	
	@RequestMapping("/batchForm")
	public String batchForm() {
		return "/member/batchForm";// writeForm.jsp 실행
	}
	
	@RequestMapping("/join")
	public String join(Model model,HttpServletRequest request) {
		service = new M_JoinService();
		System.out.println("join() 실행");
		model.addAttribute("request", request);
		service.execute(model);
		return "redirect:/";
	}
	
	@RequestMapping("/joinBatch")
	public String joinBatch(Model model,HttpServletRequest request) {
		service = new M_JoinBatchService();
		System.out.println("joinBatch() 실행");
		model.addAttribute("request", request);
		service.execute(model);
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(Model model,HttpServletRequest request) {
		// 서비스를 이용하지 않고 직접 삭제한 예 
		System.out.println("delete() 실행");
		String id =request.getParameter("id");
		try {
			 System.out.println(id);
			 dao.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:list";
	
	}	
	

	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("member/list() 실행");
		service = new M_ListService();
		service.execute(model);
		System.out.println("member/list() 실행 end");		
		return "/member/list";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("회원등록관련 앱입니다. The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("message","회원등록관련 앱입니다.");
		return "home";
	}
	
}
