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
import br.com.alura.aluraviagens.util.DiasUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;
import br.com.alura.aluraviagens.util.ResourceUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle("Resumo do Pacote");

        //binding dos dados
        Pacote pacoteSp = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        TextView local = findViewById(R.id.tv_local);
        local.setText(pacoteSp.getLocal());

        ImageView img = findViewById(R.id.iv_imagem_local);
        Drawable drawableDoPacote = ResourceUtil.devolveDrawable(this, pacoteSp.getImagem());
        img.setImageDrawable(drawableDoPacote);

        TextView dias = findViewById(R.id.tv_dias);
        String diasEmTexto = DiasUtil.formataEmTexto(pacoteSp.getDias());
        dias.setText(diasEmTexto);

        TextView preco = findViewById(R.id.tv_preco);
        String moedaBr = MoedaUtil.formataParaBrasileiro(pacoteSp.getPreco());
        preco.setText(moedaBr);

        TextView data = findViewById(R.id.tv_data);
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE,pacoteSp.getDias());
        SimpleDateFormat formatoBr = new SimpleDateFormat("dd/MM");

        String dataFormatadaIda = formatoBr.format(dataIda.getTime());
        String dataFormatadaVolta = formatoBr.format(dataVolta.getTime());
        String dataFormatadaDaViagem = dataFormatadaIda + " - "
                +dataFormatadaVolta + " de "
                +dataVolta.get(Calendar.YEAR);
        data.setText(dataFormatadaDaViagem);
    }
}