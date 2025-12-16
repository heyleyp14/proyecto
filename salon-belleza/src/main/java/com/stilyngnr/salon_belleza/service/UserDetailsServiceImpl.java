package com.stilyngnr.salon_belleza.service;

import com.stilyngnr.salon_belleza.model.Usuario;
import com.stilyngnr.salon_belleza.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepo;

    public UserDetailsServiceImpl(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String telefono) throws UsernameNotFoundException {

        Usuario u = usuarioRepo.findByTelefono(telefono)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return new User(
                u.getTelefono(),                // username = telefono
                u.getPassword(),                // password encriptado
                List.of(new SimpleGrantedAuthority(u.getRol()))
        );
    }
}
