package com.hanbit.board.serviceImpl;

import com.hanbit.board.domain.BoardBean;
import com.hanbit.board.service.BoardService;

public class BoardServiceImpl implements BoardService {
	BoardBean board;
	BoardBean[] list;
	int seq;
	
	public BoardServiceImpl(){
		seq=0;
		board = new BoardBean();
		list = new BoardBean[seq];
	}
	@Override
	public void writeBoard(BoardBean board) {
		BoardBean[] temp = new BoardBean[seq+1];
		if(list.length==seq){
			System.arraycopy(list,0, temp,0,seq);
			list = temp;
		}
		board.setSeq(seq+1);
		list[seq]=board;
		seq++;
	}
	@Override
	public BoardBean[] Boardlist() {
		return list;
	}
	@Override
	public BoardBean findBySeq(int seq) {
		board = new BoardBean();
		for(int i=0; i<seq; i++){
			if(seq==list[i].getSeq()){
				board=list[i];
				break;
			}
		}
		return board;
	}
	@Override
	public BoardBean[] findByWriter(String writer) {
		int j=0;
		for(int i=0;i<seq;i++){
			if(writer.equals(list[i].getWriter())){
				j++;
			}
		}
		BoardBean[] find = new BoardBean[j];
		int k=0;
		for(int i=0;i<seq;i++){
			if(writer.equals(list[i].getWriter())){
				find[k]=list[i];
				k++;
			}
			if(j==k){
				break;
			}
		}
		return find;
	}
	@Override
	public int count() {
		return seq;
	}
	@Override
	public void updateContent(BoardBean board) {
		for(int i=0; i<seq; i++){
			if(board.getSeq()==list[i].getSeq()){
				list[i].setContent(board.getContent());
				break;
			}
		}
	}
	@Override
	public void delete(int num) {
		for(int i=0; i<seq; i++){
			if(num==list[i].getSeq()){
				list[i] = list[seq-1];
				list[seq-1]=null;
				seq--;
			}
		}
	}

}
