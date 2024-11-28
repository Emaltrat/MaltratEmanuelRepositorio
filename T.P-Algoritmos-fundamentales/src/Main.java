import java.util.Scanner;

public class Main {
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ejercicio;
        do {
            System.out.println("Ingrese la opcion:");
            System.out.println(
                    "1) Ejercicio 1 (No implementado). \n" +
                            "2) Ejercicio 2 (Algoritmo de Inserción). \n" +
                            "3) Ejercicio 3 (Algoritmo ASC DESC). \n" +
                            "4) Ejercicio 4 (Selección de ordenamiento en matriz de 2 elementos). \n" +
                            "5) Ejercicio 5 (Matriz de 2 enteros). \n" +
                            "0) Salir ");
            ejercicio = scanner.nextInt();
            scanner.nextLine();

            switch (ejercicio) {

                case 1:
                    ejercicio1.eje1(scanner);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    Ejercicio5.Ej5(scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Esto no es un ejercicio, intente de nuevo");
                    break;
            }

        } while (ejercicio != 0);
    }
}
