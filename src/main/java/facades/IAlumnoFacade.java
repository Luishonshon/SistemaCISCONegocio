package facades;

import DTO.alumnos.*;
import Dominio.Alumno;

/**
 *
 * @author luishonshon
 */
public interface IAlumnoFacade {

    public Alumno buscarAlumno(BuscarAlumnoDTO alumnoData);

    public Alumno confirmarAlumno(ConfirmarAlumnoDTO alumnoData);

}
