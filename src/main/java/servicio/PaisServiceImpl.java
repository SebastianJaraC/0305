/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Pais;

/**
 *
 * @author amawt
 */
public class PaisServiceImpl implements PaisService {
    
    private static List<Pais> paisList = new ArrayList<>();

    @Override
    public void crear(Pais pais) {
        this.paisList.add(pais);
        this.almacenarArchivo(pais, "C:/Netbeans1/pais.dat");
    }

    @Override
    public Pais buscarPorCodigo(int codigoPais) {
        Pais retorno = null;
        for (var pais : this.paisList){
            if(codigoPais == pais.getCodigoPais()){
                retorno = pais;
                break;   
            }
            
        }
       return retorno; 
    }

    @Override
    public Pais buscarPorNombre(String nombrePais) {
        Pais retorno = null;

        for (var pais : this.paisList) {
            if (nombrePais.equals(pais.getNombrePais())) {
                retorno = pais;
                break;
            }
        }

        return retorno;
    }

    @Override
    public void modificar(Pais pais, int codigoPais) {
        
        var indice = -1;
        for (var paises : this.paisList) {
            indice++;
            if (codigoPais == paises.getCodigoPais()) {
                this.paisList.set(indice, pais);

            }

        }
    }

    @Override
    public void eliminar(int codigoPais) {
        var indice = -1;
        for (var pais : this.paisList) {
            indice++;
            if (codigoPais == pais.getCodigoPais()) {
                this.paisList.remove(indice);

            }

        }
    }

    @Override
    public List<Pais> listar() {
        
        return this.paisList;
    }

    @Override
    public void almacenarArchivo(Pais pais, String ruta) {
        
        DataOutputStream salida = null;

        try {
            salida = new DataOutputStream(new FileOutputStream(ruta, true));
            salida.writeInt(pais.getCodigoPais());
            salida.writeUTF(pais.getDivisa());
            salida.writeUTF(pais.getNombrePais());
            salida.writeInt(pais.getPoblacion());
            salida.writeInt(pais.getNroProvincias());

        } catch (IOException ex) {
            Logger.getLogger(PaisServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Pais> recuperarArchivo(String ruta) {
        
        var paisList = new ArrayList<Pais>();
        DataInputStream entrada = null;
        try {
            entrada = new DataInputStream(new FileInputStream(ruta));
            while (true) {
                var codigoPais = entrada.readInt();
                var divisa = entrada.readUTF();
                var nombrePais = entrada.readUTF();
                var poblacion = entrada.readInt();
                var nroProvincias = entrada.readInt();
                var pais = new Pais(codigoPais, divisa, nombrePais, poblacion, nroProvincias);
                paisList.add(pais);
            }
        } catch (IOException e) {
            try {
                entrada.close();
            } catch (IOException ex) {
                Logger.getLogger(PaisServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return paisList;
    }

    public  List<Pais> getPaisList() {
        return paisList;
    }

    public void setPaisList(List<Pais> paisList) {
        PaisServiceImpl.paisList = paisList;
    }

    public void ReGrabar() {
        var Borrarfile = new File("C:/Netbeans1/pais.dat");
        Borrarfile.delete();

        for (var i = 0; i < paisList.size(); i++) {
            this.almacenarArchivo(paisList.get(i), "C:/Netbeans1/pais.dat");

        }

    }

    
}
