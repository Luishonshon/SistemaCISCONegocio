package negocio;

import DTO.centro.AgregarCentroDTO;
import Dominio.Centro;
import Dominio.Plantel;
import java.util.List;

/**
 *
 * @author luishonshon
 */
public interface ILaboratorioNegocio {

    public List<Centro> listarLaboratorios(Plantel plntl) throws NegocioException;

    public Centro agregarLaboratorio(AgregarCentroDTO nuevoCentro) throws NegocioException;

    public Centro modificarLaboratorio() throws NegocioException;
}
