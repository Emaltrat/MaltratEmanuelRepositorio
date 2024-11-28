import java.util.Scanner;

public class ejercicio3 {

    public static void run(Scanner scanner) {
        System.out.println("¿Qué algoritmo quieres usar?\na) Ordenar por inserción\nb) Ordenar por burbuja\nc) Ordenar por selección");
        String opcion = scanner.nextLine();

        System.out.println("Ingrese el tamaño del array:");
        int tamano = scanner.nextInt();
        scanner.nextLine(); // limpiar el buffer

        System.out.println("Ingrese " + tamano + " valores separados por guiones:");
        String input = scanner.nextLine();
        String[] separacion = input.split("-");

        int[] x = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            x[i] = Integer.parseInt(separacion[i]);
        }

        System.out.println("Ingrese el orden (ASC/DESC):");
        String orden = scanner.nextLine();

        switch (opcion) {
            case "a":
                algoritmoInsercion(x, orden);
                break;
            case "b":
                burbuja(x, orden);
                break;
            case "c":
                seleccion(x, orden);
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        System.out.println("Array ordenado:");
        for (int num : x) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Algoritmo de inserción
    public static void algoritmoInsercion(int[] x, String orden) {
        for (int i = 1; i < x.length; i++) {
            int num = x[i];
            int a = i - 1;
            if (orden.equals("ASC")) {
                while (a >= 0 && x[a] > num) {
                    x[a + 1] = x[a];
                    a--;
                }
            } else if (orden.equals("DESC")) {
                while (a >= 0 && x[a] < num) {
                    x[a + 1] = x[a];
                    a--;
                }
            }
            x[a + 1] = num;
        }
    }

    // Algoritmo de burbuja
    public static void burbuja(int[] x, String orden) {
        int n = x.length;
        boolean intercambiado;
        do {
            intercambiado = false;
            for (int i = 1; i < n; i++) {
                if (orden.equals("ASC")) {
                    if (x[i - 1] > x[i]) {
                        int aux = x[i - 1];
                        x[i - 1] = x[i];
                        x[i] = aux;
                        intercambiado = true;
                    }
                } else if (orden.equals("DESC")) {
                    if (x[i - 1] < x[i]) {
                        int aux = x[i - 1];
                        x[i - 1] = x[i];
                        x[i] = aux;
                        intercambiado = true;
                    }
                }
            }
        } while (intercambiado);
    }

    // Algoritmo de selección
    public static void seleccion(int[] x, String orden) {
        int n = x.length;
        for (int i = 0; i < n - 1; i++) {
            int minimo = i;
            for (int j = i + 1; j < n; j++) {
                if (orden.equals("ASC")) {
                    if (x[j] < x[minimo]) {
                        minimo = j;
                    }
                } else if (orden.equals("DESC")) {
                    if (x[j] > x[minimo]) {
                        minimo = j;
                    }
                }
            }
            int aux = x[minimo];
            x[minimo] = x[i];
            x[i] = aux;
        }
    }
}
