/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso2;

/**
 *
 * @author usuario
 */
public abstract class Persona {
    private String nombre;
    private int documento;
    private int celular;
    private String correo;
    
    public Persona(String nombre, int documento, int celular, String correo){
        this.nombre=nombre;
        this.documento=documento;
        this.celular=celular;
        this.correo=correo;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public int getDocumento(){
        return documento;
    }
    
    public void setDocumento(int documento){
        this.documento=documento;
    }
    public int getCelular(){
        return celular;
    }
    
    public void setCelular(int celular){
        this.celular=celular;
    }
    
    public String getCorreo(){
        return correo;
    }
    
    public void setCorreo(String correo){
        this.correo=correo;
    }
    public abstract double calcular_salario();
    
    public abstract void imprimir_info();
}
