package com.stilyngnr.salon_belleza.service;

import com.stilyngnr.salon_belleza.model.Usuario;
import com.stilyngnr.salon_belleza.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepo;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepo, PasswordEncoder passwordEncoder) {
        this.usuarioRepo = usuarioRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean telefonoExiste(String telefono) {
        return usuarioRepo.findByTelefono(telefono).isPresent();
    }

    public Usuario registrarCliente(String nombre, String telefono, String email, String clave) {
        Usuario u = new Usuario();
        u.setNombre(nombre);
        u.setTelefono(telefono);
        u.setEmail(email);
        u.setPassword(passwordEncoder.encode(clave));
        u.setRol("ROLE_CLIENTE");
        return usuarioRepo.save(u);
    }
}
