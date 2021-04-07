package com.redbeet.s3.member;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "memberJoin")
	public String memberJoin() throws Exception {
		return "member/memberJoin";
	}
	
	@RequestMapping(value="memberJoin", method=RequestMethod.POST)
	public String memberJoin(MemberDTO memberDTO, Model model, MultipartFile avatar, HttpSession session) throws Exception {
		int result = memberService.memberJoin(memberDTO, avatar, session);
		System.out.println(avatar.getName());
		System.out.println(avatar.getOriginalFilename());
		System.out.println(avatar.getSize());
		System.out.println(avatar.isEmpty());
		
		Random random = new Random();
		result = random.nextInt(2);
		String path = "./memberJoin";
		String msg = "회원가입 실패";
		if(result>0) {
			msg="회원가입 성공";
			path = "../";
		}
		
		model.addAttribute("path", path);
		model.addAttribute("msg", msg);
		return "common/commonResult";
	}
	
	@RequestMapping(value="memberLogin")
	public String memberLogin() throws Exception {
		return "member/memberLogin";
	}
	
	@RequestMapping(value="memberLogin", method= RequestMethod.POST)
	public String memberLogin(MemberDTO memberDTO, HttpSession session) throws Exception {
		memberDTO = memberService.memberLogin(memberDTO);
		
		String re = "";
		if(memberDTO!=null) {
			re="redirect:../";
		}else {
			re="redirect:./memberLogin";
		}
		session.setAttribute("member", memberDTO);
		
		return re;
	}
	
	@RequestMapping("memberLogout")
	public String memberLogout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:../";
	}
	
	@RequestMapping("memberPage")
	public String memberPage() throws Exception {
		return "member/memberPage";
	}
	
	@RequestMapping("memberDelete")
	public String memberDelete(HttpSession session) throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		int result = memberService.memberDelete(memberDTO);
		String re = "redirect:./memberPage";
		if(result==1) {
		System.out.println("삭제 완료");
		re="redirect:../";
		session.invalidate();
		}
		return re;
	}
	
	@RequestMapping(value="memberUpdate")
	public String memberUpdate() throws Exception {
		return "member/memberUpdate";
	}
	
	@RequestMapping(value="memberUpdate", method=RequestMethod.POST)
	public String memberUpdate(HttpSession session, MemberDTO memberDTO) throws Exception {
		int result = memberService.memberUpdate(memberDTO);
		session.setAttribute("member", memberDTO);
		String re="./memberPage";
		if(result==1) {
			System.out.println("수정 완료");
			re="redirect:../";
		}
		return re;
	}
	
	@RequestMapping(value="memberJoinCheck")
	public void memberJoinCheck() throws Exception {
		
	}
	
}
