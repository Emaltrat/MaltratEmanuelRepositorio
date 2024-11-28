package ema.calculobonosueldo;

import java.util.ArrayList;
import java.util.List;

public class BonoSueldo {
    private Empleado empleado;
    private int mesLiquidacion;
    private int anioLiquidacion;
    private double montoLiquidacion;
    private List<String[]> haberes = new ArrayList<>();
    private List<String[]> deducciones = new ArrayList<>();

    public BonoSueldo() {
    }

   

    public List<String[]> getHaberes() {
        return haberes;
    }

    public void agregarHaber(String codigo, String denominacion, double monto) {
        haberes.add(new String[]{codigo, denominacion, String.valueOf(monto)});
    }

    public List<String[]> getDeducciones() {
        return deducciones;
    }

    public void agregarDeduccion(String codigo, String denominacion, double monto) {
        deducciones.add(new String[]{codigo, denominacion, String.valueOf(monto)});
    }
    
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getMesLiquidacion() {
        return mesLiquidacion;
    }

    public void setMesLiquidacion(int mesLiquidacion) {
        this.mesLiquidacion = mesLiquidacion;
    }

    public int getAnioLiquidacion() {
        return anioLiquidacion;
    }

    public void setAnioLiquidacion(int anioLiquidacion) {
        this.anioLiquidacion = anioLiquidacion;
    }

    public double getMontoLiquidacion() {
        return montoLiquidacion;
    }

    public void setMontoLiquidacion(double montoLiquidacion) {
        this.montoLiquidacion = montoLiquidacion;
    }
}
