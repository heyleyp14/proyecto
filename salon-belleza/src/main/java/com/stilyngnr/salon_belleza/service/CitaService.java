package com.stilyngnr.salon_belleza.service;

import com.stilyngnr.salon_belleza.exception.OperacionNoPermitidaException;
import com.stilyngnr.salon_belleza.model.Cita;
import com.stilyngnr.salon_belleza.model.Usuario;
import com.stilyngnr.salon_belleza.repository.CitaRepository;
import com.stilyngnr.salon_belleza.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class CitaService {

    private final CitaRepository citaRepo;
    private final UsuarioRepository usuarioRepo;

    public CitaService(CitaRepository citaRepo, UsuarioRepository usuarioRepo) {
        this.citaRepo = citaRepo;
        this.usuarioRepo = usuarioRepo;
    }

    public Cita guardar(Cita cita) {

    int duracion = cita.getServicio().getDuracion(); // minutos

    LocalTime horaInicio = cita.getHoraInicio();
    LocalTime horaFin = horaInicio.plusMinutes(duracion);

    // Validar que no haya solape
    boolean ocupado = citaRepo.existeSolape(
        cita.getFecha(),
        horaInicio,
        horaFin
    );

    if (ocupado) {
        throw new RuntimeException("Horario no disponible");
    }

    cita.setHoraFin(horaFin);
    cita.setEstado(Cita.EstadoCita.REGISTRADA);

    return citaRepo.save(cita);
}


    public List<Cita> listarTodas() {
        return citaRepo.findAll();
    }

    public List<Cita> listarPorCliente(Long idCliente) {

        Usuario cliente = usuarioRepo.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        return citaRepo.findByCliente(cliente);
    }

    public void eliminar(Long id) {
        citaRepo.deleteById(id);
    }
    public Cita cambiarEstado(Long id, Cita.EstadoCita nuevoEstado) {
    Cita c = citaRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Cita no encontrada"));

    c.setEstado(nuevoEstado);
    return citaRepo.save(c);
}

    public Cita cancelar(Long idCita, Long idCliente) {

    Cita c = citaRepo.findById(idCita)
            .orElseThrow(() -> new RuntimeException("Cita no encontrada"));

    if (!c.getCliente().getId().equals(idCliente)) {
        throw new OperacionNoPermitidaException("No puedes cancelar una cita que no es tuya");
    }
    if (c.getEstado() != Cita.EstadoCita.REGISTRADA) {
        throw new OperacionNoPermitidaException("Solo puedes cancelar citas aprobadas");
    }

    // ---- VALIDACIÓN DE 12 HORAS ----
    LocalDateTime ahora = LocalDateTime.now();
    LocalDateTime fechaCita = LocalDateTime.of(c.getFecha(), c.getHoraInicio());

    if (fechaCita.minusHours(12).isBefore(ahora)) {
        throw new OperacionNoPermitidaException("Solo puedes cancelar tu cita con mínimo 12 horas de anticipación.");

    }

    // ---- Cancelación ----
    c.setEstado(Cita.EstadoCita.CANCELADA);
    return citaRepo.save(c);
}


}
