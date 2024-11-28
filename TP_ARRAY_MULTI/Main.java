import java.sql.SQLOutput;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese las dimensiones del array (filas)x(columnas).\n" +
                "Filas deben ser >= a 3 y columnas deben ser >= 2");
        int x = 0, y = 0;

        do {
            System.out.println("Filas: ");
            x = sc.nextInt();
            System.out.println("Columnas: ");
            y = sc.nextInt();
        } while (x < 3 || y < 2);

        double[][] array = new double[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.println("Valor para la posición " + (i + 1) + "-" + (j + 1));
                array[i][j] = sc.nextDouble();
            }
        }

        double suma;
        int[] arrayDos = new int[x];
        System.out.println("El arreglo es: ");
        for (int i = 0; i < x; i++) {
            suma = 0;
            System.out.println("");
            for (int j = 0; j < y; j++) {
                System.out.print(array[i][j] + " ");
                suma = suma + array[i][j];
            }
            arrayDos[i] = (int) suma;
        }

        System.out.println("");
        System.out.println("\nSuma de filas del array:");
        System.out.println("");
        for (int i = 0; i < x; i++) {
            System.out.println(arrayDos[i]);
        }

        System.out.println("\nArray de sumas ordenado con posición anterior: ");
        int[][] arrayTres = new int[x][2];
        for (int i = 0; i < x; i++){
            arrayTres[i][0] = arrayDos[i];
            arrayTres[i][1] = i;
        }
        for (int i = 1; i < x; i++){
            int[] valor = arrayTres[i];
            int j = i-1;
            while ( j >= 0 && arrayTres[j][0] < valor[0]){
                arrayTres[j+1] = arrayTres[j];
                j--;
            }
            arrayTres[j+1] = valor;
        }

        System.out.println("SUMA     POSICION");
        for (int i = 0; i < x; i++) {
            System.out.print(arrayTres[i][0]);
            System.out.print("     ");
            System.out.print(arrayTres[i][1] + "\n");
        }

        int total = 0;
        for (int i = 0; i < x; i++){
            total = total + arrayTres[i][0];
        }
        System.out.println("El total de la suma del arreglo es: " + total);
    }
}



