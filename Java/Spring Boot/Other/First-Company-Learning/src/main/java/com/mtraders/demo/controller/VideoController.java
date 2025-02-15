package com.mtraders.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("api/video")
public class VideoController {

public ResponseEntity<Object> getVideo(int id, String videoName) {
	try {
		File file = new File("C:/apps/video/" + id + "/" + videoName);
		InputStream is = new FileInputStream(file);
		HttpHeaders http = new HttpHeaders();
		http.set("Accept-Ranges","bytes");
		http.set("Content-Type", "video/mp4");
		http.set("Content-Range", "bytes 50-1025/17839845");
		http.set("Content-Length", String.valueOf(file.length()));
		return new ResponseEntity<>(new InputStreamResource(is),http,HttpStatus.OK);
	} catch (FileNotFoundException fileNotFoundException) {
		return ResponseEntity.ok("file not found");
	}
}
	
	@GetMapping("/{id}/{imageName}/getImage")
	public ResponseEntity<Object> getImage(@PathVariable int id, @PathVariable String imageName)  throws IOException{
		return getVideo(id, imageName);
	}

	@PutMapping("/{id}/addImages")
	public String addImages(@PathVariable int id, @RequestParam("images") MultipartFile image) throws IOException {
		String value;
		String destination = "C:/apps/video/" + id;
		File file = new File(destination);
		if (file.isDirectory()) {
			file.delete();
		}
		file.mkdirs();

		String filename = id + "." + getExtensens(image.getOriginalFilename());
		try {
			byte[] bytes = image.getBytes();
			String insPath = destination + "/" + filename;// Directory path where you want to save ;
			Files.write(Paths.get(insPath), bytes);
			value =filename;

		} catch (Exception e) {
			value = "image not save";
			e.printStackTrace();
		}

		return value;

	}
	
	private String getExtensens(String imageDefaultName) {
		return imageDefaultName.substring(imageDefaultName.lastIndexOf(".") + 1, imageDefaultName.length());
	}
}
