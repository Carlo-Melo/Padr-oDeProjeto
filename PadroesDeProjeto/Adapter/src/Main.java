public class Main {
    public static void main(String[] args) {

        CarroCombustao combustao = new CarroCombustao();
        CarroEletrico eletrico = new CarroEletrico();
        CarroAdapter adapter = new CarroAdapter(eletrico);
        adapter.abastecer();
        combustao.abastecer();

    }
}
