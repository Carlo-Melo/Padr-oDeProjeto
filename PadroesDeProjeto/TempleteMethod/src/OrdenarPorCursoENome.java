import java.util.Comparator;
import java.util.List;

public class OrdenarPorCursoENome extends OrdenacaoTemplate {
    public OrdenarPorCursoENome(List<Aluno> alunos) {
        super(alunos);
    }

    @Override
    protected void ordenar() {
        alunos.sort(Comparator.comparing((Aluno a) -> a.curso).thenComparing(a -> a.nome));
    }
}