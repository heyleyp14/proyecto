import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n --- LIQUIDACION INTERESES DE CUENTAS ---");
        System.out.print("Ingrese la cantidad de cuentas: ");
        int n = sc.nextInt();
        sc.nextLine();

        Cuenta[] cuentas = new Cuenta[n]; 

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- CUENTA " + (i + 1) + " ---");
            System.out.print("Tipo de cuenta (1 = Ahorro, 2 = Corriente): ");
            int tipo = sc.nextInt();
            sc.nextLine();

            System.out.print("Documento: ");
            long doc = sc.nextLong();
            sc.nextLine();
            
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            
            System.out.print("Correo: ");
            String correo = sc.nextLine();
            
            System.out.print("Celular: ");
            int cel = sc.nextInt();
            sc.nextLine();
            
            System.out.print("Direccion: ");
            String direccion = sc.nextLine();

            System.out.print("Numero de cuenta: ");
            long numero = sc.nextLong();
            sc.nextLine();
            
            System.out.print("Fecha de apertura (aaaa/mm/dd): ");
            String fecha = sc.nextLine();
            
            System.out.print("Saldo actual: ");
            double saldo = sc.nextDouble();

            if (tipo == 1) { 
                System.out.print("Tipo de ahorro (1:AhorroDiario, 2:CuentaJoven, 3:Tradicional): ");
                int tipoAhorro = sc.nextInt();

                cuentas[i] = new Cuenta(doc, nombre, correo, cel, direccion, numero, fecha, tipoAhorro, saldo);
            } else { 
                System.out.print("Porcentaje de interes: ");
                double porcentaje = sc.nextDouble();
                
                System.out.print("Valor permitido de sobregiro: ");
                double sobregiro = sc.nextDouble();

                cuentas[i] = new CuentaCorriente(doc, nombre, correo, cel, direccion, numero, fecha, saldo, porcentaje, sobregiro);
            }
        }
        
        System.out.println("\n--- RESUMEN DE CUENTAS ---");
        double totalIntereses = 0, totalSaldos = 0;

        for (Cuenta c : cuentas) {
            double interes = c.calcular_interes();
            c.setSaldo(c.getSaldo() + interes);
            totalIntereses += interes;
            totalSaldos += c.getSaldo();

            System.out.println("\nCliente: " + c.getNombre());
            System.out.println("Documento: " + c.getDocumentoIdentidad());
            System.out.println("Numero de cuenta: " + c.getNumeroCuenta());
            System.out.printf("Interes mensual: $%.2f%n", interes);
            System.out.printf("Nuevo saldo: $%.2f%n", c.getSaldo());
        }

        System.out.println("\nValor total de intereses: $" + String.format("%.2f", totalIntereses));
        System.out.println("Valor total de saldos: $" + String.format("%.2f", totalSaldos));
    }
}
