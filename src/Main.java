import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.time.*;
public class Main {
    static List<Jugador> listaJugadores = new ArrayList<>();
    static List<Arbitro> listaArbitros = new ArrayList<>();
    static List<Tecnico> listaTecnico = new ArrayList<>();
    static List<Partido> listaPartidos = new ArrayList<>();

    public static void main(String[] args) {
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);

        while (!salir) {
            System.out.println("\nPagina Pricipal\n");
            System.out.println("1. Gestion Jugadores");
            System.out.println("2. Gestion Arbitros");
            System.out.println("3. Gestion Tecnicos");
            System.out.println("4. Gestion Partidos");
            System.out.println("5. Salir");
            System.out.print("\nSeleccione una opción: ");

            int opcion;
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1 -> gestionJugador();
                    case 2 -> gestionArbitro();
                    case 3 -> gestionTecnicos();
                    case 4 -> gestionPartidos();
                    case 5 -> salir = true;
                    default -> System.out.println("Opción no válida. Intente de nuevo. \n");
                }
            }
        }
    }

    static public void gestionJugador() {
        boolean salir = false;
        while (!salir) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nGestión Jugadores\n");
            System.out.println("1. Agregar Jugador");
            System.out.println("2. Eliminar Jugador");
            System.out.println("3. Modificar Jugador");
            System.out.println("4. Mostrar Jugadores");
            System.out.println("5. Salir");
            System.out.print("\nSeleccione una opción: ");

            int opcion;
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1 -> agregarJugador();
                    case 2 -> eliminarJugador();
                    case 3 -> modificarJugador();
                    case 4 -> mostrarListaJugador();
                    case 5 -> salir = true;
                    default -> System.out.println("Opción no válida. Intente de nuevo. \n");
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
            scanner.nextLine();
            String nombre = scanner.nextLine();
            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();
            System.out.print("Sueldo: ");
            double sueldo = scanner.nextDouble();
            System.out.print("Posicion: ");
            scanner.nextLine();
            String Posicion = scanner.nextLine();
            System.out.print("Equipo: ");
            String Equipo = scanner.nextLine().toUpperCase();
            System.out.print("Minutos Jugados: ");
            int minutos = scanner.nextInt();
            scanner.nextLine();

            listaJugadores.add(new Jugador(cedula, nombre, apellido, sueldo, Posicion, Equipo, minutos));
            System.out.println("Agregado con exito");
    }

    static void eliminarJugador() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Personas disponibles para eliminar");
                    for (Jugador unJugador : listaJugadores) {
                    System.out.println(unJugador.toString());
                    }
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
        System.out.println("Personas disponibles para modificar");
        for (Jugador unJugador : listaJugadores) {
            System.out.println(unJugador.toString());
        }
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
            case 1 -> {
                System.out.println("Lista de Jugadores:");
                for (Jugador unJugador : listaJugadores) {
                    System.out.println(unJugador.toString());
                }
            }
            case 2 -> {
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
                    for (Jugador unJugador : listaJugadoresEquipo) {
                        System.out.println(unJugador.toString());
                    }
                    System.out.println();
                } else {
                    System.out.println("No hay jugadores de ese equipo. \n");
                }
            }
            default -> System.out.println("Opción no válida. Intente de nuevo. \n");
        }
    }

    static public void gestionArbitro() {
        boolean salir = false;
        while (!salir) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nGestión Arbitro\n");
            System.out.println("1. Agregar Arbitro");
            System.out.println("2. Eliminar Arbitro");
            System.out.println("3. Modificar Arbitro");
            System.out.println("4. Mostrar Arbitros");
            System.out.println("5. Salir");
            System.out.print("\nSeleccione una opción: ");

            int opcion;
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1 -> agregarArbitro();
                    case 2 -> eliminarArbitro();
                    case 3 -> modificarArbitro();
                    case 4 -> mostrarListaArbitros();
                    case 5 -> salir = true;
                    default -> System.out.println("Opción no válida. Intente de nuevo. \n");
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
        scanner.nextLine();
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        scanner.nextLine();
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
        System.out.println("Personas disponibles para eliminar");
        for (Arbitro unA : listaArbitros) {
            System.out.println(unA.toString());
        }
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
        System.out.println("Personas disponibles para modificar");
        for (Arbitro unA : listaArbitros) {
            System.out.println(unA.toString());
        }
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
        System.out.println("Lista de Arbitros:");
        for (Arbitro unArbitro : listaArbitros) {
            System.out.println(unArbitro.toString());
        }
    }

    static public void gestionTecnicos() {
        boolean salir = false;
        while (!salir) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nGestión Tecnico\n");
            System.out.println("1. Agregar Tecnico");
            System.out.println("2. Eliminar Tecnico");
            System.out.println("3. Modificar Tecnico");
            System.out.println("4. Mostrar tecnicos");
            System.out.println("5. Salir");
            System.out.print("\nSeleccione una opción: ");

            int opcion;
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1 -> agregarTecnico();
                    case 2 -> eliminarTecnico();
                    case 3 -> modificarTecnico();
                    case 4 -> mostrarListaTecnicos();
                    case 5 -> salir = true;
                    default -> System.out.println("Opción no válida. Intente de nuevo. \n");
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
        scanner.nextLine();
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        scanner.nextLine();
        String apellido = scanner.nextLine();
        System.out.print("Sueldo: ");
        double sueldo = scanner.nextDouble();
        System.out.print("Equipo: ");
        scanner.nextLine();
        String Equipo = scanner.nextLine();
        scanner.nextLine();

        listaTecnico.add(new Tecnico(cedula, nombre, apellido, sueldo, Equipo));
        System.out.println("Agregado con exito");
    }

    static void eliminarTecnico() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Personas disponibles para eliminar");
        for (Tecnico unTec : listaTecnico) {
            System.out.println(unTec.toString());
        }
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
        System.out.println("Personas disponibles para modificar");
        for (Tecnico unTec : listaTecnico) {
            System.out.println(unTec.toString());
        }
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

    static void mostrarListaTecnicos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lista de Tecnicos:");
        for (Tecnico unTec : listaTecnico) {
            System.out.println(unTec.toString());
        }
    }

    static public void gestionPartidos() {
        boolean salir = false;
        while (!salir) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nGestión Partidos\n");
            System.out.println("1. Crear partido");
            System.out.println("2. Eliminar partido");
            System.out.println("3. Modificar partidos");
            System.out.println("4. Mostrar partidos");
            System.out.println("5. Salir");
            System.out.print("\nSeleccione una opción: ");

            int opcion;
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1 -> agregarPartido();
                    case 2 -> eliminarPartido();
                    case 3 -> modificarPartido();
                    case 4 -> mostrarListaPartidos();
                    case 5 -> salir = true;
                    default -> System.out.println("Opción no válida. Intente de nuevo. \n");
                }
            } else {
                System.out.println("Entrada no válida. Intente de nuevo. \n");
                scanner.nextLine();
            }

        }
    }

    static void agregarPartido() {
        List<Jugador> jugadoresSeleccionadosEquipo1 = new ArrayList<>();
        List<Jugador> jugadoresSeleccionadosEquipo2 = new ArrayList<>();
        List<Jugador> jugadoresPosibleEquipo1 = new ArrayList<>();
        List<Jugador> jugadoresPosibleEquipo2 = new ArrayList<>();
        List<Tecnico> tecnicoPosible1 = new ArrayList<>();
        List<Tecnico> tecnicoPosible2 = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los datos del partido :");
        System.out.print("Id: ");
        int id = scanner.nextInt();
        System.out.print("Fecha: ");
        scanner.nextLine();
        String fecha = scanner.nextLine();
        System.out.print("Hora: ");
        scanner.nextLine();
        String Hora = scanner.nextLine();
        System.out.print("1er Equipo: ");
        String equipo1 = scanner.nextLine().toUpperCase();
        for (Jugador unJ: listaJugadores) {
            if (unJ.getEquipo().equals(equipo1)){
                jugadoresPosibleEquipo1.add(unJ);
            }
        }
        if (jugadoresPosibleEquipo1.size() <= 4){
            System.out.println("El equipo no tiene suficientes jugadores");
        }
        else {
            System.out.print("2do Equipo: ");
            String equipo2 = scanner.nextLine().toUpperCase();
            for (Jugador unJ: listaJugadores) {
                if (unJ.getEquipo().equals(equipo2)){
                    jugadoresPosibleEquipo2.add(unJ);
                }
            }
            if (jugadoresPosibleEquipo2.size() <= 4){
                System.out.println("El equipo no tiene suficientes jugadores");
            } else {
                    System.out.print("Ganador (Si lo hay): ");
                String ganador = scanner.nextLine();
                System.out.println("Arbitros posibles");
                for (Arbitro unA : listaArbitros) {
                    System.out.println(unA.toString());
                }
                System.out.print("Arbitro (Cedula): ");
                int arbitro = scanner.nextInt();

                System.out.println("Ingrese los titulares del primer equipo.\n");
                for (int i = 0; i < 5; i++) {
                    int contador = 1;
                    for (Jugador unJ : jugadoresPosibleEquipo1) {
                        System.out.println(contador + ". " + unJ.getNombre() + " " + unJ.getApellido());
                        contador++;
                    }
                    System.out.println("Ingrese la posicion en la lista del jugador a agregar");
                    int eleccion = scanner.nextInt() - 1 ;
                    if (eleccion > jugadoresPosibleEquipo1.size() - 1 || eleccion < jugadoresPosibleEquipo1.size() - 1) {
                        System.out.println("Ese jugador no existe");
                        i--;
                    } else {
                        jugadoresSeleccionadosEquipo1.add(jugadoresPosibleEquipo1.get(eleccion));
                        jugadoresPosibleEquipo1.remove(eleccion);
                    }
                }
                System.out.println("Los titulares del equipo " + equipo1 +  " son: ");
                int contador = 1;
                for (Jugador unJ : jugadoresSeleccionadosEquipo1) {
                    System.out.println(contador + ". " + unJ.getNombre() + " " + unJ.getApellido());
                    contador++;
                }
                if (!jugadoresPosibleEquipo1.isEmpty()){
                    System.out.println("Quiere ingresar los suplentes del equipo 1?");
                    System.out.println("1. Si");
                    System.out.println("2. No");
                    if (scanner.nextInt() == 1){
                        for (Jugador unJ: jugadoresPosibleEquipo1) {
                            System.out.println("Desea agregar el jugador " + unJ.getNombre() + " " + unJ.getApellido() + " como suplente?");
                            System.out.println("1. Si");
                            System.out.println("2. No");
                            if(scanner.nextInt() == 1) {
                                jugadoresSeleccionadosEquipo1.add(unJ);
                            }
                        }
                    }
                }
                else{
                    System.out.println("no hay jugadores suficientes para agregar de suplentes");
                }
                if (jugadoresSeleccionadosEquipo1.size() >= 6) {
                    System.out.println("Los suplentes del equipo " + equipo1 + " son: \n");
                    Jugador sup1 = jugadoresSeleccionadosEquipo1.get(5);
                    System.out.println("Suplente 1: " +sup1.getNombre() + " " + sup1.getApellido());
                    try {
                        Jugador sup2 = jugadoresSeleccionadosEquipo1.get(6);
                        System.out.println("Suplente 2: " +sup2.getNombre() + " " + sup2.getApellido());
                    }
                    catch (Exception e){}
                }
                System.out.println("Ingrese los titulares del segundo equipo.\n");
                for (int i = 0; i < 5; i++) {
                    contador = 1;
                    for (Jugador unJ : jugadoresPosibleEquipo2) {
                        System.out.println(contador + ". " + unJ.getNombre() + " " + unJ.getApellido());
                        contador++;
                    }
                    System.out.println("Ingrese la posicion en la lista del jugador a agregar");
                    int eleccion = scanner.nextInt() -1;
                    if (eleccion > jugadoresPosibleEquipo2.size() -1) {
                        System.out.println("Ese jugador no existe");
                        i--;
                    } else {jugadoresSeleccionadosEquipo2
                            .add(jugadoresPosibleEquipo2.get(eleccion));
                        jugadoresPosibleEquipo2.remove(eleccion);
                    }
                }
                System.out.println("Los titulares del equipo " + equipo2 +  " son: ");
                contador = 1;
                for (Jugador unJ : jugadoresSeleccionadosEquipo2) {
                    System.out.println(contador + ". " + unJ.getNombre() + " " + unJ.getApellido());
                    contador++;
                }
                if (!jugadoresPosibleEquipo2.isEmpty()){
                    System.out.println("Quiere ingresar los suplentes del equipo 1?");
                    System.out.println("1. Si");
                    System.out.println("2. No");
                    if (scanner.nextInt() == 1){
                        for (Jugador unJ: jugadoresPosibleEquipo2) {
                            System.out.println("Desea agregar el jugador " + unJ.getNombre() + " " + unJ.getApellido() + " como suplente?");
                            System.out.println("1. Si");
                            System.out.println("2. No");
                            if(scanner.nextInt() == 1) {
                                jugadoresSeleccionadosEquipo2.add(unJ);
                            }
                        }
                    }
                }
                else{
                    System.out.println("no hay jugadores suficientes para agregar de suplentes");
                }
                if (jugadoresSeleccionadosEquipo2.size() >= 6) {
                    System.out.println("Los suplentes del equipo " + equipo2 + " son: \n");
                    Jugador sup1 = jugadoresSeleccionadosEquipo2.get(5);
                    System.out.println("Suplente 1: " +sup1.getNombre() + " " + sup1.getApellido());
                    try {
                        Jugador sup2 = jugadoresSeleccionadosEquipo2.get(6);
                        System.out.println("Suplente 2: " +sup2.getNombre() + " " + sup2.getApellido());
                    }
                    catch (Exception e){}
                }
                for (Tecnico unT: listaTecnico) {
                    if (unT.getEquipo().equals(equipo1)){
                        tecnicoPosible1.add(unT);
                    }
                    if (unT.getEquipo().equals(equipo2)){
                        tecnicoPosible2.add(unT);
                    }
                }
                System.out.println("Los tecnicos posibles del 1er equipo son: ");
                for (int i = 1; i < tecnicoPosible1.size() + 1; i++) {
                    for (Tecnico unT : tecnicoPosible1) {
                        System.out.println(i + ". " + unT.getNombre() + " " + unT.getApellido());
                    }
                }
                boolean true1 = false;
                Tecnico tEquipo1 = null;
                while (!true1) {
                    System.out.println("Ingrese la posicion en la lista del Tecnico a agregar");
                    int eleccion = scanner.nextInt();
                    if (eleccion > tecnicoPosible1.size() || eleccion < tecnicoPosible1.size()) {
                        System.out.println("Ese tecnico no existe");
                    } else {
                        tEquipo1 = tecnicoPosible1.get(eleccion - 1);
                        true1 = true;
                    }
                }
                System.out.println("Los tecnicos posibles del 2do equipo son: ");
                for (int i = 1; i < tecnicoPosible2.size() + 1; i++) {
                    for (Tecnico unT : tecnicoPosible2) {
                        System.out.println(i + ". " + unT.getNombre() + " " + unT.getApellido());
                    }
                }
                boolean true2 = false;
                Tecnico tEquipo2 = null;
                while (!true2) {
                    System.out.println("Ingrese la posicion en la lista del Tecnico a agregar");
                    int eleccion = scanner.nextInt();
                    if (eleccion > tecnicoPosible2.size() || eleccion < tecnicoPosible2.size()) {
                        System.out.println("Ese tecnico no existe");
                    } else {
                        tEquipo2 = tecnicoPosible2.get(eleccion - 1);
                        true2 = true;
                    }
                }
                Arbitro arbitroP = null;
                for (Arbitro unB: listaArbitros) {
                    if (unB.getCedula() == arbitro){
                        arbitroP = unB;
                    }
                }
                Partido unP = new Partido(id, fecha, equipo1, equipo2, ganador, arbitroP, tEquipo1, tEquipo2, jugadoresSeleccionadosEquipo1, jugadoresSeleccionadosEquipo2, Hora);
                listaPartidos.add(unP);
                System.out.println("Partido ingresado con exito");
            }
        }
                scanner.nextLine();
        }

    static void eliminarPartido() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Partidos disponibles para eliminar");
        for (Partido unP : listaPartidos) {
            System.out.println(unP.getId() + " " + unP.getFecha());
        }
        System.out.print("Ingrese la id a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();


        Partido PId = null;
        for (Partido unPartido : listaPartidos) {
            if (unPartido.getId() == id) {
                PId = unPartido;
                break;
            }
        }

        if (PId != null) {
            listaPartidos.remove(PId);
            System.out.println("Eliminado con exito el partido: " + PId.getId());
        } else {
            System.out.println("Id no encontrado. \n");
        }
    }

    static void modificarPartido() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Partidos disponibles para modificar");
        for (Partido unP: listaPartidos) {
            System.out.println(unP.toString());
        }
        System.out.print("Ingrese la id del partido a modificar: ");
        int cedulaModificar = scanner.nextInt();
        scanner.nextLine();

        Partido PartidoMod = null;
        for (Partido unP : listaPartidos) {
            if (unP.getId() == cedulaModificar) {
                PartidoMod = unP;
                break;
            }
        }

        if (PartidoMod != null) {
            System.out.println("Datos actuales del Partido: " + PartidoMod.toString());
            System.out.println("Ingrese los nuevos datos:");
            System.out.print("Fecha: ");
            String nuevoFecha = scanner.nextLine();
            System.out.print("Hora: ");
            String nuevohora = scanner.nextLine();
            listaPartidos.remove(PartidoMod);

            PartidoMod.setFecha(nuevoFecha);
            PartidoMod.setHora(nuevohora);

            listaPartidos.add(PartidoMod);
        } else {
            System.out.println("Id no encontrado. \n");
        }
    }

    static void mostrarListaPartidos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lista Partidos:");
        for (Partido unPartido : listaPartidos) {
            System.out.println(unPartido.toString());
        }
    }
    }
