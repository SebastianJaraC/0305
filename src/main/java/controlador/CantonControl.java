/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.time.LocalDate;
import java.util.List;
import modelo.Canton;
import servicio.CantonServiceImpl;
import servicio.ProvinciaServiceImpl;

/**
 *
 * @author amawt
 */
public class CantonControl {
    
    private ProvinciaServiceImpl provinciaServiceImpl = new ProvinciaServiceImpl();
    private CantonServiceImpl cantonServiceImpl = new CantonServiceImpl();
    
    public void crear(String[] data) {
        
        try{
            
        var retorno="No se pudo crear";
        var codigoCanton = Integer.valueOf(data[0]);
        var nombreCanton = data[1];
        var nombreProvincia = this.provinciaServiceImpl.buscarPorNombre(data[2]);
        var universidades = Integer.valueOf(data[3]);
        var areaTotal=Double. parseDouble(data[4]);

        
        var canton = new Canton (codigoCanton,nombreCanton,nombreProvincia,universidades,areaTotal);
        
        if (this.codigoExiste(codigoCanton)) {
                throw new RuntimeException("Código existe");
            } else {
        this.cantonServiceImpl.crear(canton);
        retorno="Canton creada exitosamente";
        }
        } catch (NumberFormatException e1) {
            throw new NumberFormatException("Error al convertir el formato");
        }
        
    }
    public List<Canton> listar(){
        return this.cantonServiceImpl.listar();
    }
    
    public String modificar(String[] data) {
        
        var retorno="No se pudo modificar";
        var codigoCanton = Integer.valueOf(data[0]);
        var nombreCanton = data[1];
        var nombreProvincia = this.provinciaServiceImpl.buscarPorNombre(data[2]);
        var universidades = Integer.valueOf(data[3]);
        var areaTotal=Double.parseDouble(data[4]);
 
        
        var canton = new Canton (codigoCanton,nombreCanton,nombreProvincia,universidades,areaTotal);
        int cantonModificado = 0;
        this.cantonServiceImpl.modificar(canton, cantonModificado);
        retorno="Canton modificado exitosamente";
        return retorno;
    }
    
    public void eliminar(String codigos) {
        var codigoCanton = Integer.valueOf(codigos);
        this.cantonServiceImpl.eliminar(codigoCanton);

    }
    
    public boolean codigoExiste(int codigoActual) {
        var retorno=false;
        for(var canton:this.cantonServiceImpl.listar()){
            if(canton.getCodigoCanton()==codigoActual){
                retorno = true;
            }
        }

        return retorno;
    }
}
