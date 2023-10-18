package org.track_by_daylight.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.track_by_daylight.models.AddOn;
import org.track_by_daylight.models.Offering;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AddOnJdbcTemplateRepositoryTest {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AddOnRepository repository;

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
        List<AddOn> addOns = repository.findAll();

        assertTrue(addOns.size() >= 2);
        assertTrue(addOns.stream()
                .anyMatch(o -> o.getAddOnId() == 1 && o.getAddOnName().equals("Honing Stone")));
    }

}
