import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       
        System.out.println("Ingrese documento del vendedor: ");
        String documento= sc.nextLine();
        
        System.out.println("Ingrese tipo de vendedor (1=Puerta a puerta, 2=Telemercadeo)");
        int tipo= sc.nextInt();
        
        System.out.println("Ingrese el valor de ventas del mes");
        double ventas= sc.nextDouble();
        
        Vendedor vendedor= new Vendedor(documento, tipo, ventas);
        
        double comision= vendedor.calcularComision();
        
        System.out.println("\n--- LIQUIDACION DE COMSION ---");
        System.out.println("Documento: " +vendedor.getDocumento());
        System.out.println("Tipo de vendedor: " +(vendedor.getTipoVendedor()==1?"Puerta a puerta":"Telemercadeo"));
        System.out.println("Valor ventas del mes: $"+vendedor.getValorVentas());
        System.out.println("Comision a pagar: $"+comision);
       
    }
    
}
