package com.example.trabalho2;

import android.service.quicksettings.Tile;

import java.io.Serializable;

public class Book implements Serializable {
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
            this.title = title;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public void setId(int id){ this.id = id;}
    public String toString(){
        //return "Id: " + Integer.toString(id) + " Título " + title + " Autor " + autor + " Preço " + Double.toString(price);
        return Integer.toString(id) + ":  " + title + " - " + autor + " - R$" + Double.toString(price);
    }
    private String autor;
    private double price;
    private String title;
    private int id;

    public Book(String title,String autor,double price,int id){
        this.setAutor(autor);
        this.setTitle(title);
        this.setPrice(price);
        this.setId(id);
    }
}
