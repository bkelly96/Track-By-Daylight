package org.track_by_daylight.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.track_by_daylight.models.Trial;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TrialJdbcTemplateRepositoryTest {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    TrialRepository repository;

    static boolean hasRun = false;

    @BeforeEach
    void setup() {
        if (!hasRun) {
            jdbcTemplate.update("call set_known_good_state();");
            hasRun = true;
        }
    }

    @Test
    void shouldFindAll() {
        List<Trial> trials = repository.findAll();

        Date currentDate = new Date(3000,12,12);

        assertTrue(trials.size() >= 2);
        assertTrue(trials.stream()
                .anyMatch(o -> o.getTrialId() == 1 && o.getDate().before(currentDate)));
    }

    @Test
    void shouldFindById() {
        List<Trial> trials = repository.findByUserId(1);

        Date currentDate = new Date(3000,12,12);

        assertTrue(trials.size() ==1);
        assertTrue(trials.stream()
                .anyMatch(o -> o.getTrialId() == 1 && o.getDate().before(currentDate)));
    }

    @Test
    void shouldFindByUsername(){

        String username = "john@smith.com";

        List<Trial> trials = repository.findByUsername(username);

        Date currentDate = new Date(3000,12,12);

        assertTrue(trials.size() ==1);
        assertTrue(trials.stream()
                .anyMatch(o -> o.getTrialId() == 1 && o.getDate().before(currentDate)));
    }
}