/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import DTO.software.FiltroSoftwareDTO;
import Dominio.Software;

/**
 *
 * @author luishonshon
 */
public interface ISoftwareNegocio {

    public Software listarSoftware(FiltroSoftwareDTO filtroListaSoftware);
}
