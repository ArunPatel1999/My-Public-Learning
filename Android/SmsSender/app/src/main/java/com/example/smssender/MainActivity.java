package com.example.smssender;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;


public class MainActivity extends  Activity {

    private  TextView setText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setText = findViewById(R.id.myText);
        socket();
    }


    private void sendSMS(String phoneNumber, String message) {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    }

    String msg;
    String number;
    String message;
    BufferedReader in ;
    private void socket() {
        try {
            Socket s = new Socket("192.168.0.169", 8888);
            Log.i( "SOCKET","Connection accepted...");
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            while (true) {
                msg=in.readLine();
                number = msg.substring(0, 10);
                message = msg.substring(11, msg.length());
                if(number != null && message != null)
                    sendSMS(number, message);
                Log.i( "SOCKET_MESSAGE","Server : "+msg);
                setText.setText("Sms Send to "+number);
            }

        }catch (Exception e) {
            Log.i( "SOCKET_ERROR",e.toString());
        }
    }

}















