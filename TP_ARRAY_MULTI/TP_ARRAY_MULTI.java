package grupo_6.tp_array_multi;

import java.util.Scanner;



public class TP_ARRAY_MULTI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int opcion;
        do{
            System.out.println("Ingrese la opcion:");
            System.out.println("1)Ejercicio 1 Países.\n"+
                    "2)Ejercicio 2 Matrices. \n"+
                    "3)Ejercicio 3 \n"+
                    "4)Ejercicio 4 \n"+
                    "5)Ejercicio 5 Máquina expendedora\n" +
                    "0)Salir ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                  Ej1.ejercicio1(scanner);
                  break;
              case 2:
                  Ej2.EJ2();
                  break;
              case 3:
                  Ej3.EJ3(scanner);
                  break;
              case 4:
                  Ej4.Ejercicio4(scanner);
                  break;
               case 5:
                  Ej5.menuInteractivo();
                  break;
              default :
                  System.out.println("Saliendoo....");
                  break;
          }
        } while ( opcion !=0);
        }
    }

