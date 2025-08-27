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
    private final List<String> usuarios = List.of("Andrés", "Maycol", "Christian", "user");

    // 1️⃣ Mostrar formulario de login
    @GetMapping("/Login")
    public String mostrarLogin(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "Login"; // → login.html
    }

    // 2️⃣ Procesar login
    @PostMapping("/Login")
    public String procesarLogin(@ModelAttribute Usuario usuario, Model model) {
        // Aquí validarías usuario/contraseña con tu servicio o BD
        if ("user".equals(usuario.getUser()) && "1234".equals(usuario.getPassword())) {
            model.addAttribute("usuarios", usuarios);
            return "Lista"; // → lista.html
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "Login";
        }
    }

    // 3️⃣ Mostrar lista directamente (ejemplo)
    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarios);
        return "Lista"; // → lista.html
    }
}
