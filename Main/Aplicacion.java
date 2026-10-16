import java.util.Scanner;
import java.util.List;
import java.time.LocalDate;
public class Aplicacion {
    /*
                 _______   _____   ____   __  __  ____ _____     _
                |  ____| / ____| / __ \ |  \/  |/ __ \|  __ \   / \
                | |__   | |     | |  | || \  / | |  | | |  | | / _ \
                |  __|  | |     | |  | || |\/| | |  | | |  | |/ ___ \
                | |____ | |____ | |__| || |  | | |__| | |__| / /   \ \
                |______| \______|\____/ |_|  |_|\____/|_____/_/     \_\

                    +--------------------------------------------+
                    |  \    EEE    / \    CCC    / \    OOO    / |
                    |   \   E     /   \   C     /   \   O O   /  |
                    |    \  EEE  /     \  C    /     \  O O  /   |
                    |     \ E   /       \ C   /       \ O O /    |
                    |      \EEE/         \CCC/         \OOO/     |
                    |       \ /           \ /           \ /      |
                    |                                            |
                    |  M       M   O O O O   D D D D       A     |
                    |  M M   M M  O       O  D      D    A   A   |
                    |  M  M M  M  O       O  D      D   A A A A  |
                    |  M   M   M  O       O  D      D   A     A  |
                    |  M       M   O O O O   D D D D    A     A  |
                    +--------------------------------------------+

     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Menú Interactivo
        Empresa ecomoda = new Empresa("Ecomoda", "800.198.234-1", "Centro, Armenia, Quindío");

        Sucursal sucursalNorte = new Sucursal("SUC-01", "Sede norte", "Centro Comercial Portal del Quindío", "Armenia");
        Sucursal sucursalSur = new Sucursal("SUC-02", "Sede centro", "Centro Comercial Unicentro", "Armenia");
        ecomoda.registrarSucursal(sucursalNorte);
        ecomoda.registrarSucursal(sucursalSur);

        Cliente c1 = new Cliente("101010", "María López", "maria@mail.com", "300111", "AF-001", Membresia.BRONCE);
        ecomoda.registrarCliente(c1);

        Vendedor v1 = new Vendedor("303030", "Carlos Ruiz", "carlos@mail.com", "300333", "EMP-01", LocalDate.of(2023, 1, 15), 1300000.0);
        sucursalNorte.registrarVendedor(v1);

        Prenda p1 = new Prenda("PR-001", "Camiseta tipo polo", "Nike", 60000.0, CategoriaPrenda.CAMISETA);
        Prenda p2 = new Prenda("PR-002", "Pantalón baggy", "Levis", 150000.0, CategoriaPrenda.PANTALON);
        ecomoda.registrarPrenda(p1);
        ecomoda.registrarPrenda(p2);

        Inventario inv1 = new Inventario("M", "Negro", 15, p1, sucursalNorte);
        sucursalNorte.registrarInventario(inv1);



        int opcion;

        do {
            System.out.println("===== SISTEMA ECOMODA =====");
            System.out.println("1. Registrar prenda en catálogo global (Req 1)");
            System.out.println("2. Registrar cliente (Req 2)");
            System.out.println("3. Registrar existencias en sucursal (Req 3)");
            System.out.println("4. Consultar prendas disponibles en una sucursal");
            System.out.println("5. Registrar una venta");
            System.out.println("6. Consultar prendas agotadas");
            System.out.println("7. Historial de movimientos (Clientes/Vendedores)");
            System.out.println("8. Estadísticas del negocio (Ingresos/Top Ventas)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1: {
                    System.out.println("\n--- REGISTRAR NUEVA PRENDA ---");
                    System.out.print("Código de la prenda: ");
                    String codigo = scanner.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();

                    System.out.print("Precio Base: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Categorías: 1. CAMISETA | 2. PANTALON | 3. CHAQUETA");
                    System.out.print("Seleccione categoría: ");
                    int opcCat = scanner.nextInt();
                    scanner.nextLine();

                    CategoriaPrenda categoria = CategoriaPrenda.CAMISETA;
                    if (opcCat == 2) categoria = CategoriaPrenda.PANTALON;
                    else if (opcCat == 3) categoria = CategoriaPrenda.CHAQUETA;

                    Prenda nuevaPrenda = new Prenda(codigo, nombre, marca, precio, categoria);

                    if (ecomoda.registrarPrenda(nuevaPrenda)) {
                        System.out.println("¡Prenda registrada en el catálogo con éxito!");
                    } else {
                        System.out.println("Error: Ya existe una prenda con ese código en el catálogo.");
                    }
                    break;
                }

                case 2: {
                    System.out.println("\n--- REGISTRAR NUEVO CLIENTE ---");
                    System.out.print("Documento de identidad: ");
                    String doc = scanner.nextLine();

                    System.out.print("Nombre completo: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Teléfono: ");
                    String tel = scanner.nextLine();

                    System.out.print("Código de afiliación: ");
                    String codAfiliacion = scanner.nextLine();

                    System.out.println("Membresía: 1. BRONCE | 2. PLATA | 3. ORO");
                    System.out.print("Seleccione membresía: ");
                    int opcMem = scanner.nextInt();
                    scanner.nextLine();

                    Membresia membresia = Membresia.BRONCE;
                    if (opcMem == 2) membresia = Membresia.PLATA;
                    else if (opcMem == 3) membresia = Membresia.ORO;

                    Cliente nuevoCliente = new Cliente(doc, nombre, email, tel, codAfiliacion, membresia);

                    if (ecomoda.registrarCliente(nuevoCliente)) {
                        System.out.println("¡Cliente registrado con éxito!");
                    } else {
                        System.out.println("Error: Ya existe un cliente con ese documento.");
                    }
                    break;
                }

                case 3: {
                    System.out.println("\n--- REGISTRAR INVENTARIO EN SUCURSAL ---");

                    System.out.print("Código de la sucursal (Ej. SUC-01): ");
                    String codSucursal = scanner.nextLine();
                    Sucursal sucursalEncontrada = null;

                    // Buscar sucursal
                    for (Sucursal s : ecomoda.getListaSucursalesE()) {
                        if (s.getCodigo().equalsIgnoreCase(codSucursal)) {
                            sucursalEncontrada = s;
                            break;
                        }
                    }

                    if (sucursalEncontrada == null) {
                        System.out.println("Error: Sucursal no encontrada.");
                        break;
                    }

                    System.out.print("Código de la prenda del catálogo (Ej. PR-001): ");
                    String codPrenda = scanner.nextLine();
                    Prenda prendaEncontrada = null;

                    // Buscar prenda
                    for (Prenda p : ecomoda.getListaCatalogoPrendas()) {
                        if (p.getCodigo().equalsIgnoreCase(codPrenda)) {
                            prendaEncontrada = p;
                            break;
                        }
                    }

                    if (prendaEncontrada == null) {
                        System.out.println("Error: La prenda no existe en el catálogo global.");
                        break;
                    }

                    System.out.print("Talla (Ej. S, M, L, 32): ");
                    String talla = scanner.nextLine();

                    System.out.print("Color: ");
                    String color = scanner.nextLine();

                    System.out.print("Cantidad a ingresar: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();

                    Inventario nuevoInventario = new Inventario(talla, color, cantidad, prendaEncontrada, sucursalEncontrada);

                    if (sucursalEncontrada.registrarInventario(nuevoInventario)) {
                        System.out.println("¡Stock registrado/actualizado en la sucursal con éxito!");
                    } else {
                        System.out.println("Error al registrar el inventario.");
                    }
                    break;
                }

                case 4: {
                    System.out.println("\n--- (Próximo paso: Consultar disponibilidad) ---");
                    break;
                }

                case 5: {
                    System.out.println("\n--- (Próximo paso: Registrar Venta) ---");
                    break;
                }

                case 6: {
                    System.out.println("\n--- (Próximo paso: Consultar Agotados) ---");
                    break;
                }

                case 7: {
                    System.out.println("\n--- (Próximo paso: Historial Clientes/Vendedores) ---");
                    break;
                }

                case 8: {
                    System.out.println("\n--- (Próximo paso: Estadísticas Financieras) ---");
                    break;
                }

                case 0:
                    System.out.println("Cerrando el sistema de Ecomoda... ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción incorrecta, por favor intente nuevamente.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}