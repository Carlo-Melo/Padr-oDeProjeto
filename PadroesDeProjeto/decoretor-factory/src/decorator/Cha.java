package decorator;

public class Cha implements Bebida {
    @Override
    public String getDescricao() {
        return "Chá";
    }

    @Override
    public double custo() {
        return 5;
    }
}
