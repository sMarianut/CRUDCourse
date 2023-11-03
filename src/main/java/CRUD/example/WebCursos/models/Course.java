package CRUD.example.WebCursos.models;

import CRUD.example.WebCursos.enums.Payment;
import CRUD.example.WebCursos.enums.PaymentMethod;
import CRUD.example.WebCursos.enums.Sector;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "course_tbl")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @OneToMany(mappedBy = "course")
    private Set<Cohort> cohorts = new HashSet<>();

    public Course(String name, String description, boolean status, Payment payment, PaymentMethod paymentMethod, String studyPlan, int totalHours,Sector sector) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.payment = payment;
        this.paymentMethod = paymentMethod;
        this.studyPlan = studyPlan;
        this.totalHours = totalHours;
        this.sector = sector;
    }

    public void addModule(Module module){
        module.setCourse(this);
        modules.add(module);
    }
    public void addCohort(Cohort cohort){
        cohort.setCourse(this);
        cohorts.add(cohort);
    }
}
