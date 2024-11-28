
package grupo_6.tp_array_multi;

public class Ej3 {
    public static void EJ3(){
       do {


           System.out.print("INgrese un valor entero X mayor o igual a 3 y menor o igual a 10");
           int x = new scanner.nextint();

       } while (x<3 || x > 10);

       int [][] matriz = new int [x][x];

       System.out.println("Ingrese los valores para llenar la matriz");
       for (int i = 0; i < x; i++) {
           for (int j = 0; j < x; j++){

               System.out.print("Valor para la posición ["+ i +"][" + j +"]: ");
               matriz[i][j] = scanner.nextint();
           }
       }

       System.out.println("\nMatriz ingresada:");
       for (int i = 0; i < i < x; i++) {
           for (int j = 0; j < x; j++){
               System.out.print(matriz[i][j] + "\t");
           }
       }
    System.out.println();
    }
    int[] sumarColumnas = new int[x];
    for (int j = 0; j < x; j++){
        int suma = 0;
        for (int i = 0; i < x; i++){
            suma += matriz [i][j];
        }
        sumarColumnas[j] = suma;
    }

    System.out.println("\nsuma de cada colummna: ");
    for (int i = 0; i < x; i++){
        System.out.print("columna " + i + ": " + sumarColumnas[i]);
    }
    int sumaTotal = 0;
    for (int i = 0; i < x; i++){

        sumaTotal += sumarColumnas[i];
    }

    System.out.println("\nLa suma total de las columnas es: " + sumaTotal);
}
