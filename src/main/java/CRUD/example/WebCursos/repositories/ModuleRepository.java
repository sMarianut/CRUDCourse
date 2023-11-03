package CRUD.example.WebCursos.repositories;

import CRUD.example.WebCursos.models.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module, Long> {
}
