package CRUD.example.WebCursos.superclasses;

import CRUD.example.WebCursos.enums.Role;

import javax.persistence.MappedSuperclass;


public class Person {
    private String firstName;
    private String LastName;
    private String email;
    private String password;
    private Role role;


}
