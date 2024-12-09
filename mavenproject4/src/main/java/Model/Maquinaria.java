package Model;
import java.sql.*;

public class Maquinaria {
    
      // Método para insertar un suministro en la base de datos
    public boolean insertarMaquinaria(String nombre, String modelo, int idmarca) {
        String sql = "INSERT INTO maquinaria (nombre, modelo, idmarca) VALUES (?, ?, ?)";

        try (Connection conn = Conexion.Conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, modelo);
            ps.setInt(3, idmarca);  // Almacenar el idmarca (entero)

            int filasInsertadas = ps.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar Maquinaria: " + e.getMessage());
            return false;
        }
    }

}
