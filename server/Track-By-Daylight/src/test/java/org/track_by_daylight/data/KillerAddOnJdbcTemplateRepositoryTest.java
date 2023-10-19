package org.track_by_daylight.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.track_by_daylight.models.Killer;
import org.track_by_daylight.models.KillerAddOn;
import org.track_by_daylight.models.KillerPerk;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class KillerAddOnJdbcTemplateRepositoryTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    KillerAddOnRepository repository;

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
        List<KillerAddOn> killerAddOns = repository.findAll();

        assertTrue(killerAddOns.size() >= 2);
        assertTrue(killerAddOns.stream()
                .anyMatch(o -> o.getKillerAddOnId() == 1 && o.getKillerId() == 1));
    }
}