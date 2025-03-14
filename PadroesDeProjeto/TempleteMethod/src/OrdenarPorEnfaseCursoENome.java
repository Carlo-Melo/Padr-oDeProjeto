import java.util.Comparator;
import java.util.List;

public class OrdenarPorEnfaseCursoENome extends OrdenacaoTemplate {
    public OrdenarPorEnfaseCursoENome(List<Aluno> alunos) {
        super(alunos);
    }

    @Override
    protected void ordenar() {
        alunos.sort(Comparator.comparing((Aluno a) -> a.enfase)
                .thenComparing(a -> a.curso)
                .thenComparing(a -> a.nome));
    }
}
