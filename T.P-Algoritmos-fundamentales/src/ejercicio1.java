import java.util.Scanner;

public class  ejercicio1 {

    public static void eje1(Scanner scanner) {
        int opcion;

        do {
            System.out.println("Seleccione los tipos de algoritmos que desea ver:");
            System.out.println("1. Algoritmos de Ordenación");
            System.out.println("2. Algoritmos de Búsqueda");
            System.out.println("3. Algoritmos de Recorrido");
            System.out.println("0. Salir.");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ordenacion();
                    break;
                case 2:
                    busqueda();
                    break;
                case 3:
                    recorrido();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }

        } while (opcion != 0);

        scanner.close();
    }

    public static void ordenacion() {
        System.out.println("Algoritmos de Ordenación:");
        System.out.println("1. Bubble Sort: Un algoritmo de ordenación simple que repetidamente pasa a través de la lista, compara elementos adyacentes y los intercambia si están en el orden incorrecto.");
        System.out.println("2. Quick Sort: Un algoritmo eficiente que utiliza el enfoque de divide y vencerás para ordenar elementos.");
        System.out.println("3. Merge Sort: Otro algoritmo eficiente que también utiliza el enfoque de divide y vencerás, dividiendo la lista en sublistas y combinándolas.");
    }

    public static void busqueda() {
        System.out.println("Algoritmos de Búsqueda:");
        System.out.println("1. Búsqueda Lineal: Un método simple que revisa cada elemento en una lista hasta encontrar el objetivo.");
        System.out.println("2. Búsqueda Binaria: Un método eficiente que requiere que la lista esté ordenada y divide repetidamente el rango de búsqueda a la mitad.");
    }

    public static void recorrido() {
        System.out.println("Algoritmos de Recorrido:");
        System.out.println("1. Recorrido en Profundidad (DFS): Un algoritmo para recorrer o buscar en estructuras de datos en forma de árbol o gráfico, explorando lo más profundo posible antes de retroceder.");
        System.out.println("2. Recorrido en Amplitud (BFS): Un algoritmo que explora todos los nodos en el nivel actual antes de pasar al siguiente nivel.");
    }
}
