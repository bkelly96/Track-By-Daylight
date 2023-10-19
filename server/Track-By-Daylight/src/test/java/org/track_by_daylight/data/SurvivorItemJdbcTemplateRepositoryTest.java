package org.track_by_daylight.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.track_by_daylight.models.SurvivorAddOn;
import org.track_by_daylight.models.SurvivorItem;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SurvivorItemJdbcTemplateRepositoryTest {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    SurvivorItemRepository repository;

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
        List<SurvivorItem> survivorItems = repository.findAll();

        assertTrue(survivorItems.size() >= 2);
        assertTrue(survivorItems.stream()
                .anyMatch(o -> o.getSurvivorId() == 1 && o.getSurvivorItemId() == 1));
    }
}