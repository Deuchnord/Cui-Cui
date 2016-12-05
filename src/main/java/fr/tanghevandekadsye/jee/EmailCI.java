package fr.tanghevandekadsye.jee;

import fr.tanghevandekadsye.jee.Interfaces.ContactInfo;

/**
 * Created by quentinvdk on 05/12/16.
 * Validation d'un email.
 */
public class EmailCI implements ContactInfo {
    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
