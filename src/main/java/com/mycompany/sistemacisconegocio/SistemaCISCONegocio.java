package com.mycompany.sistemacisconegocio;

import DAO.AlumnoDAO;
import DAO.CentroDAO;
import DAO.ComputadoraDAO;
import DTO.alumnos.AgregarAlumnoDTO;
import DTO.alumnos.AgregarCarreraDTO;
import DTO.alumnos.BloquearAlumnoDTO;
import DTO.centro.AgregarCentroDTO;
import DTO.centro.AgregarReglaDTO;
import DTO.computadoras.AgregarComputadoraDTO;
import DTO.plantel.AgregarPlantelDTO;
import DTO.software.AgregarSoftwareDTO;
import DTO.software.InstalarSoftwareDTO;
import Dominio.Alumno;
import Dominio.Bloqueo;
import Dominio.Carrera;
import Dominio.Centro;
import Dominio.Computadora;
import Dominio.Instalacion;
import Dominio.Plantel;
import Dominio.Regla;
import Dominio.Software;
import Interfaces.IAlumnoDAO;
import Interfaces.ICentroDAO;
import Interfaces.IComputadoraDAO;
import encriptacion.Encriptador;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author luishonshon
 */
public class SistemaCISCONegocio {

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream salida = new PrintStream("salida.txt");
        PrintStream errores = new PrintStream("errores.txt");

        System.setOut(salida);
        System.setErr(errores);

        // Código normal
        System.out.println("Ejecutando código...");
        System.err.println("Mensaje de error simulado");
        IAlumnoDAO alumnoDAO = new AlumnoDAO();
        ICentroDAO centroDAO = new CentroDAO();
        IComputadoraDAO computadoraDAO = new ComputadoraDAO();

        Regla regla1 = centroDAO.agregarRegla(new AgregarReglaDTO("No comer ni beber cerca de los equipos."));
        Regla regla2 = centroDAO.agregarRegla(new AgregarReglaDTO("No desconectar cables o periféricos sin autorización."));
        Regla regla3 = centroDAO.agregarRegla(new AgregarReglaDTO("No instalar programas sin permiso."));
        Regla regla4 = centroDAO.agregarRegla(new AgregarReglaDTO("No ingresar con mochilas sobre las mesas o cerca de los equipos."));
        Regla regla5 = centroDAO.agregarRegla(new AgregarReglaDTO("No cambiar la configuración del sistema operativo."));
        Regla regla6 = centroDAO.agregarRegla(new AgregarReglaDTO("No utilizar dispositivos USB personales sin autorización."));
        Regla regla7 = centroDAO.agregarRegla(new AgregarReglaDTO("No acceder a sitios inapropiados o no educativos."));
        Regla regla8 = centroDAO.agregarRegla(new AgregarReglaDTO("No jugar videojuegos si no es parte de la clase."));
        Regla regla9 = centroDAO.agregarRegla(new AgregarReglaDTO("No manipular el hardware sin autorización."));
        Regla regla10 = centroDAO.agregarRegla(new AgregarReglaDTO("No hablar en voz alta ni molestar a los demás."));

