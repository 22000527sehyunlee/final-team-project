package com.mycom.myapp.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class BoardController{
	
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/board/add", 
			method = RequestMethod.GET) 
	public String addPost() { 
		return "addpostform"; 
	}
	
	@RequestMapping(value = "/board/addok", method = RequestMethod.POST)
	public String addPostOK(BoardVO vo) {
		int i = boardService.insertBoard(vo);
		if(i == 0)
			System.out.println(" 데이터 추가 실패");
		else
			System.out.println(" 데이터 추가 성공 !!!");
		return "redirect:add";
	}
	
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String boardlist(Model model) {
		model.addAttribute("list",boardService.getBoardList());
		return "list";
	}
	
	
}