package com.redbeet.s3.board.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.redbeet.s3.board.BoardDTO;
import com.redbeet.s3.member.MemberDTO;
import com.redbeet.s3.util.OldPager;
import com.redbeet.s3.util.Pager;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="noticeList")
	public String getList(Model model, Pager pager) throws Exception {

		List<BoardDTO> li = noticeService.getList(pager);
		model.addAttribute("list", li);
		model.addAttribute("pager", pager);
		model.addAttribute("board", "notice");
		return "board/boardList";
	}
	
	@RequestMapping(value="noticeSelect")
	public String getSelect(BoardDTO boardDTO, Model model) throws Exception {
		boardDTO = noticeService.getSelect(boardDTO);
		model.addAttribute("post", boardDTO);
		model.addAttribute("board", "notice");
		return "board/boardSelect";
	}
	
	@GetMapping(value="noticeInsert")
	public ModelAndView setInsert() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardInsert");
		mv.addObject("board", "notice");
		
		return mv;
	}
	
	@RequestMapping(value="noticeInsert", method=RequestMethod.POST)
	public String setInsert(BoardDTO boardDTO, Model model, MultipartFile[] files ) throws Exception {
		
		for(MultipartFile mf: files) {
			System.out.println(mf.getOriginalFilename());
		}
		
		int result = noticeService.setInsert(boardDTO, files);
		String msg = "입력 실패";
		String path = "./noticeInsert";
		if(result>0) {
			msg = "입력 성공";
			path = "./noticeList";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("path", path);
		
		return "common/commonResult";
	}
	
	@RequestMapping(value="noticeUpdate")
	public String setUpdate(BoardDTO boardDTO, Model model) throws Exception {
		boardDTO = noticeService.getSelect(boardDTO);
		model.addAttribute("post", boardDTO);
		model.addAttribute("board", "notice");
		return "board/boardUpdate";
	}
	
	@RequestMapping(value="noticeUpdate", method=RequestMethod.POST )
	public ModelAndView setUpdate(NoticeDTO noticeDTO, ModelAndView mv) throws Exception {
		int result = noticeService.setUpdate(noticeDTO);
		if(result>0) {
			mv.setViewName("redirect:./noticeSelect?num="+noticeDTO.getNum());
		}else {
			mv.addObject("path", "./noticeSelect?num=\"+noticeDTO.getNum()");
			mv.addObject("msg", "수정 실패");
			mv.setViewName("common/commonResult");
		}

		return mv;
	}
	
	@RequestMapping(value="noticeDelete", method=RequestMethod.POST)
	public String setDelete(NoticeDTO noticeDTO, HttpSession session) throws Exception {
		if(session.getAttribute("member")!=null) {
				noticeService.setDelete(noticeDTO);
		}
		
		return "redirect:./noticeList";
	}
	
	@RequestMapping(value="insertCheck")
	public void insertCheck() throws Exception {
		
	}
	
}
