package facades;

import DTO.software.FiltroSoftwareDTO;
import Dominio.Software;

/**
 *
 * @author luishonshon
 */
public interface ISoftwareFacade {
    public Software listarSoftware(FiltroSoftwareDTO filtroListaSoftware);
}
