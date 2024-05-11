package br.org.serratec.biblioteca.service;

import br.org.serratec.biblioteca.entity.UsuarioEntity;
import br.org.serratec.biblioteca.entity.UsuarioEntity;
import br.org.serratec.biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioEntity createUsuario(UsuarioEntity usuario){
        return usuarioRepository.save(usuario);
    }

    public UsuarioEntity getUsuarioById(UUID id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public List<UsuarioEntity> getAllUsuario (){
        return usuarioRepository.findAll();
    }

    public UsuarioEntity modifyUsuario (UsuarioEntity Usuario){
        return usuarioRepository.save(Usuario);
    }

    public UsuarioEntity deleteUsuario(UUID id) {
        var Usuario = usuarioRepository.findById(id).orElse(null);
        try {
            usuarioRepository.deleteById(id);
            if(Usuario != null)
                return Usuario;

        }catch(Exception e) {
            System.out.println(e);
        }
        return Usuario;
    }
}
