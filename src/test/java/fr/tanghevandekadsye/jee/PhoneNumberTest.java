package fr.tanghevandekadsye.jee;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


public class PhoneNumberTest {
    @Test
    public void testValidPhoneNumber() {
        PhoneCI phone = new PhoneCI("0123456789");
        assertTrue(phone.isValid());
    }

    @Test
    public void testInvalidPhoneNumber() {
        PhoneCI phone = new PhoneCI("01234567890123456");
        assertFalse(phone.isValid());

        phone = new PhoneCI("01 23 45 67 89");
        assertFalse(phone.isValid());
    }
}
