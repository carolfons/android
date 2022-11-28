package com.example.aluraviagens.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.aluraviagens.dao.PacoteDAO;
import com.example.aluraviagens.R;
import com.example.aluraviagens.model.Pacote;
import com.example.aluraviagens.ui.adapter.ListaPacotesAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listaDePacotes = findViewById(R.id.lv_lista_pacotes);

        List<Pacote> pacotes = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes,this));

    }
}