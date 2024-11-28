
package ema.calculobonosueldo;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculoBonoSueldo {

   
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        // Arrays de haberes y deducciones
        String[][] haberes = {
            {"100", "Presentismo", "9"},
            {"101", "Titulo Profesional", "9"},
            {"102", "Horas Extraordinarias", "M"},
            {"103", "Horas Nocturnas", "M"},
            {"104", "Otros Haberes", "M"}
        };

        String[][] deducciones = {
            {"200", "Obra Social", "3"},
            {"201", "Jubilacion", "11"},
            {"202", "Sindicato", "2"},
            {"203", "Seguro", "1.5"},
            {"204", "Otros", "M"}
        };

        List<BonoSueldo> bonos = new ArrayList<>();
        List<Integer> codigosIngresados = new ArrayList<>();

        boolean continuar = true;
        while (continuar) {
            // Ingreso del empleado
            System.out.print("Ingrese el nombre del empleado: ");
            String nombre = sc.nextLine();
            
            
            String cuil;
            do{
                System.out.print("Ingrese el CUIL: ");
                cuil=sc.nextLine();
                if(cuil.length() !=11){
                System.out.println("CUIL incorrecto, intente nuevamente");}
                else{
                    break;
                }
            }while(true);
            

            System.out.print("Ingrese el año de ingreso: ");
            int anioIngreso = sc.nextInt();
            while (anioIngreso > java.time.Year.now().getValue()) {
                System.out.println("El año de ingreso no puede superar el actual. Intente nuevamente:");
                anioIngreso = sc.nextInt();
            }

            System.out.print("Ingrese el sueldo basico: ");
            double sueldoBasico = sc.nextDouble();
            double montoAntiguedad = (java.time.Year.now().getValue() - anioIngreso) * 0.02 * sueldoBasico;
            
            Empleado empleado = new Empleado();
            
            empleado.setCuil(cuil);
            empleado.setNombreEmpleado(nombre);
            empleado.setAnioIngreso(anioIngreso);
            empleado.setSueldoBasico(sueldoBasico);
            empleado.setMontoAntiguedad(montoAntiguedad);

            // Ingreso del Bono de Sueldo
            System.out.print("Ingrese el mes de liquidacion: ");
            int mesLiquidacion = sc.nextInt();

            System.out.print("Ingrese el año de liquidación: ");
            int anioLiquidacion = sc.nextInt();
            while (anioLiquidacion > java.time.Year.now().getValue()) {
                System.out.println("El año de liquidacion no puede superar el actual. Intente nuevamente:");
                anioLiquidacion = sc.nextInt();
            }

            BonoSueldo bono = new BonoSueldo();
            bono.setEmpleado(empleado);
            bono.setMesLiquidacion(mesLiquidacion);
            bono.setAnioLiquidacion(anioLiquidacion);

            // Carga de haberes
            double totalHaberes = 0;
            System.out.println("Ingrese los haberes del empleado: ");
            while (true) {
                for(int f=0;f<5;f++){
                    for(int c=0;c<2;c++){
                        System.out.print(haberes[f][c]+" ");
                    }
                    System.out.println("");
                }
                System.out.println("Ingrese el codigo del ítem (000 para finalizar):");
             
                int codigo = sc.nextInt();
                if (codigo == 0) break;

                if (codigosIngresados.contains(codigo)) {
                    System.out.println("El codigo ya ha sido cargado. Intente con otro.");
                    continue;
                }

                boolean encontrado = false;
                for (String[] haber : haberes) {
                    if (Integer.parseInt(haber[0]) == codigo) {
                        encontrado = true;
                        codigosIngresados.add(codigo);
                        double monto = haber[2].equals("M")
                                ? sc.nextDouble()
                                : sueldoBasico * Double.parseDouble(haber[2]) / 100;
                        bono.agregarHaber(String.valueOf(codigo), haber[1], monto);
                        totalHaberes += monto;
                        break;
                    }
                }
                if (!encontrado) System.out.println("El codigo ingresado es incorrecto.");
            }

            // Carga de deducciones
            double totalDeducciones = 0;
            System.out.println("Ingrese las deducciones del empleado:");
            while (true) {
              
                for(int f=0;f<5;f++){
                    for(int c=0;c<2;c++){
                        System.out.print(deducciones[f][c]+" ");
                    }
                    System.out.println("");
                }
                System.out.println("Ingrese el codigo del ítem (000 para finalizar):");
                int codigo = sc.nextInt();
                if (codigo == 0) break;

                if (codigosIngresados.contains(codigo)) {
                    System.out.println("El codigo ya ha sido cargado. Intente con otro.");
                    continue;
                }

                boolean encontrado = false;
                for (String[] deduccion : deducciones) {
                    if (Integer.parseInt(deduccion[0]) == codigo) {
                        encontrado = true;
                        codigosIngresados.add(codigo);
                        double monto = deduccion[2].equals("M")
                                ? sc.nextDouble()
                                : sueldoBasico * Double.parseDouble(deduccion[2]) / 100;
                        bono.agregarDeduccion(String.valueOf(codigo), deduccion[1], monto);
                        totalDeducciones += monto;
                        break;
                    }
                }
                if (!encontrado) System.out.println("El codigo ingresado es incorrecto.");
            }
            codigosIngresados.removeAll(codigosIngresados);

            // Calculo y asignación
            double montoLiquidacion = sueldoBasico + montoAntiguedad + totalHaberes - totalDeducciones;
            bono.setMontoLiquidacion(montoLiquidacion);
            bonos.add(bono);

            // Preguntar si desea continuar
            System.out.println("Desea generar un nuevo bono de sueldo? (s/n)");
            continuar = sc.next().equalsIgnoreCase("s");
            sc.nextLine(); 
        }
          imprimirBonos(bonos);
    }

    public static void imprimirBonos(List<BonoSueldo> bonos) {
    System.out.println("\n--- BONOS DE SUELDO GENERADOS ---");

    for (BonoSueldo bono : bonos) {
        Empleado empleado = bono.getEmpleado();
        double sueldoBasico = empleado.getSueldoBasico();
        double montoAntiguedad = empleado.getMontoAntiguedad();

        // Datos generales del empleado
        System.out.println("-------------------------------------------------------------");
        System.out.printf("Nombre: %-20s CUIL: %-15s\n", empleado.getNombreEmpleado(), empleado.getCuil());
        System.out.printf("Mes Liquidacion: %-10d Año Liquidacion: %-10d\n", bono.getMesLiquidacion(), bono.getAnioLiquidacion());
        System.out.printf("Sueldo Basico: %-10.2f Año Ingreso: %-10d\n", sueldoBasico, empleado.getAnioIngreso());

        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-15s %-20s %-10s %-10s\n", "Codigo Item", "Denominacion", "Haberes", "Deducciones");

        double subtotalHaberes = sueldoBasico + montoAntiguedad; // Incluye sueldo básico y antigüedad
        double subtotalDeducciones = 0;

        System.out.printf("%-15s %-20s %-10.2f %-10s\n", "", "Sueldo Basico", sueldoBasico, "");
        System.out.printf("%-15s %-20s %-10.2f %-10s\n", "", "Antiguedad", montoAntiguedad, "");

        // Agregar haberes
        for (String[] haber : bono.getHaberes()) {
            double montoHaber = Double.parseDouble(haber[2]);
            subtotalHaberes += montoHaber;
            System.out.printf("%-15s %-20s %-10.2f %-10s\n", haber[0], haber[1], montoHaber, "");
        }

        // Agregar deducciones
        for (String[] deduccion : bono.getDeducciones()) {
            double montoDeduccion = Double.parseDouble(deduccion[2]);
            subtotalDeducciones += montoDeduccion;
            System.out.printf("%-15s %-20s %-10s %-10.2f\n", deduccion[0], deduccion[1], "", montoDeduccion);
        }

        // Subtotales y Neto
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-15s %-20s %-10.2f %-10.2f\n", "", "SUB TOTAL", subtotalHaberes, subtotalDeducciones);
        System.out.printf("%-15s %-20s %-10s %-10.2f\n", "", "NETO", "", subtotalHaberes - subtotalDeducciones);
        System.out.println("-------------------------------------------------------------");
    }
    
  }
}
