package com.mycom.semi;

import com.mycom.semi.repository.BoardRepository;
import com.mycom.semi.repository.JpaBoardRepository;
import com.mycom.semi.service.BoardService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

     private final DataSource dataSource;
     private final EntityManager em;
     public SpringConfig(DataSource dataSource, EntityManager em) {
         this.dataSource = dataSource;
         this.em = em;
    }


//    private final DataSource dataSource;
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    @Bean
    public BoardService boardService(){
        return new BoardService(boardRepository());
    }

    @Bean
    public BoardRepository boardRepository(){
        return new JpaBoardRepository(em);
//        return new JDBCBoardRepository(dataSource);

   }




}
