import decorator.Bebida;
import factoryMethod.CriadorCafe;
import factoryMethod.CriadorCha;
import factoryMethod.CriadorDeBebida;


public class Main {
    public static void main(String[] args) {


        CriadorDeBebida fabricaCafe = new CriadorCafe();
        Bebida cafe = fabricaCafe.criarBebida();
        cafe = new Leite(cafe);
        cafe = new Chantilly(cafe);
        System.out.println(cafe.getDescricao() + " - R$ " + cafe.custo());
        CriadorDeBebida fabricaCha = new CriadorCha();
        Bebida cha = fabricaCha.criarBebida();
        cha = new Acucar(cha);
        cha = new Leite(cha);
        System.out.println(cha.getDescricao() + " - R$ " + cha.custo());

    }
}