package com.botica.login.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    // Usuarios guardados de forma estática (sin base de datos)
    private record Usuario(String clave, String rol) {}

    private static final Map<String, Usuario> USUARIOS = Map.of(
            "admin",  new Usuario("admin123", "Administrador"),
            "caja01", new Usuario("caja123",  "Cajero"),
            "alm01",  new Usuario("alm123",   "Almacenero")
    );

    @GetMapping("/")
    public String inicio() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String validarLogin(@RequestParam String usuario,
                               @RequestParam String clave,
                               Model model) {
        Usuario u = USUARIOS.get(usuario);
        if (u != null && u.clave().equals(clave)) {
            model.addAttribute("usuario", usuario);
            model.addAttribute("rol", u.rol());
            return "bienvenida";
        }
        model.addAttribute("error", "Credenciales incorrectas");
        return "login";
    }
}