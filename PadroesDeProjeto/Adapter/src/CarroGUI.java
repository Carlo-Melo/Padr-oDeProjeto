import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarroGUI extends JFrame {
    private JButton btnAbastecerCombustao;
    private JButton btnAbastecerEletrico;

    public CarroGUI() {
        setTitle("Padrão Adapter - Carros");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        CarroCombustao carroCombustao = new CarroCombustao();
        CarroEletrico carroEletrico = new CarroEletrico();
        CarroAdapter carroAdapter = new CarroAdapter(carroEletrico);


        btnAbastecerCombustao = new JButton("Abastecer Carro a Combustão");
        btnAbastecerEletrico = new JButton("Carregar Carro Elétrico");


        btnAbastecerCombustao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carroCombustao.abastecer();
            }
        });

        btnAbastecerEletrico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carroAdapter.abastecer();
            }
        });


        setLayout(new GridLayout(2, 1));
        add(btnAbastecerCombustao);
        add(btnAbastecerEletrico);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CarroGUI tela = new CarroGUI();
            tela.setVisible(true);
        });
    }
}