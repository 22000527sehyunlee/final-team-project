package com.mycom.myapp.board;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	public int insertBoard(BoardVO vo) {
		System.out.println(vo.getCategory());
		vo.setRegdate(new Date());
		vo.setRecom(0);
		return sqlSession.insert("BOARD.insertBoard",vo);
	}
	
	public int deleteBoard(int no) {
		return sqlSession.delete("BOARD.deleteBoard",no);
	}
	
	public int updateBoard(BoardVO vo) {
		return sqlSession.update("BOARD.updateBoard",vo);
	}
	
	public BoardVO getBoard(int no) {
		return sqlSession.selectOne("BOARD.getBoard",no);
	}
	
	
	public List<BoardVO> getBoardList(){
		List<BoardVO> list = sqlSession.selectList("BOARD.getBoardList");
		return list;
	}
}