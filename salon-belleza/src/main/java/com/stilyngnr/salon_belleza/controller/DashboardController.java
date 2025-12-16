package com.stilyngnr.salon_belleza.controller;

import com.stilyngnr.salon_belleza.repository.CitaRepository;
import com.stilyngnr.salon_belleza.repository.ServicioRepository;
import com.stilyngnr.salon_belleza.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {

    private final CitaRepository citaRepo;
    private final UsuarioRepository usuarioRepo;
    private final ServicioRepository servicioRepo;

    public DashboardController(CitaRepository citaRepo,
                               UsuarioRepository usuarioRepo,
                               ServicioRepository servicioRepo) {
        this.citaRepo = citaRepo;
        this.usuarioRepo = usuarioRepo;
        this.servicioRepo = servicioRepo;
    }

    @GetMapping("/totales")
    public Map<String, Long> totales() {

        int mes = LocalDate.now().getMonthValue();

        long citasMes = citaRepo.countCitasMes(mes);
        long clientes = usuarioRepo.countByRol("ROLE_CLIENTE");
        long servicios = servicioRepo.count();

        return Map.of(
                "citasMes", citasMes,
                "clientesRegistrados", clientes,
                "serviciosActivos", servicios
        );
    }
}
