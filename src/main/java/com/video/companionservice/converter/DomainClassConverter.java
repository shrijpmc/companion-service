package com.video.companionservice.converter;

import com.video.companionservice.dto.MostReplayedVideoSectionDTO;
import com.video.companionservice.dto.ReplayedSectionDTO;
import com.video.companionservice.dto.VideoDTO;
import com.video.companionservice.entity.ReplayedSection;
import com.video.companionservice.entity.Video;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DomainClassConverter {

    public static Video convertToVideo(VideoDTO videoDTO){
        Video video = new Video(videoDTO.getTitle(),videoDTO.getUrl());
        return video;
    }

    public static VideoDTO convertToVideoDTO(Video video){
        VideoDTO videoDTO = new VideoDTO(video.getVideoId(),video.getTitle(),video.getUrl());
        return videoDTO;
    }

    public static ReplayedSection convertToReplayedSection(ReplayedSectionDTO replayedSectionDTO) {
        ReplayedSection replayedSection =new ReplayedSection(replayedSectionDTO.getVideo_id(),
                replayedSectionDTO.getStartTime(),
                replayedSectionDTO.getEndTime(),0);
        return replayedSection;
    }


    public static List<ReplayedSectionDTO> convertToReplayedSectionDTOLst(List<ReplayedSection> replayedSections) {

        List<ReplayedSectionDTO> replayedSectionDTOLst = new ArrayList<>();

       replayedSections.stream().forEach(replayedSection -> {
           replayedSectionDTOLst.add( new ReplayedSectionDTO(
                   replayedSection.getVideoId(),
                   replayedSection.getStartTime(),
                   replayedSection.getEndTime(),
                   replayedSection.getReplayCount()));
       });
    return replayedSectionDTOLst;
    }

    public static ReplayedSectionDTO convertToReplayedSectionDTO(ReplayedSection savedReplaySecTn) {
        return  new ReplayedSectionDTO(savedReplaySecTn.getVideoId(),
                savedReplaySecTn.getStartTime(),savedReplaySecTn.getEndTime(),
                savedReplaySecTn.getReplayCount());
    }

    public static MostReplayedVideoSectionDTO convertToMostReplayedSectionDTO(Video video, ReplayedSection replayedSecTn) {
        VideoDTO videoDTO = convertToVideoDTO(video);
        return  new MostReplayedVideoSectionDTO(videoDTO.getTitle(),videoDTO.getUrl(),
                replayedSecTn.getStartTime(),replayedSecTn.getEndTime(),replayedSecTn.getReplayCount());
    }
}