        Software software1 = computadoraDAO.agregarSoftware(new AgregarSoftwareDTO("Microsoft Word"));
        Software software2 = computadoraDAO.agregarSoftware(new AgregarSoftwareDTO("Microsoft Excel"));
        Software software3 = computadoraDAO.agregarSoftware(new AgregarSoftwareDTO("Adobe Photoshop"));
        Software software4 = computadoraDAO.agregarSoftware(new AgregarSoftwareDTO("Visual Studio Code"));
        Software software5 = computadoraDAO.agregarSoftware(new AgregarSoftwareDTO("Google Chrome"));
        Software software6 = computadoraDAO.agregarSoftware(new AgregarSoftwareDTO("Adobe Premiere Pro"));
        Software software7 = computadoraDAO.agregarSoftware(new AgregarSoftwareDTO("Avast Antivirus"));
        Software software8 = computadoraDAO.agregarSoftware(new AgregarSoftwareDTO("Zoom"));
        Software software9 = computadoraDAO.agregarSoftware(new AgregarSoftwareDTO("WinRAR"));
        Software software10 = computadoraDAO.agregarSoftware(new AgregarSoftwareDTO("Anki"));
        Software software11 = computadoraDAO.agregarSoftware(new AgregarSoftwareDTO("AutoCAD"));
        Software software12 = computadoraDAO.agregarSoftware(new AgregarSoftwareDTO("Python (Anaconda)"));
        Software software13 = computadoraDAO.agregarSoftware(new AgregarSoftwareDTO("Spotify"));
        Software software14 = computadoraDAO.agregarSoftware(new AgregarSoftwareDTO("GIMP"));
        Software software15 = computadoraDAO.agregarSoftware(new AgregarSoftwareDTO("LibreOffice"));

        Carrera carrera1 = alumnoDAO.agregarCarrera(
                new AgregarCarreraDTO(
                        "Ingeniería en Software	",
                        300,
                        "5538219476"
                ));
        Alumno alumno = alumnoDAO.agregarAlumno(
                new AgregarAlumnoDTO(
                        "Valeria",
                        "Sánchez",
                        "Ramírez",
                        Encriptador.hashContraseña("contraseña"),
                        true,
                        carrera1)
        );
        Alumno alumno2 = alumnoDAO.agregarAlumno(
                new AgregarAlumnoDTO(
                        "Carlos",
                        "Hernández",
                        "López",
                        Encriptador.hashContraseña("contraseña"),
                        false,
                        carrera1)
        );

        Alumno alumno3 = alumnoDAO.agregarAlumno(
                new AgregarAlumnoDTO(
                        "María",
                        "Gómez",
                        "Castillo",
                        Encriptador.hashContraseña("contraseña"),
                        true,
                        carrera1)
        );

        Alumno alumno4 = alumnoDAO.agregarAlumno(
                new AgregarAlumnoDTO(
                        "Luis",
                        "Martínez",
                        "Fernández",
                        Encriptador.hashContraseña("contraseña"),
                        true,
                        carrera1)
        );

        Alumno alumno5 = alumnoDAO.agregarAlumno(
                new AgregarAlumnoDTO(
                        "Andrea",
                        "Morales",
                        "Jiménez",
                        Encriptador.hashContraseña("contraseña"),
                        false,
                        carrera1)
        );
        Carrera carrera2 = alumnoDAO.agregarCarrera(
                new AgregarCarreraDTO(
                        "Licenciatura en Psicología",
                        200,
                        "5543217890"
                )
        );
        Alumno alumno6 = alumnoDAO.agregarAlumno(
                new AgregarAlumnoDTO(
                        "Fernanda",
                        "López",
                        "Cruz",
                        Encriptador.hashContraseña("contraseña"),
                        true,
                        carrera2)
        );

        Alumno alumno7 = alumnoDAO.agregarAlumno(
                new AgregarAlumnoDTO(
                        "Javier",
                        "Ramírez",
                        "Torres",
                        Encriptador.hashContraseña("contraseña"),
                        false,
                        carrera2)
        );

        Alumno alumno8 = alumnoDAO.agregarAlumno(
                new AgregarAlumnoDTO(
                        "Daniela",
                        "Mendoza",
                        "Flores",
                        Encriptador.hashContraseña("contraseña"),
                        true,
                        carrera2)
        );

        Alumno alumno9 = alumnoDAO.agregarAlumno(
                new AgregarAlumnoDTO(
                        "Emilio",
                        "García",
                        "Morales",
                        Encriptador.hashContraseña("contraseña"),
                        false,
                        carrera2)
        );

