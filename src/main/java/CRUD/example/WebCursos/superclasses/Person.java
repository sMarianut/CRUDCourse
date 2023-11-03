package CRUD.example.WebCursos.superclasses;

import CRUD.example.WebCursos.enums.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public class Person {
    protected String firstName;
    protected String LastName;
    protected String email;
    protected String password;
    protected Role role;
    public Person() {
    }

    public Person(String firstName, String lastName, String email, String password, Role role) {
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
