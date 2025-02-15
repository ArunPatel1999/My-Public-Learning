package com.webcoket;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.github.sarxos.webcam.Webcam;

public class VideoNormal {
	
	static Socket socket;
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Webcam webcam = Webcam.getDefault();
		webcam.open();
		
		socket = new Socket("localhost",123);
		BufferedImage bm = webcam.getImage();
		ObjectOutputStream dout = new ObjectOutputStream(socket.getOutputStream());
		ImageIcon im = new ImageIcon();
		
		JFrame frame = new JFrame("User");
		frame.setSize(640,360);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		JLabel l = new JLabel();
		l.setVisible(true);
		frame.add(l);
		
		while (true) {
			bm= webcam.getImage();
			im = new ImageIcon(bm);
			dout.writeObject(im);
			dout.flush();
		}
		
		
	}
}
