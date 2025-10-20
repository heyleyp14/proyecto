import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        
        System.out.println("\n --- LIQUIDACION INTERESES DE CUENTAS DE AHORRO ---");
        System.out.print("Ingrese la cantidad de cuentas de ahorro: ");
        int n= sc.nextInt();
        
        long[] numeroCuenta= new long[n];
        String[] fechaApertura= new String[n];
        int[] tipoCuenta= new int[n];
        double[] saldo=new double[n];
        double[] interesMensual= new double[n];
        
        double totalInteres=0;
        double totalSaldos=0;
        
        for(int i=0;i<n;i++){
            System.out.println("\nCuenta "+(i+1));
            
            System.out.print("Numero de cuenta: ");
            numeroCuenta[i]=sc.nextLong();
            
            System.out.print("Fecha de apertura (aaaa-mm-dd): ");
            fechaApertura[i]=sc.next();
            
            System.out.print("Tipo de cuenta (1: AhorroDiario, 2: CuentaJoven, 3: Tradicional): ");
            tipoCuenta[i]=sc.nextInt();
            
            System.out.print("Saldo de la cuenta: ");
            saldo[i]=sc.nextDouble();
            
            double porcentaje=0;
            
            switch(tipoCuenta[i]){
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
                    System.out.println("Tipo de cuenta invalido");
                    porcentaje=0;
                    break;
            }
            
            interesMensual[i]=(porcentaje/100)*saldo[i];
            saldo[i]+=interesMensual[i];
            
            totalInteres+=interesMensual[i];
            totalSaldos+=saldo[i];
        }
        
        System.out.println("\n--- INFORMACION CUENTAS DE AHORRO ---");
        System.out.printf("%-15s %-20s %-20s%n", "Nro Cuenta", "Interes mensual", "Nuevo saldo");
        
        for(int i=0;i<n;i++){
             System.out.printf("%-15d $%-19.2f $%-19.2f%n", numeroCuenta[i], interesMensual[i], saldo[i]);
        }
        
        System.out.println("\nValor total de intereses: $"+ String.format("%.2f",totalInteres));
        System.out.println("Valor total de los saldos: $"+ String.format("%.2f",totalSaldos));
        
        
    }
}
