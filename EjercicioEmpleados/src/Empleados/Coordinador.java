/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso2;

/**
 *
 * @author usuario
 */
public class Coordinador extends Persona{
    
    private int horasTrabajadas;

    public Coordinador(String nombre, int documento, int celular, String correo, int horasTrabajadas) {
        super(nombre, documento, celular,correo);
        this.horasTrabajadas=horasTrabajadas;
    }
    public int getHorasTrabajadas(){
        return horasTrabajadas;
    }
    
    public void setHorasTrabajadas(int horasTrabajadas){
        this.horasTrabajadas=horasTrabajadas;
    }

    @Override
    public double calcular_salario() {
        return 40000*horasTrabajadas;
    }

    @Override
    public void imprimir_info() {
        System.out.println("COORDINADOR");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Documento: " + getDocumento());
        System.out.println("Celular: " + getCelular());
        System.out.println("Correo: " + getCorreo());
        System.out.printf("Salario: $%,.0f%n", calcular_salario());
        
    }
    
}
