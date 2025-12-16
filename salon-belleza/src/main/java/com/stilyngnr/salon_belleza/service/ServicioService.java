package com.stilyngnr.salon_belleza.service;

import org.springframework.stereotype.Service;
import com.stilyngnr.salon_belleza.model.Servicio;
import com.stilyngnr.salon_belleza.repository.ServicioRepository;

import java.util.List;

@Service
public class ServicioService {

    private final ServicioRepository repo;

    public ServicioService(ServicioRepository repo) {
        this.repo = repo;
    }

    public List<Servicio> listarActivos() {
        return repo.findByActivoTrue();
    }

    public List<Servicio> listarTodos() {
        return repo.findAll();
    }

    public Servicio crear(Servicio s) {
        s.setActivo(true);
        return repo.save(s);
    }

    public Servicio actualizar(Long id, Servicio datos) {
        Servicio s = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));

        s.setNombre(datos.getNombre());
        s.setDuracion(datos.getDuracion());
        s.setPrecio(datos.getPrecio());

        return repo.save(s);
    }

    public void archivar(Long id) {
        Servicio s = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));

        s.setActivo(false);

        repo.save(s);
    }
}
