package com.example.myemailapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import javax.mail.MessagingException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    static EmailReceiver folder;

    @BeforeAll
    public static void setup() {
        try {
            Connection conn = Connection.getInstance("MyEmailAppCS410@gmail.com", "Hellothere12345");
            folder = new EmailReceiver();
        } catch(Exception e) {
            System.out.println("Setup failed");
        }
    }

    @Test
    public void getMessageDateLength() {
        try {
            List<String> test = folder.getMessageDates();
            assertEquals(2, test.size());
        } catch(Exception e) {
            System.out.println("Exception");
        }
    }

    @Test
    public void getMessageSubjectLength() {
        try {
            List<String> test = folder.getMessageSubjects();
            assertEquals(2, test.size());
        } catch(Exception e) {
            System.out.println("Exception");
        }
    }

    @Test
    public void getMessageNamesLength() {
        try {
            List<String> test = folder.getMessageNames();
            assertEquals(2, test.size());
        } catch(Exception e) {
            System.out.println("Exception");
        }
    }

    @Test
    public void checkDate() {
        try {
            List<String> test = folder.getMessageDates();
            assertEquals("05/28/2019", test.get(1));
        } catch (Exception e) {
            System.out.println("Date failed");
        }
    }

    @Test
    public void checkSubject() {
        try {
            List<String> test = folder.getMessageSubjects();
            assertEquals("Critical security alert", test.get(1));
        } catch (Exception e) {
            System.out.println("Subject Failed");
        }
    }

    @Test
    public void checkAddress() {
        try {
            List<String> test = folder.getMessageNames();
            assertEquals("Google <no-reply@accounts.google.com>", test.get(1));
        } catch (Exception e) {
            System.out.println("Address Failed");
        }
    }

    @Test
    public void getMessageWrong() {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {folder.retrieveMessage(2);});
    }
}