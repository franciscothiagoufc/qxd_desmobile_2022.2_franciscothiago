package com.example.trabalho2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//http://mobimais.com.br/blog/recyclerview-android-tutorial-facil/
public class BooksAdapater extends RecyclerView.Adapter<BooksAdapater.BooksViewHolder>{
    private ArrayList<Book> Books;
    public HashMap<Integer,ACTIONS> actions; // Cada item pode ser editado ou excluido
    public HashMap<Integer,Book> editions; // Caso o item esteja marcado para ser editado, esse hash map armazena a edição
    public BooksAdapater(Context context, ArrayList<Book> Books){
        this.Books = Books;
        actions = new HashMap<Integer,ACTIONS>();
        editions = new HashMap<Integer,Book>();
    }
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_book_item,parent,false);
        return new BooksViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, int position) {
        int id = holder.getAdapterPosition();
        Book book = Books.get(holder.getAdapterPosition());
        holder.title.setText(Books.get(holder.getAdapterPosition()).getTitle());
        holder.autor.setText(Books.get(holder.getAdapterPosition()).getAutor());
        holder.price.setText(Double.toString(Books.get(holder.getAdapterPosition()).getPrice()));
        holder.id.setText(Integer.toString(Books.get(holder.getAdapterPosition()).getId()));
        holder.action.setText("");
        holder.exclude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.action.setText("Item será excluido.");
                actions.put(Books.get(holder.getAdapterPosition()).getId(),ACTIONS.REMOVE);
                Log.w("EdtActivity","Excluir "+Books.get(holder.getAdapterPosition()).getId());
            }
        });
        holder.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.action.setText("Item será editado.");
                String title = Books.get(holder.getAdapterPosition()).getTitle();
                String autor = holder.autor.getText().toString();
                Double price;
                try {
                    price = Double.parseDouble(holder.price.getText().toString());
                }
                catch(Exception e) {
                    price = 0.0;
                }
                Book book = new Book(title,autor,price,holder.getAdapterPosition());
                actions.put(Books.get(holder.getAdapterPosition()).getId(),ACTIONS.EDIT);
                editions.put(Books.get(holder.getAdapterPosition()).getId(),book);
                Log.w("EdtActivity","Editar "+Integer.toString(id));

                //BooksAdapater.this.notifyDataSetChanged();
            }
        });
        if(actions.keySet().contains(Books.get(holder.getAdapterPosition()).getId()) && actions.get(Books.get(holder.getAdapterPosition()).getId()) == ACTIONS.EDIT)
            holder.action.setText("Item será editado.");
        else if(actions.keySet().contains(Books.get(holder.getAdapterPosition()).getId()) && actions.get(Books.get(holder.getAdapterPosition()).getId()) == ACTIONS.REMOVE)
            holder.action.setText("Item será excluido.");
    }

    @Override
    public int getItemCount() {
        return Books.size();
    }

    protected class BooksViewHolder extends RecyclerView.ViewHolder{
        protected TextView title;
        protected EditText price;
        protected EditText autor;
        protected Button save;
        protected Button exclude;
        protected TextView id;
        protected TextView action;
        public BooksViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.item_title);
            price=itemView.findViewById(R.id.item_price);
            autor=itemView.findViewById(R.id.item_autor);
            save=itemView.findViewById(R.id.item_save);
            exclude=itemView.findViewById(R.id.item_exclude);
            id=itemView.findViewById(R.id.item_id);
            action=itemView.findViewById(R.id.item_action);
        }
    }
}


