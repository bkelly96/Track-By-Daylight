package org.track_by_daylight.tricky;

import org.track_by_daylight.tricky.TrickyRawResult;

public class TrickyGetResult {

    private boolean success;
    private String link;
    private String deleteHash;

    public TrickyGetResult() { }

    public TrickyGetResult(boolean success, String link, String deleteHash) {
        this.success = success;
        this.link = link;
        this.deleteHash = deleteHash;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDeleteHash() {
        return deleteHash;
    }

    public void setDeleteHash(String deleteHash) {
        this.deleteHash = deleteHash;
    }

    public static TrickyGetResult fromTrickyRawResult(TrickyRawResult rawResult) {
        return rawResult.isSuccess()
                ? new TrickyGetResult(true, rawResult.getData().getLink(), rawResult.getData().getDeletehash())
                : badResult();
    }

    private static TrickyGetResult badResult() {
        return new TrickyGetResult(false, null, null);
    }
}
