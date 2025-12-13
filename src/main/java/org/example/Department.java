package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Getter
@ToString
@EqualsAndHashCode
public class Department {

    private String departmentId;
    @Setter
    private String departmentName;
    private static int nextId = 1;

    public static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null) {
            return false;
        }

        for (int i = 0; i < departmentName.length(); i++) {
            char letter = departmentName.charAt(i);

            if (letter == ' ') {
                continue;
            }

            if (!Character.isLetter(letter)) {
                return false;
            }
        }
        return true;
    }
}
