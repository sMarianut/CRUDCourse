package CRUD.example.WebCursos.SuperClasses;

import CRUD.example.WebCursos.Enums.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person {
    private String name;
    private String fullName;
    private String email;
    private String password;
    private Role role;
    private String UserCode;

}
