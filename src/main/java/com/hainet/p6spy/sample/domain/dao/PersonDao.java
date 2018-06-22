package com.hainet.p6spy.sample.domain.dao;

import com.hainet.p6spy.sample.domain.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class PersonDao {

    private /*final*/ JdbcTemplate jdbcTemplate;

    @Autowired
    void setJdbcTemplate(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public Person findById(final int id) {
        return this.jdbcTemplate.queryForObject(
                "SELECT * FROM person WHERE id = ?",
                new BeanPropertyRowMapper<>(Person.class),
                id
        );
    }

//    public String getPersonNameById(final int id) {
//        // Executing callable statement
//
//        final SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withFunctionName("GET_PERSON_NAME");
//        final Map<String, Object> params = new HashMap<>();
//        params.put("id", id);
//        //params.put("p_name", "John");
//        //params.put("p_age", 28);
//        //params.put("p_salary", 150000);
//
//        final Map<String, Object> result = simpleJdbcCall.execute(params);
//        //System.out.println(result.get("returnvalue"));
//
//        return new Person(); result.get("returnvalue").toString();

//        return this.jdbcTemplate.queryForObject(
//                "select * from ",
//
//        );
//    }


}
