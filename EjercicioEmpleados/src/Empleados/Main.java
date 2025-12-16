/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- SISTEMA DE REGISTRO UNIVERSITARIO ---");
        System.out.println("Seleccione el tipo de empleado:");
        System.out.println("1. Rector");
        System.out.println("2. Coordinador");
        System.out.println("3. Secretaria");
        System.out.println("4. Profesor de Planta");
        System.out.println("5. Profesor Ocasional");
        System.out.println("6. Profesor de Catedra");
        System.out.print("Opcion: ");
        int opcion = sc.nextInt();
        sc.nextLine(); 

        String nombre, correo;
        int celular, documento;

        System.out.print("Nombre: ");
        nombre = sc.nextLine();
        System.out.print("Documento: ");
        documento = sc.nextInt();
        System.out.print("Celular: ");
        celular = sc.nextInt();
        sc.nextLine();
        System.out.print("Correo: ");
        correo = sc.nextLine();

        switch (opcion) {
            case 1 -> {
                System.out.print("Dias trabajados: ");
                int dias = sc.nextInt();
                Rector r = new Rector(nombre, documento, celular, correo,dias);
                r.imprimir_info();
            }

            case 2 -> {
                System.out.print("Horas trabajadas: ");
                int horas = sc.nextInt();
                Coordinador c = new Coordinador(nombre, documento, celular, correo,horas);
                c.imprimir_info();
            }

            case 3 -> {
                System.out.print("Grado (6,7,8,10,13): ");
                int grado = sc.nextInt();
                Secretaria s = new Secretaria(nombre, documento, celular, correo, grado);
                s.imprimir_info();
            }

            case 4 -> {
                System.out.print("Nivel profesional 1=Experto, 2=Profesional, 3=Especialista, 4=Magister, 5=Doctor): ");
                int nivel = sc.nextInt();
                System.out.print("Categoria (1=Experto,2=Auxiliar,3=Asistente,4=Asociado,5=Titular): ");
                int categoria = sc.nextInt();
                System.out.print("Dedicacion (1=Tiempo completo,2=Medio tiempo): ");
                int dedicacion = sc.nextInt();

                ProfesorPlanta p = new ProfesorPlanta(nombre, documento, celular, correo, nivel, categoria, dedicacion);
                p.imprimir_info();
            }

            case 5 -> {
                System.out.print("Nivel profesional (1=Experto, 2=Profesional, 3=Especialista, 4=Magister, 5=Doctor): ");
                int nivel = sc.nextInt();
                System.out.print("Categoria (1=Experto,2=Auxiliar,3=Asistente,4=Asociado,5=Titular): ");
                int categoria = sc.nextInt();
                System.out.print("Dedicacion (1=Tiempo completo,2=Medio tiempo): ");
                int dedicacion = sc.nextInt();
                System.out.print("Meses contratados (1-12): ");
                int meses = sc.nextInt();

                ProfesorOcasional o = new ProfesorOcasional(nombre, documento, celular, correo, nivel, categoria, dedicacion, meses);
                o.imprimir_info();
            }

            case 6 -> {
                System.out.print("Nivel profesional (1=Experto, 2=Profesional, 3=Especialista, 4=Magister, 5=Doctor): ");
                int nivel = sc.nextInt();
                System.out.print("Horas trabajadas: ");
                int horas = sc.nextInt();

                ProfesorCatedra cat = new ProfesorCatedra(nombre, documento, celular, correo, nivel, horas);
                cat.imprimir_info();
            }

            default -> System.out.println(" Opcion invalida.");
        }

        sc.close();
    }
}
