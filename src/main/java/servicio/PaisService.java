/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servicio;

import java.util.List;
import modelo.Pais;

/**
 *
 * @author amawt
 */
public interface PaisService {
    
    public void crear(Pais pais);

    public Pais buscarPorCodigo(int codigoPais);

    public Pais buscarPorNombre(String nombrePais);
    
    public void modificar(Pais pais, int codigoPais);

    public void eliminar(int codigoPais);

    public List<Pais> listar();
    
    public void almacenarArchivo(Pais pais, String ruta);

    public List<Pais> recuperarArchivo(String ruta);
    
}
