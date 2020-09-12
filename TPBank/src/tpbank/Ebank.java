/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpbank;

import java.util.Random;
import java.util.ResourceBundle;

/**
 *
 * @author pc
 */
public class Ebank {
    Validation val = new Validation();
    public int menu() {
        System.out.println("1. Vietnamese\n"
                + "2. English\n"
                + "3. Exit");
        int choice = val.checkInt("enter your choice: ", 1, 3);
        return choice;
    }

    public String genCaptcha() {
        String s = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        Random r = new Random();
        String captcha = "";
        for (int i = 0; i < 5; i++) {
            int index = r.nextInt(s.length());
            captcha += s.charAt(index);
        }
        return captcha;
    }

    public void login(ResourceBundle bundle) {
        val.checkAccNumber(bundle);
        val.checkPass(bundle);
        val.checkCaptcha(bundle, genCaptcha());
        System.out.println(bundle.getString("login.success"));
    }
}
