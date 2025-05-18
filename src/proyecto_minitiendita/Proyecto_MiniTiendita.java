/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_minitiendita;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Kurtg
 */
public class Proyecto_MiniTiendita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        int opcion;
        double cajaAbierta = 0;
        double caja = 0;
        double banco = 0;

        double azucar = 0;
        double avena = 0;
        double trigo = 0;
        double maiz = 0;

        int totalVentas = 0;
        int totalCompras = 0;
        double volumenVentas = 0;
        double volumenCompras = 0;
        double gananciaTotal = 0;
        double compraMayor = 0;
        double ventaMayorGanancia = 0;
        String productoEstrella = "";
        double azucarVendida = 0;
        double avenaVendida = 0;
        double trigoVendido = 0;
        double maizVendido = 0;
        int primerCierre = 0;

        do {
            System.out.println("\n|------------------------------------|");
            System.out.println("  >>> MENU DE MINITIENDITA JAVA <<<");
            System.out.println("|------------------------------------|");
            System.out.println("|  [1] Abrir Caja                    |");
            System.out.println("|  [2] Ventas                        |");
            System.out.println("|  [3] Compras                       |");
            System.out.println("|  [4] Reportes                      |");
            System.out.println("|  [5] Cierre de caja                |");
            System.out.println("|  [6] Salir del sistema             |");
            System.out.println("|------------------------------------|");
            System.out.print("-> Ingrese su opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                //Abrir Caja
                case 1 -> {
                    cajaAbierta = 0;

                    totalVentas = 0;
                    totalCompras = 0;
                    volumenVentas = 0;
                    volumenCompras = 0;
                    gananciaTotal = 0;
                    compraMayor = 0;
                    ventaMayorGanancia = 0;
                    azucarVendida = 0;
                    avenaVendida = 0;
                    trigoVendido = 0;
                    maizVendido = 0;
                    productoEstrella = "";

                    if (cajaAbierta == 1) {
                        System.out.println("! - La caja ya esta abierta. - !");
                    } else {
                        System.out.println("\n|----------------------------------------|");
                        System.out.println("         >>> ABRIR CAJA <<<        ");
                        System.out.println("|----------------------------------------|");

                        if (primerCierre == 0) {
                            System.out.print(" -> Ingrese cantidad que desea agregar: ");
                            double agregar = sc.nextDouble();
                            if (agregar > 0) {
                                caja += agregar;
                                cajaAbierta = 1;
                                System.out.println("\n~ Dinero agregado. \n-> Total en caja: Lps. " + caja);
                            } else {
                                System.out.println("\n! - Cantidad invalida. - !");
                            }
                        } else {
                            cajaAbierta = 1;
                            System.out.println(">> Caja abierta nuevamente.\n-> Total en caja: Lps. " + caja);
                        }
                    }
}


                case 2 -> {
                    //Ventas
                     System.out.println("\n|-----------------------------------|");
                    System.out.println("         >>> VENTAS <<<        ");
                    System.out.println("|-----------------------------------|");
                    if (cajaAbierta == 0) {
                        System.out.println("\n! - Debe abrir la caja primero. - !");
                        break;
                    }

                    if (azucar + avena + trigo + maiz == 0) {
                        System.out.println("\n! - No hay productos en inventario para vender. Realice compras primero. - !");
                        break;
                    }

                    System.out.print("-> Ingrese tipo de cliente (A, B o C): ");
                    sc.nextLine();
                    String tipoCliente = sc.nextLine().toUpperCase();

                    double subtotal = 0;
                    String factura = "\n-------- FACTURA --------\nProducto   Cant   Precio   Total\n";

                    while (true) {
                        System.out.println("\n|------------------------------------------------||--------------------------------------|");
                        System.out.println("          >>> CODIGO DE CADA PRODUCTO <<<               >> ESTADO DEL INVENTARIO <<");
                        System.out.println("|------------------------------------------------||--------------------------------------|");
                        System.out.println(" >> Indicaciones: Tomar en cuenta las excepciones (tipo de cliente que no puede comprar  "
                                + "\n    dicho producto) de cada producto y si hay suficiente producto en inventario, porque"
                                + "\n    si no cumple lo pedido, se devolvera al menu principal.");
                        System.out.println("|------------------------------------------------||--------------------------------------|");
                        System.out.println("|  [1] Azucar (Lps. 30/kg) -> Expcecion: Tipo C  ||   -> Azucar: " + azucar + " kg                 |");
                        System.out.println("|  [2] Avena  (Lps. 25/kg) -> Excepcion: Tipo C  ||   -> Avena: " + avena + " kg                   |");
                        System.out.println("|  [3] Trigo  (Lps. 32/kg) -> Excepcion: Tipo C  ||   -> Trigo: " + trigo + " kg                    |");
                        System.out.println("|  [4] Maiz   (Lps. 20/kg) -> Excepcion: Tipo B  ||   -> Maiz: " + maiz + " kg                    |");
                        System.out.println("|------------------------------------------------||--------------------------------------|");
                        System.out.print("-> Codigo del producto: ");
                        int codigo = sc.nextInt();

                        double precio = 0;
                        String nombre = "";
                        double inventario = 0;

                        if ((tipoCliente.equals("A") && codigo >= 1 && codigo <= 4) || (tipoCliente.equals("B") && codigo >= 1 && codigo <= 3) || (tipoCliente.equals("C") && codigo == 4)) {

                            if (codigo == 1) {
                                precio = 30;
                                nombre = "Azucar";
                                inventario = azucar;
                            }
                            if (codigo == 2) {
                                precio = 25;
                                nombre = "Avena";
                                inventario = avena;
                            }
                            if (codigo == 3) {
                                precio = 32;
                                nombre = "Trigo";
                                inventario = trigo;
                            }
                            if (codigo == 4) {
                                precio = 20;
                                nombre = "Maiz";
                                inventario = maiz;
                            }
                            System.out.println(">> Producto que escogio: " + nombre + "\n>> Precio del producto: " + precio);
                            System.out.print("-> Cantidad (kg): ");
                            double kg = sc.nextDouble();

                            if (kg <= inventario && kg > 0) {
                                double total = precio * kg;
                                subtotal += total;
                                factura += nombre + "    " + kg + "   " + precio + "   " + total + "\n";

                                if (codigo == 1) {
                                    azucar -= kg;
                                    azucarVendida += kg;
                                }
                                if (codigo == 2) {
                                    avena -= kg;
                                    avenaVendida += kg;
                                }
                                if (codigo == 3) {
                                    trigo -= kg;
                                    trigoVendido += kg;
                                }
                                if (codigo == 4) {
                                    maiz -= kg;
                                    maizVendido += kg;
                                }
                            } else {
                                System.out.println("! - Inventario insuficiente o cantidad invalida. - !");
                            }
                        } else {
                            System.out.println("! - Cliente no autorizado para ese producto. - !");
                        }

                        System.out.print("-> Desea otro producto? (Si/No): ");
                        sc.nextLine();
                        if (sc.nextLine().equalsIgnoreCase("no")) {
                            break;
                        }
                    }

                    double descuento = 0;
                    if (subtotal > 5000) {
                        descuento = subtotal * 0.10;
                    } else if (subtotal >= 1000) {
                        descuento = subtotal * 0.05;
                    }

                    double impuesto = subtotal * 0.07;
                    double totalFinal = subtotal - descuento + impuesto;

                    factura += "------------------------------\n";
                    factura += "> Subtotal: " + subtotal + "\n";
                    factura += "> Descuento: " + descuento + "\n";
                    factura += "> Impuesto: " + impuesto + "\n";
                    factura += ">> TOTAL: " + totalFinal + "\n";
                    factura += "------------------------------\n";

                    System.out.println(factura);

                    
                    caja += totalFinal;
                    totalVentas++;
                    volumenVentas += totalFinal;
                    if ((totalFinal - impuesto + descuento) > ventaMayorGanancia) {
                        ventaMayorGanancia = totalFinal - impuesto + descuento;
                    }

                    gananciaTotal += (totalFinal - impuesto - descuento);
                
                    System.out.println("|--------------------------------------|");
                    System.out.println("       >> ESTADO DEL INVENTARIO <<");
                    System.out.println("|--------------------------------------|");
                    System.out.println("|   -> Azucar: " + azucar + " kg                 |");
                    System.out.println("|   -> Avena: " + avena + " kg                   |");
                    System.out.println("|   -> Trigo: " + trigo + " kg                   |");
                    System.out.println("|   -> Maiz: " + maiz + " kg                    |");
                    System.out.println("|   -> Caja: Lps. " + caja + "                |");
                }

                case 3 -> {
                    //Compras
                    System.out.println("\n|----------------------------------------|");
                    System.out.println("             >>> COMPRAS <<<        ");
                    System.out.println("|----------------------------------------|");
                    if (cajaAbierta == 0) {
                        System.out.println("! - Debe abrir la caja primero. - !");
                        break;
                    }

                    System.out.print("-> Ingrese tipo de proveedor (A, B o C): ");
                    String tipoProveedor = sc.next().toUpperCase();
                    
                     System.out.println("\n|----------------------------------------------------------------------|");
                        System.out.println("                   >>> CODIGO DE CADA PRODUCTO <<< ");
                        System.out.println("|---------------------------------------------------------------------|");
                        System.out.println(" >> Indicaciones: Tomar en cuenta las especificaciones (que proveedor "
                                + "\n    vende cada producto) segun el proveedor que escogio.");
                        System.out.println("|---------------------------------------------------------------------|");
                        System.out.println("| [1] Azucar (Lps. 25/kg)         -> Especificacion: Proveedor A      |");
                        System.out.println("| [2] Avena  (Lps. 20/kg o 22/kg) -> Especificacion: Proveedor B o C  |");
                        System.out.println("| [3] Trigo  (Lps. 30/kg)         -> Especificacion: Proveedor B      |");
                        System.out.println("| [4] Maiz   (Lps. 18/kg)         -> Especificacion: Proveedor A      |");
                        System.out.println("|---------------------------------------------------------------------|");
                        System.out.print("    -> Codigo del producto que desea comprar: ");
                        int codigo = sc.nextInt();

                    if ((tipoProveedor.equals("A") && (codigo == 1 || codigo == 4)) || (tipoProveedor.equals("B") && (codigo == 2 || codigo == 3)) || (tipoProveedor.equals("C") && codigo == 2)|| (tipoProveedor.equals("B") && codigo == 2)) {

                        double precio = 0;
                        String nombre = "";

                        if (codigo == 1) {
                            precio = 25;
                            nombre = "Azúcar";
                        }
                        if (codigo == 2) {
                            if (tipoProveedor.equals("B")){
                                precio = 20;
                                nombre = "Avena";
                            }else{
                                precio = 22;
                                nombre = "Avena";
                            }
                        }
                        if (codigo == 3) {
                            precio = 30;
                            nombre = "Trigo";
                        }
                        if (codigo == 4) {
                            precio = 18;
                            nombre = "Maiz";
                        }
                        
                        System.out.println("\n>> Tomar en cuenta dinero en caja: "+caja+"");
                        System.out.print("-> Cuantos kg desea comprar?: ");
                        double kg = sc.nextDouble();
                        double total = precio * kg;

                        if (kg > 0 && total <= caja) {
                            caja -= total;
                            totalCompras++;
                            volumenCompras += total;
                            if (total > compraMayor) {
                                compraMayor = total;
                            }

                            if (codigo == 1) {
                                azucar += kg;
                            }
                            if (codigo == 2) {
                                avena += kg;
                            }
                            if (codigo == 3) {
                                trigo += kg;
                            }
                            if (codigo == 4) {
                                maiz += kg;
                            }

                            System.out.println("\n>> Compra realizada exitosamente.");
                            System.out.println("|--------------------------------------|");
                            System.out.println("       >> ESTADO DEL INVENTARIO <<");
                            System.out.println("|--------------------------------------|");
                            System.out.println("|   -> Azucar: " + azucar + " kg                 |");
                            System.out.println("|   -> Avena: " + avena + " kg                   |");
                            System.out.println("|   -> Trigo: " + trigo + " kg                   |");
                            System.out.println("|   -> Maiz: " + maiz + " kg                    |");
                            System.out.println("|   -> Caja: Lps. " + caja+"                |");
                        } else {
                            System.out.println("! - No se puede pagar compra. - !");
                        }
                    } else {
                        System.out.println("! - Proveedor no vende dicho producto. - !");
                    }
                }

                case 4 -> {
                    //Reportes
                    System.out.println("\n|--------------------------------------------------------|");
                    System.out.println("                    >>> REPORTES <<< ");
                    System.out.println("|--------------------------------------------------------|");
                    if (cajaAbierta == 0) {
                        System.out.println("! - Debe abrir la caja primero. - !");
                        break;
                    }
                    System.out.println(">> Caja actual: Lps. " + caja);
                    System.out.println(">> Total ventas: " + totalVentas + " por Lps. " + volumenVentas);
                    System.out.println(">> Total compras: " + totalCompras + " por Lps. " + volumenCompras);
                    System.out.println(">> Ganancia neta: Lps. " + gananciaTotal);
                    if (totalCompras > 0) {
                        System.out.println(">> Valor medio de compra: Lps. " + (volumenCompras / totalCompras));
                    }
                    if (totalVentas > 0) {
                        System.out.println(">> Valor medio de venta: Lps. " + (volumenVentas / totalVentas));
                    }
                    System.out.println(">> Compra mas costosa: Lps. " + compraMayor);
                    System.out.println(">> Venta mas rentable: Lps. " + ventaMayorGanancia);
                    System.out.println(">> Estado de cuenta en banco: "+banco);

                    double mayor = azucarVendida;
                    productoEstrella = "Ninguno ha sido vendido";
                    if (azucarVendida >= mayor) {
                        mayor = azucarVendida;
                        productoEstrella = "Azucar";
                    }
                    if (avenaVendida > mayor) {
                        mayor = avenaVendida;
                        productoEstrella = "Avena";
                    }
                    if (trigoVendido > mayor) {
                        mayor = trigoVendido;
                        productoEstrella = "Trigo";
                    }
                    if (maizVendido > mayor) {
                        productoEstrella = "Maiz";
                    }

                    System.out.println(">> Producto estrella: " + productoEstrella);
                }

                case 5 -> {
                    //cierre de caja
                    System.out.println("\n|--------------------------------------------------------|");
                    System.out.println("                  >>> CIERRE DE CAJA <<< ");
                    System.out.println("|--------------------------------------------------------|");
                    if (cajaAbierta == 0) {
                        System.out.println("! - La caja ya esta cerrada. - !");
                    } else {
                        System.out.println(">> Cierre de caja.\n>> Total acumulado: Lps. " + caja);
                        System.out.print("-> Cuanto desea depositar al banco? (Max puede ingresar 60% que hay en caja): ");
                        double deposito = sc.nextDouble();
                        double maxDeposito = caja * 0.60;

                        if (deposito >= 0 && deposito <= maxDeposito) {
                            banco += deposito;
                            caja -= deposito;
                            cajaAbierta = 0;
                            primerCierre = 1;
                            System.out.println("\n>> Deposito realizado. \n>> Caja ahora tiene: Lps. " + caja);
                            System.out.println(">> Estado de cuenta en banco: "+banco);
                        } else {
                            System.out.println("! - Deposito invalido. No se cerro la caja, ingrese monto menor al 60%. - !");
                        }
                    }
                }

                case 6 ->
                    //Salir del sistema
                    System.out.println(">> Gracias por usar la Mini Tienda Java, esperamos verte pronto :]");
                default ->
                    System.out.println("! - Opcion invalida. - !");
            }
        } while (opcion != 6);
    }
}
