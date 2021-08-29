package modelo;

public class Equipo {
    private int id;
    private String nombrequipo;
    private String nombrecapitan;
    private int numintegrantes;
    private String fechainscripcion;

    public Equipo(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrequipo() {
        return nombrequipo;
    }

    public void setNombrequipo(String nombrequipo) {
        this.nombrequipo = nombrequipo;
    }

    public String getNombrecapitan() {
        return nombrecapitan;
    }

    public void setNombrecapitan(String nombrecapitan) {
        this.nombrecapitan = nombrecapitan;
    }

    public int getNumintegrantes() {
        return numintegrantes;
    }

    public void setNumintegrantes(int numintegrantes) {
        this.numintegrantes = numintegrantes;
    }

    public String getFechainscripcion() {
        return fechainscripcion;
    }

    public void setFechainscripcion(String fechainscripcion) {
        this.fechainscripcion = fechainscripcion;
    }
       
}
