package com.hainet.p6spy.sample.domain.dao;

import com.hainet.p6spy.sample.domain.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PersonDao {

    private final JdbcTemplate jdbcTemplate;

    public Person findById(final int id) {
        return this.jdbcTemplate.queryForObject(
                "SELECT * FROM person WHERE id = ?",
                new BeanPropertyRowMapper<>(Person.class),
                id
        );
    }


}
