package fr.tanghevandekadsye.jee;

import fr.tanghevandekadsye.jee.Interfaces.ContactInfo;

/**
 * Created by quentinvdk on 05/12/16.
 * Verification d'une numéro de téléphone.
 */
public class PhoneCI implements ContactInfo {
    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
