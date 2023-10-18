package org.track_by_daylight.data;

import org.springframework.transaction.annotation.Transactional;
import org.track_by_daylight.models.AppUser;

public interface AppUserRepository {
    @Transactional
    AppUser findByUsername(String username);

    @Transactional
    AppUser create(AppUser user);

    @Transactional
    boolean update(AppUser user);
}
