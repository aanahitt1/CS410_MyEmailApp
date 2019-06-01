package com.example.myemailapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

public class EmailList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private EmailAdapter emailAdapter;
    EmailReceiver emailRec;
    List<EmailDataModel> emailDataModelList;


//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_email_lists);

        recyclerView = findViewById(R.id.recyclerView);

        //scroll email lists vertically
        linearLayoutManager = new LinearLayoutManager(EmailList.this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        //divide each email in the list
        recyclerView.addItemDecoration(new DividerItemDecoration(EmailList.this,
                DividerItemDecoration.VERTICAL));

        try {
            emailRec = new EmailReceiver();
            emailDataModelList = emailRec.getMessageList();
            emailAdapter = new EmailAdapter(EmailList.this,emailDataModelList);
            recyclerView.setAdapter(emailAdapter);

        } catch(MessagingException e){
            e.printStackTrace();
        }
    }
}
