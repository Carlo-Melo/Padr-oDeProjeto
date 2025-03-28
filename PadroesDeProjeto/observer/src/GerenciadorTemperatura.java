import javax.swing.*;

public class GerenciadorTemperatura implements Observer {

    public GerenciadorTemperatura() {
    }

    public GerenciadorTemperatura(JTextArea textArea) {
    }

    @Override
    public void update(double temperatura) { // observador 1
        System.out.println("Temperatura atualizada para " + temperatura + "°C.");
    }
}
