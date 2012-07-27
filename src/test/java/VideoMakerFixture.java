package com.example;

import java.io.*;
import java.awt.image.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import javax.imageio.*;
public class VideoMakerFixture
{
    @Test
    public void should_create_video() throws Exception
    {
        VideoMaker maker = new VideoMaker("demo.mov");
        List<BufferedImage> frames = new ArrayList<BufferedImage>();
        String path = "images";
        File folder = new File(path);
        File[] files = folder.listFiles();


        addFrames(maker, files);


        maker.finish();
    }

    private void addFrames(VideoMaker maker, File[] files) throws IOException
    {
        int count = 0;
        for (File file: files)
        {
            String fileName = file.getName();
            if (fileName.endsWith(".jpg") && file.length()>0)
            {
                BufferedImage image = ImageIO.read(file);
                assert(image != null);
                VideoFrame frame = new VideoFrame(image,Long.parseLong(fileName.substring(0,fileName.indexOf("."))));
                maker.addFrame(frame);
                count++;
            }
            
        }
        System.out.println(String.format("Frames added: %d", count));
    }
}
