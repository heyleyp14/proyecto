/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso2;

/**
 *
 * @author usuario
 */
public class Rector extends Persona{
    
    private int diasTrabajados;

    public Rector(String nombre, int documento, int celular, String correo, int diasTrabajados) {
        super(nombre, documento, celular, correo);
        this.diasTrabajados=diasTrabajados;
    }
    
    public int getDiasTrabajados(){
        return diasTrabajados;
    }
    
    public void setDiasTrabajados(int diasTrabajados){
        this.diasTrabajados=diasTrabajados;
    }

    @Override
    public double calcular_salario() {
        return 496702*diasTrabajados;
    }

    @Override
    public void imprimir_info() {
    System.out.println("RECTOR");
    System.out.println("Nombre: " + getNombre());
    System.out.println("Documento: " + getDocumento());
    System.out.println("Celular: " + getCelular());
    System.out.println("Correo: " + getCorreo());
    System.out.printf("Salario: $%,.0f%n", calcular_salario());
}  
}
