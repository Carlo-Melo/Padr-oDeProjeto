import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainGUI().createAndShowGUI());
    }

    public void createAndShowGUI() {
        // Criar a janela principal
        JFrame frame = new JFrame("Ordenação de Alunos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // Criar painel de controle
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Criar JComboBox para selecionar critério de ordenação
        String[] opcoes = {
                "1 - Nome", "2 - Sobrenome", "3 - Situação e Nome",
                "4 - Curso e Nome", "5 - Ênfase e Nome",
                "6 - Curso, Ênfase e Nome", "7 - Ênfase, Curso e Nome"
        };
        JComboBox<String> comboBox = new JComboBox<>(opcoes);
        panel.add(comboBox);

        // Botão para aplicar a ordenação
        JButton ordenarButton = new JButton("Ordenar");
        panel.add(ordenarButton);

        // TextArea para exibir os alunos
        JTextArea textArea = new JTextArea(15, 40);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Adicionar o painel e o JScrollPane ao frame
        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Carregar os alunos
        List<Aluno> alunos = LeitorCSV.lerCSV("TempleteMethod/src/RelatorioDasEnfases.csv");

        // Ação do botão Ordenar
        ordenarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcao = comboBox.getSelectedIndex() + 1;  // O índice do JComboBox começa em 0
                OrdenacaoTemplate ordenacao = null;

                switch (opcao) {
                    case 1 -> ordenacao = new OrdenarPorNome(alunos);
                    case 2 -> ordenacao = new OrdenarPorSobrenome(alunos);
                    case 3 -> ordenacao = new OrdenarPorSituacaoENome(alunos);
                    case 4 -> ordenacao = new OrdenarPorCursoENome(alunos);
                    case 5 -> ordenacao = new OrdenarPorEnfaseENome(alunos);
                    case 6 -> ordenacao = new OrdenarPorCursoEnfaseENome(alunos);
                    case 7 -> ordenacao = new OrdenarPorEnfaseCursoENome(alunos);
                    default -> JOptionPane.showMessageDialog(frame, "Opção inválida!");
                }

                if (ordenacao != null) {
                    ordenacao.ordenarEExibir();
                    StringBuilder sb = new StringBuilder();
                    for (Aluno aluno : alunos) {
                        sb.append(aluno).append("\n");
                    }
                    textArea.setText(sb.toString());
                }
            }
        });

        // Exibir a janela
        frame.setVisible(true);
    }
}
