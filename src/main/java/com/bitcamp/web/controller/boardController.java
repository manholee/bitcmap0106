package com.bitcamp.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class boardController {
	private static final Logger logger = LoggerFactory.getLogger(boardController.class);

	@RequestMapping(value="/board/write_form")
	public String writeForm() {
		logger.info("=== HomeController: writeForm() ENTER===");
		return "board/write";
	}
}
