package com.example.myemailapp;

import android.os.StrictMode;

import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import java.util.Properties;

public class Connection {

    private static Connection instance;
    private static Store store;

    private Connection(String username, String password) throws MessagingException {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        Session session = Session.getDefaultInstance(props);

        store = session.getStore("imaps");
        store.connect("imap.gmail.com", username, password);

    }

    public static Connection getInstance(String username, String password) throws MessagingException {
        if(instance == null) {
            instance = new Connection(username, password);
            return instance;
        } else {
            return instance;
        }
    }

    public static Connection getInstance() {
        return instance;
    }


    public Folder getFolder(String folderName) throws MessagingException {
        if (folderName != null) {
            return store.getFolder(folderName);
        }
        throw(new MessagingException());
    }

}