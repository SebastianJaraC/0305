/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servicio;

import java.util.List;
import modelo.Provincia;

/**
 *
 * @author amawt
 */
public interface ProvinciaService {
    
    public void crear(Provincia provincia);

    public Provincia buscarPorCodigo(int codigoProvincia);
    
    public Provincia buscarPorNombre(String nombreProvincia);
    
    public void modificar(Provincia provincia, int codigoProvincia);

    public void eliminar(int codigoProvincia);

    public List<Provincia> listar();
    
    public void almacenarArchivo(Provincia provincia, String ruta);

    public List<Provincia> recuperarArchivo(String ruta);
    
}
