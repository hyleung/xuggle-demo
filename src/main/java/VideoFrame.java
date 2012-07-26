package com.example;
import java.io.File;
import java.awt.image.*;
public class VideoFrame
{
	private BufferedImage bufferedImage;
	private long timeStamp;

	public VideoFrame(BufferedImage bufferedImage,long timeStamp)
	{
		this.bufferedImage = bufferedImage;
		this.timeStamp = timeStamp;
	}
	public BufferedImage getFrame()
	{
		return this.bufferedImage;
	}

	public long getTimeStamp()
	{
		return timeStamp;
	}

}