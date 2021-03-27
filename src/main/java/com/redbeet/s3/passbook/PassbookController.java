package com.redbeet.s3.passbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/passbook/**")
public class PassbookController {
	
	@Autowired
	private PassbookService passbookService;
	
	@RequestMapping("passbookList")
	public void getList(Model model) throws Exception {
		List<PassbookDTO> ar = passbookService.getList();
		model.addAttribute("list", ar);
	}
	
	@RequestMapping("passbookSelect")
	public ModelAndView getSelect(PassbookDTO passbookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		passbookDTO = passbookService.getSelect(passbookDTO);
		
		mv.addObject("dto", passbookDTO);
		mv.setViewName("passbook/passbookSelect");
		return mv;
	}
	
	@RequestMapping(value="passbookDelete")
	public String getDelete(PassbookDTO passbookDTO) throws Exception {
		System.out.println(passbookDTO.getNum());
		int result = passbookService.setDelete(passbookDTO);
		System.out.println(result);
		
		return "redirect:./passbookList";
	}
	
	@RequestMapping(value="passbookUpdate")
	public void setUpdate(PassbookDTO passbookDTO, Model model) throws Exception {
		passbookDTO = passbookService.getSelect(passbookDTO);
		model.addAttribute("dto", passbookDTO);
		
	}
	
	@RequestMapping(value="passbookUpdate", method=RequestMethod.POST)
	public String setUpdate(PassbookDTO passbookDTO) throws Exception {
		int result = passbookService.setUpdate(passbookDTO);
		return ("redirect:./passbookList");

	}
}
