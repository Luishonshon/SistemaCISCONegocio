package facades;

import DTO.reservas.GuardarReservaDTO;
import Dominio.Computadora;
import java.time.LocalTime;

/**
 *
 * @author luishonshon
 */
public interface IReservaFacade {

    public Computadora confirmarReserva(GuardarReservaDTO revervaData);

    public LocalTime calcularFechaReserva(LocalTime reservaHora);

}
