public class CuentaCorriente extends Cuenta{
    private double porcentajeInteres;
    private double valorSobregiro;
    
    public CuentaCorriente(long documentoIdentidad, String nombre, String correo, int numeroCelular, String direccion, long numeroCuenta, String fechaApertura, double saldo, double porcentajeInteres, double valorSobregiro){
        super(documentoIdentidad, nombre, correo, numeroCelular, direccion, numeroCuenta, fechaApertura, 0, saldo);
        this.porcentajeInteres=porcentajeInteres;
        this.valorSobregiro=valorSobregiro;
        
    }
    
    public double getPorcentajeInteres(){
        return porcentajeInteres;
    }
    
    public void setPorcentajeInteres(double porcentajeInteres){
        this.porcentajeInteres=porcentajeInteres;
    }
    
    public double getValorSobregiro(){
        return valorSobregiro;
    }
    
    public void setValorSobregiro(double valorSobregiro){
        this.valorSobregiro=valorSobregiro;
    }
    
    @Override
    public double calcular_interes(){
        return getSaldo()*(porcentajeInteres/100);
  
    }
}
