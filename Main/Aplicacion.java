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
                    |      \EEE/         \CCC/         \OOO/     |+
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

// ==================== DATOS QUEMADOS DE PRUEBA ====================

// 1. Crear una venta de prueba
        Venta ventaPrueba = new Venta("0001", LocalDate.now(), sucursalNorte, v1, c1);

// 2. Crear un detalle de venta (Comprando 2 unidades de la camiseta Polo)
        DetalleVenta detallePrueba = new DetalleVenta(2, inv1, ventaPrueba);
        ventaPrueba.agregarDetalle(detallePrueba);

// 3. Confirmar la venta (esto descuenta el stock de 15 a 13 en inv1)
        if (sucursalNorte.registrarVenta(ventaPrueba)) {

            // 4. Registrar la venta en los historiales del Cliente y del Vendedor
            c1.getComprasRealizadas().add(ventaPrueba);
            v1.getVentasRealizadas().add(ventaPrueba);

            System.out.println(">>  Venta de prueba instanciada con éxito <<");
        }
// =================================================================

        int opcion;

        do {
            System.out.println("===== SISTEMA ECOMODA ===== \n"+
                    "                    +--------------------------------------------+\n" +
                    "                    |  \\    EEE    / \\    CCC    / \\    OOO    / |\n" +
                    "                    |   \\   E     /   \\   C     /   \\   O O   /  |\n" +
                    "                    |    \\  EEE  /     \\  C    /     \\  O O  /   |\n" +
                    "                    |     \\ E   /       \\ C   /       \\ O O /    |\n" +
                    "                    |      \\EEE/         \\CCC/         \\OOO/     |\n" +
                    "                    |       \\ /           \\ /           \\ /      |\n" +
                    "                    |                                            |\n" +
                    "                    |  M       M   O O O O   D D D D       A     |\n" +
                    "                    |  M M   M M  O       O  D      D    A   A   |\n" +
                    "                    |  M  M M  M  O       O  D      D   A A A A  |\n" +
                    "                    |  M   M   M  O       O  D      D   A     A  |\n" +
                    "                    |  M       M   O O O O   D D D D    A     A  |\n" +
                    "                    +--------------------------------------------+\n");
            System.out.println("1. Registrar prenda en catálogo global ");
            System.out.println("2. Registrar cliente ");
            System.out.println("3. Registrar vendedor ");
            System.out.println("4. Registrar existencias en sucursal ");
            System.out.println("5. Consultar prendas disponibles en una sucursal");
            System.out.println("6. Venta completa, precios unitarios y total");
            System.out.println("7. Consultar prendas agotadas");
            System.out.println("8. Historial de movimientos (Clientes/Vendedores)");
            System.out.println("9. Estadísticas del negocio (Ingresos/Top Ventas)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1: {
                    //1. Registrar prenda en catálogo global
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
                    //2. Registrar cliente
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
                                    //3. Registrar vendedor
                                    System.out.print("Código de la sucursal del vendedor: ");
                                    String codSucursal = scanner.nextLine();

                                    Sucursal sucursalVendedor = null;

                                    // Buscar la sucursal por su código
                                    for (Sucursal s : ecomoda.getListaSucursalesE()) {
                                        if (s.getCodigo().equalsIgnoreCase(codSucursal)) {
                                            sucursalVendedor = s;
                                            break;
                                        }
                                    }

                                    // Verificar si la sucursal existe
                                    if (sucursalVendedor == null) {
                                        System.out.println("La sucursal no existe");
                                        break;
                                    }

                                    System.out.print("Documento de identidad: ");
                                    String docVendedor = scanner.nextLine();

                                    // Verificar que no exista otro vendedor con ese documento
                                    boolean documentoRepetido = false;

                                    for (Sucursal s : ecomoda.getListaSucursalesE()) {
                                        for (Vendedor v : s.getListaVendedores()) {
                                            if (v.getDocumentoIdentidad().equalsIgnoreCase(docVendedor)) {
                                                documentoRepetido = true;
                                            }
                                        }
                                    }

                                    if (documentoRepetido) {
                                        System.out.println("Ya existe un vendedor con ese documento");
                                        break;
                                    }

                                    System.out.print("Nombre completo: ");
                                    String nombreVendedor = scanner.nextLine();

                                    System.out.print("Email: ");
                                    String emailVendedor = scanner.nextLine();

                                    System.out.print("Teléfono: ");
                                    String telVendedor = scanner.nextLine();

                                    System.out.print("Código de empleado: ");
                                    String codEmpleado = scanner.nextLine();

                                    System.out.print("Año de contratación: ");
                                    int anio = scanner.nextInt();

                                    System.out.print("Mes de contratación: ");
                                    int mes = scanner.nextInt();

                                    System.out.print("Día de contratación: ");
                                    int dia = scanner.nextInt();

                                    System.out.print("Salario básico: ");
                                    double salario = scanner.nextDouble();
                                    scanner.nextLine();

                                    Vendedor nuevoVendedor = new Vendedor(docVendedor, nombreVendedor, emailVendedor, telVendedor,
                                            codEmpleado, LocalDate.of(anio, mes, dia), salario);

                                    if (sucursalVendedor.registrarVendedor(nuevoVendedor)) {
                                        System.out.println("Vendedor registrado correctamente");
                                    } else {
                                        System.out.println("No se pudo registrar el vendedor");
                                    }

                                    break;
                                }

                                case 4: {
                                    //4. Registrar existencias en sucursal
                                    System.out.print("Código de la sucursal (Ej. SUC-01): ");
                                    String codSucursal = scanner.nextLine();

                                    Sucursal sucursalInventario = null;

                                    // Buscar la sucursal por su código
                                    for (Sucursal s : ecomoda.getListaSucursalesE()) {
                                        if (s.getCodigo().equalsIgnoreCase(codSucursal)) {
                                            sucursalInventario = s;
                                            break;
                                        }
                                    }

                                    if (sucursalInventario == null) {
                                        System.out.println("La sucursal no existe");
                                        break;
                                    }

                                    System.out.print("Código de la prenda (Ej. PR-001): ");
                                    String codPrenda = scanner.nextLine();

                                    Prenda prendaInventario = null;

                                    // Buscar la prenda en el catálogo
                                    for (Prenda p : ecomoda.getListaCatalogoPrendas()) {
                                        if (p.getCodigo().equalsIgnoreCase(codPrenda)) {
                                            prendaInventario = p;
                                            break;
                                        }
                                    }

                                    if (prendaInventario == null) {
                                        System.out.println("La prenda no existe en el catálogo");
                                        break;
                                    }

                                    System.out.print("Talla (Ej. S, M, L, 32): ");
                                    String talla = scanner.nextLine();

                                    System.out.print("Color: ");
                                    String color = scanner.nextLine();

                                    System.out.print("Cantidad a ingresar: ");
                                    int cantidad = scanner.nextInt();
                                    scanner.nextLine();

                                    if (cantidad <= 0) {
                                        System.out.println("Cantidad incorrecta");
                                        break;
                                    }

                                    Inventario nuevoInventario = new Inventario(talla, color, cantidad, prendaInventario, sucursalInventario);

                                    if (sucursalInventario.registrarInventario(nuevoInventario)) {
                                        System.out.println("Existencias registradas correctamente");
                                    } else {
                                        System.out.println("No se pudo registrar el inventario");
                                    }

                                    break;
                                }

                                case 5: {
                                    //5. Consultar prendas disponibles en una sucursal
                                    System.out.print("Código de la sucursal (Ej. SUC-01): ");
                                    String codSucursal = scanner.nextLine();

                                    Sucursal sucursalConsulta = null;

                                    for (Sucursal s : ecomoda.getListaSucursalesE()) {
                                        if (s.getCodigo().equalsIgnoreCase(codSucursal)) {
                                            sucursalConsulta = s;
                                            break;
                                        }
                                    }

                                    if (sucursalConsulta == null) {
                                        System.out.println("La sucursal no existe");
                                        break;
                                    }

                                    List<Inventario> disponibles = sucursalConsulta.consultarPrendasDisponibles();

                                    if (disponibles.isEmpty()) {
                                        System.out.println("No hay prendas disponibles en esta sucursal");
                                    } else {
                                        System.out.println("Prendas disponibles en " + sucursalConsulta.getNombre() + ":");

                                        for (Inventario inv : disponibles) {
                                            System.out.println("- " + inv.getPrenda().getNombre() +
                                                    " | Talla: " + inv.getTalla() +
                                                    " | Color: " + inv.getColor() +
                                                    " | Cantidad: " + inv.getCantidadDisponible());
                                        }
                                    }

                                    break;
                                }

                                case 6: {
                                    //6. Venta completa, precios unitarios y total
                                    System.out.print("Código de la sucursal (Ej. SUC-01): ");
                                    String codSucursal = scanner.nextLine();

                                    Sucursal sucursalVenta = null;

                                    for (Sucursal s : ecomoda.getListaSucursalesE()) {
                                        if (s.getCodigo().equalsIgnoreCase(codSucursal)) {
                                            sucursalVenta = s;
                                            break;
                                        }
                                    }

                                    if (sucursalVenta == null) {
                                        System.out.println("La sucursal no existe");
                                        break;
                                    }

                                    System.out.print("Documento del vendedor (Ej. 303030): ");
                                    String docVendedor = scanner.nextLine();

                                    Vendedor vendedorVenta = null;

                                    for (Vendedor v : sucursalVenta.getListaVendedores()) {
                                        if (v.getDocumentoIdentidad().equalsIgnoreCase(docVendedor)) {
                                            vendedorVenta = v;
                                            break;
                                        }
                                    }

                                    if (vendedorVenta == null) {
                                        System.out.println("El vendedor no existe en esta sucursal");
                                        break;
                                    }

                                    System.out.print("Documento del cliente (Ej. 101010): ");
                                    String docCliente = scanner.nextLine();

                                    Cliente clienteVenta = null;

                                    for (Cliente c : ecomoda.getListaClientes()) {
                                        if (c.getDocumentoIdentidad().equalsIgnoreCase(docCliente)) {
                                            clienteVenta = c;
                                            break;
                                        }
                                    }

                                    if (clienteVenta == null) {
                                        System.out.println("El cliente no está registrado");
                                        break;
                                    }

                                    System.out.print("Código de la venta (Ej. V-001): ");
                                    String codVenta = scanner.nextLine();

                                    Venta nuevaVenta = new Venta(codVenta, LocalDate.now(), sucursalVenta, vendedorVenta, clienteVenta);

                                    // Agregar las prendas a la venta
                                    String agregarOtra;

                                    do {
                                        System.out.print("Código de la prenda (Ej. PR-001): ");
                                        String codPrenda = scanner.nextLine();

                                        System.out.print("Talla (Ej. M): ");
                                        String talla = scanner.nextLine();

                                        System.out.print("Color (Ej. Negro): ");
                                        String color = scanner.nextLine();

                                        Inventario inventarioVenta = null;

                                        // Buscar la prenda en el inventario de la sucursal
                                        for (Inventario inv : sucursalVenta.getListaInventario()) {
                                            if (inv.getPrenda().getCodigo().equalsIgnoreCase(codPrenda) &&
                                                    inv.getTalla().equalsIgnoreCase(talla) &&
                                                    inv.getColor().equalsIgnoreCase(color)) {
                                                inventarioVenta = inv;
                                                break;
                                            }
                                        }

                                        if (inventarioVenta == null) {
                                            System.out.println("No existe esa prenda con esa talla y color en la sucursal");
                                        } else {
                                            // Contar las unidades de esta prenda que ya están en la venta
                                            int yaAgregadas = 0;

                                            for (DetalleVenta d : nuevaVenta.getDetalles()) {
                                                if (d.getInventario().equals(inventarioVenta)) {
                                                    yaAgregadas = yaAgregadas + d.getCantidad();
                                                }
                                            }

                                            int stockRestante = inventarioVenta.getCantidadDisponible() - yaAgregadas;

                                            System.out.print("Cantidad a llevar (disponibles: " + stockRestante + "): ");
                                            int cantidad = scanner.nextInt();
                                            scanner.nextLine();

                                            // Verificar que haya stock suficiente
                                            if (cantidad > 0 && cantidad <= stockRestante) {
                                                DetalleVenta detalle = new DetalleVenta(cantidad, inventarioVenta, nuevaVenta);
                                                nuevaVenta.agregarDetalle(detalle);

                                                System.out.println("Prenda agregada");
                                                System.out.println("Precio unitario final: $" + detalle.calcularPrecioUnitario());
                                                System.out.println("Subtotal: $" + detalle.calcularSubTotal());
                                            } else {
                                                System.out.println("Cantidad incorrecta o stock insuficiente");
                                            }
                                        }

                                        System.out.print("¿Desea agregar otra prenda? (s/n): ");
                                        agregarOtra = scanner.nextLine();

                                    } while (agregarOtra.equalsIgnoreCase("s"));

                                    // Confirmar la venta
                                    if (nuevaVenta.getDetalles().isEmpty()) {
                                        System.out.println("Venta cancelada, no se agregaron prendas");
                                    } else if (sucursalVenta.registrarVenta(nuevaVenta)) {

                                        clienteVenta.getComprasRealizadas().add(nuevaVenta);

                                        System.out.println("Venta registrada correctamente");
                                        System.out.println("Total de la venta: $" + nuevaVenta.getTotalVenta());
                                    } else {
                                        System.out.println("No se pudo registrar la venta");
                                    }

                                    break;
                                }

                                case 7: {
                                    //7. Consultar prendas agotadas
                                    System.out.print("Código de la sucursal (Ej. SUC-01): ");
                                    String codSucursal = scanner.nextLine();

                                    Sucursal sucursalAgotadas = null;

                                    for (Sucursal s : ecomoda.getListaSucursalesE()) {
                                        if (s.getCodigo().equalsIgnoreCase(codSucursal)) {
                                            sucursalAgotadas = s;
                                            break;
                                        }
                                    }

                                    if (sucursalAgotadas == null) {
                                        System.out.println("La sucursal no existe");
                                        break;
                                    }

                                    List<Inventario> agotadas = sucursalAgotadas.consultarPrendasAgotadas();

                                    if (agotadas.isEmpty()) {
                                        System.out.println("No hay prendas agotadas en esta sucursal");
                                    } else {
                                        System.out.println("Prendas agotadas en " + sucursalAgotadas.getNombre() + ":");

                                        for (Inventario inv : agotadas) {
                                            System.out.println("- " + inv.getPrenda().getNombre() +
                                                    " | Talla: " + inv.getTalla() +
                                                    " | Color: " + inv.getColor());
                                        }
                                    }

                                    break;
                                }

                                case 8: {
                                    //8. Historial de movimientos
                                    System.out.println("1. Ver compras de un cliente");
                                    System.out.println("2. Ver ventas de un vendedor");
                                    System.out.print("Seleccione una opción: ");
                                    int opcHistorial = scanner.nextInt();
                                    scanner.nextLine();

                                    if (opcHistorial == 1) {
                                        System.out.print("Documento del cliente (Ej. 101010): ");
                                        String docCliente = scanner.nextLine();

                                        Cliente clienteHistorial = null;

                                        for (Cliente c : ecomoda.getListaClientes()) {
                                            if (c.getDocumentoIdentidad().equalsIgnoreCase(docCliente)) {
                                                clienteHistorial = c;
                                                break;
                                            }
                                        }

                                        if (clienteHistorial == null) {
                                            System.out.println("El cliente no existe");
                                            break;
                                        }

                                        List<Venta> compras = clienteHistorial.getComprasRealizadas();

                                        if (compras == null || compras.isEmpty()) {
                                            System.out.println("El cliente no ha realizado compras");
                                        } else {
                                            System.out.println("Compras de " + clienteHistorial.getNombre() + ":");

                                            for (Venta v : compras) {
                                                System.out.println("- Venta: " + v.getCodigo() +
                                                        " | Fecha: " + v.getFecha() +
                                                        " | Total: $" + v.getTotalVenta());
                                            }
                                        }

                                    } else if (opcHistorial == 2) {
                                        System.out.print("Código de la sucursal del vendedor: ");
                                        String codSucursal = scanner.nextLine();

                                        Sucursal sucursalHistorial = null;

                                        for (Sucursal s : ecomoda.getListaSucursalesE()) {
                                            if (s.getCodigo().equalsIgnoreCase(codSucursal)) {
                                                sucursalHistorial = s;
                                                break;
                                            }
                                        }

                                        if (sucursalHistorial == null) {
                                            System.out.println("La sucursal no existe");
                                            break;
                                        }

                                        System.out.print("Documento del vendedor (Ej. 303030): ");
                                        String docVendedor = scanner.nextLine();

                                        Vendedor vendedorHistorial = null;

                                        for (Vendedor v : sucursalHistorial.getListaVendedores()) {
                                            if (v.getDocumentoIdentidad().equalsIgnoreCase(docVendedor)) {
                                                vendedorHistorial = v;
                                                break;
                                            }
                                        }

                                        if (vendedorHistorial == null) {
                                            System.out.println("El vendedor no existe en esta sucursal");
                                            break;
                                        }

                                        List<Venta> ventas = vendedorHistorial.getVentasRealizadas();

                                        if (ventas == null || ventas.isEmpty()) {
                                            System.out.println("El vendedor no ha realizado ventas");
                                        } else {
                                            System.out.println("Ventas de " + vendedorHistorial.getNombre() + ":");

                                            for (Venta v : ventas) {
                                                System.out.println("- Venta: " + v.getCodigo() +
                                                        " | Fecha: " + v.getFecha() +
                                                        " | Total: $" + v.getTotalVenta());
                                            }
                                        }

                                    } else {
                                        System.out.println("Opción incorrecta");
                                    }

                                    break;
                                }

                                case 9: {
                                    //9. Estadísticas del negocio
                                    System.out.println("1. Ingresos totales de una sucursal");
                                    System.out.println("2. Prenda más vendida de la empresa");
                                    System.out.print("Seleccione una opción: ");
                                    int opcEstadistica = scanner.nextInt();
                                    scanner.nextLine();

                                    if (opcEstadistica == 1) {
                                        System.out.print("Código de la sucursal (Ej. SUC-01): ");
                                        String codSucursal = scanner.nextLine();

                                        Sucursal sucursalIngresos = null;

                                        for (Sucursal s : ecomoda.getListaSucursalesE()) {
                                            if (s.getCodigo().equalsIgnoreCase(codSucursal)) {
                                                sucursalIngresos = s;
                                                break;
                                            }
                                        }

                                        if (sucursalIngresos == null) {
                                            System.out.println("La sucursal no existe");
                                            break;
                                        }

                                        System.out.println("Ingresos totales de " + sucursalIngresos.getNombre() +
                                                ": $" + sucursalIngresos.calcularIngresosTotales());

                                    } else if (opcEstadistica == 2) {
                                        Prenda prendaTop = ecomoda.calcularPrendaMasVendida();

                                        if (prendaTop == null) {
                                            System.out.println("Todavía no hay ventas registradas");
                                        } else {
                                            System.out.println("Prenda más vendida: " + prendaTop.getNombre() +
                                                    " | Código: " + prendaTop.getCodigo() +
                                                    " | Marca: " + prendaTop.getMarca());
                                        }

                                    } else {
                                        System.out.println("Opción incorrecta");
                                    }

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