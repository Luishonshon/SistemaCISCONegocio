/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import DTO.alumnos.BloquearAlumnoDTO;
import Dominio.Alumno;
import Dominio.Bloqueo;
import java.util.List;

/**
 *
 * @author luishonshon
 */
public interface IBloqueoNegocio {

    public Bloqueo bloquearAlumno(BloquearAlumnoDTO alumnoBloqueado) throws NegocioException;

    public Bloqueo desbloquearAlumno(Alumno alumno) throws NegocioException;

    public List<Bloqueo> listarBloqueos() throws NegocioException;
}
