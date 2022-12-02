package br.com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.DataUtil;
import br.com.alura.aluraviagens.util.DiasUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;
import br.com.alura.aluraviagens.util.ResourceUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo do pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle(TITULO_APPBAR);

        //binding dos dados
        Pacote pacoteSp = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        mostraLocal(pacoteSp);
        mostraImagem(pacoteSp);
        mostraDias(pacoteSp);
        mostraPreco(pacoteSp);
        mostraData(pacoteSp);

    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.tv_data);
        String dataFormatadaDaViagem = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(dataFormatadaDaViagem);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.tv_preco);
        String moedaBrasileira = MoedaUtil
                .formataParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }


    private void mostraDias(Pacote pacote) {
        TextView dias = findViewById(R.id.tv_dias);
        String diasEmTexto = DiasUtil.formataEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }

    private void mostraImagem(Pacote pacoteSp) {
        ImageView img = findViewById(R.id.iv_imagem_local);
        Drawable drawableDoPacote = ResourceUtil.devolveDrawable(this, pacoteSp.getImagem());
        img.setImageDrawable(drawableDoPacote);
    }

    private void mostraLocal(Pacote pacoteSp) {
        TextView local = findViewById(R.id.tv_local);
        local.setText(pacoteSp.getLocal());
    }
}