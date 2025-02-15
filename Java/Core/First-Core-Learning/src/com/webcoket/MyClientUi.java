package com.webcoket;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyClientUi extends Frame implements ActionListener {
	JTextField tf;
	JLabel send;

	JButton b;

	int sendX = 0;

	private BufferedReader in;
	private PrintWriter out;

	MyClientUi() {

		try {
			Socket s = new Socket("localhost", 8888);
			System.out.println("Connection accepted...");
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = new PrintWriter(s.getOutputStream());

			startReading();
			

		} catch (Exception e) {

		}

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		tf = new JTextField();
		tf.setBounds(10, 350, 250, 30);

		b = new JButton("send");
		b.setBounds(260, 350, 95, 30);
		b.addActionListener(this);
		add(b);
		add(tf);
		setSize(400, 400);
		setLayout(null);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		try {
			send = new JLabel();
			String host = tf.getText();
			if (host != null && !host.isEmpty()) {
				send.setText("Me : " + host);

				out.println(host);
				out.flush();
				
				send.setBounds(10, 50 + (sendX += 10), 250, 20);
				send.setForeground(Color.GREEN);
				add(send);
				tf.setText(null);
				repaint();
			}
		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
	}

//	private void startReading() {
//
//		
//		try {
//			send = new JLabel();
//			String msg = in.readLine();
//			send.setText("server : " + msg);
//
//			if (msg.equals("exit"))
//				throw new RuntimeException("Server Stop Chating");
//				
//				
//			send.setBounds(10, 50 + (sendX += 10), 250, 20);
//			send.setForeground(Color.RED);
//			add(send);
//			repaint();
//		
//			
//			
//		} catch (Exception ex) {
//			System.out.println(ex.getLocalizedMessage());
//		}
//	}
		
	 private void startReading() {

         Runnable r = () -> {
             try {
                 while (true) {
                	 send = new JLabel();
         			String msg = in.readLine();
         			send.setText("server : " + msg);

         			if (msg.equals("exit"))
         				throw new RuntimeException("Server Stop Chating");
         				
         				
         			send.setBounds(10, 50 + (sendX += 10), 250, 20);
         			send.setForeground(Color.RED);
         			add(send);
         			repaint();
         		
                 }
             }catch (Exception e) {
                 throw new RuntimeException("Server Stop Chating");
             }
         };
         Thread  t = new Thread(r);
         t.start();

     }
		


	public static void main(String[] args) {
		new MyClientUi();
	}
}
