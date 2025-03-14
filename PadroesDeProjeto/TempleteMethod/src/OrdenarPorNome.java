import java.util.List;

public class OrdenarPorNome extends OrdenacaoTemplate {
    public OrdenarPorNome(List<Aluno> alunos) {
        super(alunos);
    }

    @Override
    protected void ordenar() {
        int n = alunos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (alunos.get(j).nome.compareTo(alunos.get(j + 1).nome) > 0) {
                    Aluno temp = alunos.get(j);
                    alunos.set(j, alunos.get(j + 1));
                    alunos.set(j + 1, temp);
                }
            }
        }
    }
}