package br.org.serratec.academia.controllers;

import br.org.serratec.academia.entities.Telefone;
import br.org.serratec.academia.services.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/telefone")
public class TelefoneController {

    @Autowired
    TelefoneService TelefoneService;

    @PostMapping
    public ResponseEntity<Telefone> save(@RequestBody Telefone Telefone) {
        return ResponseEntity.status(HttpStatus.OK).body(TelefoneService.save(Telefone));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Telefone> getById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(TelefoneService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Telefone>> getAllId () {
        return ResponseEntity.status(HttpStatus.OK).body(TelefoneService.getAll());
    }

    @PutMapping
    public ResponseEntity<Telefone> update (@RequestBody Telefone Telefone){
        return ResponseEntity.status(HttpStatus.OK).body(TelefoneService.update(Telefone));
    }

    @DeleteMapping
    public ResponseEntity<Object> delete (@RequestBody Telefone Telefone) {
        var Telefone0 = TelefoneService.delete(Telefone);
        if (Telefone0 == null) return ResponseEntity.status(HttpStatus.OK).body("Telefone NOT FOUND");
        return ResponseEntity.status(HttpStatus.OK).body("Telefone NOT FOUND");
    }
}
