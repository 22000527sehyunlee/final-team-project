package com.mycom.myapp.board;

import java.util.List;

public interface BoardService {
	public int insertBoard(BoardVO vo); 
	public int deleteBoard(int no); 
	public int updateBoard(BoardVO vo); 
	public BoardVO getBoard(int no); 
	public List<BoardVO> getBoardList();
}
