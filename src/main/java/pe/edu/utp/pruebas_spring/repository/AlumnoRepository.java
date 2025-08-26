package pe.edu.utp.pruebas_spring.repository;

import pe.edu.utp.pruebas_spring.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Long>{

    Optional<Alumno> findByEmail(String email);

    List<Alumno> findByNombreContaining(String nombre);

    List<Alumno> findByNombreContainingIgnoreCase(String email);
}
