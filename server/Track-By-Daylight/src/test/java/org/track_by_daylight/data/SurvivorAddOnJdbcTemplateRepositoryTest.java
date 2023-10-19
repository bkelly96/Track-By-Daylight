package org.track_by_daylight.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.track_by_daylight.models.SurvivorAddOn;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SurvivorAddOnJdbcTemplateRepositoryTest {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    SurvivorAddOnRepository repository;

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
        List<SurvivorAddOn> survivorAddOns = repository.findAll();

        assertTrue(survivorAddOns.size() >= 2);
        assertTrue(survivorAddOns.stream()
                .anyMatch(o -> o.getSurvivorAddOnId() == 1 && o.getSurvivorId() == 1));
    }
}