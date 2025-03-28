import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SensorTemperatura sensor = new SensorTemperatura();

        Observer gerenciador = new GerenciadorTemperatura();
        Observer refrigeração = new SistemaRefrigeracao();

        sensor.adicionarObservador(gerenciador);
        sensor.adicionarObservador(refrigeração);

        System.out.println("Ajustando temperatura para 25°C...");
        sensor.setTemperatura(25);

        System.out.println("\nAjustando temperatura para 35°C...");
        sensor.setTemperatura(35);

        sensor.removerObservador(gerenciador);
        SwingUtilities.invokeLater(() -> GUI.criarGUI(sensor));
    }
}