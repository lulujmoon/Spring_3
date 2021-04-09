package com.redbeet.s3.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.redbeet.s3.board.BoardDTO;
import com.redbeet.s3.util.OldPager;
import com.redbeet.s3.util.Pager;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	
	@GetMapping(value="qnaList")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = qnaService.getList(pager);
		mv.addObject("list", ar);
		mv.addObject("board", "qna");
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");

		
		return mv;
	}
	
	@GetMapping(value="qnaInsert")
	public ModelAndView setInsert(BoardDTO boardDTO, Model model) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardInsert");
		mv.addObject("board", "qna");
		
		return mv;
	}
	
	//setInsert post 버전도 만들기
	@PostMapping(value="qnaInsert")
	public String setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		
		qnaService.setInsert(boardDTO, files);
		return "redirect:./qnaList";
	}
	
	@GetMapping(value="qnaUpdate")
	public String setUpdate(Model model, BoardDTO boardDTO) throws Exception {
		boardDTO = qnaService.getSelect(boardDTO);
		model.addAttribute("board", "qna");
		model.addAttribute("post", boardDTO);
		return "board/boardUpdate";
	}
	
	@PostMapping(value="qnaUpdate")
	public ModelAndView setUpdate(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setUpdate(boardDTO);
		if(result>0) {
			mv.setViewName("redirect:./qnaList");
		}else {
			mv.addObject("path", "./qnaList");
			mv.addObject("msg", "수정 실패");
			mv.setViewName("common/commonResult");
		}
		return mv;
	}
	
	@GetMapping(value="qnaSelect")
	public ModelAndView getSelect(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = qnaService.getSelect(boardDTO);
		mv.addObject("post", boardDTO);
		mv.addObject("board", "qna");
		mv.setViewName("board/boardSelect");
		return mv;
	}
	
	@PostMapping(value="qnaDelete")
	public ModelAndView setDelete(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.setDelete(boardDTO);
		
		String msg = "삭제 실패";
		String path = "./qnaList";
		
		if(result>0) {
			msg = "삭제 성공";
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path", path);
		mv.setViewName("common/commonResult");
		return mv;
	}
	

	@GetMapping("qnaReply")
	public ModelAndView setReply(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardReply");
		mv.addObject("board", "qna");
		return mv;
	}
	
	@PostMapping("qnaReply")
	public ModelAndView setReply(QnaDTO qnaDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		qnaService.setReply(qnaDTO);
		mv.setViewName("redirect:./qnaList");
		return mv;
	}
	

}
