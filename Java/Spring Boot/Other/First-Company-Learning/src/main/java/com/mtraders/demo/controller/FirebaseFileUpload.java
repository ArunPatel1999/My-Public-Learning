package com.mtraders.demo.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.firebase.cloud.StorageClient;

@RestController
@RequestMapping("api/firebaseupload")
public class FirebaseFileUpload {

	private String DOWNLOAD_URL = "https://firebasestorage.googleapis.com/v0/b/ssss/o/%s?alt=media";

	@PostMapping("/{type}/{movieName}/{folder}")
	public Object upload(@PathVariable String type, @PathVariable String movieName, @PathVariable String folder,
			@RequestParam("file") MultipartFile multipartFile) throws IOException {

		String fileName = multipartFile.getOriginalFilename(); // to get original file name
		
		fileName = movieName + folder + fileName.substring(fileName.lastIndexOf(".")); // to generated random string
	
			return uploadImage(fileName, multipartFile)		;																		// values for file name.
	//	return uploadingFirebase(folder, multipartFile.getOriginalFilename(), multipartFile);
	}
	
	@DeleteMapping("/{type}/{movieName}/{folder}")
	public boolean deleteFolder(@PathVariable String type, @PathVariable String movieName, @PathVariable String folder) throws FileNotFoundException, IOException {
		String folderName = "" + type + "/" + movieName + "/" + folder + "/";
		String fileName = movieName + folder + "youtest.jpg";
		return delete(movieName);
	}
	
	
private String uploadImage(String name, MultipartFile image) throws IOException  {

	BlobId blobId = BlobId.of("ss.appspot.com", name);
	Map<String, String> map = new HashMap<>();
	map.put("firebaseStorageDownloadTokens", "aa");
	BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setMetadata(map).setContentType(image.getContentType()).build();

    StorageClient.getInstance().bucket().getStorage().create(blobInfo, image.getBytes());
    return name;
    
}

private boolean delete(String name) throws IOException {
	Bucket bucket = StorageClient.getInstance().bucket();
	Blob blob = bucket.get(name);
	if (blob == null) {
		throw new IOException("file not found");
	  }
	  return blob.delete();
}
	
	private String uploadingFirebase(String folderName, String fileName, MultipartFile multipartFile) {
		try {
		
			BlobId blobId = BlobId.of("ddfsss.com", folderName + fileName);
			Map<String, String> map = new HashMap<>();
			map.put("fdss", fileName);
			BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setMetadata(map).setContentType("video/x-matroska").build();
		
			Credentials credentials = GoogleCredentials.fromStream(new FileInputStream("C:\\Users\\Account\\Documents\\workspace-spring-tool-suite-4-4.5.1.RELEASE\\Demo-1\\src\\main\\resources/serviceAccountKey.json"));
			Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
			
			storage.create(blobInfo, multipartFile.getBytes());

			String url = "https://firebasestorage.googleapis.com/v0/b/+notification/o/"
					+ (folderName + fileName).replace("/", "%2F") + "?alt=media&token=Ant-Manimage.jpg";

			return "Successfully Uploaded  = " + url; // Your customized response
		} catch (Exception e) {
			e.printStackTrace();
			return "500 " + e.getLocalizedMessage() + " Unsuccessfully Uploaded!";
		}
	}

	private boolean delete(String folderName, String fileName) throws FileNotFoundException, IOException {
		BlobId blobId = BlobId.of("notification-c85c7.appspot.com", folderName + fileName);
		Credentials credentials = GoogleCredentials.fromStream(new FileInputStream("C:\\Users\\Account\\Documents\\workspace-spring-tool-suite-4-4.5.1.RELEASE\\Demo-1\\src\\main\\resources/serviceAccountKey.json"));
		Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
		return storage.delete(blobId);

	}

	
}
