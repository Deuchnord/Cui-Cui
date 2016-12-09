package fr.tanghevandekadsye.jee.controller.rest;

import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserControllerTest {

    @Test
    public void testGenerateToken() {
        assertEquals(30, UserController.generateToken().length());
    }

    @Test
    public void testGenerateTokenWith20Characters() {
        assertEquals(20, UserController.generateToken(20).length());
    }

    @Test
    public void testGenerateTokenWith20CharactersAndOnlyNumbers() {
        String token = UserController.generateToken(20, "0123456789");

        assertEquals(20, token.length());

        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher matcher = pattern.matcher(token);

        assertTrue(matcher.find());
    }

}
