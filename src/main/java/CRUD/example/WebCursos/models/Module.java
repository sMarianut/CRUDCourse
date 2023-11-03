package CRUD.example.WebCursos.models;

import CRUD.example.WebCursos.enums.Stacks;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Arrays;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "module_tbl")
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Stacks name;
    private boolean status;
    private String technologies;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public Module(Stacks name, boolean status, String technologies) {
        this.name = name;
        this.status = status;
        this.technologies = technologies;
    }

}
