/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author luisj
 */
public class Main {

    static ArrayList<Client> clients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    
    public static void createClient() {

        System.out.println("Enter ID");
        String id = sc.nextLine();

        System.out.println("Enter name");
        String name = sc.nextLine();

        System.out.println("Enter phone");
        String phone = sc.nextLine();

        System.out.println("Enter email");
        String email = sc.nextLine();

        Client client = new Client(id, name, phone, email);
        clients.add(client);

        System.out.println("Client created successfully.");
        

    }
    
    public static void listClients () {
        for (Client client : clients) {
            System.out.println(client);    
        }
    }
    
    public static void main(String[] args) {
        
    }


}
