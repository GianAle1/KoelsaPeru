package Model;

public class Marca {
    private int idmarca;  // idmarca es de tipo int
    private String nombre;

    // Constructor
    public Marca(int idmarca, String nombre) {
        this.idmarca = idmarca;
        this.nombre = nombre;
    }

    // Métodos getter y setter
    public int getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(int idmarca) {
        this.idmarca = idmarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Sobrescribir toString para mostrar solo el nombre en el ComboBox
    @Override
    public String toString() {
        return nombre;  // Devolvemos solo el nombre en el ComboBox
    }
}
