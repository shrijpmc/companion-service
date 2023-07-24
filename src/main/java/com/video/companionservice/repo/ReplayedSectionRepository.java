package com.video.companionservice.repo;

import com.video.companionservice.entity.ReplaySectionPKId;
import com.video.companionservice.entity.ReplayedSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ReplayedSectionRepository extends JpaRepository<ReplayedSection, ReplaySectionPKId> {


    @Query("SELECT replay  FROM ReplayedSection replay WHERE replay.videoId = :video_id " +
            " AND replay.startTime = :startTime AND replay.endTime = :endTime ")
    ReplayedSection findExistingReplayedSections(Long video_id, LocalDateTime startTime, LocalDateTime endTime);

    @Query(nativeQuery = true, value = "SELECT replay.*  FROM replayed_section replay WHERE replay.video_id= :videoId " +
            "ORDER BY replay.replay_count DESC LIMIT 1 ")
    ReplayedSection getMostReplayedVideoSection(Long videoId);
}
