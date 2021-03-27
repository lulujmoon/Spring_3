package com.redbeet.s3.account;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.redbeet.s3.member.MemberDTO;

@Controller
@RequestMapping(value="/account/**")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="accountList")
	public void getList(HttpSession session, Model model) throws Exception {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setId(((MemberDTO)session.getAttribute("member")).getId());
		List<AccountDTO> ar = accountService.getList(accountDTO);
		model.addAttribute("list", ar);
	}

	@RequestMapping(value="accountOpen")
	public String setInsert(AccountDTO accountDTO, HttpSession session) throws Exception {
		accountDTO.setId(((MemberDTO)(session.getAttribute("member"))).getId());
		
		int result = accountService.setInsert(accountDTO);
		
		return "redirect:./accountList";
	}
}
