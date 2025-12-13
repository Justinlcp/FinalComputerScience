package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private int StreetNo;
    private String street;
    private String city;
    private Province province;
    private String postalCode;

    public enum Province {
        AB, BC, MB, NB, NL, NS, NT, NU, ON, PE, QC, SK, YT
    }

    /**
     * Checks if a postcode is valid or not. The length of a postal code can only be 6.
     * The postcode must follow the format: CDCDCD, where C is a character, while D
     * is a digit, such as A1B2C3.
     * @param postalCode the given postal code
     * @return True or False as the validity of the given postal code
     */
    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode == null || postalCode.length() != 6) {
            return false;
        }

        for (int i = 0; i < 6; i++) {
            char c = postalCode.charAt(i);

            if (i % 2 == 0) {
                if (!Character.isLetter(c)) {
                    return false;
                }
            } else {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
        }

        return true;
    }
}