/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Provincia;

/**
 *
 * @author amawt
 */
public class ProvinciaServiceImpl implements ProvinciaService{
    
    private static List<Provincia> provinciaList = new ArrayList<>();

    @Override
    public void crear(Provincia provincia) {
        this.provinciaList.add(provincia);
        this.almacenarArchivo(provincia, "C:/Netbeans1/provincia.dat");
    }

    @Override
    public Provincia buscarPorCodigo(int codigoProvincia) {
        Provincia retorno = null;
        for (var provincia : this.provinciaList){
            if(codigoProvincia == provincia.getCodigoProvincia()){
                retorno = provincia;
                break;   
            }
            
        }
       return retorno; 
    }

    @Override
    public void modificar(Provincia provincia, int codigoProvincia) {
        var indice = -1;
        for (var provincias : this.provinciaList) {
            indice++;
            if (codigoProvincia == provincias.getCodigoProvincia()) {
                this.provinciaList.set(indice, provincia);

            }

        }
    }

    @Override
    public void eliminar(int codigoProvincia) {
        var indice = -1;
        for (var provincia : this.provinciaList) {
            indice++;
            if (codigoProvincia == provincia.getCodigoProvincia()) {
                this.provinciaList.remove(indice);

            }

        }
    }

    @Override
    public List<Provincia> listar() {
        return this.provinciaList;
    }

    @Override
    public Provincia buscarPorNombre(String nombreProvincia) {
        Provincia retorno = null;

        for (var provincia : this.provinciaList) {
            if (nombreProvincia.equals(provincia.getNombreProvincia())) {
                retorno = provincia;
                break;
            }
        }

        return retorno;
    }

    @Override
    public void almacenarArchivo(Provincia provincia, String ruta) {
        
       ObjectOutputStream salida = null;

        try {
            salida = new ObjectOutputStream(new FileOutputStream(ruta, true));
            salida.writeObject(provincia);
            salida.close();

        } catch (Exception ex) {
            Logger.getLogger(ProvinciaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Provincia> recuperarArchivo(String ruta) {
        
        List<Provincia> provinciaList = new ArrayList<Provincia>();
        try {
            var fis = new FileInputStream(new File(ruta));
            ObjectInputStream entrada = null;

            while (fis.available() > 0) {
                entrada = new ObjectInputStream(fis);
                Provincia provincia = (Provincia) entrada.readObject();
                provinciaList.add(provincia);

            }
            entrada.close();
        } catch(Exception ex){
            //entrada.close(); 
        }
        return provinciaList;
    }

    public static List<Provincia> getProvinciaList() {
        return provinciaList;
    }

    public static void setProvinciaList(List<Provincia> provinciaList) {
        ProvinciaServiceImpl.provinciaList = provinciaList;
    }
    
    public void ReGrabar() {
        var Borrarfile = new File("C:/Netbeans1/provincia.dat");
        Borrarfile.delete();

        for (var i = 0; i < provinciaList.size(); i++) {
            this.almacenarArchivo(provinciaList.get(i), "C:/Netbeans1/provincia.dat");

        }
    }
    
}
