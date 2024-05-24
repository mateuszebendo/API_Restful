package br.org.serratec.biblioteca.service;

import br.org.serratec.biblioteca.dtos.FakeStoreUserDtio;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClientRestService {
    public FakeStoreUserDtio  findUserByIdFromFakeApi(Integer idUser) {
        var restTemplate = new RestTemplate();
        String uri = "'https://fakestoreapi.com/users/{id}";

        Map<String, String> params = new HashMap<String, String>();
        params.put("id", idUser.toString());

        var dto = restTemplate.getForObject(uri, FakeStoreUserDtio.class, params);

        return dto;
    }
}
