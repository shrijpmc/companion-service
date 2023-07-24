package com.video.companionservice.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "REPLAYED_SECTION")
@IdClass(ReplaySectionPKId.class)
public class ReplayedSection {

    @Id
    private Long videoId;
    @Id
    private LocalDateTime startTime;
    @Id
    private LocalDateTime endTime;

    @Column(name = "REPLAY_COUNT")
    private Integer replayCount;

}
