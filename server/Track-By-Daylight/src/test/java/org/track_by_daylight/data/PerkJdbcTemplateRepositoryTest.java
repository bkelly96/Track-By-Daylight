package org.track_by_daylight.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.track_by_daylight.models.Offering;
import org.track_by_daylight.models.Perk;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PerkJdbcTemplateRepositoryTest {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    PerkRepository repository;

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
        List<Perk> perk = repository.findAll();

        assertTrue(perk.size() >= 2);
        assertTrue(perk.stream()
                .anyMatch(o -> o.getPerkId() == 1 && o.getPerkName().equals("Ace in the Hole")));
    }
}