        Alumno alumno10 = alumnoDAO.agregarAlumno(
                new AgregarAlumnoDTO(
                        "Paola",
                        "Ríos",
                        "Delgado",
                        Encriptador.hashContraseña("contraseña"),
                        true,
                        carrera2)
        );

        Carrera carrera3 = alumnoDAO.agregarCarrera(
                new AgregarCarreraDTO(
                        "Ingeniería Mecatrónica",
                        270,
                        "5578901234"
                )
        );

        Alumno alumno11 = alumnoDAO.agregarAlumno(
                new AgregarAlumnoDTO(
                        "Sofía",
                        "Navarro",
                        "Pérez",
                        Encriptador.hashContraseña("contraseña"),
                        false,
                        carrera3)
        );

        Alumno alumno12 = alumnoDAO.agregarAlumno(
                new AgregarAlumnoDTO(
                        "Diego",
                        "Ortega",
                        "Reyes",
                        Encriptador.hashContraseña("contraseña"),
                        true,
                        carrera3)
        );

        Alumno alumno13 = alumnoDAO.agregarAlumno(
                new AgregarAlumnoDTO(
                        "Camila",
                        "Silva",
                        "Acosta",
                        Encriptador.hashContraseña("contraseña"),
                        true,
                        carrera3)
        );

        Alumno alumno14 = alumnoDAO.agregarAlumno(
                new AgregarAlumnoDTO(
                        "Leonardo",
                        "Vargas",
                        "Castañeda",
                        Encriptador.hashContraseña("contraseña"),
                        false,
                        carrera3)
        );

        Alumno alumno15 = alumnoDAO.agregarAlumno(
                new AgregarAlumnoDTO(
                        "Valentina",
                        "Ibarra",
                        "Nieto",
                        Encriptador.hashContraseña("contraseña"),
                        true,
                        carrera3)
        );

        Carrera carrera4 = alumnoDAO.agregarCarrera(
                new AgregarCarreraDTO(
                        "Licenciatura en Diseño grafico",
                        270,
                        "5578901234"
                )
        );

        Alumno alumno16 = alumnoDAO.agregarAlumno(
                new AgregarAlumnoDTO(
                        "Tomás",
                        "Luna",
                        "Esquivel",
                        Encriptador.hashContraseña("contraseña"),
                        true,
                        carrera4)
        );

        Alumno alumno17 = alumnoDAO.agregarAlumno(
                new AgregarAlumnoDTO(
                        "Renata",
                        "Carrillo",
                        "Santos",
                        Encriptador.hashContraseña("contraseña"),
                        false,
                        carrera4)
        );

        Alumno alumno18 = alumnoDAO.agregarAlumno(
                new AgregarAlumnoDTO(
                        "Alejandro",
                        "Peña",
                        "Gallardo",
                        Encriptador.hashContraseña("contraseña"),
                        true,
                        carrera4)
        );

        Alumno alumno19 = alumnoDAO.agregarAlumno(
                new AgregarAlumnoDTO(
                        "Lucía",
                        "Salas",
                        "Camacho",
                        Encriptador.hashContraseña("contraseña"),
                        false,
                        carrera4)
        );

        Alumno alumno20 = alumnoDAO.agregarAlumno(
                new AgregarAlumnoDTO(
                        "Angela",
                        "Lobos",
                        "Lopez",
                        Encriptador.hashContraseña("contraseña"),
                        true,
                        carrera4)
        );

        Carrera carrera5 = alumnoDAO.agregarCarrera(
                new AgregarCarreraDTO(
                        "Licenciatura en Derecho",
                        150,
                        "5589012345"
                )
        );

        Alumno alumno21 = alumnoDAO.agregarAlumno(
                new AgregarAlumnoDTO(
                        "Abril",
                        "Del Valle",
                        "Linares",
                        Encriptador.hashContraseña("contraseña"),
                        true,
                        carrera5)
        );

