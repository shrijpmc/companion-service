package com.video.companionservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import java.io.Serializable;


public class VideoDTO implements Serializable {


    private Long videoId;
    private String title;
    private String url;

    public VideoDTO(Long videoId, String title, String url) {
        this.videoId = videoId;
        this.title = title;
        this.url = url;
    }

    public VideoDTO() {
    }

    public Long getVideoId() {
        return videoId;
    }

    @JsonIgnore
    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
