/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor;

/**
 *
 * @author MSI
 */
public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.add("Add doctor");
        menu.add("Edit doctor");
        menu.add("Delete doctor");
        menu.add("Find doctor");
        menu.add("Sort list");
        menu.add("Exit system");
        int chose;
        DoctorManagerment dm= new DoctorManagerment();
        dm.addDump();          
        while (true) {
            chose=menu.printOut();
            switch (chose) {
                case 1:
                    dm.addDoctor();
                    break;
                case 2:
                    dm.edit();
                    break;
                case 3:
                    dm.delete();
                    break;
                case 4:
                    dm.search();
                    break;
                case 5:
                    dm.softDoctor();
                    break;
                default:
                    return;
            }
        }

    }
}
