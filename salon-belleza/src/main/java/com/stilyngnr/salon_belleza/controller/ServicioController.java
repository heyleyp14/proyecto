package com.stilyngnr.salon_belleza.controller;

import com.stilyngnr.salon_belleza.model.Servicio;
import com.stilyngnr.salon_belleza.service.ServicioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
@CrossOrigin(origins = "*")
public class ServicioController {

    private final ServicioService service;

    public ServicioController(ServicioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Servicio> listarActivos() {
        return service.listarActivos();
    }

    @GetMapping("/todos")
    public List<Servicio> listarTodos() {
        return service.listarTodos();
    }

    @PostMapping
    public Servicio crear(@RequestBody Servicio s) {
        return service.crear(s);
    }

    @PutMapping("/{id}")
    public Servicio actualizar(@PathVariable Long id, @RequestBody Servicio s) {
        return service.actualizar(id, s);
    }

    @DeleteMapping("/{id}")
    public void archivar(@PathVariable Long id) {
        service.archivar(id); // NO elimina, solo desactiva
    }
}
