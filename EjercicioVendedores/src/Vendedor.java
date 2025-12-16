public class Vendedor {
    private String documento;
    private int tipoVendedor;
    private double valorVentas;
    
    public Vendedor(String documento, int tipoVendedor, double valorVentas){
        this.documento=documento;
        this.tipoVendedor=tipoVendedor;
        this.valorVentas=valorVentas;
    }
    
    public String getDocumento(){
        return documento;
    }
    
    public void setDocumento(String documento){
        this.documento=documento;
    }
    
    public int getTipoVendedor(){
        return tipoVendedor;
    }
    
    public void setTipoVendedor(int tipoVendedor){
        this.tipoVendedor=tipoVendedor;
    }
    
    public double getValorVentas(){
        return valorVentas;
    }
    
    public void setValorVentas(double valorVentas){
        this.valorVentas=valorVentas;
    }
    
    public double calcularComision(){
        double comision=0;
        if(tipoVendedor==1){
            comision=valorVentas*0.25;
        }else if(tipoVendedor==2){
            comision=valorVentas*0.20;
        }
        return comision;
    }
    
    @Override
    public String toString(){
        return "Documento: "+documento+
                ", tipo vendedor: "+tipoVendedor
        +" valorVentas= "+valorVentas+"comision: "+ calcularComision()
        ;
    }
}
