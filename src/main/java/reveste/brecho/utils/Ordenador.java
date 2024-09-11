package reveste.brecho.utils;

import reveste.brecho.entity.Endereco;

import java.util.List;

public class Ordenador {

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
