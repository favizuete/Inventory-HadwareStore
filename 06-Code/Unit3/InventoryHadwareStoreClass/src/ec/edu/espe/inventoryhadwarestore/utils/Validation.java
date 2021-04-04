/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.utils;

import java.util.Scanner;

/**
 *
 * @author Fausto Vizuete
 */
public class Validation {

    Scanner string = new Scanner(System.in);

    public String getYesOrNo(String question) {

        String data = "";
        while (data.equals("")) {
            System.out.println(question);
            data = string.nextLine();
            if (!"si".equals(data) & !"no".equals(data)) {
                data = "";
            }
        }
        return data;
    }

}
