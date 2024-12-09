package Controller;

import Model.Conexion;
import Model.Maquinaria;
import Model.Marca;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaquinariaController {

    // Método para insertar un suministro
    public boolean insertarSuministro(String nombre, String modelo, int idmarca) {
        Maquinaria maquinaria = new Maquinaria();
        return maquinaria.insertarMaquinaria(nombre, modelo, idmarca);  // Llamada a insertar maquinaria
    }

    // Método para obtener las marcas disponibles
    public List<Marca> obtenerMarcas() {
        List<Marca> marcas = new ArrayList<>();
        String sql = "SELECT idmarca, nombre FROM marca";  // Obtener tanto el id como el nombre de la marca

        try (Connection conn = Conexion.Conectar(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int idmarca = rs.getInt("idmarca");
                String nombre = rs.getString("nombre");
                marcas.add(new Marca(idmarca, nombre));  // Crear el objeto Marca con idmarca y nombre
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener marcas: " + e.getMessage());
        }

        return marcas;  // Retornar la lista de objetos Marca
    }
}
