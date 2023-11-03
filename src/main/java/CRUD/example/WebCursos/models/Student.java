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
public class Student extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String studentCode;
    @OneToMany(mappedBy = "student")
    private Set<Cohort> cohorts = new HashSet<>();
    public Student(String name, String lastName, String email, String password, Role role, String studentCode) {
        super(name, lastName, email, password, role);
        this.studentCode = studentCode;
    }

    public void addCohort(Cohort cohort){
        cohort.setStudent(this);
        cohorts.add(cohort);
    }


}
