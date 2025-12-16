/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso2;

/**
 *
 * @author usuario
 */
public abstract class Profesor extends Persona{
    
    private int nivelProfesional;

    public Profesor(String nombre, int documento, int celular, String correo, int nivelProfesional) {
        super(nombre, documento, celular, correo);
        this.nivelProfesional=nivelProfesional;
    }
    
    public int getNivelProfesional(){
        return nivelProfesional;
    }
    
    public void setNivelProfesional(int nivelProfesional){
        this.nivelProfesional=nivelProfesional;
    }
   
    
    
}
