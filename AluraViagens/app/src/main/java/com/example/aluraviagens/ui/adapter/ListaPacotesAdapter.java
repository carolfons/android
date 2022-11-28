package com.example.aluraviagens.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.aluraviagens.R;
import com.example.aluraviagens.model.Pacote;

import java.util.List;


public class ListaPacotesAdapter extends BaseAdapter {
    private List<Pacote>pacotes;
    private Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context){
        this.pacotes = pacotes;
        this.context=context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int position) {
        return pacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       View viewCriada =  LayoutInflater.from(context).inflate(R.layout.item_pacote,parent,false );
        return null;
    }
}
