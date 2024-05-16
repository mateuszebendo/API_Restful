package br.org.serratec.biblioteca.controller;

import br.org.serratec.biblioteca.entity.UsuarioEntity;
import br.org.serratec.biblioteca.service.UsuarioService;
import jakarta.validation.Valid;
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
    public ResponseEntity<UsuarioEntity> saveUsuario (@RequestBody @Valid UsuarioEntity Usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioService.createUsuario(Usuario));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioEntity>> getAllUsuario () {
        return ResponseEntity.status(HttpStatus.OK).body(UsuarioService.getAllUsuario());
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Object> getUsuarioById (@PathVariable UUID id){
//        try {
            return ResponseEntity.status(HttpStatus.OK).body(UsuarioService.getUsuarioById(id));
//        }
//        catch (NullPointerException notFound) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("EXCEPTION GUGU: " + notFound.getMessage());
//        }
//        catch (NumberFormatException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ 'EXCEPTION BONAFÉ': " + e.getMessage() + "}");
//        }
//        catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{ 'EXCEPTION GUGU': " + e + "}");
//        }
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
