import java.util.Scanner;

public class ejercicio4 {

    public static int[] array_20 = new int[20];

    public static void carga_elementos(Scanner scanner) {
        System.out.println("Ingrese 20 números enteros");

        for (int i = 0; i < array_20.length; i++) {
            System.out.println("Número " + (i + 1) + ":");
            array_20[i] = scanner.nextInt();
        }

        System.out.println("Los números ingresados son:");
        for (int num : array_20) {
            System.out.print(num + " ");
        }
        System.out.println("");
    }

    public static void menu_seleccion(Scanner scanner) {
        int opcionMetodo;
        do {
            System.out.println("Seleccione el método de ordenamiento:");
            System.out.println("1) Ascendente");
            System.out.println("2) Descendente");
            System.out.println("0) Salir");
            opcionMetodo = scanner.nextInt();
            scanner.nextLine();

            if (opcionMetodo != 0) {
                mostrarTiposOrdenamiento(scanner, opcionMetodo);
            } else {
                System.out.println("Saliendo del menú de selección.");
            }

        } while (opcionMetodo != 0);
    }

    public static void mostrarTiposOrdenamiento(Scanner scanner, int metodo) {
        int opcionTipo;
        System.out.println("Seleccione el tipo de ordenamiento:");
        System.out.println("1) Inserción");
        System.out.println("2) Burbuja");
        System.out.println("3) Selección");
        System.out.println("0) Volver al menú anterior");
        opcionTipo = scanner.nextInt();
        scanner.nextLine();

        switch (opcionTipo) {
            case 1:
                System.out.println("Ordenamiento por Inserción seleccionado.");
                ordenamientoInsercion(array_20, metodo);
                break;
            case 2:
                System.out.println("Ordenamiento por Burbuja seleccionado.");
                ordenamientoBurbuja(array_20, metodo);
                break;
            case 3:
                System.out.println("Ordenamiento por Selección seleccionado.");
                ordenamientoSeleccion(array_20, metodo);
                break;
            case 0:
                System.out.println("Volviendo al menú anterior.");
                break;
            default:
                System.out.println("Opción no válida, intente de nuevo.");
                break;
        }
        mostrarArray(array_20);
    }

    public static void ordenamientoInsercion(int[] array, int metodo) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            // Ascendente: insertar key en la posición correcta
            if (metodo == 1) {
                while (j >= 0 && array[j] > key) {
                    array[j + 1] = array[j];
                    j = j - 1;
                }
            }
            // Descendente: insertar key en la posición correcta
            else {
                while (j >= 0 && array[j] < key) {
                    array[j + 1] = array[j];
                    j = j - 1;
                }
            }
            array[j + 1] = key;
        }
        System.out.println("Ordenamiento por inserción completado.");
    }

    public static void ordenamientoBurbuja(int[] array, int metodo) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Ascendente: intercambiar si el elemento actual es mayor que el siguiente
                if (metodo == 1 && array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                // Descendente: intercambiar si el elemento actual es menor que el siguiente
                else if (metodo == 2 && array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("Ordenamiento por burbuja completado.");
    }

    public static void ordenamientoSeleccion(int[] array, int metodo) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minOrMaxIdx = i;

            // Encontrar el mínimo (para ascendente) o máximo (para descendente) en el subarreglo restante
            for (int j = i + 1; j < n; j++) {
                if (metodo == 1 && array[j] < array[minOrMaxIdx]) {
                    minOrMaxIdx = j; // Encontrar el menor para orden ascendente
                } else if (metodo == 2 && array[j] > array[minOrMaxIdx]) {
                    minOrMaxIdx = j; // Encontrar el mayor para orden descendente
                }
            }

            // Intercambiar el elemento mínimo o máximo encontrado con el primero
            int temp = array[minOrMaxIdx];
            array[minOrMaxIdx] = array[i];
            array[i] = temp;
        }
        System.out.println("Ordenamiento por selección completado.");
    }


    public static void mostrarArray(int[] array) {
        System.out.println("El arreglo ordenado es:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        carga_elementos(scanner);
        menu_seleccion(scanner);
    }
}
