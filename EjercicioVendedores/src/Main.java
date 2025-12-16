import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       
        System.out.println("ingrese la cantidad de vendedores");
       
        int cantidad=sc.nextInt();
        
        Vendedor[] vendedores=new Vendedor[cantidad];
        
        for(int i=0;i<cantidad;i++){
            System.out.println("Ingrese documento del vendedor: ");
            sc.nextLine();
        String documento= sc.nextLine();
        
        System.out.println("Ingrese tipo de vendedor (1=Puerta a puerta, 2=Telemercadeo)");
        int tipo= sc.nextInt();
        
        System.out.println("Ingrese el valor de ventas del mes");
        double ventas= sc.nextDouble();
        
        vendedores[i]=new Vendedor(documento,tipo,ventas);
        }
        
        double totalcomisiones=0;
        for (Vendedor v:vendedores){
            totalcomisiones+= v.calcularComision();
            
        }
        System.out.println(totalcomisiones);
       
    }
    
}
