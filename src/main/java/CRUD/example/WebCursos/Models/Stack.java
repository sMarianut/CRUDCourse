package CRUD.example.WebCursos.Models;

import CRUD.example.WebCursos.Enums.Stacks;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "stack_tbl")
@Data
public class Stack {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private Stacks stack;
    private int totalHours;
    private boolean status;
}
