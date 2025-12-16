package com.stilyngnr.salon_belleza.controller;

import com.stilyngnr.salon_belleza.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/reg")
    public String registro() {
        return "reg";
    }

    @PostMapping("/registro")
    public String procesarRegistro(@RequestParam String nombre,
                                   @RequestParam String telefono,
                                   @RequestParam(required = false) String email,
                                   @RequestParam String clave,
                                   @RequestParam String confirmarClave,
                                   Model model) {

        if (!clave.equals(confirmarClave)) {
            model.addAttribute("errorRegistro", "Las contraseñas no coinciden");
            return "reg";
        }

        if (usuarioService.telefonoExiste(telefono)) {
            model.addAttribute("errorRegistro", "Ya existe un cliente con este teléfono");
            return "reg";
        }

        usuarioService.registrarCliente(nombre, telefono, email, clave);

        return "redirect:/login?registrado";
    }
}
