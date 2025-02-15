package com.video.compreser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import io.github.techgnious.IVCompressor;
import io.github.techgnious.dto.IVAudioAttributes;
import io.github.techgnious.dto.IVSize;
import io.github.techgnious.dto.IVVideoAttributes;
import io.github.techgnious.dto.VideoFormats;
import io.github.techgnious.exception.VideoException;

public class Main3 {
	
//	public static void main(String[] args) throws VideoException, IOException {
//		IVCompressor compressor = new IVCompressor();
//		IVSize customRes = new IVSize();
//		customRes.setWidth(400);
//		customRes.setHeight(300);
//		File file = new File("D:/Testing/20.mp4");
//	    	compressor.reduceVideoSizeAndSaveToAPath(file,VideoFormats.MP4,ResizeResolution.R480P,"D:/Testing/Custome");
//		}

	
	public static void main(String[] args) throws IOException, VideoException {
		
		IVCompressor compressor = new IVCompressor();
		IVSize customRes = new IVSize();
		customRes.setWidth(400);
		customRes.setHeight(300);
		IVAudioAttributes audioAttribute = new IVAudioAttributes();
		// here 64kbit/s is 64000
		audioAttribute.setBitRate(64000);
		audioAttribute.setChannels(2);
		audioAttribute.setSamplingRate(44100);
		IVVideoAttributes videoAttribute = new IVVideoAttributes();
		// Here 160 kbps video is 160000
		videoAttribute.setBitRate(160000);
		// More the frames more quality and size, but keep it low based on //devices like mobile
		videoAttribute.setFrameRate(15);
		videoAttribute.setSize(customRes);
		File file = new File("D:/Testing/20.mp4");
		byte[] fileContent  =	FileUtils.readFileToByteArray(file);
		
		FileOutputStream out = new FileOutputStream("D:/Testing/QQQQ.mp4");
		out.write(compressor.encodeVideoWithAttributes(fileContent, VideoFormats.MP4,audioAttribute, videoAttribute));
		
		out.close();
	}
	
	
	
}
