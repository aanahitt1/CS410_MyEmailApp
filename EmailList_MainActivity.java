package com.example.myemailapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import javax.mail.MessagingException;

public class EmailList_MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private EmailListScreen emailAdapter;
    EmailReceiver emailRec;
    List<EmailDataModel> emailDataModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_email_lists);

        recyclerView = findViewById(R.id.recyclerView);

        //scroll email lists vertically
        linearLayoutManager = new LinearLayoutManager(EmailList_MainActivity.this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        //divide each email in the list
        recyclerView.addItemDecoration(new DividerItemDecoration(EmailList_MainActivity.this,
                DividerItemDecoration.VERTICAL));

        try {
            emailRec = new EmailReceiver();
            emailDataModelList = emailRec.getMessageList();
            emailAdapter = new EmailListScreen(EmailList_MainActivity.this, emailDataModelList, emailRec);
            recyclerView.setAdapter(emailAdapter);

        } catch(MessagingException e){
            e.printStackTrace();
        }
    }
}
