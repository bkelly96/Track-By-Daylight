package org.track_by_daylight.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.track_by_daylight.models.Killer;
import org.track_by_daylight.models.KillerPerk;
import org.track_by_daylight.models.Survivor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class KillerJdbcTemplateRepositoryTest {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    KillerRepository repository;

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
        List<Killer> killers = repository.findAll();

        assertTrue(killers.size() >= 2);
        assertTrue(killers.stream()
                .anyMatch(o -> o.getKillerId() == 1 && o.getKillerName().equals("Chuckles")));
    }

    @Test
    void findKillerByTrialId() {
        List<Killer> killers = repository.findKillerByTrialId(1);

        assertTrue(killers.size() == 1);
        assertTrue(killers.stream()
                .anyMatch(o -> o.getKillerId() == 1 && o.getKillerName().equals("Chuckles")));
    }
}