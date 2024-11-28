
package org.example;

public class Calculo {
    public static void main() {
    OperacionMatematica operacion = new OperacionMatematica(10, 5);
        System.out.println("La variable 1 es : "+operacion.getValor1()+" y la variable 2 es : "+operacion.getValor2());
        System.out.println("Suma: " + operacion.aplicarOperacion("+"));
        System.out.println("Resta: " + operacion.aplicarOperacion("-"));
        System.out.println("Multiplicación: " + operacion.aplicarOperacion("*"));
        System.out.println("División: " + operacion.aplicarOperacion("/"));
    }
    }
    
