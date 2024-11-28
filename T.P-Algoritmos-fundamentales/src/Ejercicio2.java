import java.util.Scanner;

public class Ejercicio2 {
    public static void run(Scanner scanner) {

        System.out.println("¿Qué quieres hacer?\na) Ordenar por inserción\nb) Ordenar por burbuja\nc) Ordenar por selección \nd) Ordenar por 'quick-sort'");
        String punto = scanner.nextLine();

        switch (punto) {
            case "a":
                System.out.println("Ingrese el tamaño del array:");
                int tamano = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Ingrese " + tamano + " valores separados por guiones:");
                String input = scanner.nextLine();

                String[] separacion = input.split("-");

                int[] x = new int[tamano];
                for (int i = 0; i < tamano; i++) {
                    x[i] = Integer.parseInt(separacion[i]);
                }

                algoritmoInsercion(x);

                System.out.println("Array ordenado por inserción:");
                for (int num : x) {
                    System.out.print(num + " ");
                }
                System.out.println();
                break;

            case "b":

                System.out.println("Ingrese el tamaño del array:");
                int tamano1 = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Ingrese " + tamano1 + " valores separados por guiones:");
                String input1 = scanner.nextLine();

                String[] separacion1 = input1.split("-");

                int[] x1 = new int[tamano1];
                for (int i = 0; i < tamano1; i++) {
                    x1[i] = Integer.parseInt(separacion1[i]);
                }

                burbuja(x1);

                System.out.println("Array ordenado por burbuja:");
                for (int num : x1) {
                    System.out.print(num + " ");
                }
                System.out.println();

                break;

            case "c":

                System.out.println("Ingrese el tamaño del array:");
                int tamano2 = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Ingrese " + tamano2 + " valores separados por guiones:");
                String input2 = scanner.nextLine();

                String[] separacion2 = input2.split("-");

                int[] x2 = new int[tamano2];
                for (int i = 0; i < tamano2; i++) {
                    x2[i] = Integer.parseInt(separacion2[i]);
                }

                seleccion(x2);

                System.out.println("Array ordenado por selección:");
                for (int num : x2) {
                    System.out.print(num + " ");
                }
                System.out.println();

                break;

            case "d":

                System.out.println("Ingrese el tamaño del array:");
                int tamano3 = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Ingrese " + tamano3 + " valores separados por guiones:");
                String input3 = scanner.nextLine();

                String[] separacion3 = input3.split("-");

                int[] x3 = new int[tamano3];
                for (int i = 0; i < tamano3; i++) {
                    x3[i] = Integer.parseInt(separacion3[i]);
                }

                quicksort(x3, 0, x3.length - 1);

                System.out.println("Array ordenado por quicksort:");
                for (int num : x3) {
                    System.out.print(num + " ");
                }
                System.out.println();

                break;

            default:
                System.out.println("Opción no válida, intente de nuevo");
                break;
        }
    }

    // métodoInserción
    public static void algoritmoInsercion(int[] x) {
        for (int i = 1; i < x.length; i++) {
            int num = x[i];
            int a = i - 1;
            while (a >= 0 && x[a] > num) {
                x[a + 1] = x[a];
                a--;
            }
            x[a + 1] = num;
        }
    }

    // métodoBurbuja
    public static void burbuja(int[] x) {
        int n = x.length;
        boolean intercambiado;

        do {
            intercambiado = false;
            for (int i = 1; i < n; i++) {
                if (x[i - 1] > x[i]) {
                    int aux = x[i - 1];
                    x[i - 1] = x[i];
                    x[i] = aux;
                    intercambiado = true;
                }
            }
        } while (intercambiado);
    }

    // métodoSelección
    public static void seleccion(int[] x) {
        int n = x.length;

        for (int i = 0; i < n - 1; i++) {
            int minimo = i;
            for (int j = i + 1; j < n; j++) {
                if (x[j] < x[minimo]) {
                    minimo = j;
                }
            }
            int aux = x[minimo];
            x[minimo] = x[i];
            x[i] = aux;
        }
    }

    // métodoQuicksort
    public static void quicksort(int[] x, int inicio, int fin) {
        if (inicio < fin) {
            int indicePivote = particion(x, inicio, fin);
            quicksort(x, inicio, indicePivote - 1);
            quicksort(x, indicePivote + 1, fin);
        }
    }

    public static int particion(int[] x, int inicio, int fin) {
        int pivote = x[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (x[j] < pivote) {
                i++;
                int aux = x[i];
                x[i] = x[j];
                x[j] = aux;
            }
        }

        int aux = x[i + 1];
        x[i + 1] = x[fin];
        x[fin] = aux;

        return i + 1;
    }
}
