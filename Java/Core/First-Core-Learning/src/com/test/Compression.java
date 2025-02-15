package com.test;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

class Compression {

	 
	 
	/**
	 * This program demonstrates how to resize an image.
	 *
	 * @author www.codejava.net
	 *
	 */
	
	    /**
	     * Resizes an image to a absolute width and height (the image may not be
	     * proportional)
	     * @param inputImagePath Path of the original image
	     * @param outputImagePath Path to save the resized image
	     * @param scaledWidth absolute width in pixels
	     * @param scaledHeight absolute height in pixels
	     * @throws IOException
	     */
	    public static void resize(String inputImagePath,
	            String outputImagePath, int scaledWidth, int scaledHeight)
	            throws IOException {
	        // reads input image
	        File inputFile = new File(inputImagePath);
	        BufferedImage inputImage = ImageIO.read(inputFile);
	 
	        // creates output image
	        BufferedImage outputImage = new BufferedImage(scaledWidth,
	                scaledHeight, inputImage.getType());
	        
	        // scales the input image to the output image
	        Graphics2D g2d = outputImage.createGraphics();
	        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
	        g2d.dispose();
	 
	        // extracts extension of output file
	        String formatName = outputImagePath.substring(outputImagePath
	                .lastIndexOf(".") + 1);
	 
	        // writes to output file
	        ImageIO.write(outputImage, formatName, new File(outputImagePath));
	    }

	    /**
	     * Resizes an image by a percentage of original size (proportional).
	     * @param inputImagePath Path of the original image
	     * @param outputImagePath Path to save the resized image
	     * @param percent a double number specifies percentage of the output image
	     * over the input image.
	     * @throws IOException
	     */
	    public static void resize(String inputImagePath,
	            String outputImagePath, double percent) throws IOException {
	        File inputFile = new File(inputImagePath);
	        BufferedImage inputImage = ImageIO.read(inputFile);
	        int scaledWidth = (int) (inputImage.getWidth() * percent);
	        int scaledHeight = (int) (inputImage.getHeight() * percent);
	        resize(inputImagePath, outputImagePath, scaledWidth, scaledHeight);
	    }
	 
	    /**
	     * Test resizing images
	     */
	    public static void main(String[] args) {
	        String inputImagePath = "C:\\Users\\Account\\Desktop\\ping\\Compression/wp4778196-5120x1600-wallpapers.jpg";
	        String outputImagePath1 = "C:\\\\Users\\\\Account\\\\Desktop\\\\ping\\\\Compression/Puppy_Fixed.jpg";
	        String outputImagePath2 = "C:\\\\Users\\\\Account\\\\Desktop\\\\ping\\\\Compression/Puppy_Smaller.jpg";
	        String outputImagePath3 = "C:\\\\Users\\\\Account\\\\Desktop\\\\ping\\\\Compression/Puppy_Bigger.jpg";
	 
	        try {
	            // resize to a fixed width (not proportional)
	            int scaledWidth = 1024;
	            int scaledHeight = 800;
	            Compression.resize(inputImagePath, outputImagePath1, scaledWidth, scaledHeight);
	 
	            // resize smaller by 50%
	            double percent = 0.5;
	            Compression.resize(inputImagePath, outputImagePath2, percent);
	 
	            // resize bigger by 50%
	            percent = 1.5;
	            Compression.resize(inputImagePath, outputImagePath3, percent);
	            
	            cropImage();
	            c();
	        } catch (IOException ex) {
	            System.out.println("Error resizing the image.");
	            ex.printStackTrace();
	        }
	    }
	    
	    static void cropImage() {
	    	try {
	    	File imageFile = new File("C:\\\\Users\\\\Account\\\\Desktop\\\\ping\\\\Compression//wp4778196-5120x1600-wallpapers.jpg");
	    	BufferedImage bufferedImage = ImageIO.read(imageFile);
	    	BufferedImage dest = bufferedImage.getSubimage(4000, 0, 1000, 1000);
	        File pathFile = new File("C:\\\\\\\\Users\\\\\\\\Account\\\\\\\\Desktop\\\\\\\\ping\\\\\\\\Compression///image-crop.jpg");
	        ImageIO.write(dest,"jpg", pathFile);
	    	}catch (Exception e) {
				// TODO: handle exception
			}
	     }
	    
	    static void c() {
	    	try {
	    	 File input = new File("C:\\\\\\\\Users\\\\\\\\Account\\\\\\\\Desktop\\\\\\\\ping\\\\\\\\Compression/image-crop.jpg");
	         BufferedImage image = ImageIO.read(input);

	         File compressedImageFile = new File("C:\\\\\\\\Users\\\\\\\\Account\\\\\\\\Desktop\\\\\\\\ping\\\\\\\\Compression/compress.jpg");
	         OutputStream os =new FileOutputStream(compressedImageFile);

	         Iterator<ImageWriter>writers =  ImageIO.getImageWritersByFormatName("jpg");
	         ImageWriter writer = (ImageWriter) writers.next();

	         ImageOutputStream ios = ImageIO.createImageOutputStream(os);
	         writer.setOutput(ios);

	         ImageWriteParam param = writer.getDefaultWriteParam();
	         
	         param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
	         param.setCompressionQuality(0.1f);
	         writer.write(null, new IIOImage(image, null, null), param);
	         
	         os.close();
	         ios.close();
	         writer.dispose();}catch (Exception e) {
				// TODO: handle exception
			}
	      }
	    
}