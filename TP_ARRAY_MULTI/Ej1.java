package grupo_6.tp_array_multi;

import java.util.Scanner;

public class Ej1 {
    public static void ejercicio1(Scanner scanner) {
        // Array para almacenar los nombres de los países
        String[] paises = new String[4];
        // Array multidimensional para almacenar las ciudades
        String[][] ciudades = new String[4][3];

        // Recibir el nombre de los países y sus ciudades
        for (int i = 0; i < 4; i++) {
            System.out.print("Ingresa el nombre del país " + (i + 1) + ": ");
            paises[i] = scanner.nextLine();

            // Recibir las tres ciudades de cada país
            for (int j = 0; j < 3; j++) {
                System.out.print("Ingresa el nombre de la ciudad " + (j + 1) + " de " + paises[i] + ": ");
                ciudades[i][j] = scanner.nextLine();
            }
        }

        System.out.println("\nResultados:");
        for (int i = 0; i < 4; i++) {
            System.out.print("País: " + paises[i] + " Ciudades: ");
            for (int j = 0; j < 3; j++) {
                System.out.print(ciudades[i][j]);
                if (j < 2) {
                    System.out.print(", ");
                }
            }
            System.out.println(); // Salto de línea después de cada país
        }
    }
}
