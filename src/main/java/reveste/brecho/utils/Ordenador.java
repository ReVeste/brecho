package reveste.brecho.utils;

import reveste.brecho.entity.Endereco;

import java.util.List;

public class Ordenador {

    // selectionSortOtimizado
    public static int[] ordenarPorEndereco(int[] enderecos){
        for (int i = 0; i < enderecos.length -1; i++) {
            int indiceMenor = i;
            for (int j = i+1; j < enderecos.length; j++) {
                if (enderecos[j] < enderecos[indiceMenor]){ // Se inverter o sinal, inverte a ordem da lista
                    indiceMenor = j;
                }
            }
            int aux = enderecos[i];
            enderecos[i] = enderecos[indiceMenor];
            enderecos[indiceMenor] = aux;
        }
        return enderecos;
    }

    public static void ordenarPorLogradouro(List<Endereco> enderecos) {
        for (int i = 0; i < enderecos.size() - 1; i++) {
            int indMenor = i;
            for (int j = i + 1; j < enderecos.size(); j++) {
                if (enderecos.get(j).getLogradouro().compareToIgnoreCase(enderecos.get(indMenor).getLogradouro()) < 0) {
                    indMenor = j;
                }
            }
            Endereco temp = enderecos.get(indMenor);
            enderecos.set(indMenor, enderecos.get(i));
            enderecos.set(i, temp);
        }
    }

}
