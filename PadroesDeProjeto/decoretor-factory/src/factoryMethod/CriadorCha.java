package factoryMethod;

import decorator.Bebida;
import decorator.Cha;

public class CriadorCha extends CriadorDeBebida {
    @Override
    public Bebida criarBebida() {
        return new Cha();
    }
}
