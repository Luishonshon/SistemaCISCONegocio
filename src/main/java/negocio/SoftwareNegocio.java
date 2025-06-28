/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DTO.software.FiltroSoftwareDTO;
import Dominio.Software;
import DAO.ComputadoraDAO;
import Interfaces.IComputadoraDAO;

/**
 *
 * @author luishonshon
 */
public class SoftwareNegocio implements ISoftwareNegocio{
    private final IComputadoraDAO CD = new ComputadoraDAO();
    @Override
    public Software listarSoftware(FiltroSoftwareDTO filtroListaSoftware) {
        return new Software();
    }
    
}
