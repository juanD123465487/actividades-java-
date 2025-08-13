import java.util.Scanner;

public class CajeroAutomatico {
    
    static class Banco {
        private String nombre;
        private String cuenta;
        private int saldo;

        public Banco(String nombre, String cuenta, int saldo) {
            this.nombre = nombre;
            this.cuenta = cuenta;
            this.saldo = saldo;
        }

        public void mostrarCuenta() {
            System.out.println("\n=== INFORMACIÓN DE LA CUENTA ===");
            System.out.println("Titular: " + nombre);
            System.out.println("Número de cuenta: " + cuenta);
            System.out.println("Saldo disponible: $" + saldo);
        }

        public void depositar(int cantidad) {
            if (cantidad > 0) {
                this.saldo += cantidad;
                System.out.println("\nDepósito exitoso: +$" + cantidad);
                System.out.println("Nuevo saldo: $" + saldo);
            } else {
                System.err.println("\nError: La cantidad a depositar debe ser positiva");
            }
        }

        public void retirar(int cantidad) {
            if (cantidad <= 0) {
                System.err.println("\nError: La cantidad a retirar debe ser positiva");
            } else if (cantidad > this.saldo) {
                System.err.println("\nError: Saldo insuficiente");
                System.out.println("Saldo disponible: $" + saldo);
            } else {
                this.saldo -= cantidad;
                System.out.println("\nRetiro exitoso: -$" + cantidad);
                System.out.println("Nuevo saldo: $" + saldo);
            }
        }

        public void transferir(int monto, Banco destino) {
            if (monto <= 0) {
                System.err.println("\nError: El monto a transferir debe ser positivo");
            } else if (monto > this.saldo) {
                System.err.println("\nError: Saldo insuficiente para transferir");
                System.out.println("Saldo disponible: $" + saldo);
            } else {
                this.saldo -= monto;
                destino.saldo += monto;
                System.out.println("\nTransferencia exitosa: -$" + monto);
                System.out.println("Cuenta destino: " + destino.cuenta);
                System.out.println("Nuevo saldo: $" + saldo);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Crear cuentas bancarias de ejemplo
        Banco cuentaUsuario = new Banco("Carlos García", "123456789", 1500);
        Banco cuentaDestino = new Banco("Ana Martínez", "987654321", 2500);
        
        int opcion;
        do {
            System.out.println("\n=== CAJERO AUTOMÁTICO ===");
            System.out.println("1. Ver información de mi cuenta");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Transferir dinero");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción (1-5): ");
            
            try {
                opcion = scanner.nextInt();
                
                switch(opcion) {
                    case 1:
                        cuentaUsuario.mostrarCuenta();
                        break;
                        
                    case 2:
                        System.out.print("\nIngrese la cantidad a depositar: $");
                        int deposito = scanner.nextInt();
                        cuentaUsuario.depositar(deposito);
                        break;
                        
                    case 3:
                        System.out.print("\nIngrese la cantidad a retirar: $");
                        int retiro = scanner.nextInt();
                        cuentaUsuario.retirar(retiro);
                        break;
                        
                    case 4:
                        System.out.println("\nCuenta destino disponible:");
                        cuentaDestino.mostrarCuenta();
                        System.out.print("\nIngrese la cantidad a transferir: $");
                        int transferencia = scanner.nextInt();
                        cuentaUsuario.transferir(transferencia, cuentaDestino);
                        break;
                        
                    case 5:
                        System.out.println("\nGracias por usar nuestro cajero automático. ¡Hasta pronto!");
                        break;
                        
                    default:
                        System.out.println("\nError: Opción no válida. Por favor ingrese un número del 1 al 5.");
                }
            } catch (Exception e) {
                System.err.println("\nError: Entrada inválida. Por favor ingrese solo números.");
                scanner.next(); // Limpiar el buffer del scanner
                opcion = 0;
            }
        } while(opcion != 5);
        
        scanner.close();
    }
}