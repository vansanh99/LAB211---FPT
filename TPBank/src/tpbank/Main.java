/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpbank;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author pc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ebank e = new Ebank();
        int choice = e.menu();
        switch (choice) {
            case 1: {
//                Locale vi_Locale = new Locale("vi", "VN");
                ResourceBundle vi_bundle = ResourceBundle.getBundle("language_vi_VN"/*, vi_Locale*/);
                e.login(vi_bundle);
                break;
            }
            case 2: {
//                Locale en_Locale = new Locale("en", "US");
                ResourceBundle en_bundle = ResourceBundle.getBundle("language_en_US"/*, en_Locale*/);
                e.login(en_bundle);
                break;
            }
            case 3:
        }
    }

}
