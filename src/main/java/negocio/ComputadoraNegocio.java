package negocio;

import DAO.CentroDAO;
import DAO.ComputadoraDAO;
import DTO.computadoras.ActualizarEstadoComputadoraDTO;
import DTO.computadoras.AgregarComputadoraDTO;
import DTO.computadoras.FiltroComputadoraDTO;
import DTO.software.AgregarSoftwareDTO;
import Dominio.Computadora;
import Interfaces.ICentroDAO;
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
    private final ICentroDAO LD = new CentroDAO();

    @Override
    public Computadora agregarComputadora(AgregarComputadoraDTO computadoraData, Long idSoftware) throws NegocioException {
        Computadora computadora;
        //Validaciones
        computadora = CD.agregarComputadora(computadoraData);
        //Validaciones
        return computadora;
    }

    @Override
    public List<Computadora> listarComputadorasPorCentro(FiltroComputadoraDTO filtro) {
        List<Computadora> computadoras;
        //Validaciones
        computadoras = LD.computadorasCentro(LD.BuscarCentroID(filtro.getIdCentro()));
        //Validaciones
        return computadoras;
    }

    @Override
    public Computadora apartarComputadora(ActualizarEstadoComputadoraDTO alumnoData) {
        Computadora computadora;
        alumnoData.setEstadoNuevo("ocupada");
        //Validaciones
        computadora = CD.actualizarEstado(alumnoData);
        //Validaciones
        return computadora;
    }

    @Override
    public void liberarComputadora(ActualizarEstadoComputadoraDTO alumnoData) {
        alumnoData.setEstadoNuevo("disponible");
        //Validaciones
        CD.actualizarEstado(alumnoData);
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
