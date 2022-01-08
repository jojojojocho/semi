package com.mycom.semi.repository;

import com.mycom.semi.domain.Board;


import java.util.List;

public interface BoardRepository {
    Board save(Board board);

    List<Board> postList();

}
