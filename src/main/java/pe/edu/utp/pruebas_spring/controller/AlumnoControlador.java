package pe.edu.utp.pruebas_spring.controller;

import pe.edu.utp.pruebas_spring.entity.Alumno;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.utp.pruebas_spring.service.AlumnoService;

public class AlumnoControlador {

    private final AlumnoService service;

    public AlumnoControlador(AlumnoService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model){
        model.addAttribute("alumnos",service.listar());
        return "alumnos";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model){
        model.addAttribute("alumno",new Alumno());
        return "form";
    }

    @PostMapping
    public String guardar(@ModelAttribute Alumno alumno){
        service.save(alumno);
        return "redirect:/alumnos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id){
        service.eliminar(id);
        return "redirect:/alumnos";
    }
}
