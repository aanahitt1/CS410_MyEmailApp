package com.example.myemailapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.mail.Message;

public class ReadEmailScreen extends AppCompatActivity {

//    private Message reading;
//
//    public ReadEmailScreen(Message given) {
//        reading = given;
//    }

    public ReadEmailScreen() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_email_screen);

        TextView content =  findViewById(R.id.filling);
        TextView subject =  findViewById(R.id.title);
        TextView address =  findViewById(R.id.sender);
//        subject.setY(0);
//        address.setY(35);
//        content.setY(65);
        String error = "Message not loading";
        String messageContent;
        String messageSubject;
        String messageSender;

        Bundle bundle = getIntent().getExtras();

        try {
            subject.setText(bundle.getString("subject"));
            address.setText(bundle.getString("sender"));
            content.setText(bundle.getString("content"));
        } catch (Exception e) {
            content.setText(error);
        }
    }
}

