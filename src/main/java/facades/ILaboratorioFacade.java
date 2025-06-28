package facades;

import DTO.centro.AgregarCentroDTO;
import Dominio.Centro;
import java.util.List;
import negocio.NegocioException;

/**
 *
 * @author luishonshon
 */
public interface ILaboratorioFacade {
    public List<Centro> listarLaboratorios() throws NegocioException;
    public Centro agregarLaboratorio(AgregarCentroDTO nuevoCentro) throws NegocioException;
    public Centro modificarLaboratorio() throws NegocioException;
}
