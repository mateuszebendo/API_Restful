package br.org.serratec.academia.services;

import br.org.serratec.academia.entities.Telefone;
import br.org.serratec.academia.repositories.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelefoneService {

    @Autowired
    TelefoneRepository telefoneRepository;

    public Telefone save (Telefone telefone){
        return telefoneRepository.save(telefone);
    }

    public Telefone getById(Integer id){
        return telefoneRepository.findById(id).orElse(null);
    }

    public List<Telefone> getAll(){
        return telefoneRepository.findAll();
    }

    public Telefone update (Telefone telefone){
        return telefoneRepository.save(telefone);
    }

    public Telefone delete (Telefone telefone){
        var telefone0 = telefoneRepository.findById(telefone.getTelefoneId()).orElse(null);
        try {
            if(telefone0 != null)  telefoneRepository.delete(telefone);
        } catch (Exception e) {
            System.out.println(e);
        }
        return telefone0;
    }
}
