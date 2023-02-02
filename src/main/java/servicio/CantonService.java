/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servicio;

import java.util.List;
import modelo.Canton;

/**
 *
 * @author amawt
 */
public interface CantonService {
    
    public void crear(Canton canton);
    
    public Canton buscarPorCodigo(int codigoCanton);
    
    public Canton buscarPorNombre(String nombreCanton);
    
    public void modificar(Canton canton, int codigoCanton);

    public void eliminar(int codigoCanton);

    public List<Canton> listar();
    
    public void almacenarArchivo(Canton canton, String ruta);

    public List<Canton> recuperarArchivo(String ruta);
    
}
