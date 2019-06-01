package com.example.myemailapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;

public class ReadEmailScreen extends AppCompatActivity {

    private Message reading;

    public ReadEmailScreen(Message given) {
        reading = given;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_email_screen);

        TextView content = (TextView) findViewById(R.id.filling);
        TextView subject = (TextView) findViewById(R.id.title);
        TextView address = (TextView) findViewById(R.id.sender);
        subject.setY(0);
        address.setY(35);
        content.setY(65);
        String error = "Message not loading";
        String messageContent;
        String messageSubject;
        String messageSender;
        try {
            messageContent = (String) reading.getContent();
            messageSender =  InternetAddress.toString(reading.getFrom());
            messageSubject = reading.getSubject();
            subject.setText(messageSubject);
            address.setText(messageSender);
            content.setText(messageContent);
        } catch (Exception e) {
            content.setText(error);
        }
    }
}
