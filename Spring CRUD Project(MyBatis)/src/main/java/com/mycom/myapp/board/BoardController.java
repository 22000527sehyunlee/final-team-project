package com.mycom.myapp.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.myapp.board.BoardVO;
import com.mycom.myapp.user.UserVO;


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
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String boardlist(Model model) {
		model.addAttribute("list",boardService.getBoardList());
		return "list";
	}
	
	@RequestMapping(value = "/board/editok", method = RequestMethod.GET)
	public String editPostOK(BoardVO vo) {
		int i = boardService.updateBoard(vo);
		if(i == 0)
			System.out.println(" 데이터 업데이트 실패");
		else
			System.out.println(" 데이터 업데이트 성공 !!!");
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/board/deleteok/{id}/{writer}", method = RequestMethod.GET)
	public  String deletePost(HttpSession session, @PathVariable("id") int id, @PathVariable("writer") String writer) {
		UserVO user = (UserVO) session.getAttribute("login");
		if(user != null && user.getUserid().equals(writer)) {
			int i = boardService.deleteBoard(id);
			if(i == 0)
				System.out.println(" 데이터 삭제 실패");
			else
				System.out.println(" 데이터 삭제 성공 !!!");
			return "redirect:/board/list";
		}
		else {
			return "redirect:/board/list";
		}
	}
	
	@RequestMapping(value = "/board/editpost/{id}/{writer}", method = RequestMethod.GET)
	public String editPost(HttpSession session, @PathVariable("id") int id,@PathVariable("writer") String writer,Model model) {
		UserVO user = (UserVO) session.getAttribute("login");
		session.setAttribute("editNo", id);
		if(user != null && user.getUserid().equals(writer)) {
			return "editform";
		}
		else {
			return "redirect:/board/list";
		}
	}
	
	
}