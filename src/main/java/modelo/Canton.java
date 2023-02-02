/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author amawt
 */
public class Canton implements Serializable{

    private int codigoCanton;
    private String nombreCanton;
    private Provincia nombreProvincia;
    private int universidades;
    private double areaTotal;

    public Canton(int codigoCanton, String nombreCanton, Provincia nombreProvincia, int universidades, double areaTotal) {
        this.codigoCanton = codigoCanton;
        this.nombreCanton = nombreCanton;
        this.nombreProvincia = nombreProvincia;
        this.universidades = universidades;
        this.areaTotal = areaTotal;
    }

    public int getCodigoCanton() {
        return codigoCanton;
    }

    public void setCodigoCanton(int codigoCanton) {
        this.codigoCanton = codigoCanton;
    }

    public String getNombreCanton() {
        return nombreCanton;
    }

    public void setNombreCanton(String nombreCanton) {
        this.nombreCanton = nombreCanton;
    }

    public Provincia getNombreProvincia() {
        return nombreProvincia;
    }

    public void setNombreProvincia(Provincia nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    public int getuniversidades() {
        return universidades;
    }

    public void setuniversidades(int universidades) {
        this.universidades = universidades;
    }

    public double getareaTotal() {
        return areaTotal;
    }

    public void setareaTotal(double areaTotal) {
        this.areaTotal = areaTotal;
    }

    @Override
    public String toString() {
        return "Canton{" + "codigoCanton=" + codigoCanton + ", nombreCanton=" + 
                nombreCanton + ", nombreProvincia=" + nombreProvincia.getNombreProvincia() + ", nroPoblacion=" 
                + universidades + ", areaTotal=" + areaTotal + '}';
    }

}
