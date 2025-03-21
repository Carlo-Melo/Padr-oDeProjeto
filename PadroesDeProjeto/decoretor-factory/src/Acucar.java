import decorator.Bebida;
import decorator.BebidaDecorator;

public class Acucar extends BebidaDecorator {
    public Acucar(Bebida bebida) {
        super(bebida);
    }

    @Override
    public String getDescricao() {
        return bebida.getDescricao() + ", com Açúcar";
    }

    @Override
    public double custo() {
        return bebida.custo() + 0.50;
    }
}