        Alumno alumno22 = alumnoDAO.agregarAlumno(
                new AgregarAlumnoDTO(
                        "Gael",
                        "Palacios",
                        "Rentería",
                        Encriptador.hashContraseña("contraseña"),
                        false,
                        carrera5)
        );

        Alumno alumno23 = alumnoDAO.agregarAlumno(
                new AgregarAlumnoDTO(
                        "Ximena",
                        "Vega",
                        "Montes",
                        Encriptador.hashContraseña("contraseña"),
                        true,
                        carrera5)
        );

        Alumno alumno24 = alumnoDAO.agregarAlumno(
                new AgregarAlumnoDTO(
                        "Sebastián",
                        "Calderón",
                        "Rosales",
                        Encriptador.hashContraseña("contraseña"),
                        false,
                        carrera5)
        );

        Alumno alumno25 = alumnoDAO.agregarAlumno(
                new AgregarAlumnoDTO(
                        "Mariana",
                        "Estrada",
                        "Figueroa",
                        Encriptador.hashContraseña("contraseña"),
                        true,
                        carrera5)
        );

        Plantel plantel = centroDAO.agregarPlantel(
                new AgregarPlantelDTO("Itson")
        );

        Centro centro = centroDAO.agregarCentro(
                new AgregarCentroDTO(
                        "laboratorio especial",
                        Encriptador.hashContraseña("segurdad25"),
                        plantel,
                        LocalTime.of(8, 0),
                        LocalTime.of(20, 0)
                ));

        Centro centro2 = centroDAO.agregarCentro(
                new AgregarCentroDTO(
                        "laboratorio general",
                        Encriptador.hashContraseña("segurdad24"),
                        plantel,
                        LocalTime.of(6, 0),
                        LocalTime.of(21, 0)
                ));

        Plantel plantel2 = centroDAO.agregarPlantel(
                new AgregarPlantelDTO("ITESCA")
        );

        Centro centro3 = centroDAO.agregarCentro(
                new AgregarCentroDTO(
                        "laboratorio enrique",
                        Encriptador.hashContraseña("segurdad22"),
                        plantel2,
                        LocalTime.of(8, 0),
                        LocalTime.of(21, 0)
                ));

        Centro centro4 = centroDAO.agregarCentro(
                new AgregarCentroDTO(
                        "laboratorio luis",
                        Encriptador.hashContraseña("segurdad21"),
                        plantel2,
                        LocalTime.of(8, 0),
                        LocalTime.of(21, 0)
                ));

        Plantel plantel3 = centroDAO.agregarPlantel(
                new AgregarPlantelDTO("UNISON")
        );

        Centro centro5 = centroDAO.agregarCentro(
                new AgregarCentroDTO(
                        "laboratorio especial juan",
                        Encriptador.hashContraseña("123contra"),
                        plantel3,
                        LocalTime.of(8, 0),
                        LocalTime.of(21, 0)
                ));

        Computadora computadora1 = computadoraDAO.agregarComputadora(
                new AgregarComputadoraDTO(1, "192.168.0.101", true, centro)
        );

        Computadora computadora2 = computadoraDAO.agregarComputadora(
                new AgregarComputadoraDTO(2, "192.168.0.102", true, centro)
        );

        Computadora computadora3 = computadoraDAO.agregarComputadora(
                new AgregarComputadoraDTO(1, "192.168.0.103", true, centro2)
        );

        Computadora computadora4 = computadoraDAO.agregarComputadora(
                new AgregarComputadoraDTO(2, "192.168.0.104", true, centro2)
        );

        Computadora computadora5 = computadoraDAO.agregarComputadora(
                new AgregarComputadoraDTO(1, "192.168.0.105", true, centro3)
        );

        Computadora computadora6 = computadoraDAO.agregarComputadora(
                new AgregarComputadoraDTO(2, "192.168.0.106", true, centro3)
        );

        Computadora computadora7 = computadoraDAO.agregarComputadora(
                new AgregarComputadoraDTO(1, "192.168.0.107", true, centro4)
        );

