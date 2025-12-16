package com.stilyngnr.salon_belleza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class PaginasController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/servicios")
    public String servicios() {
        return "servicios";
    }

    @GetMapping("/acercade")
    public String acercade() {
        return "acercade";
    }

    @GetMapping("/contacto")
    public String contacto() {
        return "contacto";
    }

    // Login (vista)
@GetMapping("/login")
public String loginView() {
    return "login";  // busca login.html en templates
}



    @GetMapping("/cliente/dashboard")
    public String dashboardCliente() {
        return "dashboard-cliente";
    }

    @GetMapping("/admin/dashboard")
    public String dashboardAdmin() {
        return "dashboard-admin";
    }
}
