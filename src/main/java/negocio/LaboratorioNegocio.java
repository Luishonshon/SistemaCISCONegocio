package negocio;

import DAO.CentroDAO;
import DTO.centro.AgregarCentroDTO;
import Dominio.Centro;
import Dominio.Computadora;
import static Dominio.Computadora_.centro;
import Dominio.Plantel;
import Interfaces.ICentroDAO;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author luishonshon
 */
public class LaboratorioNegocio implements ILaboratorioNegocio {

    private final ICentroDAO CD = new CentroDAO();

    @Override
    public List<Centro> listarLaboratorios(Plantel plntl) throws NegocioException {
        List<Centro> laboratorios;
        laboratorios = CD.ListaCentroPlantel(plntl);
        validarListaLaboratorios(laboratorios);
        return laboratorios;
    }

    @Override
    public Centro agregarLaboratorio(AgregarCentroDTO nuevoCentro) throws NegocioException {
        Centro laboratorio;
        //Validaciones
        laboratorio = CD.agregarCentro(nuevoCentro);
        validarLaboratorio(laboratorio);
        return laboratorio;
    }

    /**
     * NO implementado
     * @return
     * @throws NegocioException 
     */
    @Override
    public Centro modificarLaboratorio() throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //Validadores
    private void validarLaboratorioDTO(AgregarCentroDTO nuevoCentro) throws NegocioException {
        
    }

    private void validarLaboratorio(Centro laboratorio) throws NegocioException {
        if (laboratorio == null) {
            throw new NegocioException("El objeto Centro no puede ser nulo");
        }
        Long id = laboratorio.getId();
        if (laboratorio.getId() == 0 || !String.valueOf(laboratorio.getId()).matches("^[0-9]{1,19}$")) {
            throw new NegocioException("El Id presenta un fallo");
        }
        String nombre = laboratorio.getNombre();
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new NegocioException("El nombre no puede estar vacío");
        }
        if (nombre.length() > 50) {
            throw new NegocioException("El nombre no puede exceder los 50 caracteres");
        }
        String contrasenia = laboratorio.getContrasenia();
        if (contrasenia.isEmpty()) {
            throw new NegocioException("La contraseña no puede estar vacía");
        }
        if (contrasenia.length() > 100) {
            throw new NegocioException("La contraseña no puede exceder los 100 caracteres");
        }
        LocalTime fechaInicio = laboratorio.getTiempoInicio();
        if (fechaInicio == null) {
            throw new NegocioException("La fecha de inicio no puede ser nula");
        }
        if (fechaInicio.isAfter(LocalTime.now())) {
            throw new NegocioException("La fecha de inicio no puede ser posterior a hoy");
        }
    }

    private void validarListaLaboratorios(List<Centro> laboratorios) throws NegocioException {

    }

}
