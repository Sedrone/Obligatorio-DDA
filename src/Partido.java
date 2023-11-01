import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Partido {
    private int Id;

    private LocalDateTime fecha;

    private String equipo1;

    private String equipo2;

    private String ganador;

    private Arbitro arbitro;

    private List<Jugador> listaJugadoresEquipo1;

    private List<Jugador> listaJugadoresEquipo2;

    private Tecnico TecEquipo1;
    private Tecnico TecEquipo2;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    public Arbitro getArbitro() {
        return arbitro;
    }

    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    public List<Jugador> getListaJugadoresEquipo1() {
        return listaJugadoresEquipo1;
    }

    public void setListaJugadoresEquipo1(List<Jugador> listaJugadoresEquipo1) {
        this.listaJugadoresEquipo1 = listaJugadoresEquipo1;
    }

    public List<Jugador> getListaJugadoresEquipo2() {
        return listaJugadoresEquipo2;
    }

    public void setListaJugadoresEquipo2(List<Jugador> listaJugadoresEquipo2) {
        this.listaJugadoresEquipo2 = listaJugadoresEquipo2;
    }

    public Tecnico getTecEquipo1() {
        return TecEquipo1;
    }

    public void setTecEquipo1(Tecnico tecEquipo1) {
        TecEquipo1 = tecEquipo1;
    }

    public Tecnico getTecEquipo2() {
        return TecEquipo2;
    }

    public void setTecEquipo2(Tecnico tecEquipo2) {
        TecEquipo2 = tecEquipo2;
    }

    @Override
    public String toString() {
        return "Partido: " + '\'' +
                "Id: " + Id + '\'' +
                ", Fecha: " + fecha.format(DateTimeFormatter.ISO_LOCAL_DATE) + '\'' +
                ", Equipo 1: " + equipo1 + '\'' +
                ", Equipo 2: " + equipo2 + '\'' +
                ", Ganador: " + ganador + '\'' +
                ", Arbitro: " + arbitro.toString() + '\'' +
                ", Tecnico del equipo 1: " + TecEquipo1.toString() + '\'' +
                ", Tecnico del equipo 2: " + TecEquipo2.toString();
    }

    public Partido(int id, LocalDateTime fecha, String equipo1, String equipo2, String ganador, Arbitro arbitro, Tecnico tecEquipo1, Tecnico tecEquipo2, List<Jugador> listaJugadoresEquipo1, List<Jugador> listaJugadoresEquipo2) {
        Id = id;
        this.fecha = fecha;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.ganador = ganador;
        this.arbitro = arbitro;
        this.TecEquipo1 = tecEquipo1;
        this.TecEquipo2 = tecEquipo2;
        this.listaJugadoresEquipo1 = listaJugadoresEquipo1;
        this.listaJugadoresEquipo2 = listaJugadoresEquipo2;
    }
}
