package main;

import sn.isi.dao.ClientImp;
import sn.isi.dao.DB;
import sn.isi.dao.IClient;
import sn.isi.entities.Client;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
       int rep = 0;
        Scanner sc = new Scanner(System.in);
        Client c = new Client();
        boolean b = false;
        do {
            System.out.println("        |------------------------------------------------------|");
            System.out.println("        |---------------    1. CREATION          --------------|");
            System.out.println("        |---------------    2. EDITION           --------------|");
            System.out.println("        |---------------    3. VISUALISATION     --------------|");
            System.out.println("        |---------------    4. RECHERCHE         --------------|");
            System.out.println("        |---------------    5. QUITTER           --------------|");
            System.out.println("        |------------------------------------------------------|");
            System.out.println("Veuillez choisir un numero:");
            rep =Integer.parseInt(sc.nextLine());
            DB db = new DB();
            IClient clientdao = new ClientImp();
                switch (rep){
                    case 1:
                        clientdao.add(c);
                        break;
                    case 2:
                        clientdao.update(c);
                        break;
                    case 3:
                        List<Client> clients = clientdao.liste();
                        break;
                    case 4:
                        clientdao.getClient(c.getEmail());
                        break;
                        case 5:
                            System.out.println("bye !");
                        break;
                    default:
                        System.out.println("numero invalide !");
                }
            if (b == false){
                do {
                    System.out.println("        |------------------------------------------------------|");
                    System.out.println("        |---------------    1. CREATION          --------------|");
                    System.out.println("        |---------------    2. EDITION           --------------|");
                    System.out.println("        |---------------    3. VISUALISATION     --------------|");
                    System.out.println("        |---------------    4. RECHERCHE         --------------|");
                    System.out.println("        |------------------------------------------------------|");
                    System.out.println("Veuillez choisir un numero:");
                    rep =Integer.parseInt(sc.nextLine());
                    switch (rep){
                        case 1:
                            clientdao.add(c);
                            break;
                        case 2:
                            clientdao.update(c);
                            break;
                        case 3:
                            clientdao.liste();
                            break;
                        case 4:
                            clientdao.getClient(c.getEmail());
                            break;
                        default:
                            System.out.println("numero invalide !");
                    }
                }while (b == true);
            }
            }while (b == true);
    }
}
