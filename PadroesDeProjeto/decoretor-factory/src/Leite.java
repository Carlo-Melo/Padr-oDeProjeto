import decorator.Bebida;
import decorator.BebidaDecorator;

public class Leite extends BebidaDecorator {
    public Leite(Bebida bebida) {
        super(bebida);
    }

    @Override
    public String getDescricao() {
        return bebida.getDescricao() + ", com Leite";
    }

    @Override
    public double custo() {
        return bebida.custo() + 1.50;
    }
}
