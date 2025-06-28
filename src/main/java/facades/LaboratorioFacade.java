package facades;

import DTO.centro.AgregarCentroDTO;
import Dominio.Centro;
import java.util.List;
import negocio.ILaboratorioNegocio;
import negocio.LaboratorioNegocio;
import negocio.NegocioException;

/**
 *
 * @author luishonshon
 */
public class LaboratorioFacade implements ILaboratorioFacade {

    private final ILaboratorioNegocio LN = new LaboratorioNegocio();

    @Override
    public List<Centro> listarLaboratorios() throws NegocioException {
        return LN.listarLaboratorios();
    }

    @Override
    public Centro agregarLaboratorio(AgregarCentroDTO nuevoCentro) throws NegocioException {
        return LN.agregarLaboratorio(nuevoCentro);
    }

    /**
     * Faltan métodos en persistencia
     *
     * @return
     * @throws NegocioException
     */
    @Override
    public Centro modificarLaboratorio() throws NegocioException {
        return LN.modificarLaboratorio();
    }

}
