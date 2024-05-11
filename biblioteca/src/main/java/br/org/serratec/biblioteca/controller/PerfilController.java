package br.org.serratec.biblioteca.controller;

import br.org.serratec.biblioteca.entity.PerfilEntity;
import br.org.serratec.biblioteca.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    PerfilService perfilService;

    @PostMapping
    public ResponseEntity<PerfilEntity> savePerfil (@RequestBody PerfilEntity perfil) {
        return ResponseEntity.status(HttpStatus.CREATED).body(perfilService.createPerfil(perfil));
    }

    @GetMapping
    public ResponseEntity<List<PerfilEntity>> getAllPerfil () {
        return ResponseEntity.status(HttpStatus.OK).body(perfilService.getAllPerfil());
    }

    @GetMapping ("/{id}")
    public ResponseEntity<PerfilEntity> getPerfilById (@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(perfilService.getPerfilById(id));
    }

    @PutMapping
    public ResponseEntity<PerfilEntity> updatePerfil (@RequestBody PerfilEntity perfil) {
        return ResponseEntity.status(HttpStatus.OK).body(perfilService.modifyPerfil(perfil));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePerfilById (@PathVariable UUID id) {
        Optional <PerfilEntity> perfil0 = Optional.ofNullable(perfilService.deletePerfil(id));
        if(perfil0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PERFIL NOT FOUND");
        }
        return ResponseEntity.status(HttpStatus.OK).body("PERFIL SUCCESSFULLY DELETED");
    }

}
