package co.za.bbd.UkukhuluBursaryAPI.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.za.bbd.UkukhuluBursaryAPI.model.Tester;

@Repository
public class TesterRepoImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(Tester tester) {
        return jdbcTemplate.update("INSERT INTO tester (feels, working, push) VALUES(?,?,?)",
                new Object[] { tester.getFeels(), tester.getWorking(), tester.getPush() });
    }


    
}
