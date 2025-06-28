package negocio;

import DTO.reservas.GuardarReservaDTO;
import Dominio.Computadora;
import Dominio.Reservacion;
import java.time.LocalTime;

/**
 *
 * @author luishonshon
 */
public interface IReservaNegocio {

    public Reservacion confirmarReserva(GuardarReservaDTO revervaData);

    public LocalTime calcularFechaReserva(LocalTime reservaHora);
}
