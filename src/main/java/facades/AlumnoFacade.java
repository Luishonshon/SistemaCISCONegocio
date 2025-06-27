package facades;

import DTO.alumnos.BuscarAlumnoDTO;
import DTO.alumnos.ConfirmarAlumnoDTO;
import Dominio.Alumno;
import negocio.AlumnoNegocio;
import negocio.IAlumnoNegocio;

/**
 *
 * @author luishonshon
 */
public class AlumnoFacade implements IAlumnoFacade {

    private final IAlumnoNegocio AN = new AlumnoNegocio();

    @Override
    public Alumno buscarAlumno(BuscarAlumnoDTO alumnoData) {
        return AN.buscarAlumno(alumnoData);
    }

    @Override
    public Alumno confirmarAlumno(ConfirmarAlumnoDTO alumnoData) {
        return AN.confirmarAlumno(alumnoData);
    }

}
