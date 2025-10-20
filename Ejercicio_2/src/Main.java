import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n --- LIQUIDACION INTERESES DE CUENTAS DE AHORRO ---");
        System.out.print("Ingrese la cantidad de cuentas de ahorro: ");
        int n= sc.nextInt();
        
        Cuenta[] cuentas = new Cuenta[n];
        
        double totalIntereses=0;
        double totalSaldos=0;
        double[] intereses = new double[n];
        
        for (int i = 0; i < n; i++) {
            System.out.println("\nCuenta " + (i + 1));
            
            System.out.print("Numero de cuenta: ");
            long numero = sc.nextLong();
            
            System.out.print("Fecha de apertura (aaaa/mm/dd): ");
            String fechaApertura = sc.next();
            
            System.out.print("Tipo de cuenta (1:AhorroDiario, 2:CuentaJoven, 3:Tradicional): ");
            int tipo = sc.nextInt();
            
            System.out.print("Saldo actual: ");
            double saldo = sc.nextDouble();
            
            cuentas[i] = new Cuenta(numero, fechaApertura, tipo, saldo);
            
            double interes = cuentas[i].calcular_interes();
            intereses[i]=interes;
            
            cuentas[i].setSaldo(cuentas[i].getSaldo() + interes);
            
            totalIntereses += interes;
            totalSaldos += cuentas[i].getSaldo();
        }
   
        System.out.println("\n--- INFORMACION DE LAS CUENTAS ---");
        System.out.printf("%-15s %-20s %-20s%n", "Nro Cuenta", "Interes mensual", "Nuevo saldo");
        
        for (int i = 0; i < n; i++) {
            double interes = cuentas[i].calcular_interes(); 
            System.out.printf("%-15d $%-19.2f $%-19.2f%n", cuentas[i].getNumeroCuenta(), intereses[i], cuentas[i].getSaldo());
        }
        
        System.out.println("\nValor total de intereses: $" + String.format("%.2f", totalIntereses));
        System.out.println("Valor total de saldos: $" + String.format("%.2f", totalSaldos));
    
    }
}

