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

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.departmentId = String.format("D%02d", nextId);
        nextId++;

        if (!isDepartmentNameValid(departmentName)) {
            this.departmentId = null;
            this.departmentName = null;
            return;
        }
    }

    /**
     * checks if a department name is valid or not, a department
     * name should only contain letters or space
     * @param departmentName the given department name as a string
     * @return True or False as the validity if the department name
     */
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
