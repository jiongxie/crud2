package com.spring.pfb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.pfb.dao.BoardDao;
import com.spring.pfb.vo.BoardVo;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	BoardDao boardDao;
	

	@Override
	public BoardVo getBoardContent(int idx) {

		return boardDao.getBoardContent(idx);
	}

	@Override
	public BoardVo getPasswordCheck(int idx, String pwd) {

		return boardDao.getPasswordCheck(idx, pwd);
	}

	@Override
	public void getBoardDelete(int idx) {

		boardDao.getBoardDelete(idx);
	}

	@Override
	public void setBoardUpdate(BoardVo vo) {
		
		boardDao.setBoardUpdate(vo);
	}

	@Override
	public int totBoardRecCnt() {

		return boardDao.totBoardRecCnt();
	}

	@Override
	public List<BoardVo> getBoardList(int startNo, int pageSize) {

		return boardDao.getBoardList(startNo, pageSize);
	}

}
