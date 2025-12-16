package com.stilyngnr.salon_belleza;

import com.stilyngnr.salon_belleza.model.Usuario;
import com.stilyngnr.salon_belleza.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SalonBellezaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalonBellezaApplication.class, args);
	}

	@Bean
	CommandLineRunner initAdmin(UsuarioRepository usuarioRepo,
	                            PasswordEncoder encoder) {

		return args -> {

			// 🔐 CONTRASEÑA DEL ADMIN
			String passwordPlano = "1234";

			// Verificar si YA existe admin
			Usuario admin = usuarioRepo.findByTelefono("3178734424") // teléfono del admin
					.orElseGet(Usuario::new);

			admin.setNombre("Administrador");
			admin.setTelefono("3178734424");  // este es su usuario
			admin.setEmail("admin@stilyngnr.com");
			admin.setPassword(encoder.encode(passwordPlano));
			admin.setRol("ROLE_ADMIN");

			usuarioRepo.save(admin);

			System.out.println("🔑 Admin creado/actualizado: tel=3178734424 / clave=" + passwordPlano);
		};
	}
}
