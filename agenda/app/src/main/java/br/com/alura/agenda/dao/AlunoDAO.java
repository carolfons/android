package br.com.alura.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.model.Aluno;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();
    private static int contador = 1;

    public void salva(Aluno aluno) {
        aluno.setId(contador);
        alunos.add(aluno);
        atualizaIds();
    }

    private void atualizaIds() {
        contador++;
    }

    public void editaAluno(Aluno aluno) {
        Aluno alunoEncontrado = buscaAlunoPeloId(aluno);
        if (alunoEncontrado != null) {
            int posicao = alunos.indexOf(alunoEncontrado);
            alunos.set(posicao, aluno);
        }
    }

    private Aluno buscaAlunoPeloId(Aluno aluno) {
        Aluno alunoEncontrado = null;
        for (Aluno a : alunos) {
            if (a.getId() == aluno.getId()) {
                return a;
            }
        }
        return null;
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }

    public void removeAluno(Aluno aluno) {
        Aluno alunoRetornado = buscaAlunoPeloId(aluno);
        if(alunoRetornado != null){
            alunos.remove(alunoRetornado);
        }

    }
}
