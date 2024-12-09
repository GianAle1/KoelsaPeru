package Model;

public class Usuario {

    private String usuario;
    private String contrasena;

    // Constructor vacío
    public Usuario() {}

    // Constructor con parámetros
    public Usuario(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    // Getter y Setter para 'usuario'
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    // Getter y Setter para 'contrasena'
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
