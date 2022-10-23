package com.example.trabalho2;

import static com.example.trabalho2.CODES.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    private Button edtButton;
    private EditText add_book_title;
    private EditText add_book_price;
    private Button add_book;

    private Intent editActivityIntent;
    private BooksDAO Books;
    private ArrayAdapter<Book> adapter;
    private ListView list_books;
    private Bundle Args;
    private View.OnClickListener edtButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivityForResult(editActivityIntent,CODES.edit);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Books = new BooksDAO();

        edtButton = findViewById(R.id.edt_button);
        list_books = findViewById(R.id.list_books);
        add_book = findViewById(R.id.add_book);
        add_book_title = findViewById(R.id.add_book_title);
        add_book_price = findViewById(R.id.add_book_price);

        adapter = new ArrayAdapter<Book>(this, android.R.layout.simple_spinner_dropdown_item,Books.getBooks());
        list_books.setAdapter(adapter);

        edtButton.setOnClickListener(edtButtonListener);
        add_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = add_book_title.getText().toString();
                Double price;
                try {
                    price = Double.parseDouble(add_book_price.getText().toString());
                }
                catch(Exception e) {
                    price = 0.0;
                }
                Books.addBook(title,"",price);
                adapter.notifyDataSetChanged();
            }
        });

        editActivityIntent = new Intent(MainActivity.this,EditActivity.class);
        adapter.notifyDataSetChanged();
        Args = new Bundle();

        Args.putSerializable("Books",(Serializable) Books);
        editActivityIntent.putExtra("Args",Args);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode == CODES.OK){
            adapter.notifyDataSetChanged();
        }
        else if(resultCode == CODES.finished){

        }
    }
}