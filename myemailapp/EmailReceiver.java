package com.example.myemailapp;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;

public class EmailReceiver {

    //We are saving the folder and the message as variables so we can use them in any context
    Folder allMail;
    Message[] messages;

    private void downloadMessages () throws MessagingException {
            Connection conn;
            conn = Connection.getInstance("MyEmailAppCS410@gmail.com", "Hellothere12345");
            allMail = conn.getFolder("Inbox");
            if(!allMail.isOpen()) {
                allMail.open(Folder.READ_ONLY);
            }
            messages = allMail.getMessages();
    }

    public EmailReceiver() throws MessagingException {
        downloadMessages();
    }

    //This function returns a list of the EmailDataModel of all messages in the emailreciever
    //And holds only sender's address, the date of the email, and the subject.
    public List<EmailDataModel> getMessageList() throws MessagingException {
        List<EmailDataModel> emailDataModels = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        for (Message message : messages) {
            String sender = InternetAddress.toString(message.getFrom());
            String subject = message.getSubject();
            String date = formatter.format(message.getSentDate());

            emailDataModels.add(new EmailDataModel(sender, subject, date));
        }
        return emailDataModels;
    }

    //This will retrieve the message at the number specified. It should match the messages' number
    //on the lists fetched in the get() methods.
//    public Message retrieveMessage(String subject) throws MessagingException {
//        Message found = null;
//        for(int i = 0; i < messages.length; i++) {
//            if(messages[i].getSubject().equals(subject)) {
//                found = messages[i];
//            }
//        }
//        return found;
//    }

}
