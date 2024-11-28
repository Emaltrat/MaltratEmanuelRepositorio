package grupo_6.tp_array_multi;

import java.util.Scanner;

public class Ej2 {
    public static void MatricesYSuma(){
        int x;
        Scanner scanner = new Scanner(System.in);
        do {

            System.out.println("Ingrese el tamaño de la matriz (debe ser mayor a 3 y menor a 10):");
            x = scanner.nextInt();

        }
        while (x < 3 || x > 10);

        //f= fila de la matriz, c= columna de la matriz

        int[] [] matrizPt2 = new int [x][x];

        System.out.println("Ahora agrega los valores de la matriz");
        for (int f = 0; f < x; f++) {
            for (int c = 0; c < x; c++){
                System.out.println("Valor para la columna n°" + c + " y para la fila n°" + f);
                matrizPt2[f][c] = scanner.nextInt();
            }}

        System.out.println("La matriz ingresada es: ");
        for (int f = 0; f < x; f++) {
            for (int c = 0; c < x; c++) {
                System.out.print(matrizPt2[f][c] + "\t");
            }
            System.out.println();
        }

        int totalSuma = 0;
        int[] sumaColumnas = new int[x];
        for (int c = 0; c < x; c++) {
            for (int f = 0; f < x; f++) {
                sumaColumnas[c] += matrizPt2[f][c];
            }
            totalSuma += sumaColumnas[c]; // Sumar para el total
        }
        System.out.println("La suma de la matriz ingresada es: "+ totalSuma);
    }
}
