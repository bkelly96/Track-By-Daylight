package org.track_by_daylight.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.track_by_daylight.models.KillerOffering;
import org.track_by_daylight.models.SurvivorOffering;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class KillerOfferingJdbcTemplateRepositoryTest {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    KillerOfferingRepository repository;

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
        List<KillerOffering> killerOfferings = repository.findAll();

        assertTrue(killerOfferings.size() >= 2);
        assertTrue(killerOfferings.stream()
                .anyMatch(o -> o.getKillerOfferingId() == 1 && o.getKillerId() == 1));
    }
}