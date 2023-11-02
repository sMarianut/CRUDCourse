package CRUD.example.WebCursos.repositories;

import CRUD.example.WebCursos.models.Cohort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CohortRepository extends JpaRepository<Cohort, Long> {
}
