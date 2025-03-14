/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Singleton.Fila;
import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Aluno
 */
// Classe da Interface Gráfica
public class FilaClinicaGUI extends JFrame {
    
    private Fila fila; // Singleton da fila
    private JTextField campoNome;
    private JTextArea areaFila;

    public FilaClinicaGUI() {
        fila = Fila.getInstance(); // Obtendo instância única

        // Configuração da Janela
        setTitle("Fila da Clínica Médica");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

       
        JPanel painelSuperior = new JPanel();
        campoNome = new JTextField(15);
        JButton btnAdicionar = new JButton("Adicionar Paciente");
        painelSuperior.add(new JLabel("Nome:"));
        painelSuperior.add(campoNome);
        painelSuperior.add(btnAdicionar);

       
        areaFila = new JTextArea(10, 30);
        areaFila.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaFila);

        
        JPanel painelInferior = new JPanel();
        JButton btnChamar = new JButton("Chamar Próximo Paciente");
        painelInferior.add(btnChamar);

        
        add(painelSuperior, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(painelInferior, BorderLayout.SOUTH);

        
        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = campoNome.getText().trim();
                if (!nome.isEmpty()) {
                    fila.adicionarPaciente(nome);
                    campoNome.setText("");
                    atualizarFila();
                } else {
                    JOptionPane.showMessageDialog(null, "Digite um nome válido!");
                }
            }
        });

        
        btnChamar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pacienteChamado = fila.chamarProximoPaciente();
                if (pacienteChamado != null) {
                    JOptionPane.showMessageDialog(null, "Chamando paciente: " + pacienteChamado);
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum paciente na fila.");
                }
                atualizarFila();
            }
        });

        atualizarFila(); // Atualizar fila no início
    }

    // Atualiza o campo de texto com a fila atual
    private void atualizarFila() {
        areaFila.setText("Pacientes na fila:\n" + fila.exibirFila());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FilaClinicaGUI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
