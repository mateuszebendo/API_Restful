package br.org.serratec.biblioteca.service;

import br.org.serratec.biblioteca.entity.PerfilEntity;
import br.org.serratec.biblioteca.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PerfilService {

    @Autowired
    PerfilRepository perfilRepository;

    public PerfilEntity createPerfil(PerfilEntity perfil){
        return perfilRepository.save(perfil);
    }

    public PerfilEntity getPerfilById(UUID id){
        return perfilRepository.findById(id).orElse(null);
    }

    public List<PerfilEntity> getAllPerfil (){
        return perfilRepository.findAll();
    }

    public PerfilEntity modifyPerfil (PerfilEntity perfil){
        return perfilRepository.save(perfil);
    }

    public PerfilEntity deletePerfil(UUID id) {
        var perfil = perfilRepository.findById(id).orElse(null);
        try {
            perfilRepository.deleteById(id);
            if(perfil != null)
                return perfil;

        }catch(Exception e) {
            System.out.println(e);
        }
        return perfil;
    }
}
