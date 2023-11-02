package CRUD.example.WebCursos.models;

import CRUD.example.WebCursos.enums.Stacks;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "stack_tbl")
@Data
@NoArgsConstructor
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private long id;
    private Stacks name;
    private boolean status;
    private Arrays technologies;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;

}
