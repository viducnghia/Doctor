/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor;

import java.util.ArrayList;

/**
 *
 * @author MSI
 */
public class Menu extends ArrayList<String> {

    private Checker ck = new Checker();

    public int printOut() {
        int chose;
        while (true) {
            for (int i = 0; i < this.size(); i++) {
                System.out.println((i + 1) + ". " + this.get(i));
            }
            chose = Integer.parseInt(ck.checkInputByRegex("[0-9]+", "You must enter a number"));
            if (chose <= this.size() + 1) {
                return chose;
            } else {
                System.out.println("You must enter a number form 1 to" + this.size());
            }
        }
    }
}
