package com.mycom.semi.repository;

import com.mycom.semi.domain.Board;


import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class JpaBoardRepository implements BoardRepository{

    private final EntityManager em;

    public JpaBoardRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Board save(Board board) {
        String formatedNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
        board.setTime(formatedNow);
        em.persist(board);
        return board;
    }

    @Override
    public List<Board> postList() {
        return em.createQuery("select b from Board b", Board.class)
                .getResultList();
    }
}
