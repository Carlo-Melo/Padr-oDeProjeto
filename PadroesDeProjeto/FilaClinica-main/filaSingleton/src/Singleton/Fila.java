package Singleton;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Carlos
 */

//classe singleton
public class Fila {
    
    private static Fila instanciaUnica;// variavel estatica
    private Queue<String> filaPacientes;
    
    //construtor privado para impedir a criação de novas instâncias
    private Fila() {
        filaPacientes = new LinkedList<>();
    }
    
    //metodo estático para obter a única instância da classe
    public static Fila getInstance() {
        if (instanciaUnica == null) {
            instanciaUnica = new Fila();
        }
        return instanciaUnica;
    }
    
    public void adicionarPaciente(String nome){
        filaPacientes.add(nome);
        System.out.println(nome+" foi adicionado na fila.");
    }
    
    //chamar próximo paciente da fila
    public String chamarProximoPaciente() {
        return filaPacientes.poll();
    }
    
    //metodo para exibir os pacientes na fila
    public String exibirFila() {
        return filaPacientes.isEmpty() ? "Fila vazia" : filaPacientes.toString();
    }
}
