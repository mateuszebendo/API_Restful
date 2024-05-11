package br.org.serratec.biblioteca.controller;

import br.org.serratec.biblioteca.entity.UsuarioEntity;
import br.org.serratec.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping ("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService UsuarioService;

    @PostMapping
    public ResponseEntity<UsuarioEntity> saveUsuario (@RequestBody UsuarioEntity Usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioService.createUsuario(Usuario));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioEntity>> getAllUsuario () {
        return ResponseEntity.status(HttpStatus.OK).body(UsuarioService.getAllUsuario());
    }

    @GetMapping ("/{id}")
    public ResponseEntity<UsuarioEntity> getUsuarioById (@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(UsuarioService.getUsuarioById(id));
    }

    @PutMapping
    public ResponseEntity<UsuarioEntity> updateUsuario (@RequestBody UsuarioEntity Usuario) {
        return ResponseEntity.status(HttpStatus.OK).body(UsuarioService.modifyUsuario(Usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUsuarioById (@PathVariable UUID id) {
        Optional<UsuarioEntity> Usuario0 = Optional.ofNullable(UsuarioService.deleteUsuario(id));
        if(Usuario0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("USUARIO NOT FOUND");
        }
        return ResponseEntity.status(HttpStatus.OK).body("USUARIO SUCCESSFULLY DELETED");
    }
}
