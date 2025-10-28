/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso2;

/**
 *
 * @author usuario
 */
public class Secretaria extends Persona{
    private int grado;

    public Secretaria(String nombre, int documento, int celular, String correo, int grado) {
        super(nombre, documento, celular,correo);
        this.grado=grado;
    }
    
    public int getGrado(){
        return grado;
    }
    
    public void setGrado(int grado){
        this.grado=grado;
    }

    @Override
    public double calcular_salario() {
        double salario=0;
        switch(grado){
            case 6:
                salario=2815978;
            break;
            
            case 7:
                salario=3082037;
            break;
            
            case 8:
                salario=3265637;
            break;
            
            case 10:
                salario=3411430;
            break;
            
            case 13:
                salario=3931792;
            break;
        }
        return salario;
    }

    @Override
    public void imprimir_info() {
        System.out.println("SECRETARIA");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Documento: " + getDocumento());
        System.out.println("Celular: " + getCelular());
        System.out.println("Correo: " + getCorreo());
        System.out.printf("Salario: $%,.0f%n", calcular_salario());
    }
    
}
