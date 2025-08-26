package service;

import entity.Alumno;
import repository.AlumnoRepository;

import java.util.List;

public class AlumnoServiceImpl implements AlumnoService{

    private final AlumnoRepository repo;

    public AlumnoServiceImpl(AlumnoRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Alumno> listar() {
        return repo.findAll();
    }

    @Override
    public Alumno save(Alumno alumno) {
        return repo.save(alumno);
    }

    @Override
    public Alumno searchById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
