package com.example.trabalho2;

import java.io.Serializable;
import java.util.ArrayList;

public class BooksDAO  implements Serializable {
    private static ArrayList<Book> Books;
    private static int Index;
    public BooksDAO(){
        Books = new ArrayList<Book>();
        Index = 0;
    }
    public void addBook(String titulo,String autor,Double price) {
        Book book = new Book(titulo,autor,price,Index++);
        Books.add(book);
    }
    public void edtBook(String titulo,String autor,Double price,int id) {
        for (Book book : Books){
            if(book.getId() == id){
                book.setTitle(titulo);
                book.setAutor(autor);
                book.setPrice(price);
                break;
            }
        }
    }
    public void removeBook(int id){
        //Books.remove(position);
        for (Book book : Books){
            if(book.getId() == id){
                Books.remove(book);
                break;
            }
        }
    }
    public ArrayList<Book> getBooks(){
        return Books;
    }
}
