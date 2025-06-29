package facades;

import DTO.computadoras.ActualizarEstadoComputadoraDTO;
import DTO.computadoras.AgregarComputadoraDTO;
import DTO.computadoras.FiltroComputadoraDTO;
import Dominio.Computadora;
import Dominio.Instalacion;
import java.util.List;
import negocio.ComputadoraNegocio;
import negocio.IComputadoraNegocio;
import negocio.NegocioException;

/**
 *
 * @author luishonshon
 */
public class ComputadoraFacade implements IComputadoraFacade {

    public final IComputadoraNegocio CN = new ComputadoraNegocio();

    @Override
    public List<Computadora> listarComputadorasPorCentro(FiltroComputadoraDTO filtro) throws NegocioException {
        return CN.listarComputadorasPorCentro(filtro);
    }

    @Override
    public Computadora apartarComputadora(ActualizarEstadoComputadoraDTO alumnoData) throws NegocioException {
        return CN.apartarComputadora(alumnoData);
    }

    @Override
    public void liberarComputadora(ActualizarEstadoComputadoraDTO alumnoData) throws NegocioException {
        CN.liberarComputadora(alumnoData);
    }

    @Override
    public Computadora correrProgramaValidacion() throws NegocioException {
        return CN.correrProgramaValidacion();
    }

    @Override
    public Computadora agregarComputadora(AgregarComputadoraDTO computadoraData, Long idSotfware) throws NegocioException {
        return CN.agregarComputadora(computadoraData, idSotfware);
    }

    @Override
    public List<Instalacion> listarSoftwareComputadora(Long idComputadora) throws NegocioException {
        return CN.listarSoftwareComputadora(idComputadora);
    }

}
