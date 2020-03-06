/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor;

import java.util.Date;

/**
 *
 * @author MSI
 */
public class Doctor implements Comparable<Doctor> {

    private int id;
    private String name;
    private String bod;
    private String specialization;
    private String availability;
    private String email;
    private String mobile;

    public Doctor() {
    }

    public Doctor(int id, String name, String bod, String specialization, String availability, String email, String mobile) {
        this.id = id;
        this.name = name;
        this.bod = bod;
        this.specialization = specialization;
        this.availability = availability;
        this.email = email;
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBod() {
        return bod;
    }

    public void setBod(String bod) {
        this.bod = bod;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Doctor{" + "id=" + id + ", name=" + name + ", bod=" + bod + ", specialization=" + specialization + ", availability=" + availability + ", email=" + email + ", mobile=" + mobile + '}';
    }

    @Override
    public int compareTo(Doctor o) {
        Date d1 = new Date(this.getBod());
        Date d2 = new Date(o.getBod());
        boolean i = d1.before(d2);
        return d1.compareTo(d2);
    }

}
