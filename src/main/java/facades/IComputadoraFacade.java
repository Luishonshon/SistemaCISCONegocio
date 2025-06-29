package facades;

import DTO.computadoras.ActualizarEstadoComputadoraDTO;
import DTO.computadoras.AgregarComputadoraDTO;
import DTO.computadoras.FiltroComputadoraDTO;
import DTO.software.AgregarSoftwareDTO;
import Dominio.Computadora;
import Dominio.Instalacion;
import java.util.List;
import negocio.NegocioException;

/**
 *
 * @author luishonshon
 */
public interface IComputadoraFacade {

    public Computadora agregarComputadora(AgregarComputadoraDTO computadoraData, Long idSoftware) throws NegocioException;

    public List<Computadora> listarComputadorasPorCentro(FiltroComputadoraDTO filtro) throws NegocioException;

    public Computadora apartarComputadora(ActualizarEstadoComputadoraDTO alumnoData) throws NegocioException;

    public void liberarComputadora(ActualizarEstadoComputadoraDTO alumnoData) throws NegocioException;

    public Computadora correrProgramaValidacion() throws NegocioException;
    
    public List<Instalacion> listarSoftwareComputadora(Long idComputadora) throws NegocioException;
}
