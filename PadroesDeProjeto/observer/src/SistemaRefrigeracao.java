import javax.swing.*;

public class SistemaRefrigeracao implements Observer {

    public SistemaRefrigeracao(JTextArea textArea) {
    }

    public SistemaRefrigeracao() {
    }

    @Override
    public void update(double temperatura) { //observador 2
        if (temperatura > 30) {
            System.out.println("\nALERTA: Temperatura alta! Ativando sistema de refrigeração...");
        } else {
            System.out.println("\nSistema de Refrigeração: Temperatura estável.");
        }
    }
}