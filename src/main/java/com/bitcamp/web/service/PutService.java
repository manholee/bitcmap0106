package com.bitcamp.web.service;

import org.springframework.stereotype.Service;

//FunctionInter.. 는 람다
//RestPull 방식으로 변환하였음!
@Service @FunctionalInterface
public interface PutService {
	//add하고 똑같다. 딜리트도 똑같은데 교육상 따로 함 합쳐도 가능
	public void put(Object o);
}
