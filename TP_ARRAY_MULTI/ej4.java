package grupo_6.tp_array_multi;

import java.util.Scanner;

class Ej4 {
    public static boolean confirmacion = false ;
    public static int[][] MATRIZ;

    public static void Ejercicio4(Scanner scanner){
        String opcion;
        do{
            System.out.println("Ingrese la opcion:");
            System.out.println("A)Llenar Matriz\n"+
                    "B)Suma de filas\n"+
                    "C)Suma de columnas\n"+
                    "D)Suma de diagonal \n"+
                    "E)Suma de diagonal inversa\n" +
                    "F)Media de valores \n"+
                    "0)Salir");
            opcion = scanner.nextLine();
            switch (opcion) {
                case "a","A":
                 LlenarMatriz(scanner,Ej4.MATRIZ);
                 break;
                case "b","B" :
                if (confirmacion==true){
                 SumaFilas(scanner,Ej4.MATRIZ);}
                else{
                 System.out.println("Llene primero la matriz");} 
                 break;
                case "c","C":
                if (confirmacion==true){
                    SumaColumnas(scanner,Ej4.MATRIZ);}
                else{
                 System.out.println("Llene primero la matriz");}
                 break;
                case"d","D":
                if (confirmacion==true){
                 SumaDiagonal(Ej4.MATRIZ);}
                else{
                 System.out.println("Llene primero la matriz");}
                 break;
                case "e","E":
                if (confirmacion==true){
                    SumaDiagonalInversa(Ej4.MATRIZ);}
                else{
                 System.out.println("Llene primero la matriz");}   
                 break;
                case "f","F":
                if (confirmacion==true){
                 MediaValores(Ej4.MATRIZ);}
                else{
                    System.out.println("Llene primero la matriz");}
                    break;
                case "0":
                System.out.println("Saliendo...");
                TP_ARRAY_MULTI.main(null);
                default:
                System.out.println("Opcion invalida");
                break;} 

        }while ( opcion != "0");}
    public static void LlenarMatriz(Scanner scanner, int Matriz[][]){
        int dimMatriz;
        do{
        System.out.println("Ingrese un numero de 4 a 10 incluidos :");
        dimMatriz = scanner.nextInt();
        scanner.nextLine();}
        
     while (dimMatriz < 4 || dimMatriz > 10);
         Matriz = new int [dimMatriz][dimMatriz]; 
         for(int i = 0;i < dimMatriz;i++){
            for(int j = 0;j < dimMatriz;j++){
            Matriz[i][j] = scanner.nextInt();
            }
        }
        for(int i = 0;i < dimMatriz;i++){
             for(int j = 0;j < dimMatriz;j++){
             System.out.print(Matriz[i][j] + " ");
            }
         System.out.print("\n");
        }
        Ej4.confirmacion=true;
        Ej4.MATRIZ=Matriz;
    }
    public static void SumaFilas(Scanner scanner,int [][] Matriz){
        Integer fila;
        int suma=0;
        do{
            System.out.println("Ingrese un numero de 1 al "+ Matriz.length +" incluidos :");
            fila = scanner.nextInt();
        }while (fila <= 0 || fila > Matriz.length);
        for(int i = 0;i < Matriz.length;i++){
            suma +=Matriz[fila-1][i];
            }
            System.out.println(suma);
    }
    public static void SumaColumnas(Scanner scanner,int [][] Matriz){
        Integer columna;
        int suma=0;
        do{
            System.out.println("Ingrese un numero de 1 al "+Matriz.length+" incluidos :");
            columna = scanner.nextInt();
        }while (columna <= 0 || columna > Matriz.length);
        for(int i = 0;i < Matriz.length;i++){
            suma +=Matriz[i][columna-1];
            }
            System.out.println(suma);
    }
    public static void SumaDiagonal(int [][] Matriz){
        int diagonal=0;
        for(int i = 0;i < Matriz.length;i++){
            for(int j = 0;j < Matriz[i].length;j++){
         if(i==j){
            diagonal+=Matriz[i][j];}}
        }
        System.out.println(diagonal);
    }
    public static void SumaDiagonalInversa(int [][] Matriz){
        int diagonalInversa=0;
        for(int i = 0;i < Matriz.length;i++){
            for(int j = 0;j < Matriz[i].length;j++){
                if(j+i==Matriz.length-1){
                    diagonalInversa+=Matriz[i][j];}
            }
        }
        System.out.println(diagonalInversa);
    }
    public static void MediaValores(int Matriz[][]){
        double Promedio=0;
        for(int i = 0;i < Matriz.length;i++){
            for(int j = 0;j < Matriz.length;j++){
            Promedio+=Matriz[i][j];   
        }
        }
        Promedio= Promedio / ((Matriz.length)*(Matriz.length));
        System.out.println(Promedio);

    }
}