package com.example.trabalho1.customAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabalho1.R;

import java.util.ArrayList;

public class profissionalAdpater extends RecyclerView.Adapter<profissionalAdpater.ViewHolder> {
    @NonNull
    private ArrayList<profissional> dataset;
    public profissionalAdpater(@NonNull ArrayList<profissional> dataset) {
        this.dataset = dataset;
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.funcionario_item,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        profissional p = dataset.get(position);
        holder.getNome().setText(p.getNome());
        String dados = p.getProfissao() + " " + p.getExperiencia() + " ";
        if(p.isEmpregado())
            dados += "Empregado";
        else
            dados += "Desempregado";
        holder.dados.setText(dados);
        holder.deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profissionalAdpater.this.dataset.remove(holder.getAdapterPosition());
                profissionalAdpater.this.notifyDataSetChanged();
            }
        });
    }
    @Override
    public int getItemCount() {
        return dataset.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView getNome() {
            return nome;
        }
        public TextView getDados() {
            return dados;
        }
        public Button getDeletar() {
            return deletar;
        }
        private TextView nome;
        private TextView dados;
        private Button deletar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.nome = itemView.findViewById(R.id.rcl_prof_nome) ;
            this.dados = itemView.findViewById(R.id.rcl_prof_dados) ;;
            this.deletar = itemView.findViewById(R.id.rcl_prof_deletar)  ;
        }
    }
}
