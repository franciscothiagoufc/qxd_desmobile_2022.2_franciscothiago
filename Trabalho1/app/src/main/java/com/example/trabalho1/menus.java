package com.example.trabalho1;
import com.example.trabalho1.customAdapter.pedido;
import com.example.trabalho1.customAdapter.pedidoAdapter;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Map;

public class menus extends Fragment {
    public menus() {
        // Required empty public constructor
    }
    private AutoCompleteTextView pedidos;
    private Spinner sobremesa;
    private Button adicionar;
    private ListView list;
    private ArrayList<pedido> dataset;
    private ArrayAdapter<pedido> listAdapter;
    private ArrayAdapter<String> pedidosAdpater;
    private ArrayAdapter<String> sobremesaAdpater;
    private boolean selected = false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        // Inflate the layout for this fragment
        Bundle args = new Bundle();
        this.setArguments(args);
        args.putBoolean("selected",false);

        View view = inflater.inflate(R.layout.fragment_menus, container, false);

        pedidos = view.findViewById(R.id.menu_pedidos);
        sobremesa = view.findViewById(R.id.menu_sobremesa);
        adicionar = view.findViewById(R.id.menu_adicionar);
        list = view.findViewById(R.id.menu_list);

        pedidosAdpater = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.pedidos));
        pedidos.setAdapter(pedidosAdpater);

        sobremesaAdpater = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.sobremesas));
        sobremesa.setAdapter(sobremesaAdpater);

        dataset = new ArrayList<pedido>();

        listAdapter = new ArrayAdapter<pedido>(this.getContext(),android.R.layout.simple_list_item_1,dataset);
        list.setAdapter(listAdapter);

        pedidos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                args.putBoolean("selected",true);
            }
        });

        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                if(args.getBoolean("selected")){
                    String p = pedidos.getText().toString();
                    String s = sobremesa.getSelectedItem().toString();
                    pedido data = new pedido(p,s);
                    dataset.add(data);
                    listAdapter.notifyDataSetChanged();
                }
            }
        });
        return view;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        dataset.clear();
        listAdapter.notifyDataSetChanged();
        return super.onOptionsItemSelected(item);
    }
}