package com.stilyngnr.salon_belleza.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "citas")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;
  private LocalTime horaInicio;
private LocalTime horaFin;


    @Enumerated(EnumType.STRING)
    private EstadoCita estado = EstadoCita.REGISTRADA;

    public enum EstadoCita {
        REGISTRADA,
        CANCELADA,
        FINALIZADA
    }

    @ManyToOne
    @JsonIgnoreProperties("*")
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    @ManyToOne
    @JsonIgnoreProperties("*")
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalTime getHoraInicio() {
    return horaInicio;
}

public void setHoraInicio(LocalTime horaInicio) {
    this.horaInicio = horaInicio;
}

public LocalTime getHoraFin() {
    return horaFin;
}

public void setHoraFin(LocalTime horaFin) {
    this.horaFin = horaFin;
}


    public Usuario getCliente() { return cliente; }
    public void setCliente(Usuario cliente) { this.cliente = cliente; }

    public Servicio getServicio() { return servicio; }
    public void setServicio(Servicio servicio) { this.servicio = servicio; }

    public EstadoCita getEstado() {return estado;}

    public void setEstado(EstadoCita estado) {this.estado = estado;}

}
