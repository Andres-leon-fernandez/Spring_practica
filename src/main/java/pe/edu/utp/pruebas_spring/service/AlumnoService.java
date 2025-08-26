package pe.edu.utp.pruebas_spring.service;

import pe.edu.utp.pruebas_spring.entity.Alumno;

import java.util.List;

public interface AlumnoService {
    List<Alumno> listar();
    Alumno save(Alumno alumno);
    Alumno searchById(Long id);
    void eliminar(Long id);
}
