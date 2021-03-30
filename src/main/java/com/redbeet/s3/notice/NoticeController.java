package com.redbeet.s3.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.redbeet.s3.member.MemberDTO;
import com.redbeet.s3.util.Pager;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="noticeList")
	
	public void getList(Model model, Pager pager) throws Exception {

		List<NoticeDTO> li = noticeService.getList(pager);
		model.addAttribute("list", li);
		model.addAttribute("pager", pager);

	}
	
	@RequestMapping(value="noticeSelect")
	public void getSelect(NoticeDTO noticeDTO, Model model) throws Exception {
		noticeDTO = noticeService.getSelect(noticeDTO);
		model.addAttribute("post", noticeDTO);
	}
	
	@RequestMapping(value="noticeInsert")
	public void setInsert() throws Exception {
		
	}
	
	@RequestMapping(value="noticeInsert", method=RequestMethod.POST)
	public String setInsert(NoticeDTO noticeDTO) throws Exception {
		noticeService.setInsert(noticeDTO);
		return "redirect:./noticeList";
	}
	
	@RequestMapping(value="noticeUpdate")
	public void setUpdate(NoticeDTO noticeDTO, Model model, HttpServletRequest request) throws Exception {
		noticeDTO.setNum(Long.parseLong(request.getParameter("num")));
		noticeDTO = noticeService.getSelect(noticeDTO);
		model.addAttribute("notice", noticeDTO);
	}
	
	@RequestMapping(value="noticeUpdate", method=RequestMethod.POST )
	public String setUpdate(NoticeDTO noticeDTO, HttpServletRequest request) throws Exception {
		noticeService.setUpdate(noticeDTO);
		
		return "redirect:./noticeSelect?num="+noticeDTO.getNum();
	}
	
	@RequestMapping(value="noticeDelete")
	public String setDelete(NoticeDTO noticeDTO, HttpSession session) throws Exception {
		if(session.getAttribute("member")!=null) {
			if(((MemberDTO)(session.getAttribute("member"))).getId().equals("admin")) {
				noticeService.setDelete(noticeDTO);
			}
		}
		
		return "redirect:./noticeList";
	}
	
}
