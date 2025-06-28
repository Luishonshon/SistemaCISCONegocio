package negocio;

import DAO.AlumnoDAO;
import DTO.alumnos.BloquearAlumnoDTO;
import Dominio.Bloqueo;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author luishonshon
 */
public class BloqueoNegocio implements IBloqueoNegocio {

    private final AlumnoDAO AD = new AlumnoDAO();

    @Override
    public Bloqueo bloquearAlumno(BloquearAlumnoDTO alumnoBloqueado) throws NegocioException {
        Bloqueo bloqueo;
        validarBloquearAlumnoDTO(alumnoBloqueado);
        bloqueo = AD.bloquearAlumno(alumnoBloqueado);
        validarBloqueo(bloqueo);
        return bloqueo;
    }

    @Override
    public Bloqueo desbloquearAlumno() throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Bloqueo> listarBloqueos() throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    //Validadores
    private void validarBloquearAlumnoDTO(BloquearAlumnoDTO datos) throws NegocioException {
        if (datos == null) {
            throw new NegocioException("Los datos no pueden ser nulos.");
        }

        if (datos.getMotivo() == null || datos.getMotivo().isBlank()) {
            throw new NegocioException("El motivo no puede ser nulo ni estar en blanco.");
        }

        if (datos.getMotivo().length() > 150) {
            throw new NegocioException("El motivo no puede tener más de 150 caracteres.");
        }

        if (datos.getFechaBloqueo() == null) {
            throw new NegocioException("La fecha de bloqueo no puede ser nula.");
        }
        if (datos.getFechaBloqueo().isAfter(LocalDate.now())) {
            throw new NegocioException("La fecha de bloqueo no puede ser en el futuro.");
        }

        if (datos.getAlumno() == null) {
            throw new NegocioException("El alumno no puede ser nulo.");
        }
    }

    private void validarBloqueo(Bloqueo bloqueo) throws NegocioException{
        if (bloqueo == null) {
            throw new IllegalArgumentException("El objeto Bloqueo no puede ser nulo");
        }
        if (bloqueo.getId() == 0 || !String.valueOf(bloqueo.getId()).matches("^[0-9]{1,19}$")) {
            throw new NegocioException("Id invalido");
        }
        String motivo = bloqueo.getMotivo();
        if (motivo == null || motivo.trim().isEmpty()) {
            throw new NegocioException("El motivo no puede ser nulo ni vacío");
        }
        if (motivo.length() > 150) {
            throw new NegocioException("El motivo no puede exceder los 150 caracteres");
        }
        LocalDate fechaBloqueo = bloqueo.getFechaBloqueo();
        if (fechaBloqueo == null) {
            throw new NegocioException("La fecha de bloqueo no puede ser nula");
        }
        if (fechaBloqueo.isAfter(LocalDate.now())) {
            throw new NegocioException("La fecha de bloqueo no puede ser despues de hoy");
        }
        if (bloqueo.getAlumno() == null) {
            throw new NegocioException("El alumno no puede ser nulo");
        }
    }
    
    private void validarListaBloqueos(List<Bloqueo> bloqueos) throws NegocioException{
        if (bloqueos == null){
            throw new NegocioException("Lista nula");
        }
        for (Bloqueo bloqueo: bloqueos){
            validarBloqueo(bloqueo);
        }
    }
}
