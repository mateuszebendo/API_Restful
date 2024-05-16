package br.org.serratec.biblioteca.controller;

import br.org.serratec.biblioteca.dtos.PerfilResumidoDto;
import br.org.serratec.biblioteca.entity.PerfilEntity;
import br.org.serratec.biblioteca.service.PerfilService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    PerfilService perfilService;

    @PostMapping
    public ResponseEntity<PerfilEntity> savePerfil (@RequestBody @Valid PerfilEntity perfil) {
        return ResponseEntity.status(HttpStatus.CREATED).body(perfilService.createPerfil(perfil));
    }

    @GetMapping
    public ResponseEntity<List<PerfilEntity>> getAllPerfil () {
        return ResponseEntity.status(HttpStatus.OK).body(perfilService.getAllPerfil());
    }

    @GetMapping ("/perfil-resumido")
    public ResponseEntity<List<PerfilResumidoDto>> getAllPerfilResumido() {
        return ResponseEntity.status(HttpStatus.OK).body(perfilService.getAllPerfilResumido());
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Object> getPerfilById (@PathVariable UUID id){
        var perfil = perfilService.getPerfilById(id);
        if(perfil == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{ 'Status': 'Não encontrado'}");
        return ResponseEntity.status(HttpStatus.OK).body(perfil);
    }

    @GetMapping ("/perfil-resumido/{id}")
    public ResponseEntity<Object> getPerfilResumidoById (@PathVariable UUID id){
        PerfilResumidoDto perfil = null;
//        try{
            perfil = perfilService.getPerfilResumidoById(id);
//        } catch (IllegalArgumentException e){
//            throw new IllegalArgumentException("Ocorreu uma exceção: " + e);
//        }
        if(perfil != null) return ResponseEntity.status(HttpStatus.OK).body(perfil);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{ 'Status': 'Não encontrado'}");
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
