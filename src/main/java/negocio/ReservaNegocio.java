package negocio;

import DAO.ComputadoraDAO;
import DTO.reservas.GuardarReservaDTO;
import Dominio.Reservacion;
import java.time.LocalTime;

/**
 *
 * @author luishonshon
 */
public class ReservaNegocio implements IReservaNegocio{
    private final ComputadoraDAO CD = new ComputadoraDAO();

    @Override
    public Reservacion confirmarReserva(GuardarReservaDTO revervaData) {
        Reservacion reservacion;
        //Validacion
        reservacion = CD.reservarComputadora(revervaData);
        //Validacion
        return reservacion;
    }

    @Override
    public LocalTime calcularFechaReserva(LocalTime reservaHora) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
