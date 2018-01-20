package com.bitcamp.web.service;

import org.springframework.stereotype.Service;

@Service @FunctionalInterface
public interface PostService {
	
	public void post(Object o);
}
