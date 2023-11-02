package CRUD.example.WebCursos.models;

import CRUD.example.WebCursos.enums.Payment;
import CRUD.example.WebCursos.enums.PaymentMethod;
import CRUD.example.WebCursos.enums.Sector;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course_tbl")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String name;

    private String description;

    private boolean status;

    private Payment payment;

    private PaymentMethod paymentMethod;

    private String studyPlan;

    private int totalHours;

    private Sector sector;

    @OneToMany(mappedBy = "course")
    private Set<Module> modules = new HashSet<>();

    @OneToMany(mappedBy = "cohort")
    private Set<Cohort> cohorts = new HashSet<>();
    public void addModule(Module module){
        module.setCourse(this);
        modules.add(module);
    }
    public void addCohort(Cohort cohort){
        cohort.setCourse(this);
        cohorts.add(cohort);
    }
}
