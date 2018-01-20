package com.bitcamp.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.web.domain.Member;
import com.bitcamp.web.mapper.Mapper;
import com.bitcamp.web.service.GetService;

@RestController
public class AjaxController {
	private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);
	
	@Autowired Mapper mapper;
	@RequestMapping(value="/get/login")
	public Member login(@RequestBody Member member) {
		logger.info("=== Ajax-c: writeForm() IN===");
		logger.info("ID:" + member.getId());
		logger.info("PASS:" + member.getPw());
		
		//ajax 예시로 보여줬음. 다음부터는 jsp 조합으로
		// 람다처리, 모바일이랑 웹 동시 처리할떄 사용!
		//GetService g = (Object o) ->  { return mapper.selectMember(member);};
		//Member m = (Member) g.get(member);
		
		return (Member) new GetService() {
		
			@Override
			public Object get(Object o) {
				
				return mapper.selectMember(member);
			}
		}.get(member);
	}
}
