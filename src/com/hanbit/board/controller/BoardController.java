package com.hanbit.board.controller;

import javax.swing.*;

import com.hanbit.board.domain.BoardBean;
import com.hanbit.board.serviceImpl.BoardServiceImpl;

public class BoardController {
	public static void main(String[]args){
		BoardServiceImpl service = new BoardServiceImpl();
		BoardBean board=null;
	while(true){
		switch(JOptionPane.showInputDialog("0.종료 1.게시글추가 2.게시글수 3.게시글목록 4.검색(작성자) 5.검색(글번호) 6.게시글수정 7.게시글삭제")){
			case "0":
				JOptionPane.showInternalMessageDialog(null, "종료");
				return;
			case "1":
				board = new BoardBean();
				String ar[] = JOptionPane.showInputDialog("작성자/제목/내용/날짜").split("/");
				board.setWriter(ar[0]);
				board.setTitle(ar[1]);
				board.setContent(ar[2]);
				board.setRegdate(ar[3]);
				service.writeBoard(board);
				JOptionPane.showMessageDialog(null, "게시글추가성공!");
				break;
			case "2":
				JOptionPane.showMessageDialog(null,service.count());
				break;
			case "3":
				JOptionPane.showMessageDialog(null,service.Boardlist());
				break;
			case "4":
				JOptionPane.showMessageDialog(null,service.findByWriter(JOptionPane.showInputDialog("작성자검색")));
				break;
			case "5":
				JOptionPane.showMessageDialog(null, service.findBySeq(Integer.parseInt(JOptionPane.showInputDialog("검색(글번호)"))));
				break;
			case "6":
				board = new BoardBean();
				String up[] = JOptionPane.showInputDialog("번호/내용").split("/");
				board.setSeq(Integer.parseInt(up[0]));
				board.setContent(up[1]);
				service.updateContent(board);
				JOptionPane.showMessageDialog(null, "수정완료");
				break;
			case "7":
				service.delete(Integer.parseInt(JOptionPane.showInputDialog("삭제할 글번호")));
				JOptionPane.showMessageDialog(null, "삭제완료");
				break;
			
			default:
				break;
			}
		}
	}
}
