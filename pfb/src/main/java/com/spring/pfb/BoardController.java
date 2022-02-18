package com.spring.pfb;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mysql.cj.Session;
import com.spring.pfb.pagination.PageVo;
import com.spring.pfb.pagination.Pagination;
import com.spring.pfb.service.BoardService;
import com.spring.pfb.vo.BoardVo;
import com.spring.pfb.vo.MemberVo;

@Controller
@RequestMapping("/board")
public class BoardController {

	String msgFlag = "";
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	Pagination pagination;
	
	@RequestMapping(value="/bList", method=RequestMethod.GET)
	public String bListGet(Model model, HttpServletRequest request) {
		
		int totRecCnt = boardService.totBoardRecCnt();
		int pag = request.getParameter("pag")==null ? 1 : Integer.parseInt(request.getParameter("pag"));
		int pageSize = request.getParameter("pageSize") == null? 5 : Integer.parseInt(request.getParameter("pageSize"));
		
		
		PageVo pageVo = pagination.pagination(pag, pageSize);
		
		List<BoardVo> vos = boardService.getBoardList(pageVo.getStartNo(), pageSize);
		model.addAttribute("vos", vos);
		model.addAttribute("pageVo", pageVo);
		
		System.out.println("pageVo.blockSize: " + pageVo.getBlockSize());
		System.out.println("pageVo.totPage: " + pageVo.getTotPage());
		System.out.println("curScrNo : " + pageVo.getCurScrNo());
		
		return "board/bList";
	}
	
	
	@RequestMapping(value="/bInput", method=RequestMethod.GET)
	public String bInputGet(HttpServletRequest request, Model model) {
		
		int totRecCnt = boardService.totBoardRecCnt();
		int pag = request.getParameter("pag") == null ? 1 : Integer.parseInt(request.getParameter("pag"));
		int pageSize = request.getParameter("pageSize") == null ? 5 : Integer.parseInt(request.getParameter("pageSize"));
			
		PageVo pageVo = pagination.pagination(pag, pageSize);
		
		model.addAttribute("pageVo", pageVo);
		
		return "board/bInput";
	}
	
	
	@RequestMapping(value="/bInput", method=RequestMethod.POST)
	public String bInputPost(BoardVo vo, Model model, MultipartHttpServletRequest mfile, HttpServletRequest request) {
		
		int totRecCnt = boardService.totBoardRecCnt();
		int pag = request.getParameter("pag") == null ? 1 : Integer.parseInt(request.getParameter("pag"));
		int pageSize = request.getParameter("pageSize") == null ? 5 : Integer.parseInt(request.getParameter("pageSize"));
		
		PageVo pageVo = pagination.pagination(pag, pageSize);
		
		
		boardService.setBoardInput(mfile, vo);
		System.out.println("파일업로드단");
		model.addAttribute("pageVo", pageVo);
		
		msgFlag = "bInputOk$pag="+pag+"&pageSize="+pageSize;
		
		
		
		
		return "redirect:/msg/" + msgFlag;
	}
	
	
	
	
	@RequestMapping(value="/bContent", method=RequestMethod.GET)
	public String bContentGet(HttpServletRequest request, Model model) {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		int totRecCnt = boardService.totBoardRecCnt();
		int pag = request.getParameter("pag") == null ? 1 : Integer.parseInt(request.getParameter("pag"));
		int pageSize = request.getParameter("pageSize") == null? 5 : Integer.parseInt(request.getParameter("pageSize"));
		
		PageVo pageVo = pagination.pagination(pag, pageSize);
		
		
		BoardVo vo = boardService.getBoardContent(idx);
		
		model.addAttribute("vo", vo);
		model.addAttribute("pageVo", pageVo);
		
		return "board/bContent";
	}
	
	
	@RequestMapping(value="/bDelete", method=RequestMethod.GET)
	public String bDeleteGet(HttpServletRequest request, int pag, int pageSize) {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String pwd = request.getParameter("pwd");
		
		BoardVo pvo = boardService.getPasswordCheck(idx, pwd);
		
		if(pvo == null) {
			
			msgFlag = "bPwdNo$idx="+idx;
		}
		else {
			boardService.getBoardDelete(idx);
			System.out.println("pag : " + pag);
			System.out.println("pageSize : " + pageSize);
			msgFlag = "bDeleteOk$pag="+ pag+"&pageSize="+pageSize;
		}
		
		
		
		
		return "redirect:/msg/" + msgFlag;
	}
	
	@RequestMapping(value="/bUpdate", method=RequestMethod.GET)
	public String bUpdateGet(HttpServletRequest request, Model model, int pag, int pageSize) {
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		BoardVo vo = boardService.getBoardContent(idx);
		
		model.addAttribute("vo", vo);
		
		
		return "board/bUpdate";
	}
	
	@RequestMapping(value="/bUpdate", method=RequestMethod.POST)
	public String bUpdatePost(BoardVo vo, HttpServletRequest request,int pag, int pageSize) {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String pwd = request.getParameter("pwd");
		
		BoardVo pvo = boardService.getPasswordCheck(idx, pwd);
		
		if(pvo == null) {
			msgFlag = "bPwdNo$idx="+idx;
			
		}
		else {
			boardService.setBoardUpdate(vo);
			System.out.println("pag : " + pag);
			System.out.println("pageSize : " + pageSize);
			msgFlag = "bUpdateOk$pag="+pag+"&pageSize="+pageSize;
			
		}
		
		return "redirect:/msg/" + msgFlag;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/bADelete", method=RequestMethod.GET)
	public int baDeleteGet(int idx) {
		
		
		boardService.getBoardDelete(idx);
		System.out.println("ajax idx : " + idx);
		
		return 1;
	}
	
	
	@RequestMapping(value="bLogin", method=RequestMethod.GET)
	public String bLoginGet() {
		
		
		
		return "board/bLogin";
	}
	

	
	@RequestMapping(value="bLogin", method=RequestMethod.POST)
	public String bLoginPost(HttpServletRequest request, HttpSession session) {
		
		String mid = request.getParameter("mid");
		String pwd = request.getParameter("pwd");
		
		
		MemberVo pvo = boardService.getAPasswordCheck(mid, pwd);
		
		if(pvo == null) {
			
			msgFlag = "baLoginNo";
		}
		else {
			session.setAttribute("mid", mid);
			msgFlag = "baLoginOk";
			
		}
		
		
		return "redirect:/msg/" + msgFlag;
	}
	
	@RequestMapping(value="bLogout", method=RequestMethod.GET)
	public String bLogoutGet(HttpSession session, HttpServletRequest request, Model model) {
		System.out.println("세션 인밸리대이트1	");
		int totRecCnt = boardService.totBoardRecCnt();
		int pag = request.getParameter("pag") == null ? 1 : Integer.parseInt(request.getParameter("pag"));
		int pageSize = request.getParameter("pageSize") == null? 5 : Integer.parseInt(request.getParameter("pageSize"));
		
		
		PageVo pageVo = pagination.pagination(pag, pageSize);
		List<BoardVo> vos = boardService.getBoardList(pageVo.getStartNo(), pageSize);
		model.addAttribute("vos", vos);
		model.addAttribute("pageVo", pageVo);
		System.out.println("pageVo.blockSize: " + pageVo.getBlockSize());
		System.out.println("pageVo.totPage: " + pageVo.getTotPage());
		System.out.println("curScrNo : " + pageVo.getCurScrNo());
		session.invalidate();
		System.out.println("세션 인밸리대이트2");
		return "board/bList";
	}
	
	
}
