package org.vision.hotel;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import org.vision.hotel.model.HotelBoard;
import org.vision.hotel.model.HotelBoardDao;
import org.vision.hotel.model.RESERVE_VIEW;
import org.vision.hotel.serviceboard.B_ContentService;
import org.vision.hotel.serviceboard.B_DeleteService;
import org.vision.hotel.serviceboard.B_ListService;
import org.vision.hotel.serviceboard.B_ModifyService;
import org.vision.hotel.serviceboard.B_ReplyService;
import org.vision.hotel.serviceboard.B_ReplyViewService;
import org.vision.hotel.serviceboard.B_WriteService;


@Controller
@RequestMapping("/board/*")
public class B_Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(B_Controller.class);
	IService service;
	HotelBoardDao dao;
	SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		Constant.sqlSession = this.sqlSession;
		dao = sqlSession.getMapper(HotelBoardDao.class);
	}
	
	
	@RequestMapping("/reply")
	public String reply(Model model,HttpServletRequest request) {
		System.out.println("reply()");
		model.addAttribute("request", request);
		service = new B_ReplyService();
		service.execute(model);
			
		return "redirect:list";
	}


	@RequestMapping("/reply_view")
	public String reply_view(Model model,HttpServletRequest request) {
		System.out.println("reply_view() 실행");
		model.addAttribute("request", request);
		service = new B_ReplyViewService();
		service.execute(model);
		return "/board/reply_view";
	}
	
	
	
	@RequestMapping("/modify")
	public String modify(Model model,HttpServletRequest request) {
		System.out.println("modify url execute start");
		String memid="";
//		try {
			HttpSession session = request.getSession();
			memid=(String) session.getAttribute("id");
			if(memid==null) {
				System.out.println("modify url executing");
				return "/member/loginForm";
			}
			System.out.println("board modify() 실행");
			
			model.addAttribute("request", request);
			model.addAttribute("memid",memid);
			service = new B_ModifyService();
			service.execute(model);
			
			// 여기선 서비스를 이용해본다. 
//			int no = Integer.parseInt(request.getParameter("no"));
//			Hotel vo = dao.selectVO(no);
//			model.addAttribute("no",no);
//			model.addAttribute("memid",memid);
//			model.addAttribute("vo",vo);
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("modify url executed");
		return "redirect:list";
	}
	
	
	@RequestMapping(value ="/board_content_view", method = RequestMethod.GET)
	public String content_view(Model model,HttpServletRequest request) {
		System.out.println("board_content_view url 실행");
		model.addAttribute("request", request);
		service = new B_ContentService();
		service.execute(model);
		return "/board/board_content_view";
	}
	
	
	
	
	@RequestMapping("/boardwrite")
	public String write(Model model,HttpServletRequest request) 
			throws SQLException, IOException {
		System.out.println("boardwrite() 실행");
		model.addAttribute("request", request);
		service = new B_WriteService();
		service.execute(model);
		return "redirect:list";
	}
	
	
	
	@RequestMapping("/write_view")
	public String write_view(HttpServletRequest request,Model model) {
		
		String memid="";
		HttpSession session = request.getSession();
		memid=(String) session.getAttribute("id");
		if(memid==null) {
			return "/member/loginForm";
		}
		System.out.println("write_view()가 실행됩니다.");
		model.addAttribute("id",memid);

		return "/board/write_view";
	}
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request,Model model) {
//	public String list(Model model) {
//		service = new B_ListService();
//		service.execute(model);
//		model.addAttribute("message","호텔 보드 앱입니다.!");
//		return "/board/boardlist";
		// 서비스를 사용하지 않고 처리 해보겠습니다.
//		HttpSession session = request.getSession();
//		String memid = (String) session.getAttribute("id");
		try {
//			model.addAttribute("id",memid);
			model.addAttribute("list", dao.selectAll());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("list url executed");
		return "/board/boardlist";
	}

	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(Model model,HttpServletRequest request) {
		// 서비스를 이용하지 않고 직접 삭제한 예 
		System.out.println("board/delete() 실행");
		service = new B_DeleteService();
		int num = Integer.parseInt(request.getParameter("num"));
		model.addAttribute("num", num);
		service.execute(model);
	
		return "redirect:list";
	
	}
	
	
	@RequestMapping("/")
	public String home(Locale locale, Model model) {
		logger.info("렌트카 보드 입니다.! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("message","렌트카 보드 앱입니다.!");
		return "home";
	}
	
	
	
}
