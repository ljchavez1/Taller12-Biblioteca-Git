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
    static ArrayList<Loan> loans = new ArrayList<>();
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
    
    public static void listBooks() {

        for (Book book : books) {
            System.out.println(book);
        }

    }
    
    public static Book findBook(String code) {

        for (Book book : books) {
            if (book.getCode().equals(code)) {
                return book;
            }
        }

        return null;
    }

    public static void updateBook(String code) {

        Book book = findBook(code);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        System.out.println("Enter new title");
        String title = sc.nextLine();

        System.out.println("Enter new publication year");
        String publicationYear = sc.nextLine();

        System.out.println("Enter new author");
        String author = sc.nextLine();

        book.setTitle(title);
        book.setPublicationYear(publicationYear);
        book.setAuthor(author);

        System.out.println("Book updated successfully.");
    }

    public static void deleteBook(String code) {

        Book book = findBook(code);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        books.remove(book);

        System.out.println("Book deleted successfully.");
    }
    
    public static void createLoan() {

        System.out.print("Enter loan ID: ");
        String loanId = sc.nextLine();

        System.out.print("Enter client ID: ");
        String clientId = sc.nextLine();

        Client client = findClient(clientId);

        if (client == null) {
            System.out.println("Client not found.");
            return;
        }

        System.out.print("Enter book code: ");
        String bookCode = sc.nextLine();

        Book book = findBook(bookCode);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!book.getAvailable()) {
            System.out.println("Book is not available.");
            return;
        }

        Loan loan = new Loan(
                loanId,
                client,
                book,
                java.time.LocalDate.now(),
                "ACTIVE"
        );

        loans.add(loan);

        book.setAvailable(false);

        System.out.println("Loan created successfully.");
    }
    
    public static Loan findLoan(String loanId) {

        for (Loan loan : loans) {
            if (loan.getLoanId().equals(loanId)) {
                return loan;
            }
        }

        return null;
    }
    
    public static void returnLoan(String loanId) {

        Loan loan = findLoan(loanId);

        if (loan == null) {
            System.out.println("Loan not found.");
            return;
        }

        loan.setStatus("RETURNED");
        loan.getBook().setAvailable(true);

        System.out.println("Loan returned successfully.");
    }

    public static void listLoans() {

        for (Loan loan : loans) {
            if (loan.getStatus().equals("ACTIVE")) {
                System.out.println(loan);
            }
        }
    }

    public static void main(String[] args) {
        int option;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Client management");
            System.out.println("2. Book management");
            System.out.println("3. Loan management");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1:

                    int clientOption;

                    do {
                        System.out.println("\n===== CLIENT MANAGEMENT =====");
                        System.out.println("1. Create client");
                        System.out.println("2. List clients");
                        System.out.println("3. Find client");
                        System.out.println("4. Update client");
                        System.out.println("5. Delete client");
                        System.out.println("0. Back");
                        System.out.print("Choose an option: ");

                        clientOption = Integer.parseInt(sc.nextLine());

                        switch (clientOption) {

                            case 1:
                                createClient();
                                break;

                            case 2:
                                listClients();
                                break;

                            case 3:
                                System.out.print("Enter client ID: ");
                                String clientId = sc.nextLine();

                                Client client = findClient(clientId);

                                if (client == null) {
                                    System.out.println("Client not found.");
                                } else {
                                    System.out.println(client);
                                }
                                break;

                            case 4:
                                System.out.print("Enter client ID: ");
                                String updateId = sc.nextLine();
                                updateClient(updateId);
                                break;

                            case 5:
                                System.out.print("Enter client ID: ");
                                String deleteId = sc.nextLine();
                                deleteClient(deleteId);
                                break;

                            case 0:
                                System.out.println("Returning to main menu.");
                                break;

                            default:
                                System.out.println("Invalid option.");
                        }

                    } while (clientOption != 0);

                    break;

                case 2:

                    int bookOption;

                    do {
                        System.out.println("\n===== BOOK MANAGEMENT =====");
                        System.out.println("1. Create book");
                        System.out.println("2. List books");
                        System.out.println("3. Find book");
                        System.out.println("4. Update book");
                        System.out.println("5. Delete book");
                        System.out.println("0. Back");
                        System.out.print("Choose an option: ");

                        bookOption = Integer.parseInt(sc.nextLine());

                        switch (bookOption) {

                            case 1:
                                createBook();
                                break;

                            case 2:
                                listBooks();
                                break;

                            case 3:
                                System.out.print("Enter book code: ");
                                String bookCode = sc.nextLine();

                                Book book = findBook(bookCode);

                                if (book == null) {
                                    System.out.println("Book not found.");
                                } else {
                                    System.out.println(book);
                                }
                                break;

                            case 4:
                                System.out.print("Enter book code: ");
                                String updateCode = sc.nextLine();
                                updateBook(updateCode);
                                break;

                            case 5:
                                System.out.print("Enter book code: ");
                                String deleteCode = sc.nextLine();
                                deleteBook(deleteCode);
                                break;

                            case 0:
                                System.out.println("Returning to main menu.");
                                break;

                            default:
                                System.out.println("Invalid option.");
                        }

                    } while (bookOption != 0);

                    break;

                case 3:

                    int loanOption;

                    do {
                        System.out.println("\n===== LOAN MANAGEMENT =====");
                        System.out.println("1. Create loan");
                        System.out.println("2. Return loan");
                        System.out.println("3. List active loans");
                        System.out.println("0. Back");
                        System.out.print("Choose an option: ");

                        loanOption = Integer.parseInt(sc.nextLine());

                        switch (loanOption) {

                            case 1:
                                createLoan();
                                break;

                            case 2:
                                System.out.print("Enter loan ID: ");
                                String loanId = sc.nextLine();
                                returnLoan(loanId);
                                break;

                            case 3:
                                listLoans();
                                break;

                            case 0:
                                System.out.println("Returning to main menu.");
                                break;

                            default:
                                System.out.println("Invalid option.");
                        }

                    } while (loanOption != 0);

                    break;

                case 0:
                    System.out.println("Goodbye.");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (option != 0);
    }

}
