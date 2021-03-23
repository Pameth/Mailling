package sn.isi.entities;

import java.io.Serializable;

public class Client implements Serializable {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String tel;

    //Constructors
    public Client() {
    }

    public Client(int id, String nom, String prenom, String email, String tel) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
    }

    //Getters and Setters

    public int getId() {
        return id;
    }

    public int setId(int id) {
        this.id = id;
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String setNom(String nom) {
        this.nom = nom;
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String setPrenom(String prenom) {
        this.prenom = prenom;
        return prenom;
    }


    public String getTel() {
        return tel;
    }

    public String setTel(String tel) {
        this.tel = tel;
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public String setEmail(String email) {
        this.email = email;
        return email;
    }

}
