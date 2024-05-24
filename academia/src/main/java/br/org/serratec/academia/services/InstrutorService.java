package br.org.serratec.academia.services;

import br.org.serratec.academia.entities.Instrutor;
import br.org.serratec.academia.repositories.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrutorService {

    @Autowired
    InstrutorRepository instrutorRepository;

    public Instrutor save (Instrutor instrutor){
        return instrutorRepository.save(instrutor);
    }

    public Instrutor getById(Integer id){
        return instrutorRepository.findById(id).orElse(null);
    }

    public List<Instrutor> getAll(){
        return instrutorRepository.findAll();
    }

    public Instrutor update (Instrutor instrutor){
        return instrutorRepository.save(instrutor);
    }

    public Instrutor delete (Instrutor instrutor){
        var instrutor0 = instrutorRepository.findById(instrutor.getInstrutorID()).orElse(null);
        try {
            if(instrutor0 != null)  instrutorRepository.delete(instrutor);
        } catch (Exception e) {
            System.out.println(e);
        }
        return instrutor0;
    }

}
