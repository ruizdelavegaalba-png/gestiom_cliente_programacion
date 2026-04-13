package dao;
import modelo.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

    private String url = "jdbc:sqlite:clientes.db";

    public void insertarCliente(Cliente c) {
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "INSERT INTO clientes (nombre, email, telefono, edad, dinero_gastado, productos_comprados) VALUES (?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, c.getNombre());
            pstmt.setString(2, c.getEmail());
            pstmt.setString(3, c.getTelefono());
            pstmt.setInt(4, c.getEdad());
            pstmt.setDouble(5, c.getDineroGastado());
            pstmt.setInt(6, c.getProductosComprados());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    public void actualizarCliente(Cliente c) {
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "UPDATE clientes SET nombre=?, email=?, telefono=?, edad=?, dinero_gastado=?, productos_comprados=? WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, c.getNombre());
            pstmt.setString(2, c.getEmail());
            pstmt.setString(3, c.getTelefono());
            pstmt.setInt(4, c.getEdad());
            pstmt.setDouble(5, c.getDineroGastado());
            pstmt.setInt(6, c.getProductosComprados());
            pstmt.setInt(7, c.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    public void eliminarCliente(Cliente c) {
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "DELETE FROM clientes WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, c.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
    }


    public Cliente obtenerClientePorId(int id) {
        Cliente c = null;
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM clientes WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int idC = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                int edad = rs.getInt("edad");
                double dineroGastado = rs.getDouble("dinero_gastado");
                int productosComprados = rs.getInt("productos_comprados");
                c = new Cliente(idC, nombre, email, telefono, edad, dineroGastado, productosComprados);
            }
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
        return c;
    }


    public List<Cliente> obtenerClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM clientes";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                int edad = rs.getInt("edad");
                double dineroGastado = rs.getDouble("dinero_gastado");
                int productosComprados = rs.getInt("productos_comprados");
                Cliente c = new Cliente(id, nombre, email, telefono, edad, dineroGastado, productosComprados);
                clientes.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
        return clientes;
    }

    public List<Cliente> obtenerClientesMayoresDe30() {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM clientes WHERE edad > 30";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                int edad = rs.getInt("edad");
                double dineroGastado = rs.getDouble("dinero_gastado");
                int productosComprados = rs.getInt("productos_comprados");
                Cliente c = new Cliente(id, nombre, email, telefono, edad, dineroGastado, productosComprados);
                clientes.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
        return clientes;
    }

    public List<Cliente> obtenerClientesGastoMayor500() {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM clientes WHERE dinero_gastado > 500";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                int edad = rs.getInt("edad");
                double dineroGastado = rs.getDouble("dinero_gastado");
                int productosComprados = rs.getInt("productos_comprados");
                Cliente c = new Cliente(id, nombre, email, telefono, edad, dineroGastado, productosComprados);
                clientes.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
        return clientes;
    }


    public List<Cliente> obtenerClientesOrdenadosPorDinero() {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM clientes ORDER BY dinero_gastado DESC";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                int edad = rs.getInt("edad");
                double dineroGastado = rs.getDouble("dinero_gastado");
                int productosComprados = rs.getInt("productos_comprados");
                Cliente c = new Cliente(id, nombre, email, telefono, edad, dineroGastado, productosComprados);
                clientes.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
        return clientes;
    }


    public List<Cliente> obtenerTop3PorProductos() {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM clientes ORDER BY productos_comprados DESC LIMIT 3";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                int edad = rs.getInt("edad");
                double dineroGastado = rs.getDouble("dinero_gastado");
                int productosComprados = rs.getInt("productos_comprados");
                Cliente c = new Cliente(id, nombre, email, telefono, edad, dineroGastado, productosComprados);
                clientes.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
        return clientes;
    }

    public double obtenerSumaDineroGastado() {
        double total = 0.0;
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT SUM(dinero_gastado) FROM clientes";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                total = rs.getDouble("SUM(dinero_gastado)");
            }
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
        return total;
    }

    public double obtenerMediaProductosComprados() {
        double media = 0.0;
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT AVG(productos_comprados) FROM clientes";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                media = rs.getDouble("AVG(productos_comprados)");
            }
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
        return media;
    }

    public double obtenerMediaDineroMayores25Productos3() {
        double media = 0.0;
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT AVG(dinero_gastado) FROM clientes WHERE edad > 25 AND productos_comprados > 3";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                media = rs.getDouble("AVG(dinero_gastado)");
            }
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
        return media;
    }

    public int obtenerNumClientesGastoMayor100() {
        int total = 0;
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT COUNT(*) FROM clientes WHERE dinero_gastado > 100";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                total = rs.getInt("COUNT(*)");
            }
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
        return total;
    }

    public int obtenerNumClientesEdadEntre30y50() {
        int total = 0;
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT COUNT(*) FROM clientes WHERE edad BETWEEN 30 AND 50";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                total = rs.getInt("COUNT(*)");
            }
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
        return total;
    }


    public List<Cliente> obtenerClientesGastoMayor200OrdenadosPorProductos() {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM clientes WHERE dinero_gastado > 200 ORDER BY productos_comprados ASC";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                int edad = rs.getInt("edad");
                double dineroGastado = rs.getDouble("dinero_gastado");
                int productosComprados = rs.getInt("productos_comprados");
                Cliente c = new Cliente(id, nombre, email, telefono, edad, dineroGastado, productosComprados);
                clientes.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
        return clientes;
    }

    public Cliente obtenerClienteMasJovenGastoMayor400() {
        Cliente c = null;
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM clientes WHERE dinero_gastado > 400 ORDER BY edad ASC LIMIT 1";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                int edad = rs.getInt("edad");
                double dineroGastado = rs.getDouble("dinero_gastado");
                int productosComprados = rs.getInt("productos_comprados");
                c = new Cliente(id, nombre, email, telefono, edad, dineroGastado, productosComprados);
            }
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
        return c;
    }
}