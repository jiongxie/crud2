package com.spring.pfb.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.pfb.vo.BoardVo;
import com.spring.pfb.vo.MemberVo;

public interface BoardService {


	public BoardVo getBoardContent(int idx);

	public BoardVo getPasswordCheck(int idx, String pwd);

	public void getBoardDelete(int idx);

	public void setBoardUpdate(BoardVo vo);

	public int totBoardRecCnt();

	public List<BoardVo> getBoardList(int startNo, int pageSize);

	public void setBoardInput(MultipartHttpServletRequest mfile, BoardVo vo);

	public MemberVo getAPasswordCheck(String mid, String pwd);

}
