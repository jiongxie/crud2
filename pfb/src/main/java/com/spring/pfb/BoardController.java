package com.spring.pfb;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.pfb.pagination.PageVo;
import com.spring.pfb.pagination.Pagination;
import com.spring.pfb.service.BoardService;
import com.spring.pfb.vo.BoardVo;

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
		
		return "board/bList";
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
	
	
	
}
