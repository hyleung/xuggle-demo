package com.example;

import com.xuggle.mediatool.*;
import java.util.*;
import java.io.*;
import java.awt.image.*;
import java.util.concurrent.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static com.xuggle.xuggler.Global.DEFAULT_TIME_UNIT;
public class VideoMaker
{

    final int videoStreamIndex = 0;
    final int videoStreamId = 0;
    final int width = 480;
    final int height = 800;

    private long firstFrame = 0;
    private final IMediaWriter writer;
    public VideoMaker(String fileName)
    {
        writer = ToolFactory.makeWriter(fileName);
        //add a video stream
        writer.addVideoStream(videoStreamIndex, videoStreamId, width, height);
    }
    public void addFrame(VideoFrame frame)
    {
        
        if(firstFrame==0)
            firstFrame = frame.getTimeStamp();
        long time =  frame.getTimeStamp() - firstFrame;
        writer.encodeVideo(videoStreamIndex, frame.getFrame(),time, MILLISECONDS);
        System.out.println(String.format("Frame added at: %d", time));
    }

    public void finish()
    {
        //close the writer
        writer.close();
    }

}