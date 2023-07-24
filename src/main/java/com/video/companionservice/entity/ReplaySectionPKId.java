package com.video.companionservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class ReplaySectionPKId implements Serializable {

    private Long videoId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;


}
