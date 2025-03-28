import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    public static void criarGUI(SensorTemperatura sensor) {
        JFrame frame = new JFrame("Monitor de Temperatura");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Área de texto para logs
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Painel inferior para entrada e botão
        JPanel panel = new JPanel();
        JTextField tempField = new JTextField(5);
        JButton btnAtualizar = new JButton("Atualizar Temperatura");

        panel.add(new JLabel("Temperatura:"));
        panel.add(tempField);
        panel.add(btnAtualizar);

        // Criando os observadores e adicionando ao sensor
        Observer gerenciador = new GerenciadorTemperatura(textArea);
        Observer refrigeracao = new SistemaRefrigeracao(textArea);



        // Evento do botão
        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    float temperatura = Float.parseFloat(tempField.getText());
                    textArea.append("\n🌡 Ajustando temperatura para " + temperatura + "°C...\n");
                    sensor.setTemperatura(temperatura);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Digite um número válido!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Adicionando componentes ao frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
