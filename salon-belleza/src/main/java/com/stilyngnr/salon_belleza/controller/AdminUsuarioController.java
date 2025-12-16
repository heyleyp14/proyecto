package com.stilyngnr.salon_belleza.controller;

import com.stilyngnr.salon_belleza.model.Usuario;
import com.stilyngnr.salon_belleza.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class AdminUsuarioController {

    private final UsuarioRepository usuarioRepo;

    public AdminUsuarioController(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @GetMapping("/clientes")
    public List<Usuario> listarClientes() {
        return usuarioRepo.findByRol("ROLE_CLIENTE");
    }
}
