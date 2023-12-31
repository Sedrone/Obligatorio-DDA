public class Jugador extends Persona implements Precalentar, Salario{
    private String posicion;
    private String equipo;
    private int minutosJugados;

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo.toUpperCase();
    }

    public int getMinutosJugados() {
        return minutosJugados;
    }

    public void setMinutosJugados(int minutosJugados) {
        this.minutosJugados = minutosJugados;
    }

    public Jugador(int cedula, String nombre, String apellido, double sueldo, String posicion, String equipo, int minutosJugados) {
        super(cedula, nombre, apellido, sueldo);
        this.posicion = posicion;
        this.equipo = equipo.toUpperCase();
        this.minutosJugados = minutosJugados;
    }

    @Override
    public void precalentar(){
        System.out.println("El jugador ha precalentado 15 minutos.");
    }
    @Override
    public double calcularSalario(){
        return super.getSueldo()*1.2;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "Cedula: " + super.getCedula() +
                ", Nombre: " + super.getNombre() +
                ", Apellido: " + super.getApellido() +
                ", Sueldo base: " + super.getSueldo() +
                ", Sueldo con bonus: " + calcularSalario() +
                ", Posicion: " + getPosicion() +
                ", Equipo: " + getEquipo() +
                ", MinutosJugados: " + getMinutosJugados() +
                '}';
    }
}