        Computadora computadora8 = computadoraDAO.agregarComputadora(
                new AgregarComputadoraDTO(2, "192.168.0.108", true, centro4)
        );

        Computadora computadora9 = computadoraDAO.agregarComputadora(
                new AgregarComputadoraDTO(1, "192.168.0.109", true, centro5)
        );

        Computadora computadora10 = computadoraDAO.agregarComputadora(
                new AgregarComputadoraDTO(2, "192.168.0.110", true, centro5)
        );

        Instalacion instalacion1_1 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("1.0", computadora1, software1)
        );
        Instalacion instalacion1_2 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("2.1", computadora1, software5)
        );
        Instalacion instalacion1_3 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("3.0", computadora1, software9)
        );

        Instalacion instalacion2_1 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("2.3", computadora2, software2)
        );
        Instalacion instalacion2_2 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("1.4", computadora2, software6)
        );
        Instalacion instalacion2_3 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("3.5", computadora2, software10)
        );

        Instalacion instalacion3_1 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("1.5", computadora3, software3)
        );
        Instalacion instalacion3_2 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("2.0", computadora3, software7)
        );
        Instalacion instalacion3_3 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("3.2", computadora3, software11)
        );

        Instalacion instalacion4_1 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("2.2", computadora4, software4)
        );
        Instalacion instalacion4_2 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("1.1", computadora4, software8)
        );
        Instalacion instalacion4_3 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("3.3", computadora4, software12)
        );

        Instalacion instalacion5_1 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("1.8", computadora5, software5)
        );
        Instalacion instalacion5_2 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("2.4", computadora5, software9)
        );
        Instalacion instalacion5_3 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("3.6", computadora5, software13)
        );

        Instalacion instalacion6_1 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("1.3", computadora6, software6)
        );
        Instalacion instalacion6_2 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("2.5", computadora6, software10)
        );
        Instalacion instalacion6_3 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("3.7", computadora6, software14)
        );

        Instalacion instalacion7_1 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("1.7", computadora7, software7)
        );
        Instalacion instalacion7_2 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("2.6", computadora7, software11)
        );
        Instalacion instalacion7_3 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("3.8", computadora7, software15)
        );

        Instalacion instalacion8_1 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("1.9", computadora8, software8)
        );
        Instalacion instalacion8_2 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("2.7", computadora8, software12)
        );
        Instalacion instalacion8_3 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("3.9", computadora8, software1)
        );

        Instalacion instalacion9_1 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("2.0", computadora9, software9)
        );
        Instalacion instalacion9_2 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("1.2", computadora9, software13)
        );
        Instalacion instalacion9_3 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("3.4", computadora9, software2)
        );

        Instalacion instalacion10_1 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("2.8", computadora10, software10)
        );
        Instalacion instalacion10_2 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("1.6", computadora10, software14)
        );
        Instalacion instalacion10_3 = computadoraDAO.InstalarSoftware(
                new InstalarSoftwareDTO("3.1", computadora10, software3)
        );

        Bloqueo bloqueonuevo
                = alumnoDAO.bloquearAlumno(
                        new BloquearAlumnoDTO("por pendejo",
                                LocalDate.now(),
                                alumno)
                );

        Bloqueo bloqueonuevo2
                = alumnoDAO.bloquearAlumno(
                        new BloquearAlumnoDTO("por hackear al luis",
                                LocalDate.now(),
                                alumno3)
                );

        Carrera carreraSeleccionada = alumnoDAO.buscarCarreraID(2l);
        System.out.println(carreraSeleccionada.getNombre());

        List<Carrera> carreras = alumnoDAO.ListaCarreras();
        // Imprimir nombres de carreras
        System.out.println("=== Listado de Carreras ===");
        for (Carrera carrera : carreras) {
            System.out.println(carrera.getNombre()); // Asume que la entidad Carrera tiene un campo 'nombre'
        }
    }
}
