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
    @Setter private String departmentName;
    private static int nextId = 1;
}
