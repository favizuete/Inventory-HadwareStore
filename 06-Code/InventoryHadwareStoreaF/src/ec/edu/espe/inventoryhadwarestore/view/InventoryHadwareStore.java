/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.view;

import ec.edu.espe.inventoryhadwarestore.model.CustomerRegistry;
import ec.edu.espe.inventoryhadwarestore.model.ProductRegistry;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Fausto Vizuete ESPE-DCCO
 */
public class InventoryHadwareStore {

    public static void main(String[] args) throws IOException {

        ProductRegistry product = new ProductRegistry();
        CustomerRegistry customer = new CustomerRegistry();
        Scanner scan = new Scanner(System.in);

        int opc;

        do {
            System.out.println("\t****INVENTARIO FERRETERIA****");
            System.out.println("1. INGRESAR PRODUCTO");
            System.out.println("2. VER STOCK");
            System.out.println("3. GENERAR FACTURA");
            System.out.println("0. SALIR");
            System.out.print("ESCOJA UNA OPCION: ");
            opc = scan.nextInt();
            System.out.println("   ");
            switch (opc) {
                case 1:
                    System.out.println("\t****INGRESO DE PRODUCTOS****");
                    product.enterAProduct();
                    break;
                case 2:
                    System.out.println("\t****STOCK****");
                    product.showProducts();
                    break;
                case 3:
                    System.out.println("\t****FACTURA****");
                    customer.enterCustomer();
                    break;
                case 0:
                    System.out.println("\t**GRACIAS POR USAR MI PROGRAMA....!!**0"
                            + "");
                    break;
                default:
                    System.out.println("OPCION INCORRECTA");

            }

        } while (opc != 0);
    }
}
