package com.mycom.semi.repository;

import com.mycom.semi.domain.Board;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCBoardRepository implements BoardRepository{
    private final JdbcTemplate jdbcTemplate;

    public JDBCBoardRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);

    }

    @Override
    public Board save(Board post) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("board").usingGeneratedKeyColumns("postnum");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", post.getName());
        parameters.put("title", post.getTitle());
        parameters.put("body", post.getBody());
        String formatedNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
        parameters.put("time", formatedNow);
        Number key = jdbcInsert.executeAndReturnKey(new
                MapSqlParameterSource(parameters));
        post.setId(key.longValue());
        return post;
    }

    @Override
    public List<Board> postList() {
        return jdbcTemplate.query("select * from board", memberRowMapper());
    }

    private RowMapper<Board> memberRowMapper() {
        return (rs, rowNum) -> {
            Board post = new Board();
            post.setId(rs.getLong("postnum"));
            post.setName(rs.getString("name"));
            post.setTitle(rs.getString("title"));
            post.setBody(rs.getString("body"));
            post.setTime(rs.getString("time"));
            return post;
        };
    }
}
