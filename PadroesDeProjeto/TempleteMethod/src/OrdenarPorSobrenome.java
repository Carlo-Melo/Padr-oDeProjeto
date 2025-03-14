import java.util.Comparator;
import java.util.List;

public class OrdenarPorSobrenome extends OrdenacaoTemplate {
    public OrdenarPorSobrenome(List<Aluno> alunos) {
        super(alunos);
    }

    @Override
    protected void ordenar() {
        alunos.sort(Comparator.comparing(a -> a.sobrenome));
    }
}
