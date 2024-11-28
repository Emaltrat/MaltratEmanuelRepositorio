package grupo_6.tp_array_multi;

import java.util.Scanner;

public class Ej5 {
    private static int ventasTotales = 0;

    public static void menuInteractivo() {
        Scanner scanner = new Scanner(System.in);
        String[][] golosinas = {
                {"KitKat            ","32","10"},
                {"Chicles           ","2 ","50"},
                {"Caramelos de Menta","2 ","50"},
                {"Huevo Kinder      ","25","10"},
                {"Chetoos           ","30","10"},
                {"Twix              ","26","10"},
                {"M&M'S             ","35","10"},
                {"Papas Lays        ","40","20"},
                {"Milkybar          ","30","10"},
                {"Alfajor Tofi      ","20","15"},
                {"Lata Coca         ","50","20"},
                {"Chitos            ","45","10"}
        };

        int opcion;
        do {
            System.out.println("\nMenú Interactivo");
            System.out.println("1. Ver golosinas");
            System.out.println("2. Pedir golosina");
            System.out.println("3. Rellenar golosinas");
            System.out.println("4. Apagar Máquina");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    mostrarGolosinas(golosinas);
                    break;
                case 2:
                    pedirGolosina(golosinas, scanner);
                    break;
                case 3:
                    rellenarGolosinas(golosinas, scanner);
                    break;
                case 4:
                    apagarMaquina();
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 4);
    }

    public static void mostrarGolosinas(String[][] golosinas) {
        System.out.println("\nGolosina              Precio  Cantidad");
        for (String[] golosina : golosinas) {
            System.out.println(golosina[0] + "\t|" + golosina[1] + "|\t|" + golosina[2]+"|");
        }
    }

    public static void pedirGolosina(String[][] golosinas, Scanner scanner) {
        System.out.print("Ingresa el número de la fila de la golosina que deseas (0-11): ");
        int fila = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        if (fila >= 0 && fila < golosinas.length) {
            int cantidad = Integer.parseInt(golosinas[fila][2]);
            if (cantidad > 0) {
                golosinas[fila][2] = String.valueOf(cantidad - 1);
                int precio = Integer.parseInt(golosinas[fila][1]);
                ventasTotales += precio;
                System.out.println("Has pedido: " + golosinas[fila][0]);
                System.out.println("Cantidad restante: " + golosinas[fila][2]);
                System.out.println("Precio: " + precio + " (Ventas totales: " + ventasTotales + ")");
            } else {
                System.out.println("Lo siento, " + golosinas[fila][0] + " está agotado. Por favor, selecciona otra golosina.");
            }
        } else {
            System.out.println("Número de fila no válido. Inténtalo de nuevo.");
        }
    }

    public static void rellenarGolosinas(String[][] golosinas, Scanner scanner) {
        System.out.println("Ingrese la contraseña de administrador:");
        String password = scanner.next();

        if (password.equals("AdminXYZ")) {
            System.out.println("Bienvenido, ingrese el número de la golosina a modificar (0-11): ");
            int fila = scanner.nextInt();
            System.out.println("Ahora ingrese la cantidad a recargar:");
            int cantidad = scanner.nextInt();
            if (fila >= 0 && fila < golosinas.length) {
                if (cantidad > 0) {
                    int cantidad_final = Integer.parseInt(golosinas[fila][2]) + cantidad;
                    golosinas[fila][2] = String.valueOf(cantidad_final);
                    System.out.println("Has modificado el ítem " + golosinas[fila][0] + " en unidades = " + cantidad);
                } else {
                    System.out.println("Ha ingresado una cantidad no válida, intente nuevamente.");
                }
            } else {
                System.out.println("Ha ingresado un número no válido, vuelva a intentar.");
            }
        } else {
            System.out.println("Contraseña incorrecta. Acceso denegado.");
        }
    }

    public static void apagarMaquina() {
        System.out.println("Apagando máquina...");
        System.out.println("Ventas totales durante la ejecución del programa: " + ventasTotales);
        
    }
}
