package com.test;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

class Emp{
	private int id;
	private String name;
	private String h;
	private String z;
	private String k;
	private String l;
	private String m;
	private String n;
	private String e;
	private String a;
	public Emp(int id, String name, String h, String z, String k, String l, String m, String n, String e, String a) {
		super();
		this.id = id;
		this.name = name;
		this.h = h;
		this.z = z;
		this.k = k;
		this.l = l;
		this.m = m;
		this.n = n;
		this.e = e;
		this.a = a;
	}
	@Override
	public String toString() {
		return "emp [id=" + id + ", name=" + name + ", h=" + h + ", z=" + z + ", k=" + k + ", l=" + l + ", m=" + m
				+ ", n=" + n + ", e=" + e + ", a=" + a + "]";
	}
	
	
	
}

public class QRCode {

	
    private static final String QR_CODE_IMAGE_PATH = "./MyQRCode.png";

    private static void generateQRCodeImage(String text, int width, int height, String filePath)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

    
    
    public static void main(String[] args) {
        try {
        	Emp emp =new Emp(1, "my name is khan", "Could not generate QR Code, WriterException :: ", "Could not generate QR Code, WriterException :: ", "Could not generate QR Code, WriterException :: ", "Could not generate QR Code, WriterException :: ", "Could not generate QR Code, WriterException :: ", "Could not generate QR Code, WriterException :: ", "Could not generate QR Code, WriterException :: ", "Could not generate QR Code, WriterException :: ") ;
        	System.out.println("running");
            generateQRCodeImage(emp.toString(), 350, 350, QR_CODE_IMAGE_PATH);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }
    }
}
