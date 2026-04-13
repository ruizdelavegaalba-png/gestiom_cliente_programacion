import dao.ClienteDao;
import modelo.Cliente;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ClienteDao dao = new ClienteDao();

        Cliente c = new Cliente("Cristóbal Montero", "Cristobal.com", "600346322", 28, 350.0, 4);
        dao.insertarCliente(c);

        List<Cliente> todos = dao.obtenerClientes();
        Cliente insertado = null;
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getEmail().equals("Cristobal.com")) {
                insertado = todos.get(i);
                break;
            }
        }

        if (insertado != null) {
            System.out.println("Cliente insertado: " + insertado);
            insertado.setNombre("Temporal Actualizado");
            insertado.setDineroGastado(999.99);
            dao.actualizarCliente(insertado);
            System.out.println("Cliente actualizado: " + dao.obtenerClientePorId(insertado.getId()));

            dao.eliminarCliente(insertado);
            System.out.println("Cliente eliminado "
                    + dao.obtenerClientePorId(insertado.getId()));
        }

        System.out.println("         RESULTADOS DE CONSULTAS");
        System.out.println("Cliente con id= 1");
        Cliente porId = dao.obtenerClientePorId(1);
        System.out.println(porId);

        System.out.println("Obtener todos los clientes ");
        List<Cliente> clientes = dao.obtenerClientes();
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(clientes.get(i));
        }

        System.out.println(" Clientes mayores de 30 años");
        List<Cliente> mayores30 = dao.obtenerClientesMayoresDe30();
        for (int i = 0; i < mayores30.size(); i++) {
            System.out.println(mayores30.get(i));
        }

        System.out.println("Clientes con gasto mayor a 500");
        List<Cliente> gasto500 = dao.obtenerClientesGastoMayor500();
        for (int i = 0; i < gasto500.size(); i++) {
            System.out.println(gasto500.get(i));
        }

        System.out.println("Clientes ordenados por dinero gastado (mayor a menor)");
        List<Cliente> ordenadosDinero = dao.obtenerClientesOrdenadosPorDinero();
        for (int i = 0; i < ordenadosDinero.size(); i++) {
            System.out.println(ordenadosDinero.get(i));
        }

        System.out.println("Top 3 clientes por productos comprados");
        List<Cliente> top3 = dao.obtenerTop3PorProductos();
        for (int i = 0; i < top3.size(); i++) {
            System.out.println(top3.get(i));
        }

        System.out.println(" Suma total de dinero gastado");
        double suma = dao.obtenerSumaDineroGastado();
        System.out.printf("Total: %.2f€%n", suma);

        System.out.println("Media de productos comprados ");
        double mediaProductos = dao.obtenerMediaProductosComprados();
        System.out.printf("Media: %.2f productos%n", mediaProductos);

        System.out.println("Media de dinero gastado (edad > 25 y productos > 3)");
        double mediaDinero = dao.obtenerMediaDineroMayores25Productos3();
        System.out.printf("Media: %.2f€%n", mediaDinero);

        System.out.println("Número de clientes con gasto mayor a 100");
        int numGasto100 = dao.obtenerNumClientesGastoMayor100();
        System.out.println("Total: " + numGasto100 + " clientes");

        System.out.println("Número de clientes con edad entre 30 y 50 ");
        int numEdad3050 = dao.obtenerNumClientesEdadEntre30y50();
        System.out.println("Total: " + numEdad3050 + " clientes");

        System.out.println("Clientes con gasto > 200, ordenados por productos (ascendente)");
        List<Cliente> gasto200Productos = dao.obtenerClientesGastoMayor200OrdenadosPorProductos();
        for (int i = 0; i < gasto200Productos.size(); i++) {
            System.out.println(gasto200Productos.get(i));
        }

        System.out.println("Cliente más joven con gasto mayor a 400");
        Cliente masJoven = dao.obtenerClienteMasJovenGastoMayor400();
        System.out.println(masJoven);
    }
}