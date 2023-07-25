package com.video.companionservice.service;

import com.video.companionservice.converter.DomainClassConverter;
import com.video.companionservice.dto.MostReplayedVideoSectionDTO;
import com.video.companionservice.dto.ReplayedSectionDTO;
import com.video.companionservice.entity.ReplayedSection;
import com.video.companionservice.entity.Video;
import com.video.companionservice.repo.ReplayedSectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class ReplayedSectionService {

    @Autowired
    ReplayedSectionRepository replayedSectionRepository;

    @Autowired
    VideoService videoService;

    /** Add or update replayed section of a video by incrementing replayCount
     * @param  replayedSectionDTO
     * @return  ReplayedSectionDTO**/

    public ReplayedSectionDTO addReplayVideoSection(ReplayedSectionDTO replayedSectionDTO) {
            ReplayedSection existingReplayedSection = replayedSectionRepository.findExistingReplayedSections(
                    replayedSectionDTO.getVideo_id(),
                    replayedSectionDTO.getStartTime(), replayedSectionDTO.getEndTime());
            synchronized (this) {
                // synchronizing this check then act logic for concurrent requests.
                if (null != existingReplayedSection) {
                    existingReplayedSection.setReplayCount(existingReplayedSection.getReplayCount() + 1);
                    return saveReplaySection(existingReplayedSection);
                } else {
                    ReplayedSection replayedSection = DomainClassConverter.convertToReplayedSection(replayedSectionDTO);
                    return saveReplaySection(replayedSection);
                }
            }
    }


    private ReplayedSectionDTO saveReplaySection(ReplayedSection replayedSection) {
        ReplayedSection replayedSecTn = replayedSectionRepository.save(replayedSection);
        ReplayedSectionDTO replayedSectionDTO = DomainClassConverter.convertToReplayedSectionDTO(replayedSecTn);
        return replayedSectionDTO;
    }

    public MostReplayedVideoSectionDTO getMostReplayedVideoSection(Long videoId) {
        ReplayedSection replayedSecTn = replayedSectionRepository.getMostReplayedVideoSection(videoId);
        if(null == replayedSecTn){
            return new MostReplayedVideoSectionDTO();
        }
        Video video = videoService.findVideoById(videoId);
        MostReplayedVideoSectionDTO sectionDTO = DomainClassConverter.convertToMostReplayedSectionDTO(video,replayedSecTn);
        return sectionDTO;
    }
}
