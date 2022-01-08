package com.mycom.semi.controller;

import com.mycom.semi.domain.Board;
import com.mycom.semi.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }


    @GetMapping("board")
    public String Home(Model model){
        return "board/boardHome";
    }

    @GetMapping("board/write")
    public String writeForm(){
        return "board/write";
    }
    @PostMapping("board/save")
    public String writeSave(Board board){
//        Post newPost = new Post();
//        newPost.setTitle(post.getTitle());
//        newPost.setName(post.getName());
//        newPost.setTime(post.getTime());
        boardService.write(board);
        return "board/boardHome";
    }

    @GetMapping("board/boardlist")
    public String list(Model model){
        List<Board> board= boardService.postList();
        model.addAttribute("posts",board);
        return "board/boardList";
    }

}
