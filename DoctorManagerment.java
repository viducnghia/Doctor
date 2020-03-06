/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author MSI
 */
public class DoctorManagerment extends ArrayList<Doctor> {

    private Checker ck = new Checker();

    public void addDump() {
        Doctor d = new Doctor(1, "d1", "10/10/2010", "2da", "1", "f@g.com", "0987654321");
        this.add(d);
        Doctor w = new Doctor(2, "d2", "10/10/2020", "2da", "1", "f@g.com", "0987654321");
        this.add(w);
        Doctor a = new Doctor(3, "d3", "10/10/2009", "2da", "1", "f@g.com", "0987654321");
        this.add(a);
    }

    public void addDoctor() {
        Doctor d = new Doctor();
        if (this.isEmpty()) {
            d.setId(1);
        } else {
            d.setId(lastId() + 1);
        }

        System.out.println("Enter name: ");
        d.setName(ck.checkLength(50));
        System.out.println("Enter Date of birth: ");
        d.setBod(ck.checkDate("dd/MM/yyyy"));
        System.out.println("Enter specialization: ");
        d.setSpecialization(ck.checkLength(225));
        System.out.println("Enter availability: ");
        d.setAvailability(ck.checkInputByRegex("[0-3]", "You must enter 0,1,2,3"));
        System.out.println("Enter email: ");
        d.setEmail(ck.checkInputByRegex("[A-Z0-9]{1,}+@[A-Z0-9]{1,}+[(\\.+[A-Z]{1,})]{1,}", "You must enter email validate"));
        System.out.println("Enter phone number: ");
        d.setMobile(ck.checkInputByRegex("[0-9]{10}", "You must enter a number with length is 10"));
        this.add(d);
    }

    public void edit() {
        int location = search();
        if (location == -1) {
            return;
        }

        System.out.println("Do you want edit name: ");
        if (ck.checkYOrN()) {
            System.out.println("Enter name: ");
            this.get(location).setName(ck.checkLength(50));
        }

        System.out.println("Do you want edit Date of birth: ");
        if (ck.checkYOrN()) {
            System.out.println("Enter Date of birth: ");
            this.get(location).setBod(ck.checkDate("dd/MM/yyyy"));
        }

        System.out.println("Do you want edit specialization: ");
        if (ck.checkYOrN()) {
            System.out.println("Enter specialization: ");
            this.get(location).setSpecialization(ck.checkLength(225));
        }

        System.out.println("Do you want edit availability: ");
        if (ck.checkYOrN()) {
            System.out.println("Enter availability: ");
            this.get(location).setAvailability(ck.checkInputByRegex("[0-3]", "You must enter 0,1,2,3"));
        }

        System.out.println("Do you want edit email: ");
        if (ck.checkYOrN()) {
            System.out.println("Enter email: ");
            this.get(location).setEmail(ck.checkInputByRegex("[A-Z0-9]{1,}+@[A-Z0-9]{1,}+[(\\.+[A-Z]{1,})]{1,}", "You must enter email validate"));
        }

        System.out.println("Do you want edit number: ");
        if (ck.checkYOrN()) {
            System.out.println("Enter phone number: ");
            this.get(location).setMobile(ck.checkInputByRegex("[0-9]{10}", "You must enter a number with length is 10"));
        }

        System.out.println(this.get(location).toString());
    }

    public void delete() {
        int location = search();
        if (location == -1) {
            return;
        }
        this.remove(location);
    }

    public int search() {
        System.out.println("Do you want find by id(i) or name(n)");
        String type = ck.checkInputByRegex("[I|N]", "You must enter i or n"), find = "";
        if (type.toUpperCase().equals("I")) {
            System.out.println("Enter id you want to find: ");
            find = ck.checkInputByRegex("[0-9]+", "You must enter a number");
            for (int i = 0; i < this.size(); i++) {
                if (this.get(i).getId() == Integer.parseInt(find)) {
                    System.out.println(this.get(i).toString());
                    return i;
                }
            }
        } else {
            System.out.println("Enter name you want to find: ");
            find = ck.checkLength(50);
            for (int i = 0; i < this.size(); i++) {
                if (this.get(i).getName().equals(find)) {
                    System.out.println(this.get(i).toString());
                    return i;
                }
            }
        }
        System.out.println("Can't find this doctor");
        return -1;

    }

    public void softDoctor() {
        System.out.println("Before:");
        info();
        Collections.sort(this);
        System.out.println("After:");
        info();
    }

    public void info() {
        this.forEach((d) -> {
            System.out.println(d.toString());
        });
    }

    private int lastId() {
        int max = 0;
        for (Doctor doctor : this) {
            if (max < doctor.getId()) {
                max = doctor.getId();
            }
        }
        return max;
    }
}
