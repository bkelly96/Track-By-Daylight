package org.track_by_daylight.tricky;

public class TrickyRawResult {

    private TrickyRawDataResult data;
    private boolean success;
    private int status;

    public TrickyRawDataResult getData() {
        return data;
    }

    public void setData(TrickyRawDataResult data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}