package negocio;

import DTO.alumnos.BuscarAlumnoDTO;
import DTO.alumnos.ConfirmarAlumnoDTO;
import Dominio.Alumno;

/**
 *
 * @author luishonshon
 */
public interface IAlumnoNegocio {
        public Alumno buscarAlumno(BuscarAlumnoDTO alumnoData);

    public Alumno confirmarAlumno(ConfirmarAlumnoDTO alumnoData);
}
