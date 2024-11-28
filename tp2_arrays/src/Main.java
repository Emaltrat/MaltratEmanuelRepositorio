import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Seleccione el ejercicio que desea ejecutar");
            System.out.println("1.");
            System.out.println("2.Mostrar el array por pantalla(for)");
            System.out.println("3.Mostrar numero y sus multiplos");
            System.out.println("4.Mayor y menor de un arreglo");
            System.out.println("5.");
            System.out.println("6.Generar un array con numeros aleatorios y mostrarlo(for)");
            System.out.println("7.Suma de numero pares e impares");
            System.out.println("8.Mostrar en forma ascendente y descendente");
            System.out.println("9.");
            System.out.println("10.Mostrar el dni con la letra correspondiente(metodo,Scaner)");
            System.out.println("11.Sumatoria de arreglos");
            System.out.println("12.Cambiar elemento de un array");
            System.out.println("0. Salir");
            System.out.println("0pción: ");
            option = scanner.nextInt();

            switch (option) {
//                case 1:
//                    1();
//                    break;
                case 2:
                    ejercicio2();
                    break;
                case 3:
                    ejercicio3(scanner);
                    break;
                case 4:
                    ejercicio4(scanner);
                    break;
//                case 5:
//                    ejercicio5();
//                    break;
                case 6:
                    ejercicio6();
                    break;
                case 7:
                    ejercicio7(scanner);
                    break;
                case 8:
                    ejercicio8(scanner);
                    break;
//                case 9:
//                    ejercicio9();
//                    break;
                case 10:
                    ejercicio10(scanner);
                    break;
                case 11:
                    ejercicio11(scanner);
                    break;
                case 12:
                    ejercicio12(scanner);
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");

            }
            System.out.println();
        } while (option != 0);

        scanner.close();
    }

    public static void ejercicio2() {
        int array[] = {1, 2, 3, 4, 5};

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void ejercicio4(Scanner scanner) {
        double[] numeros = new double[20];
        int contador = 0;

        while (contador < 20) {
            System.out.print("Ingrese un número decimal (" + (contador + 1) + "/20): ");

            // Leer la entrada como cadena
            String entrada = scanner.next();

            try {
                // Convertimos la cadena a double
                double numero = Double.parseDouble(entrada);

                // Verificar si el número contiene un punto decimal
                if (entrada.contains(".")) {
                    numeros[contador] = numero; // Almacenar en el arreglo
                    contador++; // Incrementar el contador
                } else {
                    System.out.println("Error: Debe ingresar un número decimal (con punto decimal).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor ingrese un número decimal válido.");
            }
        }

        double mayor_2 = numeros[0];
        double menor_2 = numeros[0];
        double rango_2 = numeros[0];
        for (int i = 1; i < 20; i++) {
            if (numeros[i] > mayor_2) {
                mayor_2 = numeros[i];
            }
            if (numeros[i] < menor_2) {
                menor_2 = numeros[i];
            }
        }
        rango_2 = mayor_2 - menor_2;
        System.out.println("El mayor es " + mayor_2);
        System.out.println("El menor es " + menor_2);
        System.out.println("El rango es " + rango_2);

    }



    public static void ejercicio6() {
        int array[] = new int[50];
        for (int i = 0; i < array.length; i++) {
            array[i] =(int) (Math.random() * 1000);
            System.out.println(array[i]);
        }
    }
    private static final char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

    public static void ejercicio8(Scanner scanner) {
        int arreglo_1[] = new int[10];
        int arreglo_ascendente[] = new int[10];
        int arreglo_descendente[] = new int[10];

        // Ingresar los números
        for (int i = 0; i < 10; i++) {
            while (true) {
                System.out.println("Introduce un número entero (" + (i + 1) + "/10): ");
                try {
                    int numero = Integer.parseInt(scanner.nextLine());
                    arreglo_1[i] = numero;
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida, debes ingresar un número entero");
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            arreglo_ascendente[i] = arreglo_1[i];
            arreglo_descendente[i] = arreglo_1[i];
        }


        for (int i = 0; i < 10 - 1; i++) {
            for (int j = i + 1; j < 10; j++) {
                if (arreglo_ascendente[i] > arreglo_ascendente[j]) {
                    int aux = arreglo_ascendente[i];
                    arreglo_ascendente[i] = arreglo_ascendente[j];
                    arreglo_ascendente[j] = aux;
                }
            }
        }

        for (int i = 0; i < 10 - 1; i++) {
            for (int j = i + 1; j < 10; j++) {
                if (arreglo_descendente[i] < arreglo_descendente[j]) {
                    int aux = arreglo_descendente[i];
                    arreglo_descendente[i] = arreglo_descendente[j];
                    arreglo_descendente[j] = aux;
                }
            }
        }

        System.out.print("El primer arreglo es: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(arreglo_1[i] + " ");
        }
        System.out.println();

        System.out.print("El arreglo ascendente es: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(arreglo_ascendente[i] + " ");
        }
        System.out.println();

        System.out.print("El arreglo descendente es: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(arreglo_descendente[i] + " ");
        }
        System.out.println();
    }



    public static void ejercicio10(Scanner scanner) {
        System.out.println("Ingrese el numero del dni: ");
       int numero_dni = scanner.nextInt();

       if (numero_dni < 0) {
           System.out.println("El numero del dni no puede ser negativo.");
           return;
       }

       if (numero_dni > 99999999) {
           System.out.println("Número de DNI inválido. Debe tener como máximo 8 dígitos.");
           return;
       }

       char letra = optenerLetra(numero_dni);
       System.out.println("El DNI completo es: "+ numero_dni + letra);

    }
    public static char optenerLetra(int numero_dni) {
        int resto = numero_dni % 23;

        return letras[resto];

    }
    public static void ejercicio3(Scanner scanner) {
        System.out.print("Dime la dimension del areglo : ");
        int dimension = scanner.nextInt();

        System.out.print("Dime el número del cual quieres los múltiplos: ");
        int multiplo = scanner.nextInt();

        // Llenar el array con múltiplos
        int[] array = llenarArray(dimension, multiplo);

        // Mostrar el contenido del array
        System.out.println("El array con los múltiplos es:");
        mostrarArray(array);
    }
    public static int[] llenarArray(int dimension, int multiplo) {
        int[] array = new int[dimension];
        for (int i = 0; i < dimension; i++) {
            array[i] = multiplo * (i + 1); 
        }
        return array;
    }

    // Función para mostrar el contenido del array
    public static void mostrarArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void ejercicio7(Scanner scanner) {
        int array[] = new int[20];
        int numeroPar=0;
        int numeroImpar=0;
        System.out.println("Ingrese 20 numeros aleatorios: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
            if (array[i] % 2 == 0){
                numeroPar=numeroPar+array[i];}
            else{
                numeroImpar+=array[i];
            }    
        }   
        System.out.printf("La suma de los numeros pares es = "+ numeroPar +"\n"+
"La suma de los numeros impares es = "+numeroImpar);   
}

public static void ejercicio11(Scanner scanner){
    int array5[]= new int[5];
    int array10[]= new int[10];
    int array[]= new int[5];
for (int i=0;i<array5.length;i++){
    System.out.print("Ingrese los numeros del primer array: ");
    array5[i]= scanner.nextInt();
}
for (int i=0;i<array10.length;i++){
    System.out.print("Ingrese los numeros del segundo array: ");
    array10[i]= scanner.nextInt();
}
    // Calculamos los valores del tercer array
    for (int i = 0; i < 5; i++) {
        int suma = 0;
        for (int j = 0; j < 10; j++) {
            suma += array5[i] * array10[j];
        }
        array[i] = suma;
    }

    // Mostramos los 3 arrays
    System.out.println("\nArray 1:");
    for (int i = 0; i < 5; i++) {
        System.out.print(array5[i] + " ");
    }

    System.out.println("\nArray 2:");
    for (int i = 0; i < 10; i++) {
        System.out.print(array10[i] + " ");
    }

    System.out.println("\nArray 3 :");
    for (int i = 0; i < 5; i++) {
        System.out.print(array[i] + " ");
    }

}

    public static void ejercicio12(Scanner scanner) {
        int cantidad = 10;
        double[] arreglo = new double[cantidad];

        // Llenar el arreglo con números ingresados por el usuario
        for (int i = 0; i < cantidad; i++) {
            while (true) {
                System.out.println("Introduce un número: ");
                String entrada = scanner.nextLine();
                try {
                    double numero = Double.parseDouble(entrada);
                    arreglo[i] = numero;
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Eso no es un número, intentalo de nuevo");
                }
            }
        }

        // Mostrar el arreglo inicial
        System.out.println("El primer arreglo es: ");
        for (double numero : arreglo) {
            System.out.print(numero + " ");
        }
        System.out.println();

        // Eliminar elementos del arreglo según lo ingresado por el usuario
        while (true) {
            System.out.println("Introduce un número a eliminar (o 'salir' para terminar): ");
            String entrada = scanner.nextLine();
            if (entrada.equalsIgnoreCase("salir")) {
                break;
            }
            try {
                double numero = Double.parseDouble(entrada);
                arreglo = eliminarElemento(arreglo, numero);
                System.out.println("Arreglo después de eliminar " + numero + ": ");
                for (double num : arreglo) {
                    System.out.print(num + " ");
                }
                System.out.println();
            } catch (NumberFormatException e) {
                System.out.println("Eso no es un número, intentalo de nuevo");
            }
        }
    }

    public static double[] eliminarElemento(double[] arreglo, double elemento) {
        int index = -1;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == elemento) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Elemento no encontrado en el arreglo.");
            return arreglo;
        }

        double[] nuevoArreglo = new double[arreglo.length - 1];
        for (int i = 0, j = 0; i < arreglo.length; i++) {
            if (i != index) {
                nuevoArreglo[j++] = arreglo[i];
            }
        }
        return nuevoArreglo;
    }


}

