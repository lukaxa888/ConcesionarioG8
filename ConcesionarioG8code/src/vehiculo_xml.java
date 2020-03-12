
public class vehiculo_xml {
    private int idUsuario;
    private String nombre;
    private String telefono;

    public vehiculo_xml(int idUsuario, String nombre, String telefono) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}