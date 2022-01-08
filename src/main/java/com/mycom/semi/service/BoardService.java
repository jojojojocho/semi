package com.mycom.semi.service;

import com.mycom.semi.domain.Board;

import com.mycom.semi.repository.BoardRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public class BoardService {


    private final BoardRepository boardRepository;


    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Long write(Board board){
        Board post1=boardRepository.save(board);
        return post1.getId();
    }


    public List<Board> postList(){
        return boardRepository.postList();
    }



}
