package org.track_by_daylight.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.track_by_daylight.models.Survivor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SurvivorJdbcTemplateRepositoryTest {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    SurvivorRepository repository;

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
        List<Survivor> survivors = repository.findAll();

        assertTrue(survivors.size() >= 2);
        assertTrue(survivors.stream()
                .anyMatch(o -> o.getSurvivorId() == 1 && o.getSurvivorName().equals("Dwight Fairfield")));
    }

    @Test
    void findSurvivorByTrialId() {
        List<Survivor> survivors = repository.findSurvivorByTrialId(1);

        assertTrue(survivors.size() == 4);
        assertTrue(survivors.stream()
                .anyMatch(o -> o.getSurvivorId() == 1 && o.getSurvivorName().equals("Dwight Fairfield")));
    }

}