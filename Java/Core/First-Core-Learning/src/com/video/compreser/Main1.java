package com.video.compreser;

import java.util.concurrent.TimeUnit;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;

public class Main1 {
	
	public static void main(String[] args) {
	try {

		long start = System.nanoTime();
		
		FFmpeg	ffmpeg = new FFmpeg("D:\\Download\\ffmpeg-N-101969-g6c65e49990-win64-gpl\\bin/ffmpeg");
		FFprobe ffprobe = new FFprobe("D:\\Download\\ffmpeg-N-101969-g6c65e49990-win64-gpl\\bin/ffprobe");

		FFmpegBuilder builder = new FFmpegBuilder()
		                //                 .setInput("D:/Testing/1.mp4")     // Filename, or a FFmpegProbeResult
		                                 .setInput("D:/Testing/20.mp4")     // Filename, or a FFmpegProbeResult
		                                 .overrideOutputFiles(true) // Override the output if it exists
		                                 .addOutput("D:/Testing/1test.mp4")   // Filename for the destination
		                           //      .addOutput("D:/Testing/20test.mp4")   // Filename for the destination
		                                 .setFormat("mp4")       // Format is inferred from filename, or can be set
		                             //  .setTargetSize(250_000) // Aim for a 250KB file
		                                 .disableSubtitle()       // No subtiles
		                                 .setAudioChannels(1)                   // Mono audio
		                             //  .setAudioChannels(2)
		                                 .setAudioCodec("aac")       // using the aac codec
		                                 .setAudioSampleRate(48_000) // at 48KHz
		                                 .setAudioBitRate(32768)     // at 32 kbit/s
		                             //  .setAudioBitRate(126000)
		                                 .setVideoCodec("libx264")     // Video using x264             
		                                 .setVideoFrameRate(24, 1)     // at 24 frames per second
		                                 .setVideoResolution(1280, 720) // at 640x480 resolution
		                        //       .setVideoResolution(1024, 768)
		                        //       .setVideoResolution(640, 480)
		                                 .setVideoBitRate(762800)  
		                                 .setStrict(FFmpegBuilder.Strict.EXPERIMENTAL) // Allow FFmpeg to use experimental specs
		                                 .done();
		     FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);         
		     executor.createJob(builder).run(); // Run

				long end = System.nanoTime();
		     System.out.println("completed in = "+TimeUnit.NANOSECONDS.toSeconds(end-start)+" s");
		     }catch (Exception e) {
		    	 e.printStackTrace();
			}
	}
}
