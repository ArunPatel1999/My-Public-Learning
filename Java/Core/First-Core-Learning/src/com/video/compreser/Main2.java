package com.video.compreser;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.DeflaterOutputStream;

public class Main2 {
	
	public static void main(String[] args) {
		
		try {
			long start = System.nanoTime();
			  //Instantiating the FileInputStream
		      String inputPath = "D:/Testing/20.mp4";
		      FileInputStream inputStream = new FileInputStream(inputPath);
		      //Instantiating the FileOutputStream
		      String outputPath = "D:/Testing/l.mp4";
		      FileOutputStream outputStream = new FileOutputStream(outputPath);
		      //Instantiating the DeflaterOutputStream
		      DeflaterOutputStream compresser = new DeflaterOutputStream(outputStream);
		      int contents;
		      while ((contents=inputStream.read())!=-1){
		         compresser.write(contents);
		      }
		      compresser.close();
		      inputStream.close();
		      long end = System.nanoTime();
		      System.out.println("File compressed......."+(end-start));
		      
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
