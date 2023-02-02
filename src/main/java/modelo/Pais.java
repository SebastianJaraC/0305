/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author amawt
 */
public class Pais implements Serializable {

    private int codigoPais;
    private String divisa;
    private String nombrePais;
    private int poblacion;
    private int nroProvincias;

    public Pais(int codigoPais, String divisa, String nombrePais, int poblacion, int nroProvincias) {
        this.codigoPais = codigoPais;
        this.divisa = divisa;
        this.nombrePais = nombrePais;
        this.poblacion = poblacion;
        this.nroProvincias = nroProvincias;
    }

    public int getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(int codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getDivisa() {
        return divisa;
    }

    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public int getNroProvincias() {
        return nroProvincias;
    }

    public void setNroProvincias(int nroProvincias) {
        this.nroProvincias = nroProvincias;
    }

    @Override
    public String toString() {
        return "Pais{" + "codigoPais=" + codigoPais + ", divisa=" + 
                divisa + ", nombrePais=" + nombrePais + ", poblacion=" 
                + poblacion + ", nroProvincias=" + nroProvincias + '}';
    }

}
