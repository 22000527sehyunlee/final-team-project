package com.mycom.myapp.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImple implements BoardService {
	
	@Autowired
	BoardDAO boardDAO; 
	
	@Override
	public int insertBoard(BoardVO vo) { 
		return boardDAO.insertBoard(vo); 
	} 
	@Override
	public BoardVO getBoard(int seq) { 
		return boardDAO.getBoard(seq); 
	} 
	@Override
	public List<BoardVO> getBoardList(){ 
		return boardDAO.getBoardList(); 
	}
	@Override
	public int deleteBoard(int no) {
		return boardDAO.deleteBoard(no);
	}
	@Override
	public int updateBoard(BoardVO vo) {
		return boardDAO.updateBoard(vo);
	}
	

}
