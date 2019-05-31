package com.example.myemailapp;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.mail.Folder;
import javax.mail.MessagingException;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class ConnectionTest {

    private static final String SOME_VALID_USERNAME = "MyEmailAppCS410@gmail.com";
    private static final String SOME_VALID_PASSWORD = "Hellothere12345";
    private static final String SOME_INVALID_PASSWORD = "28ednek";

    Connection conn;

    @Test
    void constructor_validLogin_shouldReturnValidConnection() throws MessagingException {
        // When
        conn = Connection.getInstance(SOME_VALID_USERNAME,SOME_VALID_PASSWORD);

        // Then
        assertNotNull(conn);
    }

    @Test
    void constructor_invalidLogin_shouldThrowException() {
        // Then
        Assertions.assertThrows(RuntimeException.class, () -> {
            conn = Connection.getInstance(SOME_VALID_USERNAME,SOME_INVALID_PASSWORD);
        });
    }

    @Test
    void getFolder() throws MessagingException {
        // When
        conn = Connection.getInstance(SOME_VALID_USERNAME,SOME_VALID_PASSWORD);

        Folder resultFolder = conn.getFolder("INBOX");
        String resultFolderName = resultFolder.getName();

        // Then
        assertNotNull(conn);
        assertSame(resultFolderName, "INBOX");
    }
}
