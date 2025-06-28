package facades;

import DTO.computadoras.ActualizarEstadoComputadoraDTO;
import DTO.computadoras.FiltroComputadoraDTO;
import Dominio.Computadora;
import java.util.List;
import negocio.NegocioException;

/**
 *
 * @author luishonshon
 */
public interface IComputadoraFacade {

    public List<Computadora> listarComputadorasPorCentro(FiltroComputadoraDTO filtro);

    public Computadora desbloquearComputadora(ActualizarEstadoComputadoraDTO alumnoData);

    public void liberarComputadora(ActualizarEstadoComputadoraDTO alumnoData);
    
    public Computadora correrProgramaValidacion() throws NegocioException;
}
