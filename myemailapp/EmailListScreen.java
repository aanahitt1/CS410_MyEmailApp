package com.example.myemailapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMultipart;


public class EmailListScreen extends RecyclerView.Adapter<EmailViewHolder>{

    private List<EmailDataModel> emailDataModelList;
    private Context context;
    EmailReceiver emailRec;


    public EmailListScreen(Context context,List<EmailDataModel> emailDataModelList, EmailReceiver emailRec) {
        this.emailDataModelList = emailDataModelList;
        this.context = context;
        this.emailRec = emailRec;
    }


    @Override
    public EmailViewHolder onCreateViewHolder(ViewGroup group, int viewType) {
        View view = LayoutInflater.from(group.getContext()).inflate(R.layout.recyclerview_mail_item,
                group, false);
        return new EmailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final EmailViewHolder emailViewHolder, int position) {

        emailViewHolder.getIcon().setText(emailDataModelList.get(position).getEmailSender().substring(0,1));
        emailViewHolder.getEmailSender().setText(emailDataModelList.get(position).getEmailSender());
        emailViewHolder.getEmailSubject().setText(emailDataModelList.get(position).getEmailSubject());
        emailViewHolder.getEmailDate().setText(emailDataModelList.get(position).getEmailDate());


        emailViewHolder.getEmailLayout().setOnClickListener(view -> {
            Intent intent = new Intent(context, ReadEmailScreen.class);
            Bundle b = new Bundle();
//            try{
//                Message received = emailRec.retrieveMessage(emailViewHolder.getEmailSubject().getText().toString());
//                b.putString("sender", InternetAddress.toString(received.getFrom()));
//                b.putString("subject", received.getSubject();
//                Object content = received.getContent();
//                if (content instanceof MimeMultipart) {
//                    MimeMultipart multipart = (MimeMultipart) content;
//                  if (multipart.getCount() > 0) {
//                        BodyPart part = multipart.getBodyPart(0);
//                        content = part.getContent();
//                    }
//                }
//                if (content != null) {
//                    b.putString(content.toString());
//                }
//            } catch (Exception e) {}

//            b.putString("sender", emailViewHolder.getEmailSender().getText().toString());
//            b.putString("subject", emailViewHolder.getEmailSubject().getText().toString());
//            b.putString("date", emailViewHolder.getEmailDate().getText().toString());
//            b.putString("icon", emailViewHolder.getIcon().getText().toString());
            b.putString("content", "Bah");
            intent.putExtras(b);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return emailDataModelList.size();
    }
}

class EmailViewHolder extends RecyclerView.ViewHolder {

    private TextView icon;
    private TextView emailSender;
    private TextView emailSubject;
    private TextView emailDate;
    private TextView emailBody;
    private RelativeLayout emailLayout;

    EmailViewHolder(View itemView) {
        super(itemView);
        setIcon(itemView.findViewById(R.id.icon));
        setEmailSender(itemView.findViewById(R.id.emailSender));
        setEmailSubject(itemView.findViewById(R.id.emailSubject));
        setEmailDate(itemView.findViewById(R.id.emailDate));
        setEmailBody(itemView.findViewById(R.id.emailBody));
        setEmailLayout(itemView.findViewById(R.id.layout));
    }

    public TextView getIcon() {
        return icon;
    }

    public void setIcon(TextView icon) {
        this.icon = icon;
    }

    public TextView getEmailSender() {
        return emailSender;
    }

    public void setEmailSender(TextView emailSender) {
        this.emailSender = emailSender;
    }

    public TextView getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(TextView emailSubject) {
        this.emailSubject = emailSubject;
    }

    public TextView getEmailDate() {
        return emailDate;
    }

    public void setEmailDate(TextView emailDate) {
        this.emailDate = emailDate;
    }

//    public TextView getEmailBody() { return emailBody; }

    public void setEmailBody(TextView emailBody) {
        this.emailBody = emailBody;
    }

    public RelativeLayout getEmailLayout() {
        return emailLayout;
    }

    public void setEmailLayout(RelativeLayout emailLayout) {
        this.emailLayout = emailLayout;
    }
}







