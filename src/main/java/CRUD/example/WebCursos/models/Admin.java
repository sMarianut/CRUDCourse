package CRUD.example.WebCursos.models;

import CRUD.example.WebCursos.enums.Role;
import CRUD.example.WebCursos.superclasses.Person;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Admin extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String adminCode;
    public Admin(String name, String lastName, String email, String password, Role role, String adminCode) {
        super(name, lastName, email, password, role);
        this.adminCode = adminCode;
    }

}
