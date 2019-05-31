package com.example.myemailapp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;

public class EmailReceiver {

    //We are saving the folder and the message as variables so we can use them in any context
    Folder allMail;
    Message[] messages;
//    EmailDataModel model;

    public EmailReceiver() throws MessagingException {
        downloadMessages();
    }

    public Message[] getMessages(){
        return messages;
    }

    private void downloadMessages () throws MessagingException {
            com.example.myemailapp.Connection conn;
            conn = Connection.getInstance("MyEmailAppCS410@gmail.com","Hellothere12345");
            allMail = conn.getFolder("Inbox");
            if(!allMail.isOpen()) {
                allMail.open(Folder.READ_ONLY);
            }
            messages= allMail.getMessages();
    }



    //This method will retrieve all the addresses from the messages in the email in order
    public List<String> getMessageNames() throws Exception {
        List<String> messageNames = new ArrayList<>();
        for (Message item : messages
        ) {
            messageNames.add(InternetAddress.toString(item.getFrom()));
        }
        return messageNames;
    }

    //This method will retrieve all subjects from the messages in the email in order
    public List<String> getMessageSubjects() throws Exception {
        List<String> messageSubjects = new ArrayList<>();
        for (Message item : messages
        ) {
            messageSubjects.add(item.getSubject());
        }
        return messageSubjects;
    }

    //This method will retrieve all dates from the messages in the email in order
    public List<String> getMessageDates() throws Exception {
        List<String> messageDates = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        for (Message item : messages
        ) {
            Date bah = item.getSentDate();
            String date = formatter.format(bah);
            messageDates.add(date);
        }
        return messageDates;
    }

//    public List<EmailDataModel> getData() throws Exception {
//        List<EmailDataModel> dataList = new ArrayList<>();
//        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
//        for (Message item : messages
//        ) {
//            Date bah = item.getSentDate();
//            String date = formatter.format(bah);
//            model = new EmailDataModel(InternetAddress.toString(item.getFrom()), item.getSubject(), date);
//            dataList.add(model);
//        }
//        return dataList;
//    }

    //This will retrieve the message at the number specified. It should match the messages' number
    //on the lists fetched in the get() methods.
    public Message retrieveMessage(int messNum) {
        return messages[messNum];
    }

}
