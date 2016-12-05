package fr.tanghevandekadsye.jee;

import static org.junit.*;

public class EmailCITest {
    @Test
    public void testValidEmail() {
        EmailCI email = new EmailCI("tanghe.jerome1@gmail.com");
        assertTrue(email.isValid());
    }

    @Test
    public void testInvalidEmail() {
        EmailCI email = new EmailCI("qvandekadsye at gmail dot com");
        assertFalse(email.isValid());
    }
}
