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
        this.equipo = equipo;
    }

    @Override
    public double calcularSalario(){
        return getSueldo();
    }
}
