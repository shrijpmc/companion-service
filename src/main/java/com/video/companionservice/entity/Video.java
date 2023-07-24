package com.video.companionservice.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.annotation.Generated;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "VIDEO")
@Data
@NoArgsConstructor
@Getter
@Setter
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long videoId;

    @Column(name = "TITLE")
    private String title;

    @Column(name ="URL")
    private String url;

    public Video(String title, String url) {
        this.title = title;
        this.url = url;
    }
}
