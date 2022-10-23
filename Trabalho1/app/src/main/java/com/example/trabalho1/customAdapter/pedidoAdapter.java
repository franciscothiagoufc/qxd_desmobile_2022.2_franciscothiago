package com.example.trabalho1.customAdapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class pedidoAdapter extends BaseAdapter {
    public void setDataset(ArrayList<pedido> dataset) {
        this.dataset = dataset;
    }

    ArrayList<pedido> dataset;
    @Override
    public int getCount() {
        return dataset.size();
    }

    @Override
    public Object getItem(int i) {
        return dataset.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
