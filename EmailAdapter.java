package com.example.myemailapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public class EmailAdapter extends RecyclerView.Adapter<EmailViewHolder>{

    private List<EmailDataModel> emailDataModelList;
    private Context details;


    public EmailAdapter(Context details, List<EmailDataModel> emailDataModelList) {
        this.emailDataModelList = emailDataModelList;
        this.details = details;
    }


    @Override
    public EmailViewHolder onCreateViewHolder(ViewGroup group, int viewType) {
        View view = LayoutInflater.from(group.getContext()).inflate(R.layout.recyclerview_mail_item,
                group, false);
        return new EmailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final EmailViewHolder holder, int position) {
        holder.getIcon().setText(emailDataModelList.get(position).getEmailSender().substring(0,1));
        holder.getEmailSender().setText(emailDataModelList.get(position).getEmailSender());
        holder.getEmailSubject().setText(emailDataModelList.get(position).getEmailSubject());
        holder.getEmailDate().setText(emailDataModelList.get(position).getEmailDate());


        holder.getEmailLayout().setOnClickListener(view -> {
            Intent intent = new Intent(details, ReadEmailScreen.class);
            intent.putExtra("sender", holder.getEmailSender().getText().toString());
            intent.putExtra("subject", holder.getEmailSubject().getText().toString());
            intent.putExtra("date", holder.getEmailDate().getText().toString());
            intent.putExtra("icon", holder.getIcon().getText().toString());
//            intent.putExtra("content",holder.getEmailBody().getText().toString());
            details.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return emailDataModelList.size();
    }
}



