package pe.edu.utp.pruebas_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.utp.pruebas_spring.entity.Usuario;

import java.util.List;

@Controller
public class UsuarioController {
    private final List<String> usuarios = List.of("Andrés", "Maycol", "Christian");

    // 1️⃣ Mostrar formulario de login
    @GetMapping("/login")
    public String mostrarLogin(Model model) {
        // Aquí mandas un objeto vacío para que Thymeleaf lo use en el form
        model.addAttribute("usuario", new Usuario());
        return "login"; // → login.html
    }

    // 2️⃣ Procesar login
    @PostMapping("/login")
    public String procesarLogin(@ModelAttribute Usuario usuario, Model model) {
        // Aquí validarías usuario/contraseña con tu servicio o BD
        if ("admin".equals(usuario.getNombre()) && "123".equals(usuario.getPassword())) {
            model.addAttribute("usuarios", usuarios);
            return "lista"; // → lista.html
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        }
    }

    // 3️⃣ Mostrar lista directamente (ejemplo)
    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarios);
        return "lista"; // → lista.html
    }
}
