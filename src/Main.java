import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class Main {
    static List<Jugador> listaJugadores = new ArrayList<>();
    static List<Arbitro> listaArbitros = new ArrayList<>();
    static List<Tecnico> listaTecnico = new ArrayList<>();
    static List<Partido> listaPartidos = new ArrayList<>();

    public static void main(String[] args) {
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);

        while (!salir) {

        }
    }

    public void gestionJugador() {
        boolean salir = false;
        while (!salir) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nGestión Jugadores\n");
            System.out.println("1. Agregar Jugador");
            System.out.println("2. Eliminar Jugador");
            System.out.println("3. Modificar Jugador");
            System.out.println("4. Buscar Jugador por cedula");
            System.out.println("5. Salir");
            System.out.print("\nSeleccione una opción: ");

            int opcion;
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1:
                        agregarJugador();
                        break;
                    case 2:
                        eliminarJugador();
                        break;
                    case 3:
                        modificarJugador();
                        break;
                    case 4:
                        mostrarListaJugador();
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo. \n");
                        break;
                }
            } else {
                System.out.println("Entrada no válida. Intente de nuevo. \n");
                scanner.nextLine();
            }

        }
    }
    static void agregarJugador() {
        Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese los datos del jugador :");
            System.out.print("Cedula: ");
            int cedula = scanner.nextInt();
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();
            System.out.print("Sueldo: ");
            double sueldo = scanner.nextDouble();
            System.out.print("Posicion: ");
            String Posicion = scanner.nextLine();
            System.out.print("Equipo: ");
            String Equipo = scanner.nextLine();
            System.out.print("Minutos Jugados: ");
            int minutos = scanner.nextInt();
            scanner.nextLine();

            listaJugadores.add(new Jugador(cedula, nombre, apellido, sueldo, Posicion, Equipo, minutos));
            System.out.println("Agregado con exito");
    }

    static void eliminarJugador() {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Ingrese la cedula a eliminar: ");
                int cedula = scanner.nextInt();
                scanner.nextLine();

                Jugador Jugadorcedula = null;
                for (Jugador unJugador : listaJugadores) {
                    if (unJugador.getCedula() == cedula) {
                        Jugadorcedula = unJugador;
                        break;
                    }
                }

                if (Jugadorcedula != null) {
                    listaJugadores.remove(Jugadorcedula);
                    System.out.println("Eliminado con exito el jugador: " + Jugadorcedula.getNombre());
                } else {
                    System.out.println("Cedula no encontrado. \n");
                }
    }

    static void modificarJugador() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cedula del jugador a modificar: ");
        int cedulaModificar = scanner.nextInt();
        scanner.nextLine();

        Jugador jugadorModificar = null;
        for (Jugador unJugador : listaJugadores) {
            if (unJugador.getCedula() == cedulaModificar) {
                jugadorModificar = unJugador;
                break;
            }
        }

        if (jugadorModificar != null) {
            System.out.println("Datos actuales del jugador: " + jugadorModificar.toString());
            System.out.println("Ingrese los nuevos datos:");
            System.out.print("Nombre: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Apellido: ");
            String nuevoApellido = scanner.nextLine();
            System.out.print("Sueldo: ");
            double nuevaSueldo = scanner.nextDouble();
            System.out.print("Posicion: ");
            String nuevaPosicion = scanner.nextLine();
            System.out.print("Equipo: ");
            String nuevoEquipo = scanner.nextLine();
            System.out.print("minutos: ");
            int nuevoMinutos = scanner.nextInt();
            scanner.nextLine();
            listaJugadores.remove(jugadorModificar);

            jugadorModificar.setNombre(nuevoNombre);
            jugadorModificar.setApellido(nuevoApellido);
            jugadorModificar.setSueldo(nuevaSueldo);
            jugadorModificar.setPosicion(nuevaPosicion);
            jugadorModificar.setEquipo(nuevoEquipo);
            jugadorModificar.setMinutosJugados(nuevoMinutos);
            listaJugadores.add(jugadorModificar);

        } else {
            System.out.println("ID no encontrado. \n");
        }
    }

    static void mostrarListaJugador() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione cómo desea mostrar los jugadores:");
        System.out.println("1. Todos los jugadores");
        System.out.println("2. Jugadores por equipo");
        System.out.print("Seleccione una opción: ");

        int opcionBuscar = scanner.nextInt();
        scanner.nextLine();

        switch (opcionBuscar) {
            case 1:
                System.out.println("Lista de Jugadores:");
                for (Jugador unJugador : listaJugadores) {
                    System.out.println(unJugador.toString());
                }
            case 2:
                List<Jugador> listaJugadoresEquipo = new ArrayList<>();
                System.out.print("Ingrese el nombre del equipo: ");
                String nombre = scanner.nextLine();
                scanner.nextLine();

                for (Jugador unJugador : listaJugadores) {
                    if (unJugador.getEquipo().equals(nombre)) {
                        listaJugadoresEquipo.add(unJugador);
                    }
                }

                if (!listaJugadoresEquipo.isEmpty()) {
                    System.out.println("Jugadores del equipo: \n");
                    for (Jugador unJugador: listaJugadoresEquipo ) {
                        System.out.println(unJugador.toString());
                    }
                    System.out.println();
                } else {
                    System.out.println("No hay jugadores de ese equipo. \n");
                }
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo. \n");
                break;
        }
    }

    public void gestionArbitro() {
        boolean salir = false;
        while (!salir) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nGestión Arbitro\n");
            System.out.println("1. Agregar Arbitro");
            System.out.println("2. Eliminar Arbitro");
            System.out.println("3. Modificar Arbitro");
            System.out.println("4. Buscar Arbitro por cedula");
            System.out.println("5. Salir");
            System.out.print("\nSeleccione una opción: ");

            int opcion;
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1:
                        agregarArbitro();
                        break;
                    case 2:
                        eliminarArbitro();
                        break;
                    case 3:
                        modificarArbitro();
                        break;
                    case 4:
                        mostrarListaArbitros();
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo. \n");
                        break;
                }
            } else {
                System.out.println("Entrada no válida. Intente de nuevo. \n");
                scanner.nextLine();
            }

        }
    }

    static void agregarArbitro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los datos del Arbitro :");
        System.out.print("Cedula: ");
        int cedula = scanner.nextInt();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Sueldo: ");
        double sueldo = scanner.nextDouble();
        System.out.print("Cantidad de partidos dirigidos: ");
        int CantP = scanner.nextInt();
        System.out.print("Años trabajados: ");
        int AnosT = scanner.nextInt();
        scanner.nextLine();

        listaArbitros.add(new Arbitro(cedula, nombre, apellido, sueldo, CantP, AnosT));
        System.out.println("Agregado con exito");
    }

    static void eliminarArbitro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cedula a eliminar: ");
        int cedula = scanner.nextInt();
        scanner.nextLine();

        Arbitro ArbitroCedula = null;
        for (Arbitro unArbitro : listaArbitros) {
            if (unArbitro.getCedula() == cedula) {
                ArbitroCedula = unArbitro;
                break;
            }
        }

        if (ArbitroCedula != null) {
            listaArbitros.remove(ArbitroCedula);
            System.out.println("Eliminado con exito el Arbitro: " + ArbitroCedula.getNombre());
        } else {
            System.out.println("Cedula no encontrado. \n");
        }
    }

    static void modificarArbitro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cedula del arbitro a modificar: ");
        int cedulaModificar = scanner.nextInt();
        scanner.nextLine();

        Arbitro arbitroMod = null;
        for (Arbitro unArbitro : listaArbitros) {
            if (unArbitro.getCedula() == cedulaModificar) {
                arbitroMod = unArbitro;
                break;
            }
        }

        if (arbitroMod != null) {
            System.out.println("Datos actuales del jugador: " + arbitroMod.toString());
            System.out.println("Ingrese los nuevos datos:");
            System.out.print("Nombre: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Apellido: ");
            String nuevoApellido = scanner.nextLine();
            System.out.print("Sueldo: ");
            double nuevaSueldo = scanner.nextDouble();
            System.out.print("Cantidad de partidos dirigidos: ");
            int nuevaCant = scanner.nextInt();
            System.out.print("Años trabajados: ");
            int nuevoAnos = scanner.nextInt();
            scanner.nextLine();
            listaArbitros.remove(arbitroMod);

            arbitroMod.setNombre(nuevoNombre);
            arbitroMod.setApellido(nuevoApellido);
            arbitroMod.setSueldo(nuevaSueldo);
            arbitroMod.setCantDePartidosDirigidos(nuevaCant);
            arbitroMod.setAnostrabajados(nuevoAnos);
            listaArbitros.add(arbitroMod);

        } else {
            System.out.println("Cedula no encontrado. \n");
        }
    }

    static void mostrarListaArbitros() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lista de Jugadores:");
        for (Arbitro unArbitro : listaArbitros) {
            System.out.println(unArbitro.toString());
        }
    }

    public void gestionTecnicos() {
        boolean salir = false;
        while (!salir) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nGestión Tecnico\n");
            System.out.println("1. Agregar Tecnico");
            System.out.println("2. Eliminar Tecnico");
            System.out.println("3. Modificar Tecnico");
            System.out.println("4. Buscar Tecnico por cedula");
            System.out.println("5. Salir");
            System.out.print("\nSeleccione una opción: ");

            int opcion;
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1:
                        agregarTecnico();
                        break;
                    case 2:
                        eliminarTecnico();
                        break;
                    case 3:
                        modificarTecnico();
                        break;
                    case 4:
                        mostrarListaTecnicos();
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo. \n");
                        break;
                }
            } else {
                System.out.println("Entrada no válida. Intente de nuevo. \n");
                scanner.nextLine();
            }

        }
    }

    static void agregarTecnico() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los datos del jugador :");
        System.out.print("Cedula: ");
        int cedula = scanner.nextInt();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Sueldo: ");
        double sueldo = scanner.nextDouble();
        System.out.print("Equipo: ");
        String Equipo = scanner.nextLine();
        scanner.nextLine();

        listaTecnico.add(new Tecnico(cedula, nombre, apellido, sueldo, Equipo));
        System.out.println("Agregado con exito");
    }

    static void eliminarTecnico() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cedula a eliminar: ");
        int cedula = scanner.nextInt();
        scanner.nextLine();

        Tecnico TecnicoCedula = null;
        for (Tecnico unTecnico : listaTecnico) {
            if (unTecnico.getCedula() == cedula) {
                TecnicoCedula = unTecnico;
                break;
            }
        }

        if (TecnicoCedula != null) {
            listaTecnico.remove(TecnicoCedula);
            System.out.println("Eliminado con exito el Tecnico: " + TecnicoCedula.getNombre());
        } else {
            System.out.println("Cedula no encontrado. \n");
        }
    }

    static void modificarTecnico() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cedula del tecnico a modificar: ");
        int cedulaModificar = scanner.nextInt();
        scanner.nextLine();

        Tecnico TecnicoMod = null;
        for (Tecnico unTec : listaTecnico) {
            if (unTec.getCedula() == cedulaModificar) {
                TecnicoMod = unTec;
                break;
            }
        }

        if (TecnicoMod != null) {
            System.out.println("Datos actuales del Tecnico: " + TecnicoMod.toString());
            System.out.println("Ingrese los nuevos datos:");
            System.out.print("Nombre: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Apellido: ");
            String nuevoApellido = scanner.nextLine();
            System.out.print("Sueldo: ");
            double nuevaSueldo = scanner.nextDouble();
            System.out.print("Equipo: ");
            String nuevoEquipo = scanner.nextLine();
            scanner.nextLine();
            listaTecnico.remove(TecnicoMod);

            TecnicoMod.setNombre(nuevoNombre);
            TecnicoMod.setApellido(nuevoApellido);
            TecnicoMod.setSueldo(nuevaSueldo);
            TecnicoMod.setEquipo(nuevoEquipo);
            listaTecnico.add(TecnicoMod);

        } else {
            System.out.println("Cedula no encontrado. \n");
        }
    }
}