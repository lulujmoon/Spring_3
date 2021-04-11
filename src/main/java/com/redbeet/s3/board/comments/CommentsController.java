package com.redbeet.s3.board.comments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/comments/")
public class CommentsController {

	@Autowired
	private CommentsService commentsService;
	
	// /comments/commentList
	
	@GetMapping(value="commentsList")
	public void getList(CommentsDTO commentsDTO, Model model) throws Exception {
		System.out.println(commentsDTO.getNum());
		List<CommentsDTO> li = commentsService.getList(commentsDTO);
		model.addAttribute("list", li);
	}
	
	@PostMapping("commentsInsert")
	public ModelAndView setInsert(CommentsDTO commentsDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = commentsService.setInsert(commentsDTO);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	@PostMapping("commentsDelete")
	public ModelAndView commentsDelete(int [] commentsNum) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result=0;
		for(int n:commentsNum) {
			CommentsDTO commentsDTO = new CommentsDTO();
			commentsDTO.setCommentsNum(n);
			result = commentsService.setDelete(commentsDTO);
		}
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
}
