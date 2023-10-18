package org.track_by_daylight.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.track_by_daylight.models.Offering;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class OfferingJdbcTemplateRepositoryTest {


        @Autowired
        JdbcTemplate jdbcTemplate;

        @Autowired
        OfferingRepository repository;

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
        List<Offering> offerings = repository.findAll();

        assertTrue(offerings.size() >= 2);
        assertTrue(offerings.stream()
                .anyMatch(o -> o.getOfferingId() == 1 && o.getOfferingName().equals("Gruesome Gateau")));
    }

}
