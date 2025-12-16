package com.stilyngnr.salon_belleza.repository;

import com.stilyngnr.salon_belleza.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByTelefono(String telefono);
    List<Usuario> findByRol(String rol);

    long countByRol(String rol);


}
