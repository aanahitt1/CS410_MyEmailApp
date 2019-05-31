package com.example.myemailapp;

public class EmailDataModel {

    private String emailSender;
    private String emailSubject;
    private String emailDate;

    public EmailDataModel(String emailSender, String emailSubject, String emailDate) {
        this.emailSender = emailSender;
        this.emailSubject = emailSubject;
        this.emailDate = emailDate;
    }

    public String getEmailSender() {
        return emailSender;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public String getEmailDate() {
        return emailDate;
    }
}
