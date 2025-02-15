package com.webcoket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class ServerHandleMultiClient {

	List<Socket> list = new LinkedList<>();
	ServerSocket ss;
	Socket s;
	
	public ServerHandleMultiClient() {
		try {
			ss =new ServerSocket(8001);
			while(true) {
				s = ss.accept();
				list.add(s);
				Runnable r = new MyThread(s, list);
				new Thread(r).start();
			}
		}catch (Exception e) { }
	}
	
	
	
	public static void main(String[] args) {
		new ServerHandleMultiClient();
	}
}


class MyThread implements Runnable {

	List<Socket> list;
	Socket s;
	
	public MyThread(Socket s, List<Socket> list) {
		this.s = s;
		this.list = list;
	}
	
	@Override
	public void run() {
	
		String s1=" ";
		try {
			DataInputStream input = new DataInputStream(s.getInputStream());
			do {
				s1 = input.readUTF();
				System.out.println(s1);
				if(!s1.equals("stop"))
					broadCast(s1);
				else {
					DataOutputStream out = new DataOutputStream(s.getOutputStream());
					out.writeUTF(s1);
					out.flush();
				}}while(!s1.equals("stop"));
		}catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}}
	
		private void broadCast(String s1) {
			
			list.forEach(x -> {
				try {
					DataOutputStream out = new DataOutputStream(x.getOutputStream());
					out.writeUTF(s1);
					out.flush();
					
				} catch (IOException e) { }
				
				
			});
			
		}
	
}
