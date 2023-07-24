package com.video.companionservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReplayedSectionDTO {

    private Long video_id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @JsonIgnore
    private int replayCount;

}
