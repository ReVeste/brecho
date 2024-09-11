package reveste.brecho.service;

import org.springframework.web.client.RestTemplate;
import reveste.brecho.entity.Endereco;

import java.util.Arrays;
import java.util.List;

public class ViaCepService {

    public static List<Endereco> buscarPorEndereco(String estado, String cidade, String logradouro) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("https://viacep.com.br/ws/%s/%s/%s/json/", estado, cidade, logradouro);

        Endereco[] enderecos = restTemplate.getForObject(url, Endereco[].class);
        return Arrays.asList(enderecos);
    }

}
