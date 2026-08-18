/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca;

/**
 *
 * @author luisj
 */
public class Book extends Material {
    
    private String author;
    private String available;

    public Book(String code, String title, String publicationYear, String author, String available) {
        super(code, title, publicationYear);
        this.author = author;
        this.available = available;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }
    
    @Override
    public String toString() {
        return super.toString() +
               " | Author: " + author +
               " | Available: " + available;
        
    }
       
}
