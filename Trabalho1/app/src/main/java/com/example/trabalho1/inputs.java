package com.example.trabalho1;

import com.example.trabalho1.customAdapter.profissional;
import com.example.trabalho1.customAdapter.profissionalAdpater;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class inputs extends Fragment {
    public inputs() {
        // Required empty public constructor
    }
    ArrayList<profissional> dataset;
    profissionalAdpater adpater;
    RecyclerView recycler;
    LinearLayoutManager manager;
    EditText nome;
    AutoCompleteTextView profissao;
    RadioGroup experiencia;
    Switch empregado;
    Button adicionar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inputs, container, false);
        dataset = new ArrayList<profissional>();

        adpater = new profissionalAdpater(dataset);
        GridLayoutManager manager = new GridLayoutManager(this.getContext(),2);
        recycler = view.findViewById(R.id.rv_func);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(adpater);

        nome = view.findViewById(R.id.edt_func_nome);
        profissao = view.findViewById(R.id.edt_func_profissao);
        empregado = view.findViewById(R.id.switch_func_empregado);
        experiencia = view.findViewById(R.id.rdg_func_experiencia);
        adicionar = view.findViewById(R.id.btn_func_add);

        ArrayAdapter<String> profissoesAdapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.profissoes));
        profissao.setAdapter(profissoesAdapter);
        
        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view_listener) {
                profissional p = new profissional("Nome","Profissão",false,"1 ano de experiência");
                if(!nome.getText().toString().equals(""))
                    p.setNome(nome.getText().toString());
                if(!profissao.getText().toString().equals(""))
                    p.setProfissao(profissao.getText().toString());
                if(experiencia.getCheckedRadioButtonId() != -1){
                    RadioButton selected = view.findViewById(experiencia.getCheckedRadioButtonId());
                    p.setExperiencia(selected.getText().toString()+" de experiência");
                }
                p.setEmpregado(empregado.isChecked());
                dataset.add(p);
                adpater.notifyDataSetChanged();
            }
        });
        return view;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        dataset.clear();
        adpater.notifyDataSetChanged();
        return super.onOptionsItemSelected(item);
    }
}