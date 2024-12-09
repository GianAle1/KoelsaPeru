package controller;

import Model.Conexion;
import Model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    // Método para validar el login
    public boolean validarLogin(Usuario usuario) {
        Connection cn = Conexion.Conectar();
        if (cn == null) {
            return false;
        }

        try {
            String sql = "SELECT * FROM usuario WHERE usuario = ? AND contrasena = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, usuario.getUsuario());
            pst.setString(2, usuario.getContrasena());

            ResultSet rs = pst.executeQuery();

            // Si hay un resultado, el login es exitoso
            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        } finally {
            Conexion.cerrarConexion(cn);
        }
        
        return false;  // Si no se encuentra el usuario, retorno falso
    }
}
