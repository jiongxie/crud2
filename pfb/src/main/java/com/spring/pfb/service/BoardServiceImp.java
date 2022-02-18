package com.spring.pfb.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.pfb.dao.BoardDao;
import com.spring.pfb.vo.BoardVo;
import com.spring.pfb.vo.MemberVo;

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

	@Override
	public void setBoardInput(MultipartHttpServletRequest mfile, BoardVo vo) {

		try {
			List<MultipartFile> fileList = mfile.getFiles("file");
			String oFileNames = "";
			String saveFileNames = "";
			int fileSizes = 0;
			
			for(MultipartFile file : fileList) {
				String oFileName = file.getOriginalFilename();
				String saveFileName = saveFileName(oFileName);
				
				writeFile(file, saveFileName);
				
				oFileNames += oFileName + "/";
				saveFileNames += saveFileName + "/";
						
			  }
					vo.setFname(oFileNames);
					vo.setRfname(saveFileNames);
					
					boardDao.setBoardInput(vo);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		

	private String saveFileName(String oFileName) {
		String fileName = "";
		
		Calendar calendar = Calendar.getInstance();
		fileName += calendar.get(Calendar.YEAR);
		fileName += calendar.get(Calendar.MONTH);
		fileName += calendar.get(Calendar.DATE);
		fileName += calendar.get(Calendar.HOUR);
		fileName += calendar.get(Calendar.SECOND);
		fileName += calendar.get(Calendar.MILLISECOND);
		fileName += "-" + oFileName;
				
				 return fileName;
	}
	
	
	private void writeFile(MultipartFile file, String saveFileName) throws IOException {
	
		byte[] data = file.getBytes();
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		
		String uploadPath = request.getSession().getServletContext().getRealPath("/resources/bfile/");
		
		FileOutputStream fos = new FileOutputStream(uploadPath + saveFileName);
		fos.write(data);
		
		fos.close();
	}
	
	
	
	@Override
	public MemberVo getAPasswordCheck(String mid, String pwd) {

		return boardDao.getAPasswordCheck(mid, pwd);
	}

}
