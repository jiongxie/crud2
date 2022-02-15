package com.spring.pfb.service;

import java.util.List;

import com.spring.pfb.vo.BoardVo;
import com.spring.pfb.vo.MemberVo;

public interface BoardService {


	public BoardVo getBoardContent(int idx);

	public BoardVo getPasswordCheck(int idx, String pwd);

	public void getBoardDelete(int idx);

	public void setBoardUpdate(BoardVo vo);

	public int totBoardRecCnt();

	public List<BoardVo> getBoardList(int startNo, int pageSize);

	public void setBoardInput(BoardVo vo);

	public MemberVo getAPasswordCheck(String mid, String pwd);

}
