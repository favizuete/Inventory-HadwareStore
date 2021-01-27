/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import espe.edu.ec.filemanagerlibrary.FileManager;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class CustomerRegistry {

    Validation validate = new Validation();
    Scanner scanner = new Scanner(System.in);

    public void enterCustomer() {

        String nameCustomer, purchasedProduct, address, mail;
        int phoneNumber, id;
        float totalDebt;

        do {
            System.out.println("Ingrese el nombre del cliente: ");
            nameCustomer = scanner.nextLine();

            System.out.println("Ingrese dirección: ");
            address = scanner.nextLine();

            System.out.println("Ingrese el número de telefono del cliente: ");
            phoneNumber = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese email del cliente: ");
            mail = scanner.nextLine();

            System.out.println("Ingrese el número de cédula o ruc del cliente: ");
            id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese el producto adquirido");
            purchasedProduct = scanner.nextLine();

            System.out.println("Deuda del cliente");
            totalDebt = scanner.nextFloat();
            scanner.nextLine();

            Customer customer = new Customer(nameCustomer, address, phoneNumber, mail, id, purchasedProduct, totalDebt);

            try {
                recordCustomer("Customer.json", customer);
            } catch (Exception e) {
            }
        } while ("yes".equals(validate.getYesOrNo("Agregar nuevo cliente?[si/no]: ")));

    }

    public static void saveRecord(String fileName, Gson gson, ArrayList<Customer> customers) {
        FileManager.deleteFile(fileName);
        FileManager.writeFile(fileName, gson.toJson(customers));
    }

    public boolean recordCustomer(String fileName, Customer customer) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ArrayList<Customer> customers = new ArrayList<>();
        FileManager.createFile(fileName);
        String customersJson = new String(Files.readAllBytes(Paths.get(fileName)));
        if (gson.fromJson(customersJson, ArrayList.class) != null) {
            customers = gson.fromJson(customersJson, ArrayList.class);
        }
        customers.add(customer);
        saveRecord(fileName, gson, customers);
        return true;
    }
}
