import decorator.Bebida;
import decorator.BebidaDecorator;

public class Chantilly extends BebidaDecorator {
    public Chantilly(Bebida bebida) {
        super(bebida);
    }

    @Override
    public String getDescricao() {
        return bebida.getDescricao() + ", com Chantilly";
    }

    @Override
    public double custo() {
        return bebida.custo() + 2.00;
    }
}