/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Canton;

/**
 *
 * @author amawt
 */
public class CantonServiceImpl implements CantonService{
    
    private static List <Canton> cantonList = new ArrayList<>();

    @Override
    public void crear(Canton canton) {
        this.cantonList.add(canton);
        this.almacenarArchivo(canton, "C:/Netbeans1/canton.dat");
    }

    @Override
    public void modificar(Canton canton, int codigoCanton) {
        var indice = -1;
        for (var cantones : this.cantonList) {
            indice++;
            if (codigoCanton == cantones.getCodigoCanton()) {
                this.cantonList.set(indice, canton);

            }

        }
    }

    @Override
    public void eliminar(int codigoCanton) {
        var indice = -1;
        for (var canton : this.cantonList) {
            indice++;
            if (codigoCanton == canton.getCodigoCanton()) {
                this.cantonList.remove(indice);

            }

        }
    }

    @Override
    public List<Canton> listar() {
        return this.cantonList;
    }

    @Override
    public Canton buscarPorCodigo(int codigoCanton) {
        Canton retorno = null;
        for (var canton : this.cantonList){
            if(codigoCanton == canton.getCodigoCanton()){
                retorno = canton;
                break;   
            }
            
        }
       return retorno; 
    }

    @Override
    public Canton buscarPorNombre(String nombreCanton) {
        Canton retorno = null;

        for (var canton : this.cantonList) {
            if (nombreCanton.equals(canton.getNombreCanton())) {
                retorno = canton;
                break;
            }
        }

        return retorno;
    }

    @Override
    public void almacenarArchivo(Canton canton, String ruta) {
        
        ObjectOutputStream salida = null;

        try {
            salida = new ObjectOutputStream(new FileOutputStream(ruta, true));
            salida.writeObject(canton);
            salida.close();

        } catch (Exception ex) {
            Logger.getLogger(CantonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Canton> recuperarArchivo(String ruta) {
        
        List<Canton> cantonList = new ArrayList<Canton>();
        try {
            var fis = new FileInputStream(new File(ruta));
            ObjectInputStream entrada = null;

            while (fis.available() > 0) {
                entrada = new ObjectInputStream(fis);
                Canton canton = (Canton) entrada.readObject();
                cantonList.add(canton);

            }
            entrada.close();
        } catch(Exception ex){
            //entrada.close(); 
        }
        return cantonList;
    }

    public static List<Canton> getCantonList() {
        return cantonList;
    }

    public static void setCantonList(List<Canton> cantonList) {
        CantonServiceImpl.cantonList = cantonList;
    }
    public void ReGrabar() {
        var Borrarfile = new File("C:/Netbeans1/canton.dat");
        Borrarfile.delete();

       
    }
    
}
