public class Arbitro extends Persona implements Precalentar, Salario{
    private int cantDePartidosDirigidos;
    private int anostrabajados;

    public int getCantDePartidosDirigidos() {
        return cantDePartidosDirigidos;
    }

    public void setCantDePartidosDirigidos(int cantDePartidosDirigidos) {
        this.cantDePartidosDirigidos = cantDePartidosDirigidos;
    }

    public int getAnostrabajados() {
        return anostrabajados;
    }

    public void setAnostrabajados(int panostrabajados) {
        this.anostrabajados = panostrabajados;
    }

    public Arbitro(int cedula, String nombre, String apellido, double sueldo, int cantDePartidosDirigidos, int anostrabajados) {
        super(cedula, nombre, apellido,sueldo);
        this.cantDePartidosDirigidos = cantDePartidosDirigidos;
        this.anostrabajados = anostrabajados;
    }

    @Override
    public void precalentar(){
        System.out.println("El arbitro ha precalentado 10 minutos.");
    }
    @Override
    public double calcularSalario(){
        if (anostrabajados <= 5){
            return getSueldo();
        }
        else {
            double sueldo = getSueldo();
            for (int i = 0; i < anostrabajados; i++){
                sueldo = sueldo*1.03;
            }
            return sueldo;
        }

    }

    @Override
    public String toString() {
        return "Jugador{" +
                "Cedula: '" + super.getCedula() +
                ", Nombre: '" + super.getNombre() +
                ", Apellido: '" + super.getApellido() +
                ", Sueldo base: '" + super.getSueldo() +
                ", Cantidad de partidos arbitrados : '" + getCantDePartidosDirigidos() +
                ", Años trabajados : '" + getAnostrabajados() +
                ", Sueldo con bonus: '" + calcularSalario() +
                '}';
    }
}