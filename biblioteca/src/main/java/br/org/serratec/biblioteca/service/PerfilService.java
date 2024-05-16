package br.org.serratec.biblioteca.service;

import br.org.serratec.biblioteca.dtos.PerfilResumidoDto;
import br.org.serratec.biblioteca.entity.PerfilEntity;
import br.org.serratec.biblioteca.repository.PerfilRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PerfilService {

    @Autowired
    PerfilRepository perfilRepository;

    @Autowired
    private ModelMapper modelMapper;

    public PerfilEntity createPerfil(PerfilEntity perfil){
        return perfilRepository.save(perfil);
    }

    public PerfilEntity getPerfilById(UUID id){
//        return perfilRepository.findById(id).orElse(null);
        return perfilRepository.findById(id).get();
    }

    public PerfilResumidoDto getPerfilResumidoById(UUID id){
        var perfil = perfilRepository.findById(id).orElse(null);
        var perfilDto = modelMapper.map(perfil, PerfilResumidoDto.class);
//        if(perfil != null)
//        try {
            perfilDto = modelMapper.map(perfil, PerfilResumidoDto.class);
//        } catch(IllegalArgumentException e){
//            throw new IllegalArgumentException("Ocorreu uma exceção: ", e);
//        }
        return perfilDto;
    }

    public List<PerfilEntity> getAllPerfil (){
        return perfilRepository.findAll();
    }

    public List<PerfilResumidoDto> getAllPerfilResumido (){
        List<PerfilEntity> perfis = perfilRepository.findAll();
        List<PerfilResumidoDto> perfisDto = new ArrayList<>();

        for(PerfilEntity perfilControle : perfis){
            var perfilDto = new PerfilResumidoDto();
            perfilDto.setNome(perfilControle.getNome());
            perfilDto.setDescricao(perfilControle.getDescricao());
            perfisDto.add(perfilDto);
        }

        return perfisDto;
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
