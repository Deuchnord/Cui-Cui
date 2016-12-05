package fr.tanghevandekadsye.jee;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


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
