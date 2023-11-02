package org.track_by_daylight.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.track_by_daylight.models.SurvivorAddOn;
import org.track_by_daylight.models.SurvivorPerk;
import org.track_by_daylight.models.Trial;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SurvivorPerkJdbcTemplateRepositoryTest {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    SurvivorPerkRepository repository;

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
        List<SurvivorPerk> survivorPerks = repository.findAll();

        assertTrue(survivorPerks.size() >= 2);
        assertTrue(survivorPerks.stream()
                .anyMatch(o -> o.getSurvivorPerkId() == 1 && o.getSurvivorId() == 1));
    }

    @Test
    void shouldFindById() {
        List<SurvivorPerk> survivorPerks = repository.findPerkBySurvivorId(1);

        assertTrue(survivorPerks.size() ==4);
        assertTrue(survivorPerks.stream()
                .anyMatch(o -> o.getSurvivorId() == 1 && o.getPerk().getPerkName().equals("Ace in the Hole")));
    }

}