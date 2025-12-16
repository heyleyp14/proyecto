/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso2;

/**
 *
 * @author usuario
 */
public class ProfesorPlanta extends Profesor{
    private int categoria;
    private int dedicacion;

    public ProfesorPlanta(String nombre, int documento, int celular, String correo, int nivelProfesional, int categoria, int dedicacion) {
        super(nombre, documento, celular, correo, nivelProfesional);
        this.categoria=categoria;
        this.dedicacion=dedicacion;
    }
    public int getCategoria(){
        return categoria;
    }
    
    public void setCategoria(int categoria){
        this.categoria=categoria;
        
    }
    
    public int getDedicacion(){
        return dedicacion;
    }
    public void setDedicacion(int dedicacion){
        this.dedicacion=dedicacion;
    }

    @Override
    public double calcular_salario() {
        double salario=0;
        if (categoria==1){ //sin titulo
            if(dedicacion==1){
                salario=2743366; //tiempo completo
            }else{
                salario=1371683; //medio tiempo
            }
        }else if(categoria==2){ //auxiliar
            if(dedicacion==1){
                salario=3849684; //tiempo completo
            }else{
                salario=1924842; //medio tiempo
            }
        }else if(categoria==3){ //asistente
            if(dedicacion==1){
                salario=4499477; //tiempo completo
            }else{
                salario=2249739; //medio tiempo
            }
        }else if(categoria==4){ //asociado
            if(dedicacion==1){
                salario=4841007; //tiempo completo
            }else{
                salario=2420504; //medio tiempo
            } 
        }else{ //titular
            if(dedicacion==1){ 
                salario=5212876; //tiempo completo
            }else{
                salario=2606438; //medio tiempo
            }
        }
        return salario;
    }

    @Override
    public void imprimir_info() {
    String nombreCategoria = switch (categoria) {
        case 1 -> "Experto";
        case 2 -> "Auxiliar";
        case 3 -> "Asistente";
        case 4 -> "Asociado";
        case 5 -> "Titular";
        default -> "Desconocida";
    };
    
    String nivel = switch (getNivelProfesional()) {
        case 1 -> "Experto";
        case 2 -> "Profesional";
        case 3 -> "Especialista";
        case 4 -> "Magister";
        case 5 -> "Doctor";
        default -> "Desconocido";
    };

    System.out.println("PROFESOR DE PLANTA");
    System.out.println("Nombre: " + getNombre());
    System.out.println("Documento: " + getDocumento());
    System.out.println("Celular: " + getCelular());
    System.out.println("Correo: " + getCorreo());
    System.out.println("Nivel profesional: " + nivel);
    System.out.println("Categoria: " + nombreCategoria);
    System.out.println("Dedicacion: " + (dedicacion == 1 ? "Tiempo completo" : "Medio tiempo"));
    System.out.printf("Salario: $%,.0f%n", calcular_salario());
}
}
