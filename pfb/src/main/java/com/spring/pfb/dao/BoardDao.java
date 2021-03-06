package com.spring.pfb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.pfb.vo.BoardVo;
import com.spring.pfb.vo.MemberVo;

public interface BoardDao {


	public BoardVo getBoardContent(@Param("idx") int idx);

	public BoardVo getPasswordCheck(@Param("idx") int idx,@Param("pwd") String pwd);

	public void getBoardDelete(@Param("idx") int idx);

	public void setBoardUpdate(@Param("vo") BoardVo vo);

	public int totBoardRecCnt();

	public List<BoardVo> getBoardList(@Param("startNo") int startNo,@Param("pageSize") int pageSize);

	public void setBoardInput(@Param("vo") BoardVo vo);

	public MemberVo getAPasswordCheck(@Param("mid") String mid,@Param("pwd") String pwd);

}
