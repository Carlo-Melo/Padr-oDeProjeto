import java.io.*;
import java.util.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Aluno> alunos = LeitorCSV.lerCSV("TempleteMethod/src/RelatorioDasEnfases.csv");
        String caminhoArquivo = "TempleteMethod/src/RelatorioDasEnfases.csv"; // Caminho relativo ao projeto
        File arquivo = new File(caminhoArquivo);

        if (arquivo.exists()) {
            System.out.println("✅ O arquivo existe no caminho: " + arquivo.getAbsolutePath());
        } else {
            System.out.println("❌ O arquivo NÃO foi encontrado! Verifique o caminho.");
        }

        System.out.println("Escolha o critério de ordenação:");
        System.out.println("1 - Nome");
        System.out.println("2 - Sobrenome");
        System.out.println("3 - Situação e Nome");
        System.out.println("4 - Curso e Nome");
        System.out.println("5 - Ênfase e Nome");
        System.out.println("6 - Curso, Ênfase e Nome");
        System.out.println("7 - Ênfase, Curso e Nome");
        int opcao = scanner.nextInt();

        OrdenacaoTemplate ordenacao = null;
        switch (opcao) {
            case 1 -> ordenacao = new OrdenarPorNome(alunos);
            case 2 -> ordenacao = new OrdenarPorSobrenome(alunos);
            case 3 -> ordenacao = new OrdenarPorSituacaoENome(alunos);
            case 4 -> ordenacao = new OrdenarPorCursoENome(alunos);
            case 5 -> ordenacao = new OrdenarPorEnfaseENome(alunos);
            case 6 -> ordenacao = new OrdenarPorCursoEnfaseENome(alunos);
            case 7 -> ordenacao = new OrdenarPorEnfaseCursoENome(alunos);
            default -> System.out.println("Opção inválida!");
        }

        if (ordenacao != null) {
            ordenacao.ordenarEExibir();
        }
        System.out.println(alunos);

    }
}
