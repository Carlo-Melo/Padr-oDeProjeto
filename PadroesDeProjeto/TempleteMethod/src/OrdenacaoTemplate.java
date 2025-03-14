import java.util.List;

public abstract class OrdenacaoTemplate {
    protected List<Aluno> alunos;

    public OrdenacaoTemplate(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    // Template Method (definição do fluxo fixo)
    public final void ordenarEExibir() {
        ordenar();
        exibirLista();
    }

    // Método abstrato para que cada classe concreta implemente seu critério de ordenação
    protected abstract void ordenar();

    // Exibir alunos ordenados
    private void exibirLista() {
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }
}
