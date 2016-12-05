package fr.tanghevandekadsye.jee;

import fr.tanghevandekadsye.jee.Interfaces.ContactInfo;

/**
 * Created by quentinvdk on 05/12/16.
 * Verification d'une numéro de téléphone.
 */
public class PhoneCI implements ContactInfo {
    protected String phoneNumber;

    public PhoneCI(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean isValid() {
        Pattern pattern = Pattern.compile("^[0-9]{10}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    @Override
    public String toString() {
        return this.phoneNumber;
    }
}
