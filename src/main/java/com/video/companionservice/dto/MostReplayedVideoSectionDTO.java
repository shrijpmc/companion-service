package com.video.companionservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MostReplayedVideoSectionDTO implements Serializable {

    private String title;
    private String url;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int replayCount;
}
