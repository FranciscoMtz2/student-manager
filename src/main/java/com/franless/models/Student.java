package com.franless.models;

import lombok.Getter;
import lombok.Setter;

public class Student {
    @Getter @Setter private Integer id;
    @Getter @Setter private String name;
    @Getter @Setter private Long mobile;
    @Getter @Setter private String country;
}
