package com.spring.pfb.pagination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.pfb.dao.BoardDao;

@Service
public class Pagination {
	
	@Autowired
	BoardDao boardDao;
	
	public PageVo pagination(int pag, int pageSize) {
		
		int blockSize = 3;
		
		int totRecCnt = boardDao.totBoardRecCnt();
		
		
		PageVo pageVo = new PageVo();
		
		
		int totPage = (totRecCnt % pageSize) == 0 ? totRecCnt/pageSize : (int)(totRecCnt/pageSize) + 1;
		int startNo = (pag - 1) * pageSize;
		int curScrNo = totRecCnt - startNo;
		
		pageVo.setPag(pag);
		pageVo.setPageSize(pageSize);
		pageVo.setBlockSize(blockSize);
		pageVo.setTotRecCnt(totRecCnt);
		pageVo.setTotPage(totPage);
		pageVo.setStartNo(startNo);
		pageVo.setCurScrNo(curScrNo);
		
		
		
		
		return pageVo;
	}
	
}
