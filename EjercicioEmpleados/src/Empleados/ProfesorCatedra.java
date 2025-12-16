/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso2;

/**
 *
 * @author usuario
 */
public class ProfesorCatedra extends Profesor{
    private int horasTrabajadas;

    public ProfesorCatedra(String nombre, int documento, int celular, String correo, int nivelProfesional, int horasTrabajadas) {
        super(nombre, documento, celular, correo, nivelProfesional);
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
  
        double valorHora=0;
        int nivel=getNivelProfesional();
        switch(nivel){
            case 1: //experto
                valorHora=17129;
            break;
            
            case 2: //profesional
                valorHora=25371;
            break;
            
            case 3: //especializacion
                valorHora=32032;
            break;
            
            case 4: //maestria
                valorHora=39004;
            break;
            
            case 5: //doctorado
                valorHora=42030;
            break;
        }
        return valorHora*horasTrabajadas;
    }


    @Override
    public void imprimir_info() {
        
       String nivel = switch (getNivelProfesional()) {
        case 1 -> "Experto";
        case 2 -> "Profesional";
        case 3 -> "Especialista";
        case 4 -> "Magister";
        case 5 -> "Doctor";
        default -> "Desconocido";
    }; 
        System.out.println("PROFESOR DE CATEDRA");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Documento: " + getDocumento());
        System.out.println("Celular: " + getCelular());
        System.out.println("Correo: " + getCorreo());
        System.out.println("Nivel profesional: " + nivel);
        System.out.println("Horas trabajadas: " + horasTrabajadas);
        System.out.println("Salario: $" + calcular_salario());
}
    
}
