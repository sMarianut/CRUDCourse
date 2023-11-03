package CRUD.example.WebCursos.models;

import CRUD.example.WebCursos.enums.Role;
import CRUD.example.WebCursos.superclasses.Person;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Teacher extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String teaherCode;
    @OneToMany(mappedBy = "teacher")
    private Set<Module> modules = new HashSet<>();
    public Teacher(String name, String lastName, String email, String password, Role role, String teacherCode) {
        super(name, lastName, email, password, role);
        this.teaherCode = teacherCode;
    }

    public void addModule(Module mod){
        mod.setTeacher(this);
        this.modules.add(mod);
    }
}
