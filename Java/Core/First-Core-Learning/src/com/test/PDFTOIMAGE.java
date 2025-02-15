package com.test;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

public class PDFTOIMAGE {
	
	public static void main(String[] args) {
		
		 try {
			 
		      //Loading an existing PDF document
		      File file = new File("D:/Download/B2B_80.pdf");
		      PDDocument document = PDDocument.load(file);
		       
		      //Instantiating the PDFRenderer class
		      PDFRenderer renderer = new PDFRenderer(document);

		      //Rendering an image from the PDF document
		      BufferedImage image = renderer.renderImage(0);

		      //Writing the image to a file
		      ImageIO.write(image, "JPG", new File("D:/Download/a.jpg"));
		       
		      System.out.println("Image created");
		       
		      //Closing the document
		      document.close();
	/*		
		        String sourceDir = "D:/Download/B2B_80.pdf"; // Pdf files are read from this folder
		        String destinationDir = "D:/Download/"; // converted images from pdf document are saved here

		        File sourceFile = new File(sourceDir);
		        File destinationFile = new File(destinationDir);
		        if (!destinationFile.exists()) {
		            destinationFile.mkdir();
		            System.out.println("Folder Created -> "+ destinationFile.getAbsolutePath());
		        }
		        if (sourceFile.exists()) {
		            System.out.println("Images copied to Folder: "+ destinationFile.getName());             
		            PDDocument document = PDDocument.load(new File(sourceDir));
		            List<PDPage> list = document.getDocumentCatalog().getAllPages();
		            System.out.println("Total files to be converted -> "+ list.size());

		            String fileName = sourceFile.getName().replace(".pdf", "");             
		            int pageNumber = 1;
		            for (PDPage page : list) {
		                BufferedImage image = page.convertToImage();
		                File outputfile = new File(destinationDir + fileName +"_"+ pageNumber +".jpg");
		                System.out.println("Image Created -> "+ outputfile.getName());
		                ImageIO.write(image, "jpg", outputfile);
		                pageNumber++;
		            }
		            document.close();
		            System.out.println("Converted Images are saved at -> "+ destinationFile.getAbsolutePath());
		        } else {
		            System.err.println(sourceFile.getName() +" File not exists");
		        }
*/
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
	}

}
