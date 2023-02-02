/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.List;
import modelo.Pais;
import servicio.PaisServiceImpl;

/**
 *
 * @author amawt
 */
public class PaisControl {
    
    private PaisServiceImpl paisServiceImpl = new PaisServiceImpl();
    
    public void crear(String[] data) {
        try{
            
            var retorno="No se pudo crear Pais";
            var codigoPais = Integer.valueOf(data[0]);
            var divisa = data[1];
            var nombrePais = data[2];
            var poblacion = Integer.valueOf(data[3]);
            var nroProvincias = Integer.valueOf(data[4]);
        
            var pais = new Pais (codigoPais,divisa,nombrePais,poblacion,nroProvincias);
            if (this.codigoExiste(codigoPais)) {
                throw new RuntimeException("Código existe");
            } else {
            this.paisServiceImpl.crear(pais);
            retorno="Pais creado exitosamente";
            }
        } catch (NumberFormatException e1) {
            throw new NumberFormatException("Error al convertir el formato");
        }
        
    }
    
    public List<Pais> listar() {
        return this.paisServiceImpl.listar();
    }
    public String modificar(String[] data) {
        
        var retorno="No se puso modificar Pais";
        
        var codigoPais = Integer.valueOf(data[0]);
        var divisa = data[1];
        var nombrePais = data[2];
        var poblacion = Integer.valueOf(data[3]);
        var nroProvincias = Integer.valueOf(data[4]);
        var paisModificado = Integer.valueOf(data[5]);
        
        var pais = new Pais (codigoPais,divisa,nombrePais,poblacion,nroProvincias);
        this.paisServiceImpl.modificar(pais, paisModificado);
        retorno="Pais Modificado";
        return retorno;
    }
    
    public void eliminar(String codigos) {
        var codigoPais = Integer.valueOf(codigos).intValue();
        this.paisServiceImpl.eliminar(codigoPais);

    }
    public boolean codigoExiste(int codigoActual) {
        var retorno=false;
        for(var pais:this.paisServiceImpl.listar()){
            if(pais.getCodigoPais()==codigoActual){
                retorno = true;
            }
        }

        return retorno;
    }
}
