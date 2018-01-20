package com.bitcamp.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.web.domain.Board;
import com.bitcamp.web.mapper.Mapper;
import com.bitcamp.web.service.GetService;
import com.bitcamp.web.service.PostService;
import com.bitcamp.web.service.PutService;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	Board article; //이렇게 안할꺼면 자바 생성자로 전달해야 함
	@Autowired
	Mapper mapper;
	
	/// 이동시켜주는 페이지가 많아질때 >> move/{dir}/{page} 메소드 통합처리
	@RequestMapping(value="/move/{dir}/{page}", method=RequestMethod.GET)
	public String move(@PathVariable("dir") String dir, @PathVariable("page") String page, Model model) {
		logger.info("===move() IN===");
		return dir+ "/"+page;
	}
	//단순 페이지 이동 아닐떄는 별도로
	@RequestMapping(value="/move/board/update/{seq}", method=RequestMethod.GET)
	public String moveUpdate(@PathVariable("seq")String seq, Model model) {
		System.out.println("업데이트로 페이지 이동");
		int iSeq = Integer.parseInt(seq);
		article.setSeq(iSeq);
		GetService gs = (Object o) -> { return mapper.selectArticle(article);};
		article = (Board) gs.get(article);
		System.out.println("글 상세내역:" + article.toString());
		model.addAttribute("article", article);
		return "board/update";
	}
	
	@RequestMapping(value="/board/write", method=RequestMethod.POST)
	public String write(
			@RequestParam("title")String title, 
			@RequestParam("name")String name, 
			@RequestParam("message")String message, Model model) {
	
		logger.info("===TITLE IS {}===", title);
		logger.info("===TITLE IS {}===", name);
		logger.info("===TITLE IS {}===", message);
		
		article.setTitle(title);
		article.setId(name);
		article.setContent(message);
		//모바일 코딩 같이하는 법
		PostService ps = (Object o) -> 
		{mapper.insertArticle(article);};
		ps.post(article);
		System.out.println("#####최근 seq:"+article.getSeq());
		GetService gs = (Object o) -> { return mapper.selectArticle(article);};
		article = (Board) gs.get(article);
		System.out.println("글 상세내역:" + article.toString());
		model.addAttribute("article", article);
		return "board/detail";
	}
	
	@RequestMapping(value="/board/update", method=RequestMethod.POST)
	public String update(
			@RequestParam("title")String title, 
			@RequestParam("name")String name, 
			@RequestParam("message")String message, 
			@RequestParam("seq")String seq,
			Model model) {
		
		article.setTitle(title);
		article.setId(name);
		article.setContent(message);
		int iSeq = Integer.parseInt(seq);
		article.setSeq(iSeq);
		PutService ps = (Object o)-> {mapper.updateArticle(article);};
		ps.put(article);
		System.out.println("#####방금 수정한 seq:"+article.getSeq());		
		GetService gs = (Object o) -> {return mapper.selectArticle(article);};
		article = (Board) gs.get(article);
		System.out.println("#####글 상세 내역 seq:"+article.getSeq());
		model.addAttribute("article", article);
		
		model.addAttribute("article", article);
		return "board/detail";
	}

}