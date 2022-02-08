package com.spring.pfb;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.pfb.pagination.PageVo;
import com.spring.pfb.pagination.Pagination;
import com.spring.pfb.service.BoardService;
import com.spring.pfb.vo.BoardVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	Pagination pagination;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {
		
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
	
}
