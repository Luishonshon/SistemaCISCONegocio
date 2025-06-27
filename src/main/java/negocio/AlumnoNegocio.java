package negocio;

import DTO.alumnos.BuscarAlumnoDTO;
import DTO.alumnos.ConfirmarAlumnoDTO;
import Dominio.Alumno;
import DAO.AlumnoDAO;
import Interfaces.IAlumnoDAO;
import encriptacion.Encriptador;

/**
 *
 * @author luishonshon
 */
public class AlumnoNegocio implements IAlumnoNegocio{
    
    private final IAlumnoDAO AD = new AlumnoDAO();
    
    @Override
    public Alumno buscarAlumno(BuscarAlumnoDTO alumnoData) {
        //validaciones
        Alumno alumno = AD.Buscar(alumnoData);
        //validaciones
        return alumno;
    }

    @Override
    public Alumno confirmarAlumno(ConfirmarAlumnoDTO alumnoData) {
        //validaciones
        Alumno alumno = AD.iniciarSesion(alumnoData);
        //validaciones
        
        //Se hashea el String mandado y se compara con la contraseña en la base de datos
        Encriptador.verificarContraseña(alumnoData.getContraseña(), alumno.getContraseña()); 
        return alumno;
    }
    
}
