public class Cuenta {
    private long numeroCuenta;
    private String fechaApertura;
    private int tipoCuenta;
    private double saldo;
    
    public Cuenta(long numeroCuenta, String fechaApertura, int tipoCuenta, double saldo){
        this.numeroCuenta=numeroCuenta;
        this.fechaApertura=fechaApertura;
        this.tipoCuenta=tipoCuenta;
        this.saldo=saldo;
        
    }
    
    public long getNumeroCuenta(){
        return numeroCuenta;
    }
    
    public void setNumeroCuenta(long numeroCuenta){
        this.numeroCuenta=numeroCuenta;
    }
    
    public String getFechaApertura(){
        return fechaApertura;
    }
    
    public void setFechaApertura(String fechaApertura){
        this.fechaApertura=fechaApertura;
    }
    
    public int getTipoCuenta(){
        return tipoCuenta;
    }
    
    public void setTipoCuenta(int tipoCuenta){
        this.tipoCuenta=tipoCuenta;
    }
    
    public double getSaldo(){
        return saldo;
    }
    
    public void setSaldo(double saldo){
        this.saldo=saldo;
    }
    
    public double calcular_interes(){
        double porcentaje=0;
        
        switch(tipoCuenta){
            case 1:
                porcentaje=1.5;
                break;
            case 2:
                porcentaje=1.7;
                break;
            case 3:
                porcentaje=1.6;
                break;
            default:
                porcentaje=0;
                break;
        }
        return saldo*(porcentaje/100);
  
    }
}
