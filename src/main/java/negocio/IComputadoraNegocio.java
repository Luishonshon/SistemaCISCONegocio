package negocio;

import DTO.computadoras.ActualizarEstadoComputadoraDTO;
import DTO.computadoras.AgregarComputadoraDTO;
import DTO.computadoras.FiltroComputadoraDTO;
import Dominio.Computadora;
import java.util.List;

/**
 *
 * @author luishonshon
 */
public interface IComputadoraNegocio {

    public Computadora agregarComputadora(AgregarComputadoraDTO computadoraData, Long idSoftware) throws NegocioException;

    public List<Computadora> listarComputadorasPorCentro(FiltroComputadoraDTO filtro) throws NegocioException;

    public Computadora apartarComputadora(ActualizarEstadoComputadoraDTO alumnoData) throws NegocioException;

    public void liberarComputadora(ActualizarEstadoComputadoraDTO alumnoData) throws NegocioException;

    public Computadora correrProgramaValidacion() throws NegocioException;
}
