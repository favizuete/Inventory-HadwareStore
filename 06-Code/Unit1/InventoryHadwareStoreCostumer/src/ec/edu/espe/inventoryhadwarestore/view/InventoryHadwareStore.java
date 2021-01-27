/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.view;

import ec.edu.espe.inventoryhadwarestore.model.ProductRegistry;
import ec.edu.espe.inventoryhadwarestore.model.Stock;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Fausto Vizuete ESPE-DCCO
 */
public class InventoryHadwareStore {

    public static void main(String[] args) throws IOException {

        ProductRegistry product = new ProductRegistry();
        Stock stocks = new Stock();
        Scanner scan = new Scanner(System.in);

        int opc;

        do {
            System.out.println("\t****INVENTARIO FERRETERIA****");
            System.out.println("1. INGRESAR PRODUCTO");
            System.out.println("2. VER STOCK");
            System.out.println("0. SALIR");
            System.out.print("ESCOJA UNA OPCION: ");
            opc = scan.nextInt();
            System.out.println("   ");
            switch (opc) {
                case 1:
                    product.enterAProduct();
                    break;
                case 2:
                    System.out.println(product.toString());
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
