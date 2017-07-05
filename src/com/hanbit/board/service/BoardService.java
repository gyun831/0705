package com.hanbit.board.service;

import com.hanbit.board.domain.BoardBean;

public interface BoardService {
	public void writeBoard(BoardBean board);
	public BoardBean[] Boardlist();
	public BoardBean findBySeq(int seq);
	public BoardBean[] findByWriter(String writer);
	public int count();
	public void updateContent(BoardBean board);
	public void delete(int seq);
	
}
