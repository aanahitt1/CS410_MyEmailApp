package com.example.myemailapp;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import javax.mail.Message;
import javax.mail.MessagingException;

public class EmailList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private EmailAdapter emailAdapter;
    EmailReceiver emailRec;
//    List<EmailDataModel> emailDataModelList;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        linearLayoutManager = new LinearLayoutManager(EmailList.this,
                LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.addItemDecoration(new DividerItemDecoration(EmailList.this,
                DividerItemDecoration.VERTICAL));

        try {
            emailRec = new EmailReceiver();
            Message[] messages = emailRec.getMessages();
            emailAdapter = new EmailAdapter(messages);
            recyclerView.setAdapter(emailAdapter);


//            emailDataModelList = emailRec.getData();
//            emailAdapter = new EmailAdapter(emailDataModelList);
//            recyclerView.setAdapter(emailAdapter);

        } catch(MessagingException e){
            e.printStackTrace();
        }
    }
}
