import java.util.Scanner;
import java.util.Random;

public class ExamenParcial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar;

        do {
            // Paso 1: Solicitar dimensión
            int n = solicitarDimension(scanner);

            // Paso 2: Crear y llenar la matriz
            int[][] matriz = crearYllenarMatriz(n, scanner);

            // Paso 3: Mostrar matriz
            mostrarMatriz(matriz);

            // Paso 4: Obtener valores centrales
            int[] valoresCentrales = obtenerValoresCentrales(matriz);

            // Paso 5: Mostrar matriz de valores centrales
            System.out.println("Matriz de valores centrales:");
            mostrarMatrizUnidimensional(valoresCentrales);

            // Paso 6: Ordenar matriz con método de la burbuja
            ordenarBurbuja(valoresCentrales);

            // Paso 7: Mostrar matriz ordenada
            System.out.println("Matriz ordenada:");
            mostrarMatrizUnidimensional(valoresCentrales);

            // Paso 8: Calcular promedio de matrices
            double promedioGeneral = calcularPromedioDeMatrices(matriz, valoresCentrales);

            // Paso 9: Preguntar al usuario si desea continuar
            System.out.print("¿Desea iniciar nuevamente la ejecución del programa? (SI/NO): ");
            continuar = scanner.next().equalsIgnoreCase("SI");
        } while (continuar);

        System.out.println("Programa terminado.");
        scanner.close();
    }

    // Paso 1
    public static int solicitarDimension(Scanner scanner) {
        int n;
        do {
            System.out.print("Ingrese la dimensión impar de la matriz (entre 3 y 15): ");
            n = scanner.nextInt();
        } while (n < 3 || n > 15 || n % 2 == 0);
        return n;
    }

    // Paso 2
    public static int[][] crearYllenarMatriz(int n, Scanner scanner) {
        int[][] matriz = new int[n][n];
        Random random = new Random();

        // Llenar última fila manualmente
        System.out.println("Ingrese los valores para la última fila:");
        for (int i = 0; i < n; i++) {
            int valor;
            do {
                System.out.print("Valor [" + (n - 1) + "][" + i + "]: ");
                valor = scanner.nextInt();
            } while (valor < 10 || valor > 99 || valor == 0);
            matriz[n - 1][i] = valor;
        }

        // Llenar el resto de la matriz con valores aleatorios
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = 10 + random.nextInt(90);
            }
        }
        return matriz;
    }

    // Paso 3
    public static void mostrarMatriz(int[][] matriz) {
        System.out.println("Matriz:");
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    }

    // Paso 4
    public static int[] obtenerValoresCentrales(int[][] matriz) {
        int n = matriz.length;
        int centro = n / 2;
        int[] valoresCentrales = new int[9];
        int k = 0;

        for (int i = centro - 1; i <= centro + 1; i++) {
            for (int j = centro - 1; j <= centro + 1; j++) {
                valoresCentrales[k++] = matriz[i][j];
            }
        }
        return valoresCentrales;
    }

    // Paso 5 y 7
    public static void mostrarMatrizUnidimensional(int[] matriz) {
        for (int elemento : matriz) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }

    // Paso 6
    public static void ordenarBurbuja(int[] matriz) {
        for (int i = 0; i < matriz.length - 1; i++) {
            for (int j = 0; j < matriz.length - 1 - i; j++) {
                if (matriz[j] > matriz[j + 1]) {
                    int temp = matriz[j];
                    matriz[j] = matriz[j + 1];
                    matriz[j + 1] = temp;
                }
            }
        }
    }

    // Paso 8
    public static double calcularPromedioDeMatrices(int[][] matriz, int[] valoresCentrales) {
        int sumaMatriz = 0, elementosMatriz = 0;
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                sumaMatriz += elemento;
                elementosMatriz++;
            }
        }
        double promedioMatriz = (double) sumaMatriz / elementosMatriz;

        int sumaCentrales = 0, elementosCentrales = valoresCentrales.length;
        for (int valor : valoresCentrales) {
            sumaCentrales += valor;
        }
        double promedioCentrales = (double) sumaCentrales / elementosCentrales;

        System.out.println("Suma total de la matriz bidimensional: " + sumaMatriz);
        System.out.println("Cantidad de elementos: " + elementosMatriz);
        System.out.println("Promedio de la matriz bidimensional: " + promedioMatriz);

        System.out.println("Suma total de la matriz unidimensional: " + sumaCentrales);
        System.out.println("Cantidad de elementos: " + elementosCentrales);
        System.out.println("Promedio de la matriz unidimensional: " + promedioCentrales);

        double promedioGeneral = (promedioMatriz + promedioCentrales) / 2;
        System.out.println("Promedio general de ambas matrices: " + promedioGeneral);

        return promedioGeneral;
    }
}
