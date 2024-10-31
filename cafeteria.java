import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pedido {
    private String nombreCliente;
    private String productos;

    public Pedido(String nombreCliente, String productos) {
        this.nombreCliente = nombreCliente;
        this.productos = productos;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getProductos() {
        return productos;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombreCliente + " - Pedido: " + productos;
    }
}

public class cafeteria {

    private Queue<Pedido> colaPedidos;

    public cafeteria() {
        colaPedidos = new LinkedList<>();
    }

    public void registrarPedido(String nombreCliente, String productos) {
        Pedido nuevoPedido = new Pedido(nombreCliente, productos);
        colaPedidos.add(nuevoPedido);
        System.out.println("Pedido registrado :).");
    }

    public void atenderPedido() {
        if (colaPedidos.isEmpty()) {
            System.out.println("No hay pedidos en espera.");
        } else {
            Pedido pedidoAtendido = colaPedidos.poll();
            System.out.println("cliente: " + pedidoAtendido.getNombreCliente());
            System.out.println("producto: " + pedidoAtendido.getProductos());
        }
    }

    public void mostrarPedidosPendientes() {
        if (colaPedidos.isEmpty()) {
            System.out.println("No hay mas pedidos pendientes.");
        } else {
            System.out.println("Pedido pendiente:");
            for (Pedido pedido : colaPedidos) {
                System.out.println(pedido);
            }
        }
    }

    public static void main(String[] args) {
        cafeteria cafeteria = new cafeteria();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de la Cafetería ---");
            System.out.println("1. Registrar un Pedido");
            System.out.println("2. Atender el Próximo Pedido");
            System.out.println("3. Verificar el Estado de los Pedidos Pendientes");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombreCliente = sc.nextLine();
                    System.out.print("Ingrese los productos y cantidades  ");
                    String productos = sc.nextLine();
                    cafeteria.registrarPedido(nombreCliente, productos);
                    break;
                case 2:
                    cafeteria.atenderPedido();
                    break;
                case 3:
                    cafeteria.mostrarPedidosPendientes();
                    break;
                case 4:
                    System.out.println("Saliendo del programa. ¡CHAO! :)");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 4);
        
    }
}
