package org.track_by_daylight.models;

import java.util.Date;
import java.util.Objects;

public class Trial {

    public int trialId;

    public Date date;

    public boolean salt;

    public int userId;

    public Map map;

    public Trial() {
    }

    public Trial(int trialId, Date date, boolean salt, int userId, Map map) {
        this.trialId = trialId;
        this.date = date;
        this.salt = salt;
        this.userId = userId;
        this.map = map;
    }

    public int getTrialId() {
        return trialId;
    }

    public void setTrialId(int trialId) {
        this.trialId = trialId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isSalt() {
        return salt;
    }

    public void setSalt(boolean salt) {
        this.salt = salt;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trial trial = (Trial) o;
        return trialId == trial.trialId && salt == trial.salt && userId == trial.userId && Objects.equals(date, trial.date) && Objects.equals(map, trial.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trialId, date, salt, userId, map);
    }
}
