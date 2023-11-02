package CRUD.example.WebCursos.models;

import CRUD.example.WebCursos.superclasses.Person;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@NoArgsConstructor
public class Student extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private long id;
    private String studentCode;
    @OneToMany(mappedBy = "student")
    private Set<Cohort> cohorts = new HashSet<>();
    public void addCohort(Cohort cohort){
        cohort.setStudent(this);
        cohorts.add(cohort);
    }


}
