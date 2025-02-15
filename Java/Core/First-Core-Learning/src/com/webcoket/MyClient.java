
package com.webcoket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {

        private BufferedReader in;
        private PrintWriter out;
        public MyClient() {
            try {
                Socket s = new Socket("localhost",8888);
                System.out.println("Connection accepted...");
                in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                out = new PrintWriter(s.getOutputStream());

                startReading();
                startWriting();
          

            }catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        }

        private void startReading() {

            Runnable r = () -> {
                try {
                    while (true) {
                        String msg= in.readLine();
                        System.out.println("Server : "+msg);
                        if(msg.equals("exit"))
                            throw new RuntimeException("Server Stop Chating");
                    }
                }catch (Exception e) {
                    throw new RuntimeException("Server Stop Chating");
                }
            };
            Thread  t = new Thread(r);
            t.start();

        }

        private void startWriting() {

            Runnable r = () -> {
                try {
                    while (true) {
        				Scanner input = new Scanner(System.in);
        				String msg =input.nextLine();
        				out.println(msg);
        				out.flush();
                    }
                }catch (Exception e) {
                    throw new RuntimeException("Server Stop Chating");
                }
            };
            Thread  t = new Thread(r);
            t.start();

        }

        public static void main(String[] args) {
            new MyClient();
        }


}
