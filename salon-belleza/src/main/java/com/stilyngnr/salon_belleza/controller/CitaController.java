package com.stilyngnr.salon_belleza.controller;

import com.stilyngnr.salon_belleza.model.Cita;
import com.stilyngnr.salon_belleza.model.Servicio;
import com.stilyngnr.salon_belleza.model.Usuario;
import com.stilyngnr.salon_belleza.repository.ServicioRepository;
import com.stilyngnr.salon_belleza.repository.UsuarioRepository;
import com.stilyngnr.salon_belleza.service.CitaService;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/citas")
@CrossOrigin(origins = "*")
public class CitaController {

    private final CitaService citaService;
    private final UsuarioRepository usuarioRepo;
    private final ServicioRepository servicioRepo;

    public CitaController(CitaService citaService,
                          UsuarioRepository usuarioRepo,
                          ServicioRepository servicioRepo) {
        this.citaService = citaService;
        this.usuarioRepo = usuarioRepo;
        this.servicioRepo = servicioRepo;
    }

    // Crear cita desde el dashboard cliente (con usuario logueado)
    @PostMapping
    public Cita crearCita(@RequestBody Map<String, Object> body) {

        System.out.println("BODY RECIBIDO = " + body);

        // 1. Obtener usuario logueado
        String telefono = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario cliente = usuarioRepo.findByTelefono(telefono)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // 2. Obtener servicio
        Long idServicio = Long.valueOf(body.get("servicio").toString());
        Servicio servicio = servicioRepo.findById(idServicio)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));

        // 3. Crear la cita
        Cita c = new Cita();
        c.setFecha(LocalDate.parse((String) body.get("fecha")));
        c.setHoraInicio(LocalTime.parse((String) body.get("hora")));
        c.setCliente(cliente);
        c.setServicio(servicio);
        c.setEstado(Cita.EstadoCita.REGISTRADA);

        return citaService.guardar(c);
    }

    // Obtener citas SOLO del usuario actual
    @GetMapping("/cliente")
    public List<Cita> citasDelUsuarioActual() {

        String telefono = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario cliente = usuarioRepo.findByTelefono(telefono)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return citaService.listarPorCliente(cliente.getId());
    }

    // Listar todas las citas (admin usa este)
    @GetMapping
    public List<Cita> listarTodas() {
        return citaService.listarTodas();
    }

    // Eliminar cita
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        citaService.eliminar(id);
    }

    @PutMapping("/cancelar/{id}")
    public Cita cancelarCita(@PathVariable Long id) {

    String telefono = SecurityContextHolder.getContext().getAuthentication().getName();

    Usuario cliente = usuarioRepo.findByTelefono(telefono)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    return citaService.cancelar(id, cliente.getId());
}

}
