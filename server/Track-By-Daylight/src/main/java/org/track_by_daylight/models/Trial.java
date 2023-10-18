package org.track_by_daylight.models;

import java.util.Date;
import java.util.Objects;

public class Trial {

    public int trialId;

    public Date date;

    public boolean salt;

    public int userId;

    public Trial() {
    }

    public Trial(int trialId, Date date, boolean salt, int userId) {
        this.trialId = trialId;
        this.date = date;
        this.salt = salt;
        this.userId = userId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trial trial = (Trial) o;
        return trialId == trial.trialId && salt == trial.salt && userId == trial.userId && Objects.equals(date, trial.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trialId, date, salt, userId);
    }
}
