/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import DTO.centro.AgregarCentroDTO;
import Dominio.Centro;
import java.util.List;

/**
 *
 * @author luishonshon
 */
public interface ILaboratorioNegocio {

    public List<Centro> listarLaboratorios() throws NegocioException;

    public Centro agregarLaboratorio(AgregarCentroDTO nuevoCentro) throws NegocioException;

    public Centro modificarLaboratorio() throws NegocioException;
}
