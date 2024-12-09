package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    private static final String URL = "jdbc:mysql://127.0.0.1:3310/Koelsa";  // URL de conexión
    private static final String USER = "root";  // Usuario de la base de datos
    private static final String PASSWORD = "080322";  // Contraseña de la base de datos

    // Método estático para establecer la conexión
    public static Connection Conectar() {
        Connection cn = null;
        
        try {
            // Registrar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión con la base de datos
            cn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            // Verificar la conexión ejecutando una consulta simple
            if (cn != null) {
                try (Statement stmt = cn.createStatement()) {
                    stmt.executeQuery("SELECT 1");  // Consulta trivial para verificar la conexión
                    System.out.println("Conexión exitosa.");
                } catch (SQLException e) {
                    System.out.println("Error al verificar la conexión: " + e.getMessage());
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Manejo de errores si ocurre alguna excepción
            System.out.println("Error en la conexión: " + e.getMessage());
        }
        return cn;
    }

    // Método para cerrar la conexión
    public static void cerrarConexion(Connection cn) {
        if (cn != null) {
            try {
                cn.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
