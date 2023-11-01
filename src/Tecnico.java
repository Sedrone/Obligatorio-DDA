public class Tecnico extends Persona implements Salario{
    private String equipo;

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public Tecnico(int cedula, String nombre, String apellido, double sueldo, String equipo) {
        super(cedula, nombre, apellido, sueldo);
        this.equipo = equipo.toUpperCase();
    }

    @Override
    public double calcularSalario(){
        return getSueldo();
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "Cedula: " + super.getCedula() +
                ", Nombre: " + super.getNombre() +
                ", Apellido: " + super.getApellido() +
                ", Sueldo base: " + super.getSueldo() +
                ", Sueldo con bonus: " + calcularSalario() +
                ", Equipo: " + getEquipo() +
                '}';
    }
}
