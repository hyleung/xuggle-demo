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
		VideoMaker videoMaker = new VideoMaker();
		List<BufferedImage> frames = new ArrayList<BufferedImage>();
		String path = "images";
		File folder = new File(path);
		File[] files = folder.listFiles();
		
		for(int i=0;i<5;i++)
		{
			addFrames(frames,files);
		}
		
		videoMaker.createVideo("demo.mov", frames);
	}

	private void addFrames(List<BufferedImage> frames, File[] files) throws IOException
	{
		for(File file:files)
		{
			if(file.getName().endsWith(".jpg"))
			{
				BufferedImage frame = ImageIO.read(file);
				assert(frame!=null);				
				frames.add(frame);
			}
		}
	}
}
