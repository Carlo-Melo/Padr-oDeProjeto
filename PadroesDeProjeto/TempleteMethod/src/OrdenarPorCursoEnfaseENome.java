import java.util.Comparator;
import java.util.List;

public class OrdenarPorCursoEnfaseENome extends OrdenacaoTemplate {

    public OrdenarPorCursoEnfaseENome(List<Aluno> alunos) {
        super(alunos);
    }

    @Override
    protected void ordenar() {
        alunos.sort(Comparator.comparing((Aluno a) -> a.curso)
                .thenComparing(a -> a.enfase)
                .thenComparing(a -> a.nome));
    }
}
