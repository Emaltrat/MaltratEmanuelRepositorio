package org.example;

import java.util.Calendar;
import java.util.Date;

public class FuncionesPrograma {
    public static Date getFechaDate(int dia, int mes, int anio) {
        Calendar calendario = Calendar.getInstance();
        calendario.set(anio, mes - 1, dia);
        return calendario.getTime();
    }

    public static String getFechaString(Date fecha) {
        return fecha.toString();
    }

    public static class Fraccion {
        int numerador;
        int denominador;

        public Fraccion(int numerador, int denominador) {
            if (denominador == 0) {
                throw new IllegalArgumentException("El denominador no puede ser cero.");
            }
            int gcd = mcd(numerador, denominador);
            this.numerador = numerador / gcd;
            this.denominador = denominador / gcd;
        }

        public static Fraccion sumarFracciones(Fraccion f1, Fraccion f2) {
            int nuevoNum = f1.numerador * f2.denominador + f2.numerador * f1.denominador;
            int nuevoDenom = f1.denominador * f2.denominador;
            return new Fraccion(nuevoNum, nuevoDenom);
        }

        public static Fraccion restarFracciones(Fraccion f1, Fraccion f2) {
            int nuevoNum = f1.numerador * f2.denominador - f2.numerador * f1.denominador;
            int nuevoDenom = f1.denominador * f2.denominador;
            return new Fraccion(nuevoNum, nuevoDenom);
        }

        public static Fraccion multiplicarFracciones(Fraccion f1, Fraccion f2) {
            int nuevoNum = f1.numerador * f2.numerador;
            int nuevoDenom = f1.denominador * f2.denominador;
            return new Fraccion(nuevoNum, nuevoDenom);
        }

        public static Fraccion dividirFracciones(Fraccion f1, Fraccion f2) {
            if (f2.numerador == 0) {
                throw new ArithmeticException("No se puede dividir por una fracción con numerador 0.");
            }
            int nuevoNum = f1.numerador * f2.denominador;
            int nuevoDenom = f1.denominador * f2.numerador;
            return new Fraccion(nuevoNum, nuevoDenom);
        }

        @Override
        public String toString() {
            return numerador + "/" + denominador;
        }

        private int mcd(int a, int b) {
            if (b == 0) {
                return a;
            }
            return mcd(b, a % b);
        }
    }
    
}




