package factoryMethod;

import decorator.Bebida;
import decorator.Cafe;

public class CriadorCafe extends CriadorDeBebida {
    @Override
    public Bebida criarBebida() {
        return new Cafe();
    }
}
