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

    private void downloadMessages () throws MessagingException {
            Connection conn;
            conn = Connection.getInstance();
            allMail = conn.getFolder("Inbox");
            if(!allMail.isOpen()) {
                allMail.open(Folder.READ_ONLY);
            }
            messages= allMail.getMessages();
    }

    public EmailReceiver() throws MessagingException {
        downloadMessages();
    }

    //This function returns a list of the EmailDataModel of all messages in the emailreciever
    //And holds only sender's address, the date of the email, and the subject.
    public List<EmailDataModel> getMessageList() throws MessagingException {
        List<EmailDataModel> messageData = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        for (Message item: messages
             ) {
            String sender = InternetAddress.toString(item.getFrom());
            String subject = item.getSubject();
            String date = formatter.format(item.getSentDate());
            messageData.add(new EmailDataModel(sender, subject, date));
        }
        return messageData;
    }


    //This will retrieve the message at the number specified. It should match the messages' number
    //on the lists fetched in the get() methods.
    public Message retrieveMessage(int messNum) {
        return messages[messNum];
    }

}
