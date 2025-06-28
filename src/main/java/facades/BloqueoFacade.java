package facades;

import DAO.AlumnoDAO;
import DTO.alumnos.BloquearAlumnoDTO;
import Dominio.Bloqueo;
import java.util.List;
import negocio.BloqueoNegocio;
import negocio.NegocioException;

/**
 *
 * @author luishonshon
 */
public class BloqueoFacade implements IBloqueoFacade {

    BloqueoNegocio BN = new BloqueoNegocio();

    @Override
    public Bloqueo bloquearAlumno(BloquearAlumnoDTO alumnoBloqueado) throws NegocioException {
        return BN.bloquearAlumno(alumnoBloqueado);
    }

    /**
     * No terminado
     *
     * @return
     * @throws NegocioException
     */
    @Override
    public Bloqueo desbloquearAlumno() throws NegocioException {
        return BN.desbloquearAlumno();
    }

    @Override
    public List<Bloqueo> listarBloqueos() throws NegocioException {
        return BN.listarBloqueos();
    }

}
