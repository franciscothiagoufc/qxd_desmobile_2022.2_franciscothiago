package com.example.trabalho2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.io.Serializable;
import java.util.ArrayList;

public class EditActivity extends AppCompatActivity {
    private BooksDAO Books;
    private ArrayList<Book> Editions;
    private RecyclerView edt_view;
    private LinearLayoutManager layout;
    private BooksAdapater adapter;

    private Button save_all;
    private Button cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Books = (BooksDAO) getIntent().getBundleExtra("Args").getSerializable("Books");

        edt_view = findViewById(R.id.edt_livros);
        //add_book = findViewById(R.id.add_book);
        //add_book_title = findViewById(R.id.add_book_title);
        save_all = findViewById(R.id.save_all);
        cancel = findViewById(R.id.cancel);

        layout = new  LinearLayoutManager(this);
        edt_view.setLayoutManager(layout);
        adapter = new BooksAdapater(this,Books.getBooks());
        edt_view.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        save_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(Integer id : adapter.actions.keySet()){
                    Log.w("EdtActivity","Analisando "+Integer.toString(id));
                    if(adapter.actions.get(id) == ACTIONS.REMOVE){
                        Books.removeBook(id);
                        Log.w("EdtActivity","Excluindo "+Integer.toString(id));
                    }
                    else if(adapter.actions.get(id) == ACTIONS.EDIT){
                        Book book = adapter.editions.get(id);
                        Books.edtBook(book.getTitle(),book.getAutor(),book.getPrice(),book.getId());
                        Log.w("EdtActivity","Alterando "+Integer.toString(id));
                    }
                }
                Intent intent = new Intent();
                setResult( CODES.OK, intent );
                finish();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult( CODES.finished, intent );
                finish();
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();

    }
}