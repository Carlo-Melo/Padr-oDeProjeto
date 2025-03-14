public class Aluno {
    String nome;
    String sobrenome;
    String situacao;
    String curso;
    String enfase;

    public Aluno(String nome, String sobrenome, String situacao, String curso, String enfase) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.situacao = situacao;
        this.curso = curso;
        this.enfase = enfase;
    }

    @Override
    public String toString() {
        return nome + " " + sobrenome + " | " + situacao + " | " + curso + " | " + enfase;
    }
}
