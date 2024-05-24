package br.org.serratec.academia.services;

import br.org.serratec.academia.entities.Turma;
import br.org.serratec.academia.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    @Autowired
    TurmaRepository turmaRepository;

    public Turma save (Turma turma){
        return turmaRepository.save(turma);
    }

    public Turma getById(Integer id){
        return turmaRepository.findById(id).orElse(null);
    }

    public List<Turma> getAll(){
        return turmaRepository.findAll();
    }

    public Turma update (Turma turma){
        return turmaRepository.save(turma);
    }

    public Turma delete (Turma turma){
        var turma0 = turmaRepository.findById(turma.getTurmaId()).orElse(null);
        try {
            if(turma0 != null)  turmaRepository.delete(turma);
        } catch (Exception e) {
            System.out.println(e);
        }
        return turma0;
    }
}
