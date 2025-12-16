public class Cliente {
    private long documentoIdentidad;
    private String nombre;
    private String correo;
    private int numeroCelular;
    private String direccion;
    
    public Cliente(long documentoIdentidad, String nombre, String correo, int numeroCelular, String direccion){
        this.documentoIdentidad= documentoIdentidad;
        this.nombre= nombre;
        this.correo=correo;
        this.numeroCelular=numeroCelular;
        this.direccion=direccion;
    }
    
    public long getDocumentoIdentidad(){
        return documentoIdentidad;
    }
    
    public void setDocumentoIdentidad(long documentoIdentidad){
        this.documentoIdentidad=documentoIdentidad;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getCorreo(){
        return correo;
    }
    
    public void setCorreo(String correo){
        this.correo=correo;
    }
    public int getNumeroCelular(){
        return numeroCelular;
    }
    
    public void setNumeroCelular(int numeroCelular){
        this.numeroCelular=numeroCelular;
    }
    public String getDireccion(){
        return direccion;
    }
    
    public void setDireccion (String direccion){
        this.direccion=direccion;
    }
    
}
