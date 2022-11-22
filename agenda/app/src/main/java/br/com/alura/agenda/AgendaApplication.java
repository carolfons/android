package br.com.alura.agenda;

import android.app.Application;

import br.com.alura.agenda.dao.AlunoDAO;
import br.com.alura.agenda.model.Aluno;

public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosTeste();

    }

    private void criaAlunosTeste() {
        AlunoDAO dao = new AlunoDAO();
        dao.salva(new Aluno("Caroline","(12)9 9103-1964","carolfonseca@gmail.com"));
        dao.salva(new Aluno("Victória","(15)9 8877-0527","carolfonseca@gmail.com"));
    }
}
