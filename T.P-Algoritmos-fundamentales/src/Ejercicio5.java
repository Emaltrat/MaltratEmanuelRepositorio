import java.util.Scanner;

public class Ejercicio5 {
    
    public static void Ej5(Scanner scanner){
        int filas,columnas;
        int promedio=0,resultado=0;
        //Le pido al usuario la dimension de la matriz
        do{
         System.out.println("Ingrese un numero igual o mayor a 2");
         filas=scanner.nextInt();
         scanner.nextLine();
         System.out.println("Ingrese un numero igual o mayor a 2");
         columnas=scanner.nextInt();
         scanner.nextLine();
        }while ( filas<2 || columnas <2);
        int[][] arreglo = new int[filas][columnas];
        //Lleno la matriz con los datos que de el usuario
        System.out.println("Ingrese los numeros del arreglo de "+filas+" x "+columnas);
        for(int i = 0;i < filas;i++){
            for(int j = 0;j < columnas;j++){
             arreglo[i][j] = scanner.nextInt();
            }
        }System.out.println("\n");
        System.out.println("Matriz:");
        for(int i = 0;i < filas;i++){
            for(int j = 0;j < columnas;j++){
             System.out.print(arreglo[i][j] + " ");
            }
         System.out.print("\n");
        }
        //Sumo los elementos del arreglo
        for(int i = 0;i < filas;i++){
            for(int j = 0;j < columnas;j++){
             promedio+=arreglo[i][j];
            }
        }
        //Saco el promedio del arreglo
        resultado=promedio/(filas*columnas);
        System.out.println("El promedio entero es : "+resultado);
        //Busco el numero en el arreglo
        int coincidencia=0;
        for(int i = 0;i < filas;i++){
            for(int j = 0;j < columnas;j++){
                if (arreglo[i][j]==resultado){
                 System.out.println("El valor "+resultado+" se encuentra en la posicion con indice ("+i+","+j+") o fila "+(i+1)+" ,columna "+(j+1));
                 coincidencia++;
                }

            }
        }
        if (coincidencia==0) {
            System.out.println("No se encontro ninguna coincidencia");
        }
    }
}