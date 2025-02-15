package com.mtraders.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/image")
public class ImageController {

	
	@GetMapping
	public String  getAll(HttpServletResponse response) throws IOException {
		return getImage(response);
	}
	
	
	public String getImage(HttpServletResponse response)
			throws IOException {
		try {
			File imgFile = new File("D:/Download/2518457.jpg");
			InputStream is = new FileInputStream(imgFile); 
			
			StreamUtils.copy(is, response.getOutputStream());
			return "SUCCESS";
		} catch (FileNotFoundException fileNotFoundException) {
			return "FILE_NOT_FOUND";
		}
	}
	
	private ResponseEntity<byte[]> showImages () throws IOException {
	    String boundary="---------THIS_IS_THE_BOUNDARY";
	    List<String> imageNames = Arrays.asList("catfood.jpg","filewebp.jpg");
	    List<String> contentTypes = Arrays.asList(MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_JPEG_VALUE);
	    List<Byte[]> imagesData = new ArrayList<>();
	    File imgFile = new File("D:/Download/catfood.jpg");
		InputStream is = new FileInputStream(imgFile); 
	    File imgFile1 = new File("D:/Download/filewebp.jpg");
		InputStream is1 = new FileInputStream(imgFile1); 
		
	    imagesData.add(ArrayUtils.toObject(IOUtils.toByteArray(is)));
	    imagesData.add(ArrayUtils.toObject(IOUtils.toByteArray(is1)));
	//    imagesData.add(ArrayUtils.toObject(IOUtils.toByteArray(getClass().getResourceAsStream("D:/Download/a.jpg"))));
	    byte[] allImages = getMultipleImageResponse(boundary, imageNames,contentTypes, imagesData);
	    final HttpHeaders headers = new HttpHeaders();
	    headers.set("Content-Type","multipart/x-mixed-replace; boundary=" + boundary);
	    return new ResponseEntity<>(allImages,headers,HttpStatus.CREATED);
	}

	private static byte[] getMultipleImageResponse(String boundary, List<String> imageNames, List<String> contentTypes, List<Byte[]> imagesData){
	    byte[] finalByteArray = new byte[0];
	    Integer imagesCounter = -1;
	    for(String imageName : imageNames){
	        imagesCounter++;
	        String header="--" + boundary 
	                + "\r\nContent-Disposition: form-data; name=\"" + imageName
	                + "\"; filename=\"" + imageName + "\"\r\n"
	                + "Content-type: " + contentTypes.get(imagesCounter) + "\r\n\r\n";
	        byte[] currentImageByteArray=ArrayUtils.addAll(header.getBytes(), ArrayUtils.toPrimitive(imagesData.get(imagesCounter)));
	        finalByteArray = ArrayUtils.addAll(finalByteArray,ArrayUtils.addAll(currentImageByteArray, "\r\n\r\n".getBytes()));
	        if (imagesCounter == imageNames.size() - 1) {
	            String end = "--" + boundary + "--";
	            finalByteArray = ArrayUtils.addAll(finalByteArray, end.getBytes());
	        }
	    }
	    return finalByteArray;
	}
	
	
	public ResponseEntity<byte[]> getAllImages() throws IOException {
	    List<String> imageNames = Arrays.asList(new String[]{"a.jpg","a.jpg"});
	    List<String> contentTypes = Arrays.asList(new String[]{MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_JPEG_VALUE});
	    List<Byte[]> imagesData = new ArrayList<Byte[]>();
	//    imagesData.add(ArrayUtils.toObject(IOUtils.toByteArray(ImageController.class.getResourceAsStream("D:/Download/a.jpg"))));
	  //  imagesData.add(ArrayUtils.toObject(IOUtils.toByteArray(ImageController.class.getResourceAsStream("D:/Download/a.jpg"))));
	    
	    File imgFile = new File("D:/Download/a.jpg");
			InputStream is = new FileInputStream(imgFile); 
			InputStream is2 = new FileInputStream(imgFile); 
			
		    imagesData.add(ArrayUtils.toObject(IOUtils.toByteArray(is)));
		    imagesData.add(ArrayUtils.toObject(IOUtils.toByteArray(is2)));
		
	    
	    byte[] htmlData=getHtmlData(imageNames,contentTypes, imagesData);
	    final HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.TEXT_HTML);
	    return new ResponseEntity<byte[]>(htmlData,headers,HttpStatus.OK);
	}

	private static byte[] getHtmlData(List<String> imageNames, List<String> contentTypes, List<Byte[]> imagesData){
	    String htmlContent="<!DOCTYPE html><html><head><title>Images</title></head><body>";
	     Integer imagesCounter = -1;
	    for(String imageName : imageNames){
	         imagesCounter++;
	        htmlContent = htmlContent + "<br/><br/><b>" + imageName + "</b><br/></br/><img src='data:" + contentTypes.get(imagesCounter) + ";base64, " + org.apache.commons.codec.binary.StringUtils.newStringUtf8(Base64.encodeBase64(ArrayUtils.toPrimitive(imagesData.get(imagesCounter)))) + "'/>";
	    }
	    htmlContent = htmlContent + "</body></html>";
	    return htmlContent.getBytes();
	}
	
}
