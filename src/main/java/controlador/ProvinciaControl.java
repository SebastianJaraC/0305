 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.time.LocalDate;
import java.util.List;
import modelo.Provincia;
import servicio.PaisServiceImpl;
import servicio.ProvinciaServiceImpl;

/**
 *
 * @author amawt
 */
public class ProvinciaControl {
    
     private PaisServiceImpl paisServiceImpl = new PaisServiceImpl();
     private ProvinciaServiceImpl provinciaServiceImpl = new ProvinciaServiceImpl();
     
     public void crear(String[] data) { 
         
         try{
             
         var retorno="No se pudo crear";
         var codigoProvincia = Integer.valueOf(data[0]);
         var nombrePais = this.paisServiceImpl.buscarPorNombre(data[1]);
         var nombreProvincia = data[2];
         var nroCanton = Integer.valueOf(data[3]);
         var habitantes = Integer.valueOf(data[4]);
         var habitantesRemunerados=Integer.valueOf(data[5]);

         
         var provincia = new Provincia (codigoProvincia,nombrePais,nombreProvincia,nroCanton,habitantes,habitantesRemunerados);
         
         if (this.codigoExiste(codigoProvincia)) {
                throw new RuntimeException("Código existe");
            } else {
         this.provinciaServiceImpl.crear(provincia);
         retorno="Provincia creado exitosamente";
          }
        } catch (NumberFormatException e1) {
            throw new NumberFormatException("Error al convertir el formato");
        }
     }
    public List<Provincia> listar(){
        return this.provinciaServiceImpl.listar();
    }
    public String modificar(String[] data) {
         
         var retorno="No se pudo modificar";
         var codigoProvincia = Integer.valueOf(data[0]);
         var nombrePais = this.paisServiceImpl.buscarPorNombre(data[1]);
         var nombreProvincia = data[2];
         var nroCanton = Integer.valueOf(data[3]);
         var habitantes = Integer.valueOf(data[4]);
         var habitantesRemunerados=Integer.valueOf(data[5]);
  
         var provinciaModificado= Integer.valueOf(data[8]);
         
         var provincia = new Provincia (codigoProvincia,nombrePais,nombreProvincia,nroCanton,habitantes,habitantesRemunerados);
         this.provinciaServiceImpl.modificar(provincia,provinciaModificado);
         retorno="Provincia modificada";
         return retorno;
    }
    
    public void eliminar(String codigos) {
        var codigoProvincia = Integer.valueOf(codigos);
        this.provinciaServiceImpl.eliminar(codigoProvincia);

    }
    
    public boolean codigoExiste(int codigoActual) {
       var retorno=false;
        for(var provincia:this.provinciaServiceImpl.listar()){
            if(provincia.getCodigoProvincia()==codigoActual){
                retorno = true;
            }
        }

        return retorno;
    }
}
