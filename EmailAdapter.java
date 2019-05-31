package com.example.myemailapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myemailapp.R;
import com.example.myemailapp.EmailViewHolder;

import java.text.SimpleDateFormat;

import javax.mail.Message;
import javax.mail.MessagingException;


public class EmailAdapter extends RecyclerView.Adapter<EmailViewHolder>{

    private Message[] messages;

//    private List<EmailDataModel> emailDataModelList;

    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");


    public EmailAdapter(Message[] messages) {
        this.messages = messages;
    }


//    //if change data structure from EmailReceiver class
//    public EmailAdapter(List<EmailDataModel> emailDataModelList) {
//        this.emailDataModelList = emailDataModelList;
//    }


    @Override
    public EmailViewHolder onCreateViewHolder(ViewGroup group, int viewType) {
        View view = LayoutInflater.from(group.getContext()).inflate(R.layout.recyclerview_mail_item,
                group, false);
        return new EmailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final EmailViewHolder holder, int position) {
        try {
            holder.icon.setText(messages[position].getFrom()[0].toString().substring(0,1));
            holder.emailSender.setText(messages[position].getFrom()[0].toString());
            holder.emailSubject.setText(messages[position].getSubject());
            holder.emailDate.setText(formatter.format(messages[position].getSentDate()));
        } catch (MessagingException e) {
            e.printStackTrace();
        }

//        holder.icon.setText(emailDataModelList.get(position).getEmailSender().substring(0,1));
//        holder.emailSender.setText(emailDataModelList.get(position).getEmailSender());
//        holder.emailSubject.setText(emailDataModelList.get(position).getEmailSubject());
//        holder.emailDate.setText(emailDataModelList.get(position).getEmailDate());

    }

    @Override
    public int getItemCount() {
        return messages.length;
//        return emailDataModelList.size();
    }
}




