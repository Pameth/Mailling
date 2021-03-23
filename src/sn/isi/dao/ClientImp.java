package sn.isi.dao;

import sn.isi.entities.Client;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientImp implements IClient{

    private DB db = new DB();
    ResultSet rset;
    private int ok;
    Scanner sc = new Scanner(System.in);
    String rep = null;

    @Override
    public int add(Client c) throws Exception {
        do {
        System.out.println("---------------------");
        System.out.println("-- AJOUT --");
        System.out.println("---------------------");
        System.out.println("Entrer le Prenom du Client");
        c.setPrenom(sc.nextLine());
        System.out.println("Entrer le nom du Client");
        c.setNom(sc.nextLine());
        System.out.println("Entrer l' Email du Client");
        c.setEmail(sc.nextLine());
        System.out.println("Entrer le tel du Client");
        c.setTel(sc.nextLine());
        //requete prepare de l'insertion
        String sql = "INSERT INTO client VALUES (null, ?, ?, ?, ?)";
        db.init(sql);
        db.getPstm().setString(1,c.getNom());
        db.getPstm().setString(2,c.getPrenom());
        db.getPstm().setString(3,c.getEmail());
        db.getPstm().setString(4,c.getTel());
        //execution de la requete Insert
        ok = db.executeMaj();
        db.close();
           System.out.println("voulez vous continuez? :O/N");
            rep =sc.nextLine();
        }while (rep.equalsIgnoreCase("O") );
        return ok;
    }

    @Override
    public int update(Client c) throws Exception {
                String sql = "UPDATE client SET nom = ?, prenom = ?, email = ?, tel = ? WHERE id = ?";
                db.init(sql);
                    System.out.printf("Entrez l'ID à modifier:");
                    db.getPstm().setInt(5, c.setId(Integer.parseInt(sc.nextLine())));
                    System.out.println("---------------------");
                    System.out.println("-- EDITION --");
                    System.out.println("---------------------");
                    System.out.printf("NOM :");
                    db.getPstm().setString(1, c.setNom(sc.nextLine()));
                    System.out.printf("PRENOM :");
                    db.getPstm().setString(2, c.setPrenom(sc.nextLine()));
                    System.out.printf("EMAIL :");
                    db.getPstm().setString(3, c.setEmail(sc.nextLine()));
                    System.out.printf("TEL :");
                    db.getPstm().setString(4, c.setTel(sc.nextLine()));

                    System.out.println(ok + "update");
        ok = db.executeMaj();
        return ok;
    }

    @Override
    public Client getClient(String email) throws Exception {
        System.out.println("---------------------");
        System.out.println("-- RECHERCHE --");
        System.out.println("---------------------");
        Client c = new Client();
            System.out.println("EMAIL :");
            String newEmail = (sc.nextLine());
            System.out.println("------------------------");
            String sql = "SELECT * FROM client WHERE email = ?";
            db.init(sql);
            db.getPstm().setString(1, newEmail);
            rset = db.executeSelect();
            if (rset.next()) {
                //récuperer le client a partir de la base
                c.setId(rset.getInt(1));
                c.setNom(rset.getString(2));
                c.setPrenom(rset.getString(3));
                c.setEmail(rset.getString(4));
                c.setTel(rset.getString(5));
            }
            System.out.println("ID :"+c.getId());
            System.out.println("NOM :"+c.getNom());
            System.out.println("PRENOM :"+c.getPrenom());
            System.out.println("TEL :"+c.getTel());
        return c;
    }

    @Override
    public List<Client> liste() throws Exception {
        System.out.println("---------------------");
        System.out.println("-- LISTE --");
        System.out.println("---------------------");
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM client ORDER BY id";
        db.init(sql);
        rset = db.executeSelect();
        while (rset.next()){
            //instancier le client
            Client c = new Client();
            //recuperer et afficher les clients de la base
            System.out.println("----------------------------------------");
            System.out.println("ID: "+c.setId(rset.getInt(1)));
            System.out.println("NOM: "+c.setNom(rset.getString(2)));
            System.out.println("PRENOM: "+c.setPrenom(rset.getString(3)));
            System.out.println("EMAIL: "+c.setEmail(rset.getString(4)));
            System.out.println("TEL: "+ c.setTel(rset.getString(5)));
            System.out.println("----------------------------------------");
        }
        return clients;
    }
}
