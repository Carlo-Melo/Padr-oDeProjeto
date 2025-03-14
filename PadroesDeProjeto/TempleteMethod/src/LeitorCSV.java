import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorCSV {
    public static List<Aluno> lerCSV(String caminhoArquivo) {
        List<Aluno> alunos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 5) {
                    Aluno aluno = new Aluno(dados[0].trim(), dados[1].trim(), dados[2].trim(), dados[3].trim(), dados[4].trim());
                    alunos.add(aluno);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return alunos;
    }
}
