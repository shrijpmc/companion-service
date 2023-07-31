package com.video.companionservice.controller;

import com.video.companionservice.aop.Log;
import com.video.companionservice.dto.MostReplayedVideoSectionDTO;
import com.video.companionservice.dto.ReplayedSectionDTO;
import com.video.companionservice.dto.VideoDTO;
import com.video.companionservice.service.ReplayedSectionService;
import com.video.companionservice.service.VideoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companion")
public class CompanionController {

    @Autowired
    VideoService videoService;

    @Autowired
    ReplayedSectionService replayedService;


    @Operation(summary = "Using this endpoint video-streaming application can add videos to companion service")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Added video"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Server Error")})
    @PostMapping("/addVideo")
    @ResponseStatus(HttpStatus.CREATED)
    public VideoDTO addVideo(@RequestBody(required = true) VideoDTO video){
        return videoService.addVideo(video);
    }



    @Operation(summary = "Using this endpoint video-streaming application can post replayed section of a video")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Added replayed section of a video"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Server Error")})
    @Log
    @PostMapping("/replayVideoSection")
    @ResponseStatus(HttpStatus.CREATED)
    public ReplayedSectionDTO addReplaySection(@RequestBody ReplayedSectionDTO replayedSectionDTO){
         return replayedService.addReplayVideoSection(replayedSectionDTO);
    }

    @Operation(summary = "Using this endpoint video-streaming application can get the most replayed section of any video.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return most replayed section of a video."),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Server Error")})
    @GetMapping("/mostReplayedVideoSection/{videoId}")
    @Log
    @ResponseStatus(HttpStatus.OK)
    public MostReplayedVideoSectionDTO getMostReplayedVideoSection(@PathVariable("videoId") Long videoId){
        return replayedService.getMostReplayedVideoSection(videoId);
    }


}
