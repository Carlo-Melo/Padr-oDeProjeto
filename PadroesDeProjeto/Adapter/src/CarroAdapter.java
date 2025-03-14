public class CarroAdapter implements Carro {

    private CarroEletrico carroEletrico;

    public CarroAdapter(CarroEletrico carroEletrico) {
        this.carroEletrico = carroEletrico;
    }

    public CarroAdapter() {
    }

    @Override
    public void abastecer() {
        carroEletrico.recarregarBateria();
    }
}