package com.example.android.mediaplayer;

public class Media {
    private String mediaTitle;
    private int mediaId;

    public Media(String mediaTitle, int mediaId) {
        this.mediaTitle = mediaTitle;
        this.mediaId = mediaId;
    }

    public String getMediaTitle() {
        return mediaTitle;
    }

    public void setMediaTitle(String mediaTitle) {
        this.mediaTitle = mediaTitle;
    }

    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }
}
