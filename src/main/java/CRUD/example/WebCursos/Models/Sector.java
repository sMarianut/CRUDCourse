package CRUD.example.WebCursos.Models;

import CRUD.example.WebCursos.Enums.SectorName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "sector_tbl")
@Data
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private SectorName sectorName;
    private int min_hours;
    private int max_hours;
    private boolean status;
}
