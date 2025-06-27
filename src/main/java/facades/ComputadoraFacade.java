package facades;

import DTO.computadoras.ActualizarEstadoComputadoraDTO;
import DTO.computadoras.FiltroComputadoraDTO;
import Dominio.Computadora;
import java.util.List;

/**
 *
 * @author luishonshon
 */
public class ComputadoraFacade implements IComputadoraFacade{

    @Override
    public List<Computadora> listarComputadorasPorCentro(FiltroComputadoraDTO filtro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Computadora desbloquearComputadora(ActualizarEstadoComputadoraDTO alumnoData) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void liberarComputadora(ActualizarEstadoComputadoraDTO alumnoData) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
