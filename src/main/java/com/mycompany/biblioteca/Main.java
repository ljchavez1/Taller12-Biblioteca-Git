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
    static ArrayList<Book> books = new ArrayList<>();
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
    
    public static Client findClient (String id){
        for (Client client : clients) {
            if (client.getId().equals(id)){
                return client;
            }
        }
        return null;
    }
    
    public static void updateClient (String id) {
        
        Client client = findClient(id);
        
        if (client == null){
            System.out.println("client not found.");
            return;
        }
        
        System.out.println("Enter new name");
        String name = sc.nextLine();

        System.out.println("Enter new phone");
        String phone = sc.nextLine();

        System.out.println("Enter new email");
        String email = sc.nextLine();

        client.setName(name);
        client.setPhone(phone);
        client.setEmail(email);
        
        System.out.println("Client updated successfully");   
    }
    
    public static void deleteClient (String id){
        
        Client client = findClient(id);
        
        if(client==null){
            System.out.println("Client not found.");
            return;
        }
        
        clients.remove(client);
        
        System.out.println("Client deleted successfully");
    }
    
    public static void createBook() {

        System.out.println("Enter code");
        String code = sc.nextLine();

        System.out.println("Enter title");
        String title = sc.nextLine();

        System.out.println("Enter publication year");
        String publicationYear = sc.nextLine();

        System.out.println("Enter author");
        String author = sc.nextLine();

        Book book = new Book(code, title, publicationYear, author, true);

        books.add(book);

        System.out.println("Book created successfully.");
    }
    
    
    
    
    public static void main(String[] args) {
        
    }


}
