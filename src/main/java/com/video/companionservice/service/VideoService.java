package com.video.companionservice.service;

import com.video.companionservice.converter.DomainClassConverter;
import com.video.companionservice.dto.VideoDTO;
import com.video.companionservice.entity.ReplayedSection;
import com.video.companionservice.entity.Video;
import com.video.companionservice.repo.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

    @Autowired
    VideoRepository videoRepository;


    public VideoDTO addVideo(VideoDTO videoDTO) {
        Video video = DomainClassConverter.convertToVideo(videoDTO);
        VideoDTO result = DomainClassConverter.convertToVideoDTO(videoRepository.save(video));
        return result;
    }

    public Video findVideoById(Long videoId) {
        return  videoRepository.findById(videoId).orElse(null);
    }
}
