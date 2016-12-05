package fr.tanghevandekadsye.jee;

import fr.tanghevandekadsye.jee.Interfaces.ContactInfo;
import java.util.regex.Pattern;

/**
 * Created by quentinvdk on 05/12/16.
 * Validation d'un email.
 */
public class EmailCI implements ContactInfo {
    protected String email;

    public EmailCI(String email) {
        this.email = email;
    }

    @Override
    public boolean isValid() {
        Pattern pattern = Pattern.compile("^([a-zA-Z0-9-_.]+)@([a-zA-Z-_.])\.([a-z]+)$");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    @Override
    public String toString() {
        return this.email;
    }
}
