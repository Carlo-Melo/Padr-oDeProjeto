import java.util.ArrayList;

public class SensorTemperatura { //sujeito

    private ArrayList<Observer> observers = new ArrayList<>();
    private float temperatura;

    public void adicionarObservador(Observer observer) {
        observers.add(observer);
    }

    public void removerObservador(Observer observer) {
        observers.remove(observer);
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
        notificarObservadores();
    }

    private void notificarObservadores() {
        for (Observer observer : observers) {
            observer.update(temperatura);
        }
    }
}
