package facades;

import DTO.alumnos.BloquearAlumnoDTO;
import Dominio.Bloqueo;
import java.util.List;
import negocio.NegocioException;

/**
 *
 * @author luishonshon
 */
public interface IBloqueoFacade {
    public Bloqueo bloquearAlumno(BloquearAlumnoDTO alumnoBloqueado)throws NegocioException;
    public Bloqueo desbloquearAlumno()throws NegocioException;
    public List<Bloqueo> listarBloqueos() throws NegocioException;
}
