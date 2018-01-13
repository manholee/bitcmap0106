package com.bitcamp.web.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bitcamp.web.domain.Board;
import com.bitcamp.web.domain.Member;

//Mapper는 Repo
@Repository
public interface Mapper {
	// return type = resultType
	public Member selectMember(Member member);
	public List<Member> selectMembers();
	public List<Member> selectMemberByName(Member member);
	public int countMember();
	public void insertMember(Member member);
	public void updateMember(Member member);
	public void deleteMember(Member member);
	
	public Board selectArticle(Board board);
	public List<Board> selectArticles();
	public List<Board> selectArticleByName(Board board);
	public int countArticle();
	public void insertArticle(Board board);
	public void updateArticle(Board board);
	public void deleteArticle(Board board);	

}
