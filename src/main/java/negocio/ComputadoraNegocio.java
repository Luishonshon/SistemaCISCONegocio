package negocio;

import DAO.ComputadoraDAO;
import DTO.computadoras.ActualizarEstadoComputadoraDTO;
import DTO.computadoras.FiltroComputadoraDTO;
import Dominio.Computadora;
import Interfaces.IComputadoraDAO;
import java.net.InetAddress;
import java.util.List;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 *
 * @author luishonshon
 */
public class ComputadoraNegocio implements IComputadoraNegocio {

    private final IComputadoraDAO CD = new ComputadoraDAO();

    @Override
    public List<Computadora> listarComputadorasPorCentro(FiltroComputadoraDTO filtro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Computadora desbloquearComputadora(ActualizarEstadoComputadoraDTO alumnoData) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void liberarComputadora(ActualizarEstadoComputadoraDTO alumnoData) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Computadora correrProgramaValidacion() throws NegocioException {
        Computadora computadora = buscarComputadoraPorIp();
        if (computadora == null) {
            throw new NegocioException("Computadora no válida");
        }
        return computadora;
    }

    private Computadora buscarComputadoraPorIp() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                if (!networkInterface.isUp() || networkInterface.isLoopback()) {
                    continue;
                }
                Enumeration<InetAddress> direcciones = networkInterface.getInetAddresses();
                while (direcciones.hasMoreElements()) {
                    InetAddress direccion = direcciones.nextElement();
                    Computadora computadora = CD.buscarComputadoraIp(direccion.getHostAddress());
                    if (computadora != null) {
                        return computadora;
                    }
                }
            }

        } catch (SocketException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private void validarAtributosComputadora(Computadora computadora) throws NegocioException {
        if (computadora.getId() == 0 || !String.valueOf(computadora.getId()).matches("^[0-9]{1,19}$")) {
            throw new NegocioException("El id de la computadora es inválido.");
        }

        if (Integer.valueOf(computadora.getNumero()) == null || !String.valueOf(computadora.getNumero()).matches("^[0-9]{1,10}$")) {
            throw new NegocioException("El número de la computadora es inválido.");
        }

        String ip = computadora.getIp();
        if (ip == null || (!ip.matches("^[0-9a-fA-F:.]{13}$") && !ip.matches("^[0-9a-fA-F:.]{39}$"))) {
            throw new NegocioException("La IP es inválida.");
        }
    }
}
