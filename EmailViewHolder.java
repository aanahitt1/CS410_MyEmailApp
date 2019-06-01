package com.example.myemailapp;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.support.v7.widget.RecyclerView.ViewHolder;


class EmailViewHolder extends ViewHolder {

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

    public TextView getEmailBody() { return emailBody; }

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
