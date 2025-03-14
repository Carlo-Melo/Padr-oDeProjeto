import java.util.Comparator;
import java.util.List;

public class OrdenarPorSituacaoENome extends OrdenacaoTemplate {
    public OrdenarPorSituacaoENome(List<Aluno> alunos) {
        super(alunos);
    }

    @Override
    protected void ordenar() {
        alunos.sort(Comparator.comparing((Aluno a) -> a.situacao).thenComparing(a -> a.nome));
    }
}
