package com.spring.pfb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MsgController {

	@RequestMapping(value="/msg/{msgFlag}", method=RequestMethod.GET)
	public String MsgGet(@PathVariable String msgFlag, Model model) {
		
		
		
		if(msgFlag.equals("baLoginNo")) {
			model.addAttribute("msg", "관리자 로그인 실패하였습니다.");
			model.addAttribute("url", "board/bLogin");
		}
		if(msgFlag.equals("baLoginOk")) {
			model.addAttribute("msg", "관리자 로그인 성공");
			model.addAttribute("url", "board/bList");
		}
		if(msgFlag.substring(0, 9).equals("bDeleteOk")) {
			model.addAttribute("msg", "게시글이 삭제되었습니다.");
			model.addAttribute("url", "board/bList?"+msgFlag.substring(10));
		}
		if(msgFlag.substring(0, 9).equals("bUpdateOk")) {
			model.addAttribute("msg", "게시글이 업데이트되었습니다.");
			model.addAttribute("url", "board/bList?"+msgFlag.substring(11));
		}
		if(msgFlag.substring(0, 8).equals("bInputOk")) {
			model.addAttribute("msg", "게시글이 등록되었습니다..");
			model.addAttribute("url", "board/bList?"+msgFlag.substring(9));
		}
		else if(msgFlag.substring(0, 6).equals("bPwdNo")) {
			model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
			model.addAttribute("url", "board/bContent?"+msgFlag.substring(7));
		}
		
		
		
		return "include/msg";
	}
}
