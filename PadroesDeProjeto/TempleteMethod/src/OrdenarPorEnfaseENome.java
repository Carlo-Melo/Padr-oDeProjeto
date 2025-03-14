import java.util.Comparator;
import java.util.List;

public class OrdenarPorEnfaseENome extends OrdenacaoTemplate {
    public OrdenarPorEnfaseENome(List<Aluno> alunos) {
        super(alunos);
    }

    @Override
    protected void ordenar() {
        alunos.sort(Comparator.comparing((Aluno a) -> a.enfase).thenComparing(a -> a.nome));
    }
}
