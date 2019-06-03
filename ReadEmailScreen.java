package com.example.myemailapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import javax.mail.Message;

public class ReadEmailScreen extends AppCompatActivity {

    public ReadEmailScreen() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_email_screen);

        TextView content = findViewById(R.id.filling);
        TextView subject = findViewById(R.id.subject);
        TextView address = findViewById(R.id.sender);
//        subject.setY(0);
//        address.setY(35);
//        content.setY(65);
        String error = "Message not loading";
        String messageContent;
        String messageSubject;

        Bundle bundle = getIntent().getExtras();

        try {
            if(bundle != null) {
                messageSubject = bundle.getString("subject", "missing subject!");
                subject.setText(messageSubject);
                address.setText(bundle.getString("sender", "missing sender!"));
                content.setText(bundle.getString("content","missing content"));
            } else {
                messageSubject = "Bundle is null";
                subject.setText(messageSubject);
            }
        } catch (Exception e) {
            content.setText(error);
        }
    }